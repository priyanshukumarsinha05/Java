# **Compiler Design Laboratory – Execution Guide**

This document explains how to run all **CD Lab Programs (Program 1–6)** exactly as implemented in this repository.
Each program’s input and output is taken directly from the lab manual.

---


# ✅ **Program 1 – `tokens.l` (LEX Program)**

### **Recognizes:**

* Strings ending with **00**
* Strings containing **222222**
* Every 5-symbol block has ≥ 2 fives
* Binary strings starting with 1 divisible by 5
* 10th symbol from right is 1
* 4-digit numbers with digit-sum 9
* 4-digit numbers in ascending order

### **Run**

```bash
flex tokens.l
gcc lex.yy.c -o p1 -lfl
./p1 < input1.txt
```

### **Sample Input**

```
100
12222222
155551111
1010
1234567890
1233
1234
1357
```

### **Sample Output** (from PDF)

```
Ends with 00: 100
Contains three consecutive 222's: 12222222
Valid: every block of 5 contains at least two 5's: 155551111
Binary string divisible by 5: 1010
10th symbol from the right is 1: 1234567890
4-digit number with digit sum 9: 1233
4-digit number with digits in ascending order: 1234
4-digit number with digits in ascending order: 1357
```

---


# ✅ **Program 2 – `space.l` (LEX Program)**

### **Copies a file while replacing sequences of whitespace → single space**

### **Run**

```bash
flex space.l
gcc lex.yy.c -o p2 -lfl
./p2 < input.txt > output.txt
```

### **Input**

```
This           is
            a                        test.
```

### **Output**

```
This is a test.
```

---


# ✅ **Program 3A – `parser_a.cpp`**

### **Recursive Descent Parser with Backtracking**

Grammar A:

```
A → ab | a
S → cAd
```

### **Run**

```bash
g++ parser_a.cpp -o parser_a
./parser_a
```

### **Input**

```
cabd
```

### **Output**

```
String accepted (Grammar A: A → ab | a)
```

---



# ✅ **Program 3B – `parser_b.cpp`**

### **Recursive Descent Parser with Backtracking**

Grammar B:

```
A → a | ab
S → cAd
```

### **Run**

```bash
g++ parser_b.cpp -o parser_b
./parser_b
```

### **Input**

```
cabd
```

### **Output**

```
String rejected (Grammar B: A → a | ab)
```

---



# ✅ **Program 4 – `c4.cpp`**

### FIRST, FOLLOW, and LL(1) Parsing Table

Grammar:

```
S → AB
A → a | ε
B → b
```

### **Run**

```bash
g++ c4.cpp -o p4
./p4
```

### **Input**

```
a b $
```

### **Output** (from PDF)

```
FIRST sets:
S : { a ε }
A : { a ε }
B : { b }

FOLLOW sets:
S : { $ }
A : { b }
B : { $ }

Parsing Table:
M[S,a] = A B
M[A,a] = a
M[A,b] = ε
M[B,b] = b

Parsing result: Input string is accepted.
```

---


# ✅ **Program 5 – `calc.l` + `calc.y`**

### YACC Expression Evaluator (Desktop Calculator)

### **Run**

```bash
flex calc.l
yacc -d calc.y
gcc lex.yy.c y.tab.c -o calc -lfl
./calc
```

### **Input**

```
2 + 3 * 4
```

### **Output**

```
Result = 14
```

---


# ✅ **Program 6 – `expr.l` + `expr.y`**

### YACC – Generate Three-Address Code

### **Run**

```bash
flex expr.l
yacc -d expr.y
gcc lex.yy.c y.tab.c -o expr -lfl
./expr
```

### **Input**

```
a = b + c * d
```

### **Output**

```
t1 = c * d
t2 = b + t1
a = t2
```


