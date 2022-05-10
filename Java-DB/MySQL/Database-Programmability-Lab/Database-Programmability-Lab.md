
# **Lab: Database Programmability and Transactions**
This document defines the **exercise assignments** for the [MySQL course @ Software University.](https://softuni.bg/opencourses/databases-basics-mysql) 

You are provided with the "soft\_uni" database. Use it in the following assignments.
## 1. **Count Employees by Town**
Write a function **ufn\_count\_employees\_by\_town(town\_name)** that accepts **town\_name** as parameter and returns the count of employees who live in that town. Submit your queries using the "**MySQL** **Run Skeleton, run queries and check DB**" strategy.

### **Example**
The following example is given with employees living in **Sofia**.

|**count**|
| :- |
|3|
## 2. **Employees Promotion**
Write a stored procedure **usp\_raise\_salaries(department\_name)** to raise the **salary** of all employees in given department as parameter by 5%. Submit your queries using the "**MySQL** **Run Skeleton, run queries and check DB**" strategy. 

### **Example**
The following example is given with employees in the "**Finance**" department ordered by **first\_name**, then by **salary**.

|**first\_name**|**salary**|
| :- | :- |
|Barbara|27 720.00|
|Bryan|19 950.00|
|Candy|19 950.00|
|…|…|

## **3. Employees Promotion by ID**

Write a stored procedure **usp\_raise\_salary\_by\_id(id)** that raises a given employee's **salary** (by **id** as parameter) by **5%**. Consider that you cannot promote an employee that **doesn't exist** – if that happens, no changes to the database should be made. Submit your queries using the "**MySQL** **Run Skeleton, run queries and check DB**" strategy. 


### **Example**
The following example is given with **employee\_id**  =  **17**.

|**salary**|
| :- |
|14175.0000|
## **4. Triggered**
Create a table **deleted\_employees(employee\_id PK, first\_name,last\_name,middle\_name,job\_title,deparment\_id,salary)** that will hold information about fired(deleted) employees from the employees table. Add a trigger to employees table that inserts the corresponding information in **deleted\_employees**. Submit your queries using the "**MySQL** **Run Skeleton, run queries and check DB**" strategy.


Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
