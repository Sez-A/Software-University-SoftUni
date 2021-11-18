
# **Lab: Data Types and Variables**
Problems for exercises and homework for the ["Technology Fundamentals" course @ SoftUni.](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021)

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1227)
# I.**Integer and Real Numbers**

## 1. **Convert Meters to Kilometers**
You will be given an integer that will be distance in meters. Write a program that converts meters to kilometers formatted to the second decimal point.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|1852|1.85|
|798|0.80|
## 2. **Pounds to Dollars**
Write a program that converts British pounds to US dollars formatted to 3th decimal point.

1 British Pound = 1.36 Dollars
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|80|108.800|
|39|53.040|
## 3. **Exact Sum of Real Numbers**
Write program to enter **n** numbers and calculate and print their **exact sum** (without rounding).

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>3</p><p>1000000000000000000</p><p>5</p><p>10</p>|<p>1000000000000000015</p><p></p>|
|<p>2</p><p>0.00000000003</p><p>333333333333.3</p>|333333333333.30000000003|
### **Hints**
Use **BigDecimal** to not lose precision.
# II.**Data Types and Type Conversion**

## 4. **Town Info**
You will be given 3 lines of input. On the first line you will be given the name of the town, on the second – the population and on the third the area. Use the correct data types and print the result in the following format:

"**Town {town name} has population of {population} and area {area} square km.**".
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>Sofia</p><p>1286383</p><p>492</p>|Town Sofia has population of 1286383 and area 492 square km.|
|<p>Plovdiv</p><p>343424</p><p>101</p>|Town Plovdiv has population of 343424 and area 101 square km.|
## 5. **Concat Names**
Read two names and a delimiter. Print the names joined by the delimiter.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>John</p><p>Smith</p><p>-></p>|John->Smith|
|<p>Jan</p><p>White</p><p><-></p>|Jan<->White|
|<p>Linda</p><p>Terry</p><p>=></p>|Linda=>Terry|

## 6. **Chars to String**
Write a program that reads 3 lines of input. On each line you get a single character. Combine all the characters into one string and print it on the console.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>a</p><p>b</p><p>c</p>|abc|
|<p>%</p><p>2</p><p>o</p>|%2o|
|<p>1</p><p>5</p><p>p</p>|15p|
## 7. **Reversed Chars**
Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>A</p><p>B</p><p>C</p>|C B A|
|<p>1</p><p>L</p><p>&</p>|& L 1|
## 8. **Lower or Upper**
Write a program that prints whether a given character is upper-case or lower-case.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|L|upper-case|
|f|lower-case|
## 9. **Centuries to Minutes**
Write program to enter an integer number of **centuries** and convert it to **years**, **days**, **hours** and **minutes**.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|1|1 centuries = 100 years = 36524 days = 876581 hours = 52594877 minutes|
|5|5 centuries = 500 years = 182621 days = 4382906 hours = 262974384 minutes|
### **Hints**
- Use appropriate data type to fit the result after each data conversion.
- Assume that a year has 365.2422 days at average ([the Tropical year](https://en.wikipedia.org/wiki/Tropical_year)).
### **Solution**
You might help yourself with the code below:
![image](https://user-images.githubusercontent.com/67644402/142459380-c46a7259-15b2-40dc-bea2-81a384d7d79f.png)

## 10. **Special Numbers**
A **number** is **special** when its **sum of digits is 5, 7 or 11**.

Write a program to read an integer **n** and for all numbers in the range **1…n** to print the number and if it is special or not (**True** / **False**).
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|15|<p>1 -> False</p><p>2 -> False</p><p>3 -> False</p><p>4 -> False</p><p>5 -> True</p><p>6 -> False</p><p>7 -> True</p><p>8 -> False</p><p>9 -> False</p><p>10 -> False</p><p>11 -> False</p><p>12 -> False</p><p>13 -> False</p><p>14 -> True</p><p>15 -> False</p>|
|9|<p>1 -> False</p><p>2 -> False</p><p>3 -> False</p><p>4 -> False</p><p>5 -> True</p><p>6 -> False</p><p>7 -> True</p><p>8 -> False</p><p>9 -> False</p>|
### **Hints**
To calculate the sum of digits of given number **num**, you might repeat the following: sum the last digit (**num** **%** **10**) and remove it (**sum** **=** **sum** **/** **10**) until **num** reaches **0**.
# III.**Variables**

## 11. **Refactor Volume of Pyramid** 
You are given a **working code** that finds the **volume of a pyramid**. However, you should consider that the variables exceed their optimum span and have improper naming. Also, search for variables that **have multiple purpose**.

### **Code**

|**Sample Code**|
| :-: |
|<p>Scanner scanner = **new** Scanner(System.***in***);</p><p>**double** dul, sh, V = 0;<br>System.***out***.print(**"Length: "**);<br>dul = Double.*parseDouble*(scanner.nextLine());<br>System.***out***.print(**"Width: "**);<br>sh = Double.*parseDouble*(scanner.nextLine());<br>System.***out***.print(**"Height: "**);<br>V = Double.*parseDouble*(scanner.nextLine());<br>V = (dul + sh + V) / 3;<br>System.***out***.printf(**"Pyramid Volume: %.2f"**, V);</p><p></p>|
### **Hints**
- **Reduce the span** of the variables by declaring them in the moment they receive a value, not before
- Rename your variables to **represent their** real **purpose** (example: "dul" should become length, etc.)
- Search for variables that have multiple purpose. If you find any, **introduce a new variable**.
## 12. **Refactor Special Numbers**
You are given a **working code** that is a solution to **Problem 9. Special Numbers**. However, the variables are **improperly named, declared before** they are needed and some of them are used for multiple things. Without using your previous solution, **modify the code** so that it is **easy to read and understand**.

### **Code**

|**Sample Code**|
| :-: |
|<p>Scanner scanner = **new** Scanner(System.***in***);</p><p>**int** kolkko = Integer.*parseInt*(scanner.nextLine());<br>**int** obshto = 0;<br>**int** takova = 0;<br>**boolean** toe = **false**;<br>**for** (**int** ch = 1; ch <= kolkko; ch++) {<br>`    `takova = ch;<br>`    `**while** (ch > 0) {<br>`        `obshto += ch % 10;<br>`        `ch = ch / 10;<br>`    `}<br>`    `toe = (obshto == 5) || (obshto == 7) || (obshto == 11);<br>`    `System.***out***.printf(**"%d -> %b%n"**, takova, toe);<br>`    `obshto = 0;<br>`    `ch = takova;<br>}</p>|
### **Hints**
- Reduce the span of the variables by declaring them in the moment they receive a value, not before
- Rename your variables to represent their real purpose (example: "toe" should become isSpecialNum, etc.)
- Search for variables that have multiple purpose. If you find any, introduce a new variable



