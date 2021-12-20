﻿
# **Lab: Functional Programming**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1513/Functional-Programming-Lab).
## 1. **Sort Even Numbers**
Write a program that reads one line of **Integers** separated by **", "**. 

- Print the **even** numbers.
- **Sort** them in ascending order. 
- Print them again.

Use 2 **Lambda Expresions** to do so.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|4, 2, 1, 3, 5, 7, 1, 4, 2, 12|<p>4, 2, 4, 2, 12</p><p>2, 2, 4, 4, 12</p>|
|1, 3, 5|*(no output)*|
|2, 4, 6|<p>2, 4, 6</p><p>2, 4, 6</p>|

### **Hints**

- It is up to you what type of data structures you will use to solve this problem
-  Try different ways, for solving this problem, for example:  

## 2. **Sum Numbers**

Write a program that reads one line of **Integers** separated by **", "**. Print the **count** of the numbers and their **sum.**

Use a **Function<String, Integer>.**	
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|4, 2, 1, 3, 5, 7, 1, 4, 2, 12|<p>Count = 10</p><p>Sum = 41</p>|
|2, 4, 6|<p>Count = 3</p><p>Sum = 12</p>|
### **Hints**

- Use **Function<String, Integer>** for **parsing** integers after you split them to a **String** array.

  

## 3. **Count Uppercase Words**

Write a program that reads one line of **text** from the console. Print the **count** of words that start with a **Uppercase letter**, after that print all these **words** in the **same order,** like you found them in the text.

Use a **Predicate<String>.**
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|The following example shows how to use Predicate|<p>2</p><p>The</p><p>Predicate</p>|
|Write a program that reads one line of text from console. Print count of words that start with Uppercase, after that print all those words in the same order like you find them in text.|<p>3</p><p>Write</p><p>Print</p><p>Uppercase,</p>|
### **Hints**

- Use a **Predicate<String>** like an **if-condition.**

## 4. **Add VAT**

Write a program that reads one line of **Double** prices separated by **", "**. Print the prices with added **VAT**s for all of them. Format them to the **2nd** digit after the decimal point. The order of the prices must remain the same.

Use an **UnaryOperator<Double>.**
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|1.38, 2.56, 4.4|<p>Prices with VAT:</p><p>1.66</p><p>3.07</p><p>5.28</p>|
|1, 3, 5, 7|<p>Prices with VAT:</p><p>1.20</p><p>3.60</p><p>6.00</p><p>8.40</p>|

### **Hints**

![image](https://user-images.githubusercontent.com/67644402/146786276-8185b7b4-ee81-4160-b4be-1cb465a96b57.png)

## 5. **Filter by Age**

Write a program that reads an integer **N** on the first line. And on next **N** lines read pairs of **"{name}, {age}".** Then read three more lines with:

- Condition - "**younger**" or "**older**"
- Age - **Integer**
- Format - "**name**", "**age**" or "**name age**"

Depending on the **condition,** print the **pairs** in the right **format**.

**Don’t use any build-in functionality. Write your own methods.**
### **Examples**

|**Input**|**Output**||**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|<p>5</p><p>Peter, 20<br>George, 18<br>Maria, 29<br>Idan, 31<br>Simeon, 16</p><p>older</p><p>20</p><p>name age</p>|<p>Peter - 20</p><p>Maria - 29</p><p>Idan - 31</p>||<p>5</p><p>Peter, 20<br>George, 18<br>Maria, 29<br>Idan, 31<br>Simeon, 16</p><p>younger</p><p>20</p><p>name</p>|<p>Peter</p><p>George</p><p>Simeon</p>||<p>5</p><p>Peter, 20<br>George, 18<br>Maria, 29<br>Idan, 31<br>Simeon, 16</p><p>younger</p><p>50</p><p>age</p>|<p>20</p><p>18</p><p>29</p><p>31</p><p>16</p>|
1. ## **Find Evens or Odds**
You are given a **lower** and an **upper** **bound** for a range of integer numbers. Then a command specifies if you need to list all **even** **or** **odd** numbers in the given range. Use **predicates** that need to be **passed to a method.**
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>1 10</p><p>odd</p>|1 3 5 7 9|
|<p>20 30</p><p>even</p>|20 22 24 26 28 30|





