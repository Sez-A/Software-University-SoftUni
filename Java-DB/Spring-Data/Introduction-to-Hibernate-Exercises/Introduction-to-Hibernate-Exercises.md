
# **Exercises: Introduction to Hibernate**
This document defines the exercise assignments for the [“Spring Data” course @ SoftUni](https://softuni.bg/courses/spring-data).
## 1. **Setup**
Use the **provided skeleton** to create **soft\_uni** database. 

1. Change the **port**, **username** and **password** accordingly to your settings.

![image](https://user-images.githubusercontent.com/67644402/172387069-fe4ba6e4-8a0e-4f72-8619-a4792f92dbc3.png)

1. **Create** EntityManagerFactory and **run** your program.

![image](https://user-images.githubusercontent.com/67644402/172387117-22569fbc-f461-401a-8018-382d49ea4d50.png)

1. Fill the database into **Workbench** or **InteliJ** by **executing** the provided **.sql** script. 

   ## 2. **Change casing** 
   Use the **soft\_uni** database. Persist **all towns** from the database. Detach those whose name length is **more than 5 symbols**. Then transform the **names** of all attached towns **to uppercase** and **save them to the database**.

   ## 3. **Contains Employee**
   Use the **soft\_uni** database. Write a program that checks if a given employee name **is contained in the database.**
### **Example**

|**Input**|**Output**|
| :- | :- |
|Svetlin Nakov|Yes|
|John Doe|No|
## 4. **Employees with Salary Over 50 000**
Write a program that gets the first name of all employees who have salary over **50 000**.

### **Example:**

|**Output**|
| :- |
|<p>Terri</p><p>Jean</p><p>Ken</p><p>…</p>|
## 5. **Employees from Department**
Extract all employees from the **Research and Development** department. Order them by **salary** (in ascending order), then by **id** (in **ascending** order). Print only their **first name**, **last name**, **department name** and **salary**. 

### **Example:**

|**Output**|
| :- |
|<p>Diane Margheim from Research and Development - $40900.00</p><p>Gigi Matthew from Research and Development - $40900.00</p><p>Michael Raheem from Research and Development - $42500.00</p><p>Svetlin Nakov from Research and Development - $48000.00</p><p>Martin Kulov from Research and Development - $48000.00</p><p>George Denchev from Research and Development - $48000.00</p><p>Dylan Miller from Research and Development - $50500.00</p>|
## 6. **Adding a New Address and Updating Employee**
Create a new address with **text** "**Vitoshka 15**". Set that address to an **employee** with a **last name**, given as an input.

## 7. **Addresses with Employee Count**
Find all addresses, **ordered** by the **number of employees** who live there (**descending**). 

Take only the **first 10 addresses** and print their **address text**, **town name** and **employee count**. 

**Example**

|**Output**|
| :- |
|<p>163 Nishava Str, ent A, apt. 1, Sofia - 3 employees</p><p>7726 Driftwood Drive, Monroe - 2 employees</p><p>...</p>|
## 8. **Get Employee with Project**
Get an **employee by his/her id**. Print only his/her **first name**, **last name**, **job title** and **projects** (only their names). The projects should be **ordered** **by** **name** (ascending). The output should be printed in the format given in the example.


### **Example**

|**Input**|**Output**|
| :- | :- |
|147|<p>Linda Randall - Production Technician</p><p>`	`HL Touring Handlebars</p><p>`	`ML Road Rear Wheel</p><p>`	`Patch kit</p><p>`	`Touring-1000</p>|
|83|<p>John Evans - Production Technician</p><p>`	`Half-Finger Gloves</p><p>`	`LL Mountain Handlebars</p><p>`	`Racing Socks</p><p>`	`Women's Tights</p>|
## 9. **Find Latest 10 Projects**
Write a program that prints the **last 10 started projects**. Print **their name, description, start and end date** and **sort** **them by name** lexicographically. For the output, check the format from the example.

### **Example**

|**Output**|
| :- |
|<p>Project name: All-Purpose Bike Stand</p><p>` 	`Project Description: Research, design and development of …</p><p>` 	`Project Start Date:2005-09-01 00:00:00.0</p><p>` 	`Project End Date: null</p><p>Project name: Bike Wash</p><p>` 	`Project Description: Research, design and development of …</p><p>` 	`Project Start Date:2005-08-01 00:00:00.0</p><p>` 	`Project End Date: null</p><p>Project name: HL Touring Frame</p><p>` 	`Project Description: Research, design and development of …</p><p>` 	`Project Start Date:2005-05-16 16:34:00.0</p><p>` 	`Project End Date: null</p><p>…</p>|
## 10. **Increase Salaries**
Write a program that increases the salaries of all employees, who are in the **Engineering**, **Tool Design**, **Marketing** or **Information Services** departments by **12%**. Then **print the first name, the last name and the salary** for the employees, whose salary was increased.

### **Example**

|**Output**|
| :- |
|<p>Roberto Tamburello ($48496.00)</p><p>Gail Erickson ($36624.00)</p><p>Jossef Goldberg ($36624.00)</p><p>Terri Duffy ($71120.00) </p><p>…</p>|
## 11. **Find Employees by First Name**
Write a program that finds **all employees**, whose **first name starts with a pattern** given as an input from the console. Print their **first and last names**, their **job** **title** and **salary** in the format given in the example below.

- **Hint: The expected results of next exercises are with update of salaries in ex 10.**
### **Example**

|**Input**|**Output**|
| :- | :- |
|SA|<p>Sariya Harnpadoungsataya - Marketing Specialist - ($16128.00)</p><p>Sandra Reategui Alayo - Production Technician - ($9500.00)</p><p>Sairaj Uddin - Scheduling Assistant - ($16000.00)</p><p>Samantha Smith - Production Technician - ($14000.00)</p><p>Sameer Tejani - Production Technician - ($11000.00)</p><p>Sandeep Kaliyath - Production Technician - ($15000.00)</p>|
## 12. **Employees Maximum Salaries**	
Write a program that finds the **max salary** for each **department**. Filter the departments, which max salaries **are not in the range** between 30000 and 70000.

### **Example**

|**Output**|
| :- |
|<p>Engineering	 71120.00</p><p>Sales	 72100.00</p><p>Marketing 16128.00 </p><p>Production 84100.00</p><p>… </p>|

## 13. **Remove Towns**
Write a program that **deletes a town**,** which name is given as an input. The program should **delete all addresses** that are in the given town. Print on the console the **number of addresses** that were **deleted**. Check the example for the output format.

### **Example**

|**Input**|**Output**|
| :- | :- |
|Sofia|1 address in Sofia deleted|
|Seattle|44 addresses in Seattle deleted|


Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
