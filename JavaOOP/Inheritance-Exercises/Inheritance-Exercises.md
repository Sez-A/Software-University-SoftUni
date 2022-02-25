
# **Exercises: Inheritance**
This document defines the exercises for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1580/Inheritance-Exercises).
## 1. **Person**
NOTE: You need a public class **Main**. Create a package **person**.

You are asked to model an application for storing data about people. You should be able to have a **Person** and a **Child**. The child derives from the person. Every person has a **name**, and an **age**. Your task is to model the application.

The **Person** class also have **getters** for the fields.

Create a **Child** class that inherits **Person** and has the same public constructor definition. However, do not copy the code from the **Person** class - **reuse the Person class's constructor**.


|**Sample Main()**|
| :-: |
|<p>**public class** Main {<br>`    `**public static void** main(String[] args) {<br>`        `Scanner sc = **new** Scanner(System.***in***);<br><br>`        `String name = sc.nextLine();<br>`        `**int** age = Integer.*parseInt*(sc.nextLine());<br><br>`        `Child child = **new** Child(name, age);<br><br>`        `System.***out***.println(child.getName());<br>`        `System.***out***.println(child.getAge());<br>`    `}<br>}</p><p></p>|
### **Input / Output**

|**Input**|**Output**|
| :-: | :-: |
|<p>Peter</p><p>13</p>|<p>Peter</p><p>13</p>|
|<p>George</p><p>10</p>|<p>George</p><p>10</p>|
## 2. **Zoo**
**NOTE**: You need a public class **Main**.

Create a package **zoo**. It needs to contain the following classes: 

![image](https://user-images.githubusercontent.com/67644402/155752273-4cc62aa6-8cf1-496b-a416-c6f43c31c978.png)

Follow the diagram and create all of the classes. **Each** of them, except the **Animal** class, should **inherit** from **another** **class**. The Animal class should have field **name** – **String** and **Getter** for **name**.

Every class should have:

- A public constructor, which accepts one parameter: **name**

Zip your package and upload it in Judge.
## 3. **Players and Monsters**
NOTE: You need a public class **Main**. Create a package **hero**.

Your task is to create the following game hierarchy: 

![image](https://user-images.githubusercontent.com/67644402/155752347-23b13005-6ae4-41c0-9337-b1fcae78fc9b.png)

Create a class **Hero**. It should contain the following members:

- A public constructor, which accepts:
  - **username – String**
  - **level – int**
- The following fields:
  - **username - String**
  - **level – int**
- Getters for username and level
- **toString()** method

Hint: Override **toString()** of the base class in the following way:

|**Sample toString()**|
| :-: |
|@Override<br>**public** String toString() {<br>`    `**return** String.*format*(**"Type: %s Username: %s Level: %s"**,<br>`            `**this**.getClass().getName(),<br>`            `**this**.getUsername(),<br>`            `**this**.getLevel());<br>}|
## 4. **Need for Speed**
NOTE: You need a public class **Main**. Create the following **hierarchy** with the following **classes**: 

![image](https://user-images.githubusercontent.com/67644402/155752388-ff2a7524-8244-445c-a561-c57f46028221.png)

Create a base class **Vehicle**. It should contain the following members:

- **DEFAULT\_FUEL\_CONSUMPTION – final static double (constant)**
- **fuelConsumption –double**
- **fuel – double**
- **horsePower – int**
- **Getters and Setters for the fields**
- A public constructor which accepts (**fuel**, **horsePower**) and **set** the **default fuel consumption** on the field **fuelConsumption**
- **void drive(double kilometers)**
  - The **drive** method should have a functionality to reduce the **fuel** based on the travelled kilometers and fuel consumption. Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving.

The default fuel consumption for **Vehicle** is **1.25**.** Some of the classes have different default fuel consumption:

- **SportCar – DEFAULT\_FUEL\_CONSUMPTION = 10**
- **RaceMotorcycle – DEFAULT\_FUEL\_CONSUMPTION = 8**
- **Car – DEFAULT\_FUEL\_CONSUMPTION = 3**

Zip your package and upload it in Judge.
### **Hint**	
In the child classes' constructors use **super.setFuelConsumption()** to set **fuelConsumption.**
## 5. **Restaurant**
NOTE: You need a public class **Main**. Create a **restaurant** package with the following classes and hierarchy:

There are **Food** and **Beverages** in the restaurant and they are all products.

The **Product** class must have the following members:

- A public constructor with the following parameters: **String name, BigDecimal price**
- **name – String**
- **price - BigDecimal**
- **Getters for the fields**

**Beverage** and **Food** classes are products. The **Beverage** class must have the following members:

- A public constructor with the following parameters: **String name, BigDecimal price, double milliliters**
- **name – String**
- **price – BigDecimal**
- **milliliters - double**
- **Getter for milliliters**

The **Food** class must have the following members:

- A constructor with the following parameters: **String name, BigDecimal price, double grams**
- **name – String**
- **price – double**
- **grams - double**
- **Getter for grams**

**HotBeverage** and **ColdBeverage** are **beverages** and they accept the following parameters upon initialization: **String name, BigDecimal price, double milliliters**

**Coffee** and **Tea** are hot beverages. The **Coffee** class must have the following additional members:

- **double COFFEE\_MILLILITERS = 50**
- **BigDecimal COFFEE\_PRICE = 3.50**
- **caffeine – double**
- **Getter for caffeine**

**MainDish**, **Dessert** and **Starter** are food. They all accept the following parameters upon initialization: **String name, BigDecimal price, double grams**. **Dessert** must accept one more parameter in its constructor: **double calories**.

- **calories – double**
- **Getter for calories**

Make **Salmon**, **Soup** and **Cake** inherit the proper classes.

A **Cake** must have the following members upon initialization:

- **double CAKE\_GRAMS = 250**
- **double CAKE\_CALORIES = 1000**
- **BigDecimal CAKE\_PRICE = 5**

A **Salmon** must have the following members upon initialization:

- **double SALMON\_GRAMS = 22**

Zip your package and upload it in Judge.
## 6. **Animals**
NOTE: You need a public class **Main**.

Create a hierarchy (package) of **animals**. Your program should have three different animals – **Dog**, **Frog** and **Cat**. Deeper in the hierarchy you should have two additional classes – **Kitten** and **Tomcat**. **Kittens are "Female" and Tomcats are "Male".** All types of animals should be able to produce some kind of sound - **String produceSound()**. For example, the dog should be able to bark. Your task is to model the hierarchy and test its functionality. Create an animal of each kind and make them all produce sound and create getters for all fields.

You will be given some lines of input. Each two lines will represent an animal. On the first line will be the type of animal and on the second – the name, the age and the gender. When the command "**Beast!**" is given, stop the input and print all the animals in the format shown below.
### **Output**
- Print the information for each animal on three lines. On the first line, print: **"{animalType}"**
- On the second line, print: **"{name} {age} {gender}"**
- On the third line, print the sounds it produces: **"{produceSound()}"**
### **Constraints**
- Each **Animal** should have a **name**, an **age** and a **gender.**
- **All** input values should **not be blank** (e.g. name, age and so on…).
- If you receive an input for the **gender** of a **Tomcat** or a **Kitten**, ignore it but **create** the animal.
- If the input is invalid for one of the properties, throw an exception with message: **"Invalid input!".**
- Each animal should have the functionality to **produceSound().**
- Here is the type of sound each animal should produce:
  - Dog: **"Woof!"**
  - Cat: **"Meow meow"**
  - Frog: **"Ribbit"**
  - Kittens: **"Meow"**
  - Tomcat: **"MEOW"**


### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>Cat</p><p>Tom 12 Male</p><p>Dog</p><p>Rex 132 Male</p><p>Beast!</p>|<p>Cat </p><p>Tom 12 Male</p><p>Meow meow</p><p>Dog </p><p>Rex 132 Male</p><p>Woof!</p>|
|<p>Frog</p><p>Kermit 12 Male</p><p>Beast!</p>|<p>Frog </p><p>Kermit 12 Male</p><p>Ribbit</p>|
|<p>Frog</p><p>Froakie -2 Male</p><p>Frog</p><p>Froakie 2 Male</p><p>Beast!</p>|<p>Invalid input!</p><p>Frog</p><p>Froakie 2 Male</p><p>Ribbit</p>|
### **Hint**
To find the name of the class you can use **this.getClass().getSimpleName()** in **toString()** method inside **Animal** class.



Follow us:

© SoftUni – [about.softuni.bg](about.softuni.bg). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
