
# **Lab: Polymorphism**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1592/Polymorphism-Lab).
## 1. **Math Operation**
Create a class **MathOperation**, which should have method **add()**. Method **add()** have to be invoked with **two, three** or **four Integers.**

You should be able to use the class like this:

|**Main.java**|
| :-: |
|<p>**public static void** main(String[] args) **throws** IOException {<br>`    `MathOperation math = **new** MathOperation();<br>`    `System.***out***.println(math.add(2, 2));<br>`    `System.***out***.println(math.add(3, 3, 3));<br>`    `System.***out***.println(math.add(4, 4, 4, 4));</p><p>}</p>|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||<p>4</p><p>9</p><p>16</p>|
|||
| ||

### **Solution**

Class **MathOperation** should look like this:



![image](https://user-images.githubusercontent.com/67644402/156407081-25f94880-8c53-4ef9-a007-696ec6593ad2.png)

## 2. **Shapes**
Create class hierarchy, starting with abstract class **Shape**:

- **Fields:**
  - **perimeter: Double**
  - **area: Double**
- **Encapsulation for this fields**
- **Abstract methods:**
  - **calculatePerimeter()**
  - **calculateArea()**

Extend Shape class with two children:

- **Rectangle**
- **Circle**

Each of them needs to have:

- **Fields:** 

For **Rectangle**

- **height: Double**
- **width: Double** 

For **Circle**

- **radius: Double**
- **Encapsulation for this fields**
- **Public constructor** 
- **Concrete methods for calculations (perimeter and area)**
## 3. **Animals**
Create a class **Animal**, which holds two fields:

- **name**: **String**
- **favouriteFood**: **String**

Animal has one abstract method **explainSelf(): String.**
You should add two new classes - **Cat** and **Dog. Override** the **explainSelf()** method by adding concrete animal sound on a new line. (Look at examples below)

You should be able to use the class like this:

|**Main**|
| :-: |
|**public static void** main(String[] args) {<br>`    `Animal cat = **new** Cat(**"Oscar"**, **"Whiskas"**);<br>`    `Animal dog = **new** Dog(**"Rocky"**, **"Meat"**);<br>`    `System.***out***.println(cat.explainSelf());<br>`    `System.***out***.println(dog.explainSelf());<br>}|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||<p>I am Oscar and my favourite food is Whiskas</p><p>MEEOW</p><p>I am Rocky and my favourite food is Meat</p><p>DJAAF</p>|

### **Solution

![image](https://user-images.githubusercontent.com/67644402/156407257-2b2179a8-1868-44ea-bb14-4a77ccf70346.png)



![image](https://user-images.githubusercontent.com/67644402/156407287-ff850531-c973-4f05-af09-c0106fe0e82d.png)



Follow us:

© SoftUni – [about.softuni.bg](about.softuni.bg). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.

