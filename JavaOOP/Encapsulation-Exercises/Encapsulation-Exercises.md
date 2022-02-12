
# **Lab: Encapsulation**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1535/Encapsulation-Lab).
## 1. **Sort by Name and Age**
Create a class **Person**, which should have **private** fields for:

- **firstName**: **String**
- **lastName**: **String**
- **age**: **int**
- **toString()** - **override**

You should be able to use the class like this:

|**Main.java**|
| :-: |
|**public static void** main(String[] args) **throws** IOException {<br>`    `BufferedReader reader = **new** BufferedReader(**new** InputStreamReader(System.***in***));<br>`    `**int** n = Integer.*parseInt*(reader.readLine());<br><br>`    `List<Person> people = **new** ArrayList<>();<br><br>`    `**for** (**int** i = 0; i < n; i++) {<br>`        `String[] input = reader.readLine().split(**" "**);<br>`        `people.add(**new** Person(input[0], input[1], Integer.*parseInt*(input[2])));<br>`    `}<br><br>`    `Collections.*sort*(people, (firstPerson, secondPerson) -> {<br>`        `**int** sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());<br><br>`        `**if** (sComp != 0) {<br>`            `**return** sComp;<br>`        `} **else** { <br>`            `**return** Integer.compare(firstPerson.getAge(), secondPerson.getAge());** <br>`        `}<br>`    `});<br><br>`    `**for** (Person person : people) {<br>`        `System.***out***.println(person.toString());<br>`    `}<br>}|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>5</p><p>Angel Ivanov 65</p><p>Boris Georgiev 57</p><p>Veny Ivanov 27</p><p>Angel Harizanov 44</p><p>Boris Angelov 35</p>|<p>Angel Harizanov is 44 years old.</p><p>Angel Ivanov is 65 years old.</p><p>Boris Angelov is 35 years old.</p><p>Boris Georgiev is 57 years old.</p><p>Veny Ivanov is 27 years old.</p>|
|<p>4</p><p>Sara Cameron 21</p><p>John Petrovich 53</p><p>Anna Glen 21</p><p>John Alekseevich 43</p>|<p>Anna Glen is 21 years old.</p><p>John Alekseevich is 43 years old.</p><p>John Petrovich is 53 years old.</p><p>Sara Cameron is 21 years old.</p>|

### **Solution**
Create a **new class** and ensure **proper naming**. Define the **private** fields:



![image](https://user-images.githubusercontent.com/67644402/153705404-75522d41-ec4e-4e4b-a05b-497c183a4e5b.png)



Create getters and apply them access modifiers, which are as strictly as possible:



![image](https://user-images.githubusercontent.com/67644402/153705415-9904edd8-aff6-4ad0-897c-1620eaf42ddb.png)



Override **toString()** method:



![image](https://user-images.githubusercontent.com/67644402/153705423-ad2a22a2-d15b-4dda-8897-48c37b911ae0.png)



## 2. **Salary Increase**
Read person with their **names**, **age** and **salary**. Read **percent bonus** to every person salary. People younger **than 30** get half bonus. Expand **Person** from previous task. Add **salary** **field** and **getter** and **setter** with proper **access**.

New **fields** and **methods**

- **salary**: **double** 
- **increaseSalary(double bonus)**

You should be able to use the class like this:

|**Main.java**|
| :-: |
|**public static void** main(String[] args) **throws** IOException {<br>`    `BufferedReader reader = **new** BufferedReader(**new** InputStreamReader(System.***in***));<br>`    `**int** n = Integer.*parseInt*(reader.readLine());<br>`    `List<Person> people = **new** ArrayList<>();<br>`    `**for** (**int** i = 0; i < n; i++) {<br>`        `String[] input = reader.readLine().split(**" "**);<br>`        `people.add(**new** Person(input[0], input[1], Integer.*parseInt*(input[2]), Double.*parseDouble*(input[3])));<br>`    `}<br>`    `**double** bonus = Double.*parseDouble*(reader.readLine());<br>`    `**for** (Person person : people) {<br>`        `person.increaseSalary(bonus);<br>`        `System.***out***.println(person.toString());<br>`    `}<br>}|
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>5</p><p>Angel Ivanov 65 2200</p><p>Boris Georgiev 57 3333</p><p>Veny Ivanov 27 600</p><p>Angel Harizanov 44 666.66</p><p>Boris Angelov 35 559.4</p><p>20</p>|<p>Angel Ivanov gets 2640.0 leva</p><p>Boiko Georgiev gets 3999.6 leva</p><p>Veny Ivanov gets 660.0 leva</p><p>Angel Harizanov gets 799.992 leva</p><p>Boris Angelov gets 671.28 leva</p>|
|<p>4</p><p>Sara Cameron 21 1200</p><p>John Petrovich 53 850.50</p><p>Anna Glen 21 1640</p><p>John Alekseevich 43 2100</p><p>13</p>|<p>Sara Cameron gets 1278.0 leva</p><p>John Petrovich gets 961.065 leva</p><p>Anna Glen gets 1746.6 leva</p><p>John Alekseevich gets 2373.0 leva</p>|

### **Solution**

Add new **private** field for **salary** and proper **setters** and **getters** for it:



![image](https://user-images.githubusercontent.com/67644402/153705452-9da9e49c-6bf3-46ff-876f-02a7e14ce2be.png)



Add new **method**, which will **increase** salary with bonus:



![image](https://user-images.githubusercontent.com/67644402/153705458-48bbdeff-90a9-41f5-ae2d-adbd0cebfd9b.png)



Refactor **constructor** and **toString()** method for this task.
## 3. **Validation Data**
Expand **Person** with proper validation for every field:

- **Names must be at least 3 symbols**
- **Age must not be zero or negative**
- **Salary can't be less than 460.0** 

Print proper message to end user (look at example for messages). 

Don't use **System.out.println()** in **Person** class.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>5</p><p>Asen Ivanov -6 2200</p><p>B Borisov 57 3333</p><p>Ventsislav Ivanov 27 600</p><p>Asen H 44 666.66</p><p>Boiko Angelov 35 300</p><p>20</p>|<p>Age cannot be zero or negative integer</p><p>First name cannot be less than 3 symbols</p><p>Last name cannot be less than 3 symbols</p><p>Salary cannot be less than 460 leva</p><p>Ventsislav Ivanov gets 660.0 leva</p>|
|<p>4</p><p>Sara Cameron 21 1200</p><p>John Petrovich -53 850.50</p><p>Anna Glen 21 430</p><p>John Alekseevich 0 2100</p><p>13</p>|<p>Age cannot be zero or negative integer</p><p>Salary cannot be less than 460 leva</p><p>Age cannot be zero or negative integer</p><p>Sara Cameron gets 1278.0 leva</p>|
### **Solution**

Add **validation** to all **setters** in **Person**. Validation may look like this or something similar:



![image](https://user-images.githubusercontent.com/67644402/153705479-92c551a1-3fa9-40f8-808b-7fcfd0781e53.png)



## 4. **First and Reserve Team**

Create a **Team** class. Add to this team all person you read. All person **younger** than 40 go in **first team**, others go in **reverse team**. At the end print first and reserve team sizes.

The class should have **private fields** for:

- **name**: **String**
- **firstTeam**: **List<Person>**
- **reserveTeam**: **List<Person>**

The class should have **constructors**:

- **Team(String name)**

The class should also have private method for **setName** and **public methods** for:

- **getName()**: **String**
- **addPlayer(Person person)**: **void**
- **getFirstTeam()**: **List<Person> (Collections.unmodifiableList)**
- **getReserveTeam()**: **List<Person> (Collections.unmodifiableList)**

You should be able to use the class like this:



![image](https://user-images.githubusercontent.com/67644402/153705497-04db9f35-ffce-49b9-ab95-bd628104d915.png)



You should **NOT** be able to use the class like this:





![image](https://user-images.githubusercontent.com/67644402/153705504-4e412cfb-7254-4870-9d61-361cb3752bd9.png)        ![image](https://user-images.githubusercontent.com/67644402/153705512-3edc1dfb-07fa-40a4-bdeb-396733299677.png)









### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>5</p><p>Asen Ivanov 20 2200</p><p>Boiko Borisov 57 3333</p><p>Ventsislav Ivanov 27 600</p><p>Grigor Dimitrov 25 666.66</p><p>Boiko Angelov 35 555</p>|<p>First team have 4 players</p><p>Reserve team have 1 players</p>|
|<p>4</p><p>Sara Cameron 21 1200</p><p>John Petrovich 53 850.50</p><p>Anna Glen 21 475</p><p>John Alekseevich 27 2100</p>|<p>First team have 3 players</p><p>Reserve team have 1 players</p>|
|||
|||

### **Solution**



Add new class Team. Its fields and constructor look like:



![image](https://user-images.githubusercontent.com/67644402/153705540-36df9605-3388-4223-a2db-e68a3d6ea230.png)



**firstTeam** and **reserveTeam** have only **getters**:



![image](https://user-images.githubusercontent.com/67644402/153705547-e2592853-e5d4-446a-b93f-0cbcce256bac.png)



There will be only one method, which add players to teams:



![image](https://user-images.githubusercontent.com/67644402/153705557-bb32b133-87b0-4c6f-a501-a67fe6167018.png)





