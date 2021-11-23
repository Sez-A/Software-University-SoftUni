
# **Lab: Methods**
Problems for exercises and homework for the ["Technology Fundamentals" course @ SoftUni](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021).

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1260)
# I. **Declaring and Invoking Methods**

## 1. **Sign of Integer**
Create a method that prints the sign of an integer number.

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|2|The number 2 is positive.|
|-5|The number -5 is negative.|
|0|The number 0 is zero.|
|||
|||

- 2.00 – 2.99 - "**Fail**"
- 3.00 – 3.49 - "**Poor**"
- 3.50 – 4.49 - "**Good**"
- 4.50 – 5.49 - "**Very** **good**"
- 5.50 – 6.00 - "**Excellent**"

## 2. **Grades**

Write a method that **receives a grade** between **2.00** and **6.00** and **prints the corresponding grade in words:**



### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|3.33|Poor|
|4.50|Very good|
|2.99|Fail|

### **Hint**

Read the grade from the console and pass it to a method:



![image](https://user-images.githubusercontent.com/67644402/142995246-aff33342-fdff-410a-9381-180dfbf7a3fc.png)



Then create the method and make the **if** statements for each case:

![image](https://user-images.githubusercontent.com/67644402/142995277-6875b8df-ab0b-454e-b0f4-28c351d4bc6b.png)

## 3. **Printing Triangle**
Create a method for printing triangles as shown below:

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|3|<p>1</p><p>1 2</p><p>1 2 3</p><p>1 2</p><p>1</p>|
|4|<p>1</p><p>1 2</p><p>1 2 3 </p><p>1 2 3 4</p><p>1 2 3</p><p>1 2</p><p>1</p>|

### **Hints**

After you read the input, create a method **for printing a single line** from a **given start** to a **given end**. Choose a **meaningful name** for it, describing its purpose:



![image](https://user-images.githubusercontent.com/67644402/142995306-35036e35-4046-4f50-8ee5-b4e4f3c3611f.png)

You will need two loops. In the first loop you can print the first half of the triangle without the middle line:



![image](https://user-images.githubusercontent.com/67644402/142995339-6f716250-7eef-4a46-88a3-bc77a5d2cfe4.png)

Next, print the middle line:



![image](https://user-images.githubusercontent.com/67644402/142995354-5f4d06e9-84a5-4057-8741-18864a6220b1.png)



Lastly, print the rest of the triangle:





![image](https://user-images.githubusercontent.com/67644402/142995367-465749ea-84be-4e44-b0db-a36db1974949.png)

## 4. **Calculations**

Write a program that receives a string on the first line **("add", "multiply", "subtract", "divide")** and on the next two lines receives **two** numbers. Create four methods (for each calculation) and invoke the right one depending on the command. The method should also print the result (needs to be void).

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>subtract</p><p>5</p><p>4</p>|1|
|<p>divide</p><p>8</p><p>4</p>|2|

### **Hints**

Read the command on the first line and the two numbers, and then make an if/switch statement for each type of calculation:



![image](https://user-images.githubusercontent.com/67644402/142995401-323267f8-3419-4a5d-817b-498e625a7c1a.png)



Then create the four methods and print the result:



![image](https://user-images.githubusercontent.com/67644402/142995423-91b35509-2a75-43ab-a02c-5495f93dc3f0.png)

## 5. **Orders**

Write a method that calculates the total price of an order and prints it on the console. The method should receive **one of the following products**: coffee, water, coke, snacks; and a **quantity** of the product. The prices for a single piece of each product are:

- coffee – 1.50
- water – 1.00
- coke – 1.40
- snacks – 2.00

Print the result rounded to the **second** decimal place.
### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>water</p><p>5</p>|5.00|
|<p>coffee</p><p>2</p>|3.00|
### **Hint**

- Read the product and the quantity.
- Create a method the pass the two variables in.
- Print the result in the method.

# II. **Returning Values and Overloading**

## 6. **Calculate Rectangle Area**
Create a method that calculates and **returns** the [area](https://www.mathopenref.com/rectanglearea.html) of a rectangle by given width and length.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>3</p><p>4</p>|12|
|<p>5</p><p>7</p>|35|

### **Hints**

After reading the input, create a method, but this time **instead** of typing **"static void"** before its name, type **"static double"** as this will make it to **return a value of type double**:



![image](https://user-images.githubusercontent.com/67644402/142995453-5f3b2eb3-39a9-47c5-b60e-3677963e9479.png)



**Invoke** the method in the main and **save the return value in a new variable**:



![image](https://user-images.githubusercontent.com/67644402/142995513-88aed12f-3ff9-4f71-af6d-4a4553425744.png)



## 7. **Repeat String**

Write a method that receives a string and a repeat count **n** (integer). The method should return a new string (the old one repeated n times).

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>abc</p><p>3</p>|abcabcabc|
|<p>String</p><p>2</p>|StringString|

### **Hints**

Firstly read the string and the repeat count n. Then create the method and pass it the variables:



![image](https://user-images.githubusercontent.com/67644402/142995532-72086d71-39eb-46e5-80a3-568cddee085b.png)



## 8. **Math Power**

Create a method that calculates and returns the value of a number raised to a given power.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>2</p><p>8</p>|256|
|<p>5.5</p><p>3</p>|166.375|

### **Hints**

Create a method which will have two parameters - the number and the power, and will return a result of type **double**:



![image](https://user-images.githubusercontent.com/67644402/142995566-8e596678-04de-43a1-a7e6-28191989e380.png)





Invoke the method and use **DecimalFormat** to print the result. For the curious - you can read more [here](http://tutorials.jenkov.com/java-internationalization/decimalformat.html).



![image](https://user-images.githubusercontent.com/67644402/142995590-10e756a5-3882-461f-a5fb-459b6a55bf1b.png)



## 9. **Greater of Two Values**

You are given two values of the same type as input. The values can be of type **int**, **char** of **String**. Create a method **getMax()** that returns the greater of the two values:

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>int</p><p>2</p><p>16</p>|16|
|<p>char</p><p>a</p><p>z</p>|z|
|<p>string</p><p>Ivan</p><p>Todor</p>|Todor|
### **Hints**

1. For this method you need to create three methods with the same name and different signatures.

1. Create a method which will compare integers:

1. ![image](https://user-images.githubusercontent.com/67644402/142995610-9fc736d6-a65e-4e37-8880-484f5e71f971.png)

  

1. Create a second method with the same name which will compare characters. Follow the logic of the previous method:

  

  ![image](https://user-images.githubusercontent.com/67644402/142995635-33c26ee5-2663-481c-82a0-f0c7688b104d.png)

  

  

1. Lastly you need to create a method to compare strings. This is a bit different as strings don't allow to be compared with the operators **">"** and **"<"**:

  ![image](https://user-images.githubusercontent.com/67644402/142995658-7b383ab9-b123-4a62-bdb1-9f65bde36765.png)

  

  You need to use the method "**compareTo()**", which returns an integer value (greater than zero if the compared object is greater, less than zero if the compared object is lesser and zero if the two objects are equal).

  

1. The last step is to read the input. Use appropriate variables and call the **getMax()** from your **main()**.

   ## 10. **Multiply Evens by Odds**
   Create a program that reads an **integer** number and **multiplies the sum of all its even digits** by **the sum of all its odd digits**:
### **Examples**

|**Input**|**Output**|**Comments**|
| :-: | :-: | :-: |
|12345|54|<p>12345 has **2 even digits** - 2 and 4. Even digits have **sum of 6**.</p><p>Also it has **3 odd digits** - 1, 3 and 5. Odd digits have **sum of 9**.</p><p>**Multiply 6 by 9** and you get **54**.</p>|
|-12345|54||
### **Hints**



1. Create a method with a **name describing its purpose** (like **getMultipleOfEvensAndOdds**). The method should have a **single integer parameter** and an **integer return value**. Also, the method will call two other methods:

  

  ![image](https://user-images.githubusercontent.com/67644402/142995680-37dfee6a-7f80-4e33-ad96-3fbecc74b9dc.png)

  

1. Create two other methods each of which will sum either even or odd digits.

1. Implement the logic for summing even digits: 

  

  ![image](https://user-images.githubusercontent.com/67644402/142995716-07929415-c86e-4c82-8937-9a987e718e2a.png)

  

  

1. Do the same for the method that will sum odd digits.

1. As you test your solution you may notice that it doesn't work for negative numbers. Following the program execution line by line, find and fix the bug (**hint: you can use Math.abs()**).

   

   ## 11.**Math Operations**

Write a method that receives **two numbers** and **an operator**, calculates the result and returns it. You will be given three lines of input. The first will be the first number, the second one will be the operator and the last one will be the second number. The possible operators are: **/ \* + -**

Print the result rounded up to the **second** decimal point.
### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>5</p><p>\*</p><p>5</p>|25|
|<p>4</p><p>+</p><p>8</p>|12|

### **Hint**

Read the inputs and create a method that returns a double (the result of the operation):



![image](https://user-images.githubusercontent.com/67644402/142995736-e0476752-aae9-4d9d-9536-7c68866529de.png)
