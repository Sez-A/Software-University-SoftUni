
# **Lab: Objects and Classes**
Problems for exercises and homework for the ["Technology Fundamentals" course @ SoftUni](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021)

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1319)
# I. **Using the Built-in Java Classes**

## 1. **Randomize Words**
You are given a **list of words on one line**. **Randomize their order** and print each word on a separate line.

### **Examples**

|**Input**|**Output**|**Comments**|
| :-: | :-: | :-: |
|Welcome to SoftUni and have fun learning programming|<p>learning</p><p>Welcome</p><p>SoftUni</p><p>and</p><p>fun</p><p>programming</p><p>have</p><p>to</p>|The order of the words in the output will be different after each program execution.|
|Java is the best programming language|<p>the</p><p>programming</p><p>best</p><p>language</p><p>is</p><p>Java</p>||
### **Hints**  

- **Split** the input string (by space) and create an **array of words.**  
-  Create a random number generator - an object **rnd** of type **Random.**
- In a **for-loop exchange each number** at positions 0, 1, …, **words.Length-1** by a number at **random position**. To generate a random number in range** use **rnd.nextInt(words.length)**.
- Print each word in the array on new line.

## 2. **Sum Big Numbers**

You will receive two numbers **(0 to 1050),** print their sum. 

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>923847238931983192462832102</p><p>934572893617836459843471846187346</p>|934573817465075391826664309019448|
|<p>4</p><p>100</p>|104|
|||
|||

### **Hints**

Use the class [**BigInteger**](https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html)

Import the namespace "**java.math.BigInteger**":

![image](https://user-images.githubusercontent.com/67644402/143691214-b0cd40fe-0edc-4a9b-b6e1-ee9beaad88c2.png)


Use the type **BigInteger** to read the numbers and calculate their sum:

![image](https://user-images.githubusercontent.com/67644402/143691219-443c94b4-8619-49b3-bf65-796123215389.png)


## 3. **Big Factorial**
You will receive **N** - number in range **[0 - 1000]**. Calculate **Factorial** of **N** and print the result.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|5|120|
|50|30414093201713378043612608166064768844377641568960512000000000000|
# II. **Defining Simple Classes**

## 4. **Songs**
Define a class **Song**, which holds the following information about songs: **Type List**, **Name** and **Time**.
On the first line you will receive the **number of songs** **-** **N**. 
On the **next N-lines** you will be receiving data in the following format: **"{typeList}\_{name}\_{time}".**
On the last line you will receive "**Type List"** / **"all".** Print only the **Names of the songs** which are from that **Type List** / **All songs**. 
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>3</p><p>favourite\_DownTown\_3:14</p><p>favourite\_Kiss\_4:16</p><p>favourite\_Smooth Criminal\_4:01</p><p>favourite</p>|<p>DownTown</p><p>Kiss</p><p>Smooth Criminal</p>|
|<p>4</p><p>favourite\_DownTown\_3:14</p><p>listenLater\_Andalouse\_3:24</p><p>favourite\_In To The Night\_3:58</p><p>favourite\_Live It Up\_3:48</p><p>listenLater</p>|Andalouse|
|<p>2</p><p>like\_Replay\_3:15</p><p>ban\_Photoshop\_3:48</p><p>all</p>|<p>Replay</p><p>Photoshop</p>|
|||
|||

### **Solution**

Define class Song with fields: **Type List**, **Name** and **Time**:

![image](https://user-images.githubusercontent.com/67644402/143691244-0dabb415-c1d5-45c4-98a0-a9e2ac19d7d1.png)

Define getters and setters: use keys **ALT + INS** and generate Getter and Setter:

![image](https://user-images.githubusercontent.com/67644402/143691248-a9f63ff2-b9ea-411a-a88b-9078af863d96.png)

Read the input lines, make collection and store the data:

![image](https://user-images.githubusercontent.com/67644402/143691256-6f8068d7-5a6c-4de2-b1c6-e733ad7fdb1c.png)

Finally read your last line – **Type List** and print the result:

![image](https://user-images.githubusercontent.com/67644402/143691265-88622259-092f-474d-948d-36ac39b0a390.png)

You can use **Stream API** to filter the collection:

![image](https://user-images.githubusercontent.com/67644402/143691268-4d2e678e-cf96-4441-ba4d-783ffb50321c.png)


## 5. **Students**
Define a class **Student**, which holds the following information about students: first name, last name, age and hometown. 

Read list of students until you receive "**end**" command. After that, you will receive a city name. Print only students which are from the given city, in the following format: **"{firstName} {lastName} is {age} years old"**.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>John Smith 15 Sofia</p><p>Peter Ivanov 14 Plovdiv</p><p>Linda Bridge 16 Sofia</p><p>Simon Stone 12 Varna</p><p>end</p><p>Sofia</p>|<p>John Smith is 15 years old</p><p>Linda Bridge is 16 years old</p>|
|<p>Anthony Taylor 15 Chicago</p><p>David Anderson 16 Washington</p><p>Jack Lewis 14 Chicago</p><p>David Lee 14 Chicago</p><p>end</p><p>Chicago</p>|<p>Anthony Taylor is 15 years old</p><p>Jack Lewis is 14 years old</p><p>David Lee is 14 years old</p>|
|||
|                                                              ||

### **Solution**

Define a class student with the following properties: **firstName**, **lastName**, **age** and **city**:  

![image](https://user-images.githubusercontent.com/67644402/143691273-68d0163a-29fa-4272-ab4c-f6300d551678.png)

Generate constructor in class Student**:  ALT + INSERT**

![image](https://user-images.githubusercontent.com/67644402/143691275-78e38855-6bcd-4311-830b-78d7b2340999.png)

Read a list of students.

![image](https://user-images.githubusercontent.com/67644402/143691279-41a7d450-d483-45d3-a5c1-d2546211dc17.png)

Read a city name and print only the students which are from the given city.
You can filter the students with stream.

![image](https://user-images.githubusercontent.com/67644402/143691290-2aea0eeb-a215-4c34-8058-53aa11212018.png)

## 6. **Students 2.0**
Use the class from the previous problem. If you receive a student which already exists (first name and last name should be **unique**) overwrite the information.

### **Hints**
Check if the given student already exists:

![image](https://user-images.githubusercontent.com/67644402/143691303-c6e739a2-bce6-4305-85bf-67a0d70bf922.png)
![image](https://user-images.githubusercontent.com/67644402/143691307-d55adb6a-c8f3-42a6-af35-29f005e4ff1a.png)

Overwrite the student information.
First, we have to find the existing student:

![image](https://user-images.githubusercontent.com/67644402/143691309-97aef7fe-1358-417b-8b5e-5dd33db4e551.png)
![image](https://user-images.githubusercontent.com/67644402/143691313-da53646d-514b-4a00-9a82-8e2cb6e317b7.png)

Finally, we have to overwrite the information:

![image](https://user-images.githubusercontent.com/67644402/143691318-f934d150-5c39-4282-b62f-cab36479d67e.png)

We can use **Stream API** as well:

![image](https://user-images.githubusercontent.com/67644402/143691323-932953bf-69fa-4819-b5d8-6fddbc9ff91a.png)

**findFirst** returns the first occurrence or **null**.





### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>John Smith 15 Sofia</p><p>John Smith 16 Sofia</p><p>Linda Bridge 17 Sofia</p><p>Simon Stone 12 Varna</p><p>end</p><p>Sofia</p>|<p>John Smith is 16 years old</p><p>Linda Bridge is 17 years old</p>|
|<p>J S 3 S</p><p>Peter Ivanov 14 P</p><p>P J 104 S</p><p>J P 61 S</p><p>Simon Stone 12 Varna</p><p>Simon Sone 12 Varna</p><p>end</p><p>Varna</p>|<p>Simon Stone is 12 years old</p><p>Simon Sone is 12 years old</p>|

