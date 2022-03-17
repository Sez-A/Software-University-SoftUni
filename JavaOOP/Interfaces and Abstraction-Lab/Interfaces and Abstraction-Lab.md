
# **Lab: Interfaces and Abstraction**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1581/Interfaces-and-Abstraction-Lab).
## 1. **Car Shop**
Build hierarchy from **classes** and **interfaces** for this UML diagram:


|<p>**<<inteface>>**</p><p>**<<Car>>**</p>|
| :-: |
|**+TIRES: Integer**|
|<p>**+getModel(): String**</p><p>**+getColor(): String**</p><p>**+getHorsePower(): Integer**</p><p>**+countryProduced(): String**</p>|

|**<<Serializable>>**|
| :-: |
![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.001.png)

|**Seat**|
| :-: |
|**+toString(): String**|
![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.002.png)






Your hierarchy have to be used with this code

|**Main.java**|
| :-: |
|**public static void** main(String[] args) {<br>`    `Car seat = **new** Seat(**"Leon"**, **"gray"**, 110, **"Spain"**);<br><br>`    `System.***out***.println(String.*format*(<br>`            `**"%s is %s color and have %s horse power"**,<br>`            `seat.getModel(),<br>`            `seat.getColor(),<br>`            `seat.getHorsePower()));<br>`    `System.***out***.println(seat.toString());<br>}|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||<p>Leon is gray color and have 110 horse power</p><p>This is Leon produced in Spain and have 4 tires</p>|
### **Solution**
![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.003.png)

**Note:** consider using the wrapper classes in the **Seat** constructor**.**
## 2. **Car Shop Extend**

|**<<Car>>**|
| :-: |
Extend previous problem: 

![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.004.png)


|**CarImpl**|
| :-: |
|<p>**+CarImpl(model, color, horsePower, countryProduced)**</p><p>**+toString(): String**</p>|



![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.005.png)![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.006.png)

|**<<Rentable>>**|
| :-: |
|<p>**+getMinRentDay(): Integer**</p><p>![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.007.png)**+getPricePerDay(): Double**</p>|

|**<<Sellable>>**|
| :-: |
|**+getPrice(): Double**|


![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.008.png)





|**Seat**|
| :-: |
|**-price: Double**|
|**+toString(): String**|

|**Audi**|
| :-: |
|<p>**-minRentDay: Integer**</p><p>**-pricePerDay: Double**</p>|
|**+toString(): String**|






Your hierarchy has to be used with this code:

|**Main.java**|
| :-: |
|<p>**public static void** main(String[] args) {<br>`    `Sellable seat = **new** Seat(**"Leon"**, **"Gray"**, 110, **"Spain"**, 11111.1);<br>`    `Rentable audi = **new** Audi(**"**A4**"**, **"Gray"**, 110, **"Germany"**, 3, 99.9);<br><br>`    `*printCarInfo*(seat);<br>`    `*printCarInfo*(audi);<br>}<br><br>**private static void** printCarInfo(Car car) {<br>`    `System.***out***.println(String.*format*(<br>`            `**"%s is %s color and have %s horse power"**,<br>`            `car.getModel(),<br>`            `car.getColor(),<br>`            `car.getHorsePower()));<br>`    `System.***out***.println(car.toString());<br>}</p><p></p>|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||<p>Leon is Gray color and have 110 horse power</p><p>This is Leon produced in Spain and have 4 tires</p><p>Leon sells for 11111,100000</p><p>A4 is Gray color and have 110 horse power</p><p>This is A4 produced in Germany and have 4 tires</p><p>Minimum rental period of 3 days. Price per day 99,900000</p>|
## 3. **Say Hello**
Build hierarchy from classes and interfaces for this **UML** diagram:


|**<<Person>>**|
| :-: |
|<p>**+getName(): String**</p><p>**+sayHello(): String**</p>|



![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.009.png)![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.010.png)![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.011.png)

|**Chinese**|
| :-: |
|**-name: String**|
|**+sayHello(): String**|

|**Bulgarian**|
| :-: |
|**-name: String**|
|**+sayHello(): String**|


|**European**|
| :-: |
|**-name: String**|
||





Your hierarchy have to be used with this code:

|**Main.java**|
| :-: |
|<p>**public static void** main(String[] args) {<br>`    `List<Person> persons = **new** ArrayList<>();</p><p><br>    <br>`    `persons.add(**new** Bulgarian(**"Peter"**));<br>`    `persons.add(**new** European(**"Peter"**));<br>`    `persons.add(**new** Chinese(**"Peter"**));<br><br>`    `**for** (Person person : persons) {<br>`        `*print*(person);<br>`    `}<br>}<br><br>**private static void** print(Person person) {<br>`    `System.***out***.println(person.sayHello());<br>}</p>|

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||<p>Здравей</p><p>Hello</p><p>Djydjybydjy</p>|

## 4. **Say Hello Extend**
Build hierarchy from classes and interfaces for this **UML** diagram


|**Bulgarian**|
| :-: |
|<p>**+Bulgarian(name)**</p><p>**+sayHello(): String**</p>|


![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.012.png)

|**<<Person>>**|
| :-: |
|<p>![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.013.png)**+getName(): String**</p><p>**+sayHello(): String**</p>|

|<p>***(Abstract)***</p><p>***BasePerson***</p>|
| :-: |
|**-name: String**|
|<p>![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.014.png)**#BasePerson(name)**</p><p>**+getName(): String**</p><p>**-setName(): void**</p>|


|**European**|
| :-: |
|<p>**+European(name)**</p><p>**+sayHello(): String**</p>|

![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.015.png)




|**Chinese**|
| :-: |
|<p>**+Chinese(name)**</p><p>**+sayHello(): String**</p>|





Your hierarchy have to be used with this code:

|**Main.java**|
| :-: |
|<p>**public static void** main(String[] args) {<br>`    `List<Person> persons = **new** ArrayList<>();</p><p><br>    <br>`    `persons.add(**new** Bulgarian(**"Peter"**));<br>`    `persons.add(**new** European(**"Peter"**));<br>`    `persons.add(**new** Chinese(**"Peter"**));<br><br>`    `**for** (Person person : persons) {<br>`        `*print*(person);<br>`    `}<br>}<br><br>**private static void** print(Person person) {<br>`    `System.***out***.println(person.sayHello());<br>}</p>|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
||<p>Здравей</p><p>Hello</p><p>Djydjybydjy</p>|
## 5. **Border Control**
It’s the future, you’re the ruler of a totalitarian dystopian society inhabited by **citizens** and **robots**, since you’re afraid of rebellions you decide to implement strict control of who enters your city. Your soldiers check the **Id**s of everyone who enters and leaves.

You will receive from the console an **unknown** amount of lines until the command "**End**" is received, on each line there will be the information for either **a citizen** or **a robot** who tries to enter your city in the format 
**"{name} {age} {id}"** for citizens and "**{model} {id}**" for robots. 

After the end command on the next line you will receive a single number representing **the last digits of fake ids**, all citizens or robots whose **Id** ends with the specified digits must be detained.

The output of your program should consist of all detained **Id**s each on a separate line (the order of printing doesn’t matter).

|**Robot**|
| :-: |
|-|id: String|
|-|model: String|
|+|Robot(Stirng, String)|
|+|getId() : String|
|+|getModel() : String|

|**Citizen**|
| :-: |
|-|name: String|
|-|age: int|
|-|id: String|
|+|Citizen(Stirng, int, String)|
|+|getName() : String|
|+|getAge() : int|
|+|getId() : String|


|<p>**<<Interface>>**</p><p>**Identifiable**</p>|
| :-: |
|+|getId(): String|
![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.016.png)

![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.017.png)








### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>Peter 22 9010101122</p><p>MK-13 558833251</p><p>MK-12 33283122</p><p>End</p><p>122</p>|<p>9010101122</p><p>33283122</p><p></p>|
|<p>Teo 31 7801211340</p><p>Anna 29 8007181534</p><p>IV-228 999999</p><p>Simon 54 3401018380</p><p>KKK-666 80808080</p><p>End</p><p>340</p>|<p>7801211340</p><p></p>|

## 6. **Ferrari**
Model an application which contains a **class Ferrari** and an **interface**. Your task is simple, you have a **car - Ferrari**, its model is **"488-Spider"** and it has a **driver**. Your Ferrari should have functionality to **use brakes** and **push the gas pedal**. When the **brakes** are pushed down print **"Brakes!"**, and when the **gas pedal** is pushed down - **"brum-brum-brum-brrrrr"**. As you may have guessed this functionality is typical for all cars, so you should **implement an interface** to describe it.

|<p>**<<Interface>>**</p><p>**Car**</p>|
| :-: |
|+|brakes() : String|
|+|gas() : String|
Your task is to **create a Ferrari** and **set the driver's name** to the passed one in the input. After that, print the info. Take a look at the Examples to understand the task better.



![](Aspose.Words.ebf3543d-e463-419c-bcac-6e482b2dca42.018.png)


|**Ferrari**|
| :-: |
|-|driverName: String|
|-|model: String|
|+|Ferrari (String)|
|+|brakes() : String|
|+|gas() : String|
|+|toString(): String|
### **Input**
On the **single input line**, you will be given the **driver's name**.
### **Output**
On the **single output line**, print the model, the messages from the brakes and gas pedal methods and the driver's name. In the following format:

**"{model}/{brakes}/{gas}/{driver's name}"**
### **Constraints**
**The input will always be valid, no need to check it explicitly!** The Driver's name may contain any ASCII characters.
### **Example**

|**Input**|**Output**|
| :-: | :-: |
|Dominic Toretto|488-Spider/Brakes!/brum-brum-brum-brrrrr/Dominic Toretto|
|Brian O'Conner|488-Spider/Brakes!/brum-brum-brum-brrrrr/Brian O'Conner|

Follow us:

© SoftUni – [about.softuni.bg](about.softuni.bg). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
