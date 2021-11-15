
# **Lab: Basic Syntax, Conditional Statements and Loops**
Problems for exercises and homework for the ["Technology Fundamentals" course @ SoftUni.](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021)

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1190)
## 1. **Student Information**
You will be given 3 lines of input – student name, age and average grade. Your task is to print all the info about the student in the following format: "**Name: {student name}, Age: {student age}, Grade: {student grade}**".

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>John</p><p>15</p><p>5.40</p>|Name: John, Age: 15, Grade: 5.40|
|<p>Steve</p><p>16</p><p>2.50</p>|Name: Steve, Age: 16, Grade: 2.50|
|<p>Marry</p><p>12</p><p>6.00</p>|Name: Marry, Age: 12, Grade: 6.00|
|### **Solution**||

First, we need a scanner, which we can use to read data from the console.

![image](https://user-images.githubusercontent.com/67644402/141780325-ed3cc608-7896-47d1-aadd-606c2dbfd9e4.png)

Read all the information – student name, age and grade

![image](https://user-images.githubusercontent.com/67644402/141779186-e5217dde-a478-4f6c-b037-0852768f24c7.png)
Finally, we need to print the information in the specified format

![image](https://user-images.githubusercontent.com/67644402/141779201-3b589805-312c-43dc-9cd7-b0c684d59fe0.png)

## 2. **Passed**
Write a program, which takes as an input a **grade** and prints "**Passed!**" if the grade is **equal or more than 3.00**.

### **Input**
The **input** comes as a single floating-point number.
### **Output**
The **output** is either "**Passed!**" if the grade is **equal or more than 3.00**, otherwise you should print nothing.
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|5.32|Passed!||2.34|*(no output)*|
## 3. **Passed or Failed**
Modify the above program, so it will print "**Failed!**" if the grade is **lower than 3.00**.

### **Input**
The **input** comes as a single double number.
### **Output**
The **output** is either "**Passed!**" if the grade is **more than 2.99**, otherwise you should print "**Failed!**".
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|5.32|Passed!||2.36|Failed!|
### **Hint**
We need to take **floating-point** number from the console. After that print in the **else** statement the appropriate message.
![image](https://user-images.githubusercontent.com/67644402/141779228-4f9e5569-1492-444b-8b04-cd07e32a3d08.png)
## 4. **Back in 30 Minutes**
Every time John tries to pay his bills he sees on the cash desk the sign: **"I will be back in 30 minutes"**. One day John was sick of waiting and decided he needs a program, which **prints the time** after **30** **minutes**. That way he won’t have to wait on the desk and come at the appropriate time. He gave the assignment to you, so you have to do it.

### **Input**
The **input** will be on two lines. On the **first** **line**, you will receive the **hours** and on the **second** you will receive the **minutes**.
### **Output**
Print on the console the time after **30** minutes. The result should be in format "**hh:mm"**. The **hours** have **one or two** **numbers** and the **minutes** have always **two numbers (with leading zero)**.


### **Constraints**
- The **hours** will be between **0 and 23**.
- The **minutes** will be between **0 and 59**.
### **Examples**

|**Input**|**Output**||**Input**|**Output**||**Input**|**Output**||**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|<p>1</p><p>46</p>|2:16||<p>0</p><p>01</p>|0:31||<p>23</p><p>59</p>|0:29||<p>11</p><p>08</p>|11:38||<p>11</p><p>32</p>|12:02|
### **Hints**
Add 30 minutes to the initial minutes, which you receive from the console. If the minutes are more than 59 – increase the hours with 1 and decrease the minutes with 60. The same way check if the hours are more than 23. When you print check for leading zero.
## 5. **Month Printer**
Write a program, which takes an **integer** from the console and prints the corresponding **month**. If the number **is more than 12** or **less than 1** print "**Error!**".

### **Input**
You will receive a **single** **integer** on a **single line**.
### **Output**
If the number is within the boundaries print the corresponding month, otherwise print "**Error!**".
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|2|February||13|Error!|
### **Hints**
![image](https://user-images.githubusercontent.com/67644402/141779262-aae4878d-e133-4873-97a1-8cae0e67fe95.png)
## 6. **Foreign Languages**
Write a program, which prints the language, that a given country speaks. You can receive only the following combinations: English **is spoken** in England and USA; Spanish **is spoken** in Spain, Argentina and Mexico; for the others**,** we should print "unknown".

### **Input**
You will receive a **single country name** on a **single line**.
### **Output**
**Print** the **language**, which the country **speaks**, or if it is **unknown** for your program, print **"unknown"**.
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|USA|English||Germany|unknown|
### **Hint**
Think how you can **merge** multiple cases, in order to **avoid** writing more code than you need to.
## 7. **Theatre Promotions**
A theatre **is doing a ticket sale**, but they need a program **to** calculate the price of a single ticket. If the given age does not fit one of the categories**,** you should print "**Error!**".  You can see the prices i**n** the table below:

|**Day / Age**|**0 <= age <= 18**|**18 < age <= 64**|**64 < age <= 122**|
| :-: | :-: | :-: | :-: |
|**Weekday**|12$|18$|12$|
|**Weekend**|15$|20$|15$|
|**Holiday**|5$|12$|10$|
### **Input**
The input comes in **two lines**. On the **first** line, you will receive the **type of day**. On the **second** – the **age** of the person.
### **Output**
Print the price of the ticket according to the table, or "**Error!**" if the age is not in the table.
### **Constraints**
- The age will be in the interval **[-1000…1000]**.
- The type of day will **always be** **valid**.
### **Examples**

|**Input**|**Output**||**Input**|**Output**||**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|<p>Weekday</p><p>42</p>|18$||<p>Holiday</p><p>-12</p>|Error!||<p>Holiday</p><p>15</p>|5$||<p>Weekend</p><p>122</p>|15$|

### **Hints**  

We need to read **two** lines. **First** one will be the **type of day**. We will convert it to **lower case** letters with the method "**toLowerCase()**". After that, we will read the **age** of the person and declare a **variable** – **price**, which we will use to set the price of the ticket.
![image](https://user-images.githubusercontent.com/67644402/141780496-331349a9-db4c-471b-9860-a90d164cd4cc.png)
For every **type of day**, we will need to add **different cases** to check the **age** of the person and **set the price**. Some of the **age groups** have **equal** **prices** for the **same type** of day. This means we can use **logical operators** to **merge some of the conditions**.
![image](https://user-images.githubusercontent.com/67644402/141780371-9a97a86c-b74c-4075-8d79-8ace6e4e11e5.png)

Think **where** and **how** you can use **logical operators** for the **other cases**.

We can check if the **price has a value** different, than the **initial** one. It it does, that means we got a **valid combination of day and age** and the price of the ticket is saved in the **price** variable. If the **price** has a **value of 0**, then none of the cases got hit, therefore we have to **print the error message**.

![image](https://user-images.githubusercontent.com/67644402/141779365-8d37984d-1b7f-4e49-bde3-b00f445bc8c3.png)

## 8. **Divisible by 3**
Write a program, which prints all the numbers from **1 to 100**, which are **divisible by 3**. You have to use a single **for** loop. The program should not receive input.

### **Solution**



![image](https://user-images.githubusercontent.com/67644402/141779388-515915bc-a27b-4bce-9f6a-0b8c974feb86.png)
## 9. **Sum of Odd Numbers**
Write a program that prints the next **n** **odd numbers** (starting from 1) and on the **last row** prints the **sum of them**.

### **Input**
On the first line, you will receive a number – **n**. This number shows how many **odd numbers** you should print.
### **Output**
Print the next **n** odd numbers, starting from **1**, separated by **new lines**. On the last line, print the **sum** of these numbers.
### **Constraints**
- **n** will be in the interval **[1…100]**
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|5|<p>1</p><p>3</p><p>5</p><p>7</p><p>9</p><p>Sum: 25</p>||3|<p>1</p><p>3</p><p>5</p><p>Sum: 9</p>|
### **Hints**
![image](https://user-images.githubusercontent.com/67644402/141779412-85e8674b-0dcc-4803-be2e-4dd1f1218353.png)
## 10. **Multiplication Table**
You will receive an **integer** as an input from the console. Print the **10 times table** for this integer. See the examples below for more information.

### **Output**
Print every row of the table in the following format:

**{theInteger} X {times} = {product}**
### **Constraints**
- The integer will be in the interval **[1…100]**
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|5|<p>5 X 1 = 5</p><p>5 X 2 = 10</p><p>5 X 3 = 15</p><p>5 X 4 = 20</p><p>5 X 5 = 25</p><p>5 X 6 = 30</p><p>5 X 7 = 35</p><p>5 X 8 = 40</p><p>5 X 9 = 45</p><p>5 X 10 = 50</p>||2|<p>2 X 1 = 2</p><p>2 X 2 = 4</p><p>2 X 3 = 6</p><p>2 X 4 = 8</p><p>2 X 5 = 10</p><p>2 X 6 = 12</p><p>2 X 7 = 14</p><p>2 X 8 = 16</p><p>2 X 9 = 18</p><p>2 X 10 = 20</p>|
## 11. **Multiplication Table 2.0**
Rewrite you program so it can receive the **multiplier from the console**. Print the **table from the given multiplier to 10**. If the given multiplier is **more than 10** - print only one row with the **integer**, the given **multiplier** and the **product**. See the examples below for more information.

### **Output**
Print every row of the table in the following format:

**{theInteger} X {times} = {product}**
### **Constraints**
- The integer will be in the interval **[1…100]**
### **Examples**

|**Input**|**Output**||**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|<p>5</p><p>1</p>|<p>5 X 1 = 5</p><p>5 X 2 = 10</p><p>5 X 3 = 15</p><p>5 X 4 = 20</p><p>5 X 5 = 25</p><p>5 X 6 = 30</p><p>5 X 7 = 35</p><p>5 X 8 = 40</p><p>5 X 9 = 45</p><p>5 X 10 = 50</p>||<p>2</p><p>5</p>|<p>2 X 5 = 10</p><p>2 X 6 = 12</p><p>2 X 7 = 14</p><p>2 X 8 = 16</p><p>2 X 9 = 18</p><p>2 X 10 = 20</p>||<p>2</p><p>14</p>|2 X 14 = 28|
## 12. **Even Number**
Take as an input an even number and **print its absolute value**. If the number is odd, print "Please write an even number." and continue reading numbers.

### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|<p>1</p><p>3</p><p>6</p>|<p>Please write an even number.</p><p>Please write an even number.</p><p>The number is: 6</p>||-6|<p>The number is: 6</p><p></p>|
## 13. **Refactor Sum of Odd Numbers**
You are assigned to **find and fix the bugs** in an existing piece of code, using the **debugger**. You should trace the program execution to find the lines of code that produce incorrect or unexpected results.

You are given a program (existing source code) that prints the next **n** **odd numbers** (starting from 1) and on the **last row** prints the **sum of them**.
### **Examples**

|**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :-: | :-: | :-: |
|5|<p>1</p><p>3</p><p>5</p><p>7</p><p>9</p><p>Sum: 25</p>||3|<p>1</p><p>3</p><p>5</p><p>Sum: 9</p>|


|**SumOddNumbers.java**|
| :-: |
|Scanner sc = **new** Scanner(System.***in***);<br>**int** n = Integer.*parseInt*(sc.nextLine());<br>**int** sum = 1;<br>**for** (**int** i = 0; i <= n; i++) {<br>`    `System.***out***.print(2 \* i + 1);<br>`    `sum += 2 \* i;<br>}<br>System.***out***.printf(**"Sum: %d%n"**, sum);|



