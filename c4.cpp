#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>
#include <algorithm>
using namespace std;

// ---------- GLOBAL DATA STRUCTURES ----------
map<string, vector<vector<string>>> grammar;  // Grammar: Nonterminal → Productions
map<string, set<string>> FIRST, FOLLOW;       // FIRST and FOLLOW sets
set<string> terminals, nonTerminals;          // Terminal and nonterminal symbols
map<string, map<string, int>> parsingTable;   // LL(1) Table

// ---------- UTILITY: Check if terminal ----------
bool isTerminal(const string &symbol) {
    return terminals.count(symbol);
}

// ---------- FIRST(symbol) ----------
set<string> computeFirst(const string &symbol);

// FIRST(production)
set<string> computeFirstOfProduction(const vector<string> &prod) {
    set<string> result;
    bool epsilonPrefix = true;

    for (auto &sym : prod) {
        set<string> f = computeFirst(sym);
        result.insert(f.begin(), f.end());

        if (f.count("ε")) {
            result.erase("ε");
        } else {
            epsilonPrefix = false;
            break;
        }
    }

    if (epsilonPrefix)
        result.insert("ε");

    return result;
}

// FIRST(nonterminal)
set<string> computeFirst(const string &symbol) {
    if (isTerminal(symbol) || symbol == "ε") return {symbol};

    if (FIRST.count(symbol)) return FIRST[symbol];

    set<string> firstSet;
    for (auto &prod : grammar[symbol]) {
        set<string> fp = computeFirstOfProduction(prod);
        firstSet.insert(fp.begin(), fp.end());
    }

    FIRST[symbol] = firstSet;
    return firstSet;
}

// ---------- FOLLOW sets ----------
void computeFollow() {
    for (auto &nt : nonTerminals)
        FOLLOW[nt] = {};

    FOLLOW["S"].insert("$"); // Start symbol

    bool changed = true;
    while (changed) {
        changed = false;

        for (auto &A : nonTerminals) {
            for (auto &prod : grammar[A]) {
                for (int i = 0; i < prod.size(); i++) {
                    string B = prod[i];

                    if (nonTerminals.count(B)) {
                        set<string> first_beta;
                        bool epsilonBeta = true;

                        for (int j = i + 1; j < prod.size(); j++) {
                            set<string> f = computeFirst(prod[j]);
                            first_beta.insert(f.begin(), f.end());
                            if (!f.count("ε")) {
                                epsilonBeta = false;
                                break;
                            }
                            first_beta.erase("ε");
                        }

                        int before = FOLLOW[B].size();
                        FOLLOW[B].insert(first_beta.begin(), first_beta.end());
                        if (FOLLOW[B].size() > before) changed = true;

                        if (epsilonBeta) {
                            before = FOLLOW[B].size();
                            FOLLOW[B].insert(FOLLOW[A].begin(), FOLLOW[A].end());
                            if (FOLLOW[B].size() > before) changed = true;
                        }
                    }
                }
            }
        }
    }
}

// ---------- Build LL(1) Parsing Table ----------
bool buildParsingTable() {
    for (auto &A: nonTerminals) {
        for (int i = 0; i < grammar[A].size(); i++) {
            vector<string> prod = grammar[A][i];
            set<string> fp = computeFirstOfProduction(prod);

            for (auto &t : fp) {
                if (t != "ε") {
                    if (parsingTable[A].count(t)) return false;
                    parsingTable[A][t] = i;
                }
            }

            if (fp.count("ε")) {
                for (auto &b : FOLLOW[A]) {
                    if (parsingTable[A].count(b)) return false;
                    parsingTable[A][b] = i;
                }
            }
        }
    }
    return true;
}

// ---------- Parser simulation ----------
bool parseInput(const vector<string> &input) {
    vector<string> stk = {"$", "S"};
    int idx = 0;

    while (!stk.empty()) {
        string top = stk.back();
        stk.pop_back();
        string current = (idx < input.size()) ? input[idx] : "$";

        if (top == current) {
            if (top == "$") return true;
            idx++;
        }
        else if (isTerminal(top)) {
            cout << "Error: unexpected token " << current << endl;
            return false;
        }
        else {
            if (!parsingTable[top].count(current)) {
                cout << "Error: no rule for [" << top << "," << current << "]\n";
                return false;
            }

            int rule = parsingTable[top][current];
            vector<string> prod = grammar[top][rule];

            if (!(prod.size() == 1 && prod[0] == "ε")) {
                for (auto it = prod.rbegin(); it != prod.rend(); ++it)
                    stk.push_back(*it);
            }
        }
    }
    return false;
}

int main() {
    // Define terminals and nonterminals
    terminals = {"a", "b", "$"};
    nonTerminals = {"S", "A", "B"};

    // Grammar:
    // S → A B
    grammar["S"].push_back({"A", "B"});

    // A → a | ε
    grammar["A"].push_back({"a"});
    grammar["A"].push_back({"ε"});

    // B → b
    grammar["B"].push_back({"b"});

    // FIRST sets
    for (auto &nt : nonTerminals) computeFirst(nt);

    cout << "\nFIRST sets:\n";
    for (auto &nt : nonTerminals) {
        cout << nt << " = { ";
        for (auto &x : FIRST[nt]) cout << x << " ";
        cout << "}\n";
    }

    computeFollow();

    cout << "\nFOLLOW sets:\n";
    for (auto &nt : nonTerminals) {
        cout << nt << " = { ";
        for (auto &x : FOLLOW[nt]) cout << x << " ";
        cout << "}\n";
    }

    buildParsingTable();

    cout << "\nLL(1) Parsing Table:\n";
    for (auto &nt : nonTerminals) {
        for (auto &t : terminals) {
            if (parsingTable[nt].count(t)) {
                cout << "M[" << nt << "," << t << "] = ";
                for (auto &sym : grammar[nt][parsingTable[nt][t]])
                    cout << sym << " ";
                cout << endl;
            }
        }
    }

    cout << "\nEnter input (tokens separated by space, end with $): ";
    vector<string> input;
    string tok;
    while (cin >> tok) {
        input.push_back(tok);
        if (tok == "$") break;
    }

    cout << "\nParsing Result: ";
    if (parseInput(input))
        cout << "Accepted\n";
    else
        cout << "Rejected\n";

    return 0;
}
