﻿
# **Exercises: Methods**
Problems for exercises and homework for the ["Technology Fundamentals" course @ SoftUni](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021).

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1286)
## 1. **Smallest of Three Numbers**
Write a method to print the smallest of three integer numbers. Use appropriate name for the method.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>2</p><p>5</p><p>3</p>|2|
|<p>600</p><p>342</p><p>123</p>|123|
|<p>25</p><p>-21</p><p>4</p>|-21|
## 2. **Vowels Count**
Write a method that receives a single string and prints the count of the vowels. Use appropriate name for the method.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|SoftUni|3|
|Cats|1|
|JS|0|
## 3. **Characters in Range**
Write a method that receives two characters and prints on a single line all the characters in between them according to ASCII.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>a</p><p>d</p>|b c|
|<p>#</p><p>:</p>|$ % & ' ( ) \* + , - . / 0 1 2 3 4 5 6 7 8 9|
|<p>C</p><p>#</p>|$ % & ' ( ) \* + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? @ A B|
## 4. **Password Validator**
Write a program that checks if a given password is valid. Password rules are:

- 6 – 10 characters **(inclusive)**;
- Consists only of **letters** and **digits**;
- Have at least **2** digits.

If a password is valid, print **"Password is valid"**. If it is not valid, for every unfulfilled rule print a message:

- **"Password must be between 6 and 10 characters"**;
- **"Password must consist only of letters and digits";**
- **"Password must have at least 2 digits"**.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|logIn|<p>Password must be between 6 and 10 characters</p><p>Password must have at least 2 digits</p>|
|MyPass123|Password is valid|
|Pa$s$s|<p>Password must consist only of letters and digits</p><p>Password must have at least 2 digits</p>|
### **Hints**

Write a method for each rule.

## 5. **Add and Subtract**

You will receive 3 **integers.** Write a method **sum** to get the sum of the first two integers and **subtract** method that subtracts the third integer from the result from the sum method. 

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>23</p><p>6</p><p>10</p>|19|
|<p>1</p><p>17</p><p>30</p>|-12|
|<p>42</p><p>58</p><p>100</p>|0|
## 6. **Middle Characters**
You will receive a single string. Write a method that prints the middle character. If the length of the string is even, there are two middle characters.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|aString|r|
|someText|eT|
|3245|24|
## 7. **NxN Matrix**
Write a method that receives a single integer **n** and prints **nxn** matrix with that number.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|3|<p>3 3 3</p><p>3 3 3</p><p>3 3 3</p>|
|7|<p>7 7 7 7 7 7 7	</p><p>7 7 7 7 7 7 7</p><p>7 7 7 7 7 7 7</p><p>7 7 7 7 7 7 7</p><p>7 7 7 7 7 7 7</p><p>7 7 7 7 7 7 7</p><p>7 7 7 7 7 7 7</p>|
|2|<p>2 2</p><p>2 2</p>|
## 8. **Factorial Division**
Read two integer numbers. Calculate [factorial](https://en.wikipedia.org/wiki/Factorial) of each number. Divide the first result by the second and print the division formatted to the second decimal point.

### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|<p>5</p><p>2</p><p></p>|60.00||<p>6</p><p>2</p>|360.00|
## 9. **Palindrome Integers**
A **palindrome** is a number which reads the same backward as forward, such as 323 or 1001. Write a program which reads a positive integer numbers until you receive "**END**". For each number print whether the number is palindrome or not.

### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|<p>123</p><p>323</p><p>421</p><p>121</p><p>END</p>|<p>false</p><p>true</p><p>false</p><p>true</p>||<p>32</p><p>2</p><p>232</p><p>1010</p><p>END</p>|<p>false</p><p>true</p><p>true</p><p>false</p>|
## 10. **Top Number**
Read an **integer** n from the console. Find all top numbers in the range **[1 … n]** and print them. A top number holds the following properties:

- Its **sum of digits is divisible by 8**, e.g. 8, 16, 88.
- Holds at least **one odd digit**, e.g. 232, 707, 87578.
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|50|<p>17</p><p>35</p>||100|<p>17</p><p>35</p><p>53</p><p>71</p><p>79</p><p>97</p>|
## 11. **\*Array Manipulator**
Trifon has finally become a junior developer and has received his first task. It's about manipulating an array of integers. He is not quite happy about it, since he hates manipulating arrays. They are going to pay him a lot of money, though, and he is willing to give somebody half of it if to help him do his job. You, on the other hand, love arrays (and money) so you decide to try your luck.

The array may be manipulated by one of the following commands:

- **exchange {index}** – splits the array **after** the given index and exchanges the places of the two resulting subarrays. E.g. [1, 2, 3, 4, 5] -> **exchange 2** -> result: **[4, 5, 1, 2, 3]**
  - If the index is outside the boundaries of the array, print "**Invalid index**".
- **max** **even/odd**– returns the **INDEX** of the max even/odd element -> [1, 4, 8, 2, 3] -> **max odd** -> print **4**
- **min** **even/odd** – returns the **INDEX** of the min even/odd element -> [1, 4, 8, 2, 3] -> **min even** > print **3**
  - If there are two or more equal **min/max** elements, return the index of the **rightmost** one.
  - If a **min/max even/odd** element **cannot** be found, print **"No matches"**.
- **first {count}** **even/odd**– returns the first {count} elements -> [1, 8, 2, 3] -> **first 2 even** -> print **[8, 2]**
- **last {count}** **even/odd** – returns the last {count} elements -> [1, 8, 2, 3] -> **last 2 odd** -> print **[1, 3]**
  - If the count is greater than the array length, print "**Invalid count**".
  - If there are **not** **enough** elements to satisfy the count, print as many as you can. If there are **zero** **even/odd** elements, print an empty array **"[]"**.
- **end** – stop taking input and print the final state of the array.
### **Input**
- The input data should be read from the console.
- On the first line, the initial array is received as a line of integers, separated by a single space.
- On the next lines, until the command "**end**" is received, you will receive the array manipulation commands.
- The input data will always be valid and in the format described. There is no need to check it explicitly.
### **Output**
- The output should be printed on the console.
- On a separate line, print the output of the corresponding command
- On the last line, print the final array in **square brackets** with its elements separated by a comma and a space 
- See the examples below to get a better understanding of your task
### **Constraints**
- The **number of input lines** will be in the range [2 … 50].
- The **array elements** will be integers in the range [0 … 1000].
- The **number of elements** will be in the range [1 ... 50]
- The **split index** will be an integer in the range [-231 … 231 – 1]
- **first/last count** will be an integer in the range [1 … 231 – 1]
- There will **not** be redundant whitespace anywhere in the input
- Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>1 3 5 7 9</p><p>exchange 1</p><p>max odd</p><p>min even</p><p>first 2 odd</p><p>last 2 even</p><p>exchange 3</p><p>end</p>|<p>2</p><p>No matches</p><p>[5, 7]</p><p>[]</p><p>[3, 5, 7, 9, 1]</p>|
|<p>1 10 100 1000</p><p>max even</p><p>first 5 even</p><p>exchange 10</p><p>min odd</p><p>exchange 0</p><p>max even</p><p>min even</p><p>end</p>|<p>3</p><p>Invalid count</p><p>Invalid index</p><p>0</p><p>2</p><p>0</p><p>[10, 100, 1000, 1]</p>|
|<p>1 10 100 1000</p><p>exchange 3</p><p>first 2 odd</p><p>last 4 odd</p><p>end</p>|<p>[1]</p><p>[1]</p><p>[1, 10, 100, 1000]</p>|



