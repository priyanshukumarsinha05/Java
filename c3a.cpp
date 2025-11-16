#include<bits/stdc++.h>
using namespace std;

string input;
int i=0;

bool A(){
    if(input[i] == 'a' && input[i+1] == 'b'){
        i+=2;
        return true;
    }

    if(input[i]=='a'){
        i++;
        return true;
    }

    return false;
}

bool S(){
    if(input[i] == 'c'){
        i++;
        if(A()){
            if(input[i] == 'd'){
                i++;
                return true;
            }
        }
    }
    return false;
}

int main(){
    cout << "Enter input string: ";
    cin >> input;
    i=0;

    if(S() && i == input.length()){
        cout << "String Accepted";
    }
    else{
        cout << "String rejected";
    }

    return 0;
}