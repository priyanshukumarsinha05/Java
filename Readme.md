# 📘 Compiler Design Laboratory – Execution Guide

to clone the repo
git clone https://github.com/priyanshukumar05/java

# 🧾 **PROGRAM 1 — `c1.l`**

Lex program for pattern recognition

### ✔ Compile & Run

```bash
flex c1.l
gcc lex.yy.c -o calc -lfl
./calc < input1.txt
```

### ✔ Sample Output

```
Ends with 00: 100
Contains three Consecutive 222's: 12222222
10th symbol from the right is 1: 1234567890
4 digit number with digit sum 9: 1233
4 digit number with digits in ascending order: 1234
4 digit number with digits in ascending order: 1357
```

---

# ---------------------------------------------------------

# 🧾 **PROGRAM 2 — `c2.l`**

Lex program to remove extra whitespace

### ✔ Compile & Run

```bash
flex c2.l
gcc lex.yy.c -o calc -lfl
./calc < input2.txt
```

### ✔ Sample Output

```
This is a test
```

---

# ---------------------------------------------------------

# 🧾 **PROGRAM 3A — `c3a.cpp`**

Recursive Descent Parser (Grammar A)

### ✔ Compile & Run

```bash
g++ c3a.cpp -o calc
./calc
```

### ✔ Sample Input

```
cabd
```

### ✔ Output

```
String Accepted
```

---

# ---------------------------------------------------------

# 🧾 **PROGRAM 3B — `c3b.cpp`**

Recursive Descent Parser (Grammar B)

### ✔ Compile & Run

```bash
g++ c3b.cpp -o calc
./calc
```

### ✔ Sample Input

```
cabd
```

### ✔ Output

```
String rejected
```

---

# ---------------------------------------------------------

# 🧾 **PROGRAM 4 — `c4.cpp`**

FIRST, FOLLOW, LL(1) Parsing Table

### ✔ Compile & Run

```bash
g++ c4.cpp -o calc
./calc
```

### ✔ Sample Input

```
a b $
```

### ✔ Output

```
FIRST sets:
A = { a ε }
B = { b }
S = { a b }

FOLLOW sets:
A = { b }
B = { $ }
S = { $ }

LL(1) Parsing Table:
M[A,a] = a
M[A,b] = ε
M[B,b] = b
M[S,a] = A B
M[S,b] = A B

Parsing Result: Accepted
```

---

# ---------------------------------------------------------

# 🧾 **PROGRAM 5 — `c5.l` + `c5.y`**

YACC Expression Evaluator (Calculator)

### ✔ Compile & Run

```bash
flex c5.l
yacc -d c5.y
gcc lex.yy.c y.tab.c -o calc -lfl
./calc
```

### ✔ Sample Input

```
2+3*10/2
```

### ✔ Output

```
Simple Calculator (type expressions, press Enter)
Result = 10
```

---

# ---------------------------------------------------------

# 🧾 **PROGRAM 6 — `c6.l` + `c6.y`**

Generate Three-Address Code for Expressions

### ✔ Compile & Run

```bash
flex c6.l
yacc -d c6.y
gcc lex.yy.c y.tab.c -o calc -lfl
./calc
```

### ✔ Sample Input

```
a=b+c*d
```

### ✔ Output

```
t1 = c*d
t2 = b+t1
a = t2
```

---

# ---------------------------------------------------------

# ☕ Java Programs (j1.java – j5.java)

### ✔ Compile

```bash
javac j1.java
```

### ✔ Run

```bash
java j1
```

(Repeat same for j2.java … j5.java)

---

# 🎉 DONE

