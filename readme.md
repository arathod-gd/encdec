# Encryption-Decryption (Java)

A command-line based encryption and decryption tool built in Java as part of the JetBrains Academy project.
The project evolves step-by-step from a simple program to a flexible multi-algorithm system.

---

## Project Structure
src/main/java/org/
├── stage1
├── stage2
├── stage3
├── stage4
├── stage5
└── stage6


Each stage contains a `Main` class with incremental features.

---

## Stage 1 – Basic Encryption

### Features
- Encrypts a given string using a key.
- Simple character shifting.

### Example
```bash
java org.stage1.Main

##Stage 2 – Encryption & Decryption
Features

Supports both encryption and decryption.

User chooses mode.


##stage 3
run :
javac -d out src/main/java/org/stage3/Main.java
java -cp out org.stage3.Main
> enc
> aditya
> 4
ehmx}e



***  “-cp out” → look for compiled classes inside the out/ folder  ***
**********************************************************************

##Stage 4 – File Support
Features:
Can read input from a file.
Can write output to a file.

New arguments
-in
-out


run  :
javac -d out src/main/java/org/stage4/Main.java
java -cp out org.stage4.Main -mode enc -key 5 -data "Hello"




## Stage 5 – Unicode Algorithm
Features

Full Unicode encryption.

Shifts all characters (letters, digits, symbols).

Example
javac src/main/java/org/stage5/Main.java

using data:
> java -cp src/main/java org.stage5.Main -mode enc -key 5 -data "hello"
mjqqt

> java -cp src/main/java org.stage5.Main -mode dec -key 5 -data "mjqqt"
hello


using files
enc:
java -cp src/main/java org.stage5.Main -mode enc -key 5 -in src/main/java/org/stage5/encryptedfiles/input.txt -out src/main/java/org/stage5/encryptedfiles/encrypted.txt

dec:
java -cp src/main/java org.stage5.Main -mode dec -key 5 -in src/main/java/org/stage5/encryptedfiles/encrypted.txt -out src/main/java/org/stage5/encryptedfiles/decrypted.txt




## Stage 6 – Multiple Algorithms (Final)
______________________________
| Argument | Description     |
| -------- | --------------- |
| -mode    | enc / dec       |
| -key     | shift key       |
| -data    | direct text     |
| -in      | input file      |
| -out     | output file     |
| -alg     | unicode / shift |
------------------------------



Features :
Supports two algorithms:

unicode → shifts all characters
shift → Caesar cipher (letters only)
Fully configurable from CLI.

Algorithms :
Unicode
Shifts every character by key.
Example:
Hello! → Mjqqt&

Shift (Caesar)
Shifts only letters (wraps around a -> z).
Example:
Zebra → Ejgwf


##run stage 6:

java -cp src/main/java org.stage6.Main \
-mode enc \
-key 5 \
-alg unicode \
-in src/main/java/org/stage6/inpute.txt \
-out src/main/java/org/stage6/encryptedfiles/protected.txt



