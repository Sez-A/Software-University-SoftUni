
# **Lab: Subqueries and JOINs**
This document defines the lab assignments for [MySQL Course @ Software University](https://softuni.bg/opencourses/databases-basics-mysql).

You will use the **soft\_uni** **database** to write queries for the following exercises.
## 1. **Managers**
Write a query to retrieve information about the **managers** – **id**, **full\_name**, **deparment\_id** and **department\_name**. Select the **first 5** departments ordered by **employee\_id**. Submit your queries using the "**MySQL prepare DB and Run Queries**" strategy. 

### **Example**

|**employee\_id**|**full\_name**|**department\_id**|**department\_name**|
| :- | :- | :- | :- |
|3|Roberto Tamburello|10|Finance|
|4|Rob Walters|2|Tool Design|
|…|…|…|…|
## 2. **Towns Addresses**

Write a query to get information about the **addresses** in the database, which are in **San Francisco**, **Sofia** or **Carnation**. Retrieve **town\_id**, **town\_name**, **address\_text**. Order the result by **town\_id**, then by **address\_id**. Submit your queries using the "**MySQL prepare DB and Run Queries**" strategy. 

### **Example**

|**town\_id**|**town\_name**|**address\_text**|
| :- | :- | :- |
|9|San Fransisco|1234 Seaside Way|
|9|San Fransisco|5725 Glaze Drive|
|15|Carnation|1411 Ranch Drive|
|…|…|…|
## 3. **Employees Without Managers**
Write a query to get information about **employee\_id**, **first\_name**, **last\_name**, **department\_id** and **salary** for all employees who **don't have** a manager. Submit your queries using the "**MySQL prepare DB and Run Queries**" strategy.

### **Example**


|**employee\_id**|**first\_name**|**last\_name**|**department\_id**|**salary**|
| :- | :- | :- | :- | :- |
|109|Ken|Sanchez|16|125 500|
|291|Svetlin|Nakov|6|48 000|
|292|Martin|Kulov|6|48 000|
|293|George|Denchev|6|48 000|
## 4. **Higher Salary**

Write a query to count the number of employees who receive **salary** higher than the **average**. Submit your queries using the "**MySQL prepare DB and Run Queries**" strategy.
### **Example**

|**count**|
| :- |
|88|

Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
