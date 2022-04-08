
# **Lab: Data Definition and Data Types**
This document defines the **lab exercise assignments** for the  **[MySQL course @ Software University**](https://softuni.bg/opencourses/databases-basics-mysql)**. 
## 1. **Simple Database Operations Using MySQL Workbench**

### **Create New Database**
First, create an empty database gamebar.

New Create **Database** window will appear. In the "**Name**" field type the name of your new 
database - "**gamebar**". 

![image-20220408164433074](C:\Users\beydo\AppData\Roaming\Typora\typora-user-images\image-20220408164433074.png)

After clicking "Apply" you can see new window with the query that is about to be executed.

![image](https://user-images.githubusercontent.com/67644402/162448151-d69f8cbe-37eb-4e0e-af68-a422606d5f6b.png)


### *Create New Table**
Right click the "**Tables**" and select "**Create Table**".

![image](https://user-images.githubusercontent.com/67644402/162448187-d1df6422-13a7-4174-a530-a696982c1fc9.png)



Table creation tab will appear. In the "**Name**" field type the name of your new table – "**employees**". From the "**Columns**" tab you can start creating your table fields.

First create an "**id**" field. It will be set to **INT** and **AUTO\_INCREMENT**. Select **Auto Increment (AI)**.

Make the "**id**" field to be **Primary Key (PK).**

![image](https://user-images.githubusercontent.com/67644402/162448234-e3946d32-e3a5-4d47-8a68-9724eb926f35.png)

Create 2 more fields – "**first\_name**" and "**last\_name**".

![image](https://user-images.githubusercontent.com/67644402/162448283-a0ffe353-5d88-4a87-9f94-5dcc292a5185.png)

Similar to "**employees**" create 2 more tables. 

Table "**categories**":

•	id – **INT**, **primary** **key**, **AUTO\_INCREMENT**;

•	name – **VARCHAR**, **NOT** **NULL**; 

Table "**products**":

•	id – **INT**, **primary** **key**, **AUTO\_INCREMENT**;

•	name – **VARCHAR**, **NOT** **NULL**;

•	category\_id – **INT**, **foreign key** referenced to the "**categories**" table (**id**)

**Foreign keys** are created in the "**Foreign keys**" tab:

•	**Reference** **table** – select the table from which you will choose a column to link your foreign key – "**categories**";

- **Columns** – select the column you want to be set as foreign key – "**category\_id**";

•	**Referenced** **columns** – select the column set to primary to link the foreign key – "**id**";

![image](https://user-images.githubusercontent.com/67644402/162448322-fca39a2b-d201-438b-8809-23c079f154b6.png)


### *Insert Data in Tables**
Now we can start adding some records to our newly created tables. First select the "**employees**" table:

![image](https://user-images.githubusercontent.com/67644402/162448353-06fc9e8e-d937-4d00-a1a3-bc41fb35a314.png)

Select the **Edit** **button** to add new record.

Fill in the fields with values. Create 3 records in each table.

![image](https://user-images.githubusercontent.com/67644402/162448406-10b8c368-060a-4830-9d49-cf855a270b70.png)
### **Editing Data** 
Data in tables can easily be edited with the GUI. Now that we've populated our tables with test records we can edit them by **clicking on the value field**.

![image](https://user-images.githubusercontent.com/67644402/162448452-83916702-3458-44ed-bdf3-6d69a45664d7.png)


### **Deleting Data**
Data deletion is easy too. We just right click the row we want to delete and select "**Delete Row(s)**".

![image](https://user-images.githubusercontent.com/67644402/162448488-23ab7317-3dee-4e8d-95ab-56a10e6a13f8.png)


### ` `**Dropping Tables**
We can delete the whole table, by selecting the one we want to delete, right click and choose "**Drop Table…**". **You cannot undo this action.**

![image](https://user-images.githubusercontent.com/67644402/162448543-b905724d-2a61-4322-a581-fce07a02bbff.png)     ![image](https://user-images.githubusercontent.com/67644402/162448588-e4d440b9-cd5d-4544-b5c5-77e75bbdb7b5.png)

### **Dropping the Database**
As table dropping, we can drop the database too. **This action cannot be undone too.**

Right click the database you want to drop and select "**Drop Schema…**".

![image](https://user-images.githubusercontent.com/67644402/162448865-eb24c6c2-926d-4dfe-86bb-393e0a24b7e2.png)

## 2.**Simple Database Operations Using Queries**
Now we are going to do the same steps from Part 1 using simple MySQL queries. 

Exercises from this section should be submit in JUDGE – From 1 to 5.

Queries are written in the "Query" tab.

![image](https://user-images.githubusercontent.com/67644402/162448922-9a749b19-f147-493e-a46f-5ecf84abdae9.png)


### **Descriptions for Exercises in Judge System**
### **0. Create New Database**
Write a query that will create the "**gamebar**" database.


### **1. Create Tables**	
When we create tables, we specify the database we want to add them to. This is done by using the "**USE**" clause.

**Submit your solutions in JUDGE without the** "**USE {database name}**" **row.**

Table "**employees**":

•	id – **INT**, **primary** **key**, **AUTO\_INCREMENT**;

•	first\_name – **VARCHAR**, **NOT NULL**; 

•	last\_name – **VARCHAR**, **NOT NULL**;  

Create the "**categories**" and "**products**" tables analogically:

Table "**categories**":

•	id – **INT**, **primary** **key**, **AUTO\_INCREMENT**;

•	name – **VARCHAR**, **NOT NULL**; 

Table "**products**":

•	id –  **INT**, **primary** **key**, **AUTO\_INCREMENT**;

•	name – **VARCHAR**, **NOT NULL**; 

•	category\_id – **INT**, **NOT NULL** – it is not a foreign key for now.
### **2. Insert Data in Tables**
Inserting data can be done with a query too. To do that we use the "**INSERT**" clause. Populate the "**employees**" table with 3 test values.
### **3. Alter Tables**
Altering the tables is done via the "**ALTER TABLE**" clause. Add a new column – "**middle\_name**" to the "**employees**" table. 


### **4. Adding Constraints**
Create the connection via foreign key between the "**products**" and "**categories**" tables that you've created earlier. Make "**category\_id**" **foreign key linked to "id" in the "categories" table**. 


### **5. Modifying Columns**
Change the property "**VARCHAR(50)"** to "**VARCHAR(100)**" to the "**middle\_name**" column in "**employees**" table.




Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
