
# **Lab: Data Aggregation**
This document defines the **lab** **exercise assignments** for the [MySQL course @ Software University.](https://softuni.bg/opencourses/databases-basics-mysql)

Download and get familiar with the **restaurant** database. You will use it in the assignments bellow.
## 1. **Departments Info**
Write a query to **count** the number of employees **in each department by id**. Order the information by **deparment\_id**, then by **employees count**. Submit your queries with the **MySQL prepare DB & run queries** strategy.

### **Example**

|**department\_id**|**Number of employees**|
| :- | :- |
|**1**|**2**|
|**2**|**4**|
|**3**|**3**|

## 2. **Average Salary**
Write a query to calculate the **average salary** in each department. Order the information by **department\_id**. **Round** the salary result to **two digits after the decimal point**. Submit your queries with the **MySQL prepare DB & run queries** strategy.

### **Example**

|**department\_id**|**Average Salary**|
| :- | :- |
|**1**|**2050**|
|**2**|**1090**|
|**3**|**736.67**|

## 3. **Min Salary**
Write a query to retrieve information about the departments grouped by **department\_id** with **minumum salary** **higher than 800**. **Round** the salary result to **two digits after the decimal point**. Submit your queries with the **MySQL prepare DB & run queries** strategy.

### **Example**

|**department\_id**|**Min Salary**|
| :- | :- |
|**1**|**1700**|



## 4. **Appetizers Count**
Write a query to retrieve the count of all **appetizers** (**category id = 2**) with price **higher than 8**. Submit your queries with the **MySQL prepare DB & run queries** strategy. 

## 5. **Menu Prices**
Write a query to retrieve information about the prices of each category. The output should consist of:

- **Category\_id**
- **Average Price** 
- **Cheapest Product**
- **Most Expensive Product**

See the **examples** for more information. **Round** the results to **2 digits after the decimal point**. Submit your queries with the **MySQL prepare DB & run queries** strategy. 
### **Example**

|**category\_id**|**Average Price**|**Cheapest Product**|**Most Expensive Product**|
| :- | :- | :- | :- |
|**1**|**7.49**|**6.79**|**8.79**|
|**2**|**10.93**|**7.99**|**14.89**|
|**3**|**7.90**|**6.90**|**8.89**|
|**4**|**12.79**|**11.69**|**13.69**|
|**5**|**5.37**|**4.90**|**5.60**|



Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
