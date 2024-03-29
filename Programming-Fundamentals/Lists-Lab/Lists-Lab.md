﻿
# **Lab: Lists**
Problems for exercises and homework for the ["Programming Fundamentals" course @ SoftUni](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021)

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1295)
## 1. **Sum Adjacent Equal Numbers**
Write a program to **sum all adjacent equal numbers** in a list of decimal numbers, starting from **left to right**.

- After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed as well (see the examples below).
- Always sum the **leftmost** two equal neighbors (if several couples of equal neighbors are available).
### **Examples**

|**Input**|**Output**|**Explanation**|
| :-: | :-: | :-: |
|3 3 6 1|12 1|**3 3** 6 1 à **6 6** 1 à 12 1|
|8 2 2 4 8 16|16 8 16|8 **2 2** 4 8 16 à 8 **4 4** 8 16 à **8 8** 8 16 à 16 8 16|
|5 4 2 1 1 4|5 8 4|5 4 2 **1 1** 4 à 5 4 **2 2** 4 à 5 **4 4** 4 à 5 8 4|
|0.1 0.1 5 -5|0.2 5 -5|**0.1 0.1** 5 -5 à 0.2 5 -5|
### **Solution**

Read a list from numbers.



![image](https://user-images.githubusercontent.com/67644402/143497375-9e74988c-ea70-4f15-a7a9-bfa61f4a97c9.png)



Iterate through the elements. Check if the number at the current index is equal to the next number. If it is, aggregate the numbers and reset the loop, otherwise don't do anything.

![image](https://user-images.githubusercontent.com/67644402/143497388-926040bb-469b-493e-a63c-254de1484571.png)



Finally, you have to print the numbers joined by space.



![image](https://user-images.githubusercontent.com/67644402/143497400-6444d8c8-dc51-421d-a9e5-3d415a65aa12.png)



![image](https://user-images.githubusercontent.com/67644402/143497411-db86fc36-0775-473d-8931-312976547194.png)



## 2. **Gauss' Trick**

Write a program that **sum** all **numbers in a list** in the following order: 

first **+** last, first + 1 **+** last - 1,** first + 2 **+** last **-** 2**,** … first + n, last - n.



![image](https://user-images.githubusercontent.com/67644402/143497649-0b71a2b9-9a9c-4ace-9f61-cd37f0568b9d.png)



### **Example**

|**Input**|**Output**|
| :-: | :-: |
|1 2 3 4 5|6 6 3|
|1 2 3 4|5 5|
## 3. **Merging Lists**
You are going to receive two lists with numbers. Create a result list which contains the numbers from both of the lists. The first element should be from the first list, the second from the second list and so on. If the length of the two lists are not equal, just add the remaining elements at the end of the list.

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>3 5 2 43 12 3 54 10 23</p><p>76 5 34 2 4 12</p>|3 76 5 5 2 34 43 2 12 4 3 12 54 10 23|
|<p>76 5 34 2 4 12</p><p>3 5 2 43 12 3 54 10 23</p>|76 3 5 5 34 2 2 43 4 12 12 3 54 10 23|


### **Hint**

- Read the two lists

- Create a result list

-  Start looping through them until you reach the end of the smallest one

- Finally add the remaining elements (if any) to the end of the list

  

## 4. **List Manipulation Basics**

Write a program that reads a list of integers. Then until you receive **"end"**, you will be given different **commands:**

**Add {number}:** add a number to the end of the list

**Remove {number}:** remove a number from the list

**RemoveAt {index}:** remove a number at a given index

**Insert {number} {index}:** insert a number at a given index

**Note: All the indices will be valid!**

When you receive the **"end"** command print the **final state** of the list (**separated by spaces**)
### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>4 19 2 53 6 43</p><p>Add 3</p><p>Remove 2</p><p>RemoveAt 1</p><p>Insert 8 3</p><p>end</p>|4 53 6 8 43 3|
|<p>12 34 100 1 45 2 8</p><p>Add 30</p><p>Remove 12</p><p>Remove 3</p><p>RemoveAt 3</p><p>Insert 2 3</p><p>end</p>|34 100 1 2 2 8 30|
|||

### **Solution**

First let us read the list from the console.



![image](https://user-images.githubusercontent.com/67644402/143497662-d6208d74-4c2c-46b5-a236-53dbfd4c8d2c.png)



Next we make the while loop for the commands and make switch statement for the commands



![image](https://user-images.githubusercontent.com/67644402/143497680-22b0c037-5831-4d63-89ac-1615dab026a0.png)



We break if the line is "**end**", otherwise we split it into tokens and process the command.



![image](https://user-images.githubusercontent.com/67644402/143497687-5a33ad3d-98f4-4fc6-a2b2-1ef3f45259af.png)



Now let's implement each command.

![image](https://user-images.githubusercontent.com/67644402/143497697-48ea9aca-1e9a-4149-aceb-3ca8eed6bef9.png)



For all commands **except from** the **"Insert",** **tokens[1]** is the **number/index**. For the **"Insert"** command we receive a **number and an index** (**tokens[1], tokens[2]**)

Finally, we **print** the numbers, joined by **a single space:**

![image](https://user-images.githubusercontent.com/67644402/143497710-e37f5998-027c-4166-8fd7-9d1982386f3e.png)





## 5. **List Manipulation Advanced**

Now we will implement more complicated list commands. Again, read a list, and until you receive **"end"** read commands:

**Contains {number}** – check if the list contains the number. If **yes** print **"Yes**", **otherwise** print **"No such number"**

**Print even** – print **all the numbers** that are **even** **separated by a space**

**Print odd** – print **all the numbers** that are **odd separated by a space**

**Get sum** – print the **sum of all the numbers**

**Filter {condition} {number}** – print all the numbers that **fulfill that condition**. The condition will be either **'<'**, **'>', ">=", "<="**
### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>2 13 43 876 342 23 543</p><p>Contains 100</p><p>Contains 543</p><p>Print even</p><p>Print odd</p><p>Get sum</p><p>Filter >= 43</p><p>Filter < 100</p><p>end</p>|<p>No such number</p><p>Yes</p><p>2 876 342</p><p>13 43 23 543</p><p>1842</p><p>43 876 342 543</p><p>2 13 43 23</p>|
|<p>12 3 123 546 222 45 7</p><p>Contains 3</p><p>Contains 121</p><p>Print even</p><p>Print odd</p><p>Get sum</p><p>Filter >= 100</p><p>Filter < 45</p><p>end</p>|<p>Yes</p><p>No such number</p><p>12 546 222</p><p>3 123 45 7</p><p>958</p><p>123 546 222</p><p>12 3 7</p>|

## 6. **List of Products**



Read a number **n** and **n lines of products**. Print a **numbered list** of all the products **ordered by name**.

### **Examples**



|**Input**|**Output**|
| :-: | :-: |
|<p>4</p><p>Potatoes</p><p>Tomatoes</p><p>Onions</p><p>Apples</p>|<p>1.Apples</p><p>2.Onions</p><p>3.Potatoes</p><p>4.Tomatoes</p>|
|<p>3</p><p>Orange</p><p>Grape</p><p>Strawberry</p>|<p>1.Grape</p><p>2.Orange</p><p>3.Strawberry</p>|

### **Solution**

First, we need to read the number **n** from the console



![image](https://user-images.githubusercontent.com/67644402/143497724-5f1c570c-ffd8-476b-8f91-034539768d86.png)



Then we need to create our **list of strings**, because the **products are strings**



![image](https://user-images.githubusercontent.com/67644402/143497743-bfdca039-f45d-4a17-bf53-8ec47dd656c6.png)



Then we need to iterate **n times** and **read products**.



![image](https://user-images.githubusercontent.com/67644402/143497779-0260c048-b3a9-4e6b-a40a-03a0765fd3aa.png)



The next step is to add the current product to the list



![image](https://user-images.githubusercontent.com/67644402/143497762-055afdae-3181-4248-aad8-41bf9d61dc6e.png)



After we finish reading the products we **sort our list alphabetically**



![image](https://user-images.githubusercontent.com/67644402/143497799-faf344fd-5381-4921-b636-be477552e321.png)



The **sort method** sorts the list in ascending order.

Finally, we have to **print our sorted** list. To do that we **loop through the list**.



![image](https://user-images.githubusercontent.com/67644402/143497807-d9d5e0fe-74bd-4f22-9714-6f8dd5e94cf9.png)



We use **i + 1**, because we want to **start counting from 1**.



## 7. **Remove Negatives and Reverse**
Read a **list of integers**, **remove all negative numbers** from it and print the remaining elements in **reversed order**. In case of no elements left in the list, print "**empty**".

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|10 -5 7 9 -33 50|50 9 7 10|
|7 -2 -10 1|1 7|
|-1 -2 -3|empty|



### **Solution**

Read a list of integers.



![image](https://user-images.githubusercontent.com/67644402/143497822-5830e87e-fe6e-4208-b6c4-22d0a35366c4.png)



Remove all negative numbers and reverse the collection.

![image](https://user-images.githubusercontent.com/67644402/143497849-d0a387bd-eaa1-4957-a844-5c4ee653c9c7.png)



If the list is empty print "empty", otherwise print all numbers joined by space.



![image](https://user-images.githubusercontent.com/67644402/143497861-d7d4a4e8-5ca0-4a51-9cf3-069913eb3737.png)



