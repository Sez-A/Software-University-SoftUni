
# 			   	**Exercises: Streams, Files and Directories**
This document defines the exercises for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1506/Streams-Files-And-Directories-Exercises).

*For these exercises you are given a zipped folder with resources, that you will need to use. For each exercise submit the output of the program, not the code*

## 1. **Sum Lines**
Write a program that reads a text file (**input.txt** from the Resources - Exercises) and prints on the console the **sum** of the ASCII symbols of each of its lines. Use **BufferedReader** in combination with **FileReader**.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>On January 1 , 1533 , </p><p>Michael Angelo, </p><p>then fifty-seven years old, </p><p>writes</p><p>from Florence to </p><p>Tommaso de' Cavalieri, </p><p>a youth of noble Roman family,</p>|<p>1452</p><p>1397</p><p>2606</p><p>670</p><p>1573</p><p>2028</p><p>2762</p>|

### **Hints**

- Use **try**-with-resources to handle file.
- Create a **BufferedReader** to read each line of the file.
- Get the ASCII code of each character in the line and **add** it to the **sum** for the current line and print the sum on the console

## 2. **Sum Bytes**
Write a program that reads a text file (**input.txt** from the Resources - Exercises) and prints on the console the **sum** of the ASCII symbols of all characters inside of the file. Use **BufferedReader** in combination with **FileReader**.

|**Input**|**Output**|
| :-: | :-: |
|<p>On January 1 , 1533 , </p><p>Michael Angelo, </p><p>then fifty-seven years old, </p><p>writes</p><p>from Florence to </p><p>Tommaso de' Cavalieri, </p><p>a youth of noble Roman family,</p>|12488|
### **Hints**

- You can modify your solution to the previous problem.
- Use a type that will not overflow like **long** or **BigInteger.**

## 3. **ALL CAPITALS!**

Write a program that reads a text file (**input.txt** from the Resources - Exercises) and changes the casing of **all** letters to **upper**. Write the output to another file (**output.txt**).

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>On January 1 , 1533 , </p><p>Michael Angelo, </p><p>then fifty-seven years old, </p><p>writes</p><p>from Florence to </p><p>Tommaso de' Cavalieri, </p><p>a youth of noble Roman family,</p>|<p>ON JANUARY 1 , 1533 , </p><p>MICHAEL ANGELO, </p><p>THEN FIFTY-SEVEN YEARS OLD, </p><p>WRITES</p><p>FROM FLORENCE TO </p><p>TOMMASO DE' CAVALIERI, </p><p>A YOUTH OF NOBLE ROMAN FAMILY,</p>|
### **Hints**

- Use **BufferedReader** and **PrintWriter**.

  

## 4. **Count Character Types**

Write a program that reads a list of words from the file (**input.txt** from the Resources - Exercises) and finds the count of **vowels**, **consonants** and **punctuation** marks. Assume that:

- **a, e, i, o, u** are vowels, only lower case.
- **All** **others** are consonants.
- Punctuation marks are **(! , . ?).**
- **Do** **not** count whitespace.

Write the results to another file – **output.txt**.** 

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes</p><p>from Florence to Tommaso de' Cavalieri, a youth of noble Roman family,</p>|<p>Vowels: 41</p><p>Consonants: 72</p><p>Punctuation: 6</p>|
### **Hints**

- Use **BufferedReader** and **PrintWriter**.

  

## 5. **Line Numbers**

Write a program that reads a text file (**inputLineNumbers.txt** from the Resources - Exercises) and **inserts** line numbers in front of each of its lines. The result should be written to **another** text file – **output.txt**. 

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>Two households, both alike in dignity,</p><p>In fair Verona, where we lay our scene,</p><p>From ancient grudge break to new,</p><p>Where civil blood makes civil hands.</p><p>From forth the fatal loins of these two</p><p>A pair of star-cross'd lovers take their life;</p><p>Whose misadventured piteous overthrows</p><p>Do with their death bury their parents' strife.</p>|<p>1. Two households, both alike in dignity,</p><p>2. In fair Verona, where we lay our scene,</p><p>3. From ancient grudge break to new,</p><p>4. Where civil blood makes civil hands.</p><p>5. From forth the fatal loins of these two </p><p>6. A pair of star-cross'd lovers take their life;</p><p>7. Whose misadventured piteous overthrows</p><p>8. Do with their death bury their parents' strife.</p>|
## 6. **Word Count**
Write a program that reads a list of words from the file **words.txt** (from the Resources - Exercises) and finds how many times each of the words is **contained** in another file **text.txt** (from the Resources – Exercises). Matching should be case-**insensitive**.

Write the results in file **results.txt**. Sort the words by frequency in **descending** **order**.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|of which The|<p>of - 6</p><p>which - 2</p><p>The - 1</p>|



## 7. **Merge Two Files**
Write a program that reads the contents of **two** text files (**inputOne.txt**, **inputTwo.txt** from Resources Exercises) and **merges** them together into a third one.

### **Examples**

|**File 1**|**File 2**|**Output**|
| :-: | :-: | :-: |
|<p>1</p><p>2</p><p>3</p><p></p>|<p>4</p><p>5</p><p>6</p>|<p>1</p><p>2</p><p>3</p><p>4</p><p>5</p><p>6</p>|
## 8. **Get Folder Size**
Write a program that **traverses** a folder and **calculates** its size in bytes. Use Folder **Exercises** **Resources** in Resources.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||Folder size: 2878|
## 9. **Copy a Picture**
Write a program that makes a copy of a **.jpg** file using **FileInputStream**, **FileOutputStream**, and **byte[] buffer**. Set the name of the new file as **picture-copy.jpg**.

## 10. **Serialize Array List**
Write a program that saves and loads an **ArrayList** of doubles to a file using **ObjectInputStream** and **ObjectOutputStream**. Set the name of the file as **list.ser.**

## 11. **\*Serialize Custom Object**
Write a program that saves and loads the information about a custom object using **ObjectInputStream** and **ObjectOutputStream**. 

Create a **simple** **class** called "**Course**" that has a **String field** containing its **name** and an **integer field** containing the **number of students** attending the course. Set the name of the save file as **course.ser.**
## 12. **\*Create Zip Archive**
Write a program that reads three **.txt** files and creates a zip archive named **files.zip.** Use **FileOutputStream**, **ZipOutputStream**, and **FileInputStream.**

