
# **Exercises: Spring Data Advanced Quering**
This document defines the exercise assignments for the ["Spring Data" course @ SoftUni.](https://softuni.bg/courses/spring-data)

For the following tasks use the **bookshop\_system** database from the previous exercise. Make sure it has proper connections between the tables and it is populated with any sample data.
## 1. **Books Titles by Age Restriction**
Write a program that prints **the titles of all books**, for which the **age restriction** matches the given input (minor, teen or adult). **Ignore casing** of the input.

### **Example**

|**Input**|**Output**|
| :- | :- |
|miNor|<p>A che punto Ã¨ la note</p><p>After Many a Summer Dies the Swan</p><p>Ah</p><p>…</p>|
|teEN|<p>All Passion Spent</p><p>Wide Sea</p><p>Antic Hay</p><p>…</p>|
## 2. **Golden Books**
Write a program that prints **the** **titles of the golden edition books**, which have **less than 5000 copies**.

### **Example**

|**Output**|
| :- |
|<p>Behold the Man</p><p>Bury My Heart at Wounded Knee</p><p>The Cricket on the Hearth</p><p>…</p>|
## 3. **Books by Price**
Write a program that prints **the titles and prices** **of books** with **price lower than 5** and **higher than 40**.

### **Example**

|**Output**|
| :- |
|<p>A che punto Ã¨ la note - $45.78</p><p>All the King's Men - $45.60</p><p>An Evil Cradling - $3.30</p><p>Beyond the Mexique Bay - $45.45</p><p>…</p>|
## 4. **Not Released Books**
Write a program that prints **the titles** of all books that are **NOT released** in a given year.

### **Example**

|**Input**|**Output**|
| :- | :- |
|2000|<p>Absalom</p><p>A che punto Ã¨ la note</p><p>After Many a Summer Dies the Swan</p><p>…</p>|
|1998|<p>A che punto Ã¨ la note</p><p>Ah</p><p>Wilderness!</p><p>…</p>|
## 5. **Books Released Before Date**
Write a program that prints **the title, the edition type and the price** of books, which are **released before a given date**. The date will be in the **format dd-MM-yyyy**.

### **Example**

|**Input**|**Output**|
| :- | :- |
|12-04-1992|<p>All Passion Spent PROMO 7.18</p><p>Bury My Heart at Wounded Knee GOLD 3.86</p><p>A Catskill Eagle NORMAL 15.78</p><p>... </p>|
|30-12-1989|<p>Bury My Heart at Wounded Knee GOLD 3.86</p><p>Consider the Lilies PROMO 30.89</p><p>The Curious Incident of the Dog in the Night-Time NORMAL 23.41</p><p>…</p>|
## 6. **Authors Search**
Write a program that prints **the names** of those authors, whose **first name ends with a given string**.

### **Example**

|**Input**|**Output**|
| :- | :- |
|e|<p>George Powell</p><p>Jane Ortiz</p><p>Julie Washington</p>|
|dy|<p>Randy Morales</p><p>Randy Graham</p>|
## 7. **Books Search**
Write a program that prints **the** **titles of books**, which **contain a given string** (regardless of the casing).

### **Example**

|**Input**|**Output**|
| :- | :- |
|sK|<p>A Catskill Eagle</p><p>The Daffodil Sky</p><p>The Skull Beneath the Skin</p>|
|WOR|<p>Great Work of Time</p><p>Terrible Swift Sword</p>|
## 8. **Book Titles Search**
Write a program that prints **the titles of books**, which are **written by authors**,** whose **last name starts with a given string**.

### **Example**

|**Input**|**Output**|
| :- | :- |
|Ric|<p>Arms and the Man (Amanda Rice) </p><p>...</p><p>Book Title ( Authors first and last name)</p><p>**Check results manually in DB, because we insert random Authors for every books.**</p>|
|gr|<p>Cover Her Face (Brenda Griffin)</p><p>...</p><p>Book Title ( Authors first and last name)</p><p>**Check results manually in DB, because we insert random Authors for every books.** </p>|
## 9. **Count Books**
Write a program that prints **the** **number of books**, whose **title is longer than a given number**.

### **Example**

|**Input**|**Output**|**Comments**|
| :- | :- | :- |
|12|174|There are 174 books with longer title than 12 symbols|
|40|2|There are 2 books with longer title than 40 symbols|
## 10. **Total Book Copies**
Write a program that prints **the** **total number of book copies** **by author**. Order the results **descending by total book copies**.

### **Example**

|**Output**|
| :- |
|<p>Randy	Graham - 196584</p><p>**Check results manually in DB, because we insert random Authors for every books.**</p>|
## 11. **Reduced Book**
Write a program that prints **information** (**title**, **edition type**, **age** **restriction** and **price**) for a book **by given title**. When retrieving the book information **select only those fields** and **do NOT include any other information** in the returned result.

### **Example**

|**Input**|**Output**|
| :- | :- |
|Things Fall Apart  |Things Fall Apart GOLD ADULT 40.02|
## 12. **\* Increase Book Copies**
Write a program that **increases the copies of all books** **released after a given date** **with a given number**. Print the total amount of book copies that were added.

### **Input**
- On the **first line** – date in the format **dd MMM yyyy.** If a book is released after that date (exclusively), increase its book copies with the provided number from the second line of the input.
- On the **second line** – number of **book copies** each book should be increased with.
### **Output**
- **Total number of books** that was added to the database.
### **Example**

|**Input**|**Output**|**Comments**|
| :- | :- | :- |
|<p>12 Oct 2005</p><p>100</p>|6100|61 books are released after 12 Oct 2005, so total of 6100 book copies were added|
|<p>06 Jun 2013</p><p>44</p>|572|13 books are released after 6 Jun 2013, so total of 572 book copies were added|
## 13. **\* Remove Books**
Write a program that **removes from the database** those **books**, which **copies are lower than a given number**. Print the **number of books that were deleted** from the database.

## 14. **\* Stored Procedure**
Using Workbench (or other similar tool) **create a stored procedure**, which receives an **author's first and last name** and returns the **total amount of books the author has written**. Then write a **program** that **receives an author's name** and prints the **total number of books** the author has written by **using the stored procedure** you've just created.

### **Example**

|**Input**|**Output**|
| :- | :- |
|Amanda Rice|<p>Amanda Rice has written 9 books</p><p>**Check results manually in DB, because we insert random Authors for every books.**</p>|
|Christina Jordan|**{Author first and last name} has writtent {number of books} books**|
|Wanda Morales|**{Author first and last name} has writtent {number of books} books**|




Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
