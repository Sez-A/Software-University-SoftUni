
# **Exercises: Introduction to DB Apps**
This document defines the exercise assignments for the [“Spring Data” course @ SoftUni](https://softuni.bg/trainings/3352/spring-data-june-2021).
## 1. **Initial Setup** 
Be familiar with database "**minions\_db**". Here is an ER diagram:

![image](https://user-images.githubusercontent.com/67644402/172159033-67d5fb94-5926-49ac-be89-e55d2d7f96bb.png)

Exequte sql file that was given to you
## 2. **Get Villains’ Names**
Write a program that prints on the console **all villains’ names** and their **number of minions**. Get only the villains who have more than 15 minions. **Order** them** by number of minions in **descending order**.

### **Example**

|**Output**|
| :-: |
|Flo 16|
## 3. **Get Minion Names**
Write a program that prints on the console **all minion names** and their **age** for given **villain id.** For the output, use the formats given in the examples.

### **Example**

|**Input**|**Output**||**Input**|**Output**||**Input**|**Output**|
| :-: | :-: | :- | :-: | :-: | :- | :-: | :-: |
|1|<p>Villain: Carl</p><p>1. Annabella 34</p><p>2. Eldredge 32 </p><p>3. ...</p>||3|<p>Villain: Arabele</p><p>1. Davey 22</p><p>2. Orsola 16</p><p>3. ...</p>||2|<p>Villain: Crissy</p><p>1. Gayleen 14</p><p>2. Skipp 16</p><p>3. ... </p>|


|**Input**|**Output**|
| :-: | :-: |
|10|No villain with ID 10 exists in the database.|
## 4. **Add Minion**
Write a program that reads information about a minion and its villain and **adds it to the database**. In case the town of the minion is not in the database, insert it as well. In case the villain is not present in the database, add him too with default evilness factor of “evil”. Finally, set the new minion to be servant of the villain. Print appropriate messages after each operation – see the examples.

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|<p>Minion: Robert 14 Berlin</p><p>Villain: Gru</p>|<p>Villain Gru was added to the database.</p><p>Successfully added Robert to be minion of Gru.</p>|
|<p>Minion: Cathleen 20 Liverpool</p><p>Villain: Gru</p>|<p>Town Liverpool was added to the database.</p><p>Successfully added Cathleen to be minion of Gru.</p>|
|<p>Minion: Mars 23 Sofia</p><p>Villain: Poppy</p>|<p>Villain Poppy was added to the database.</p><p>Successfully added Mars to be minion of Poppy</p>|
|<p>Minion: Carry 20 Eindhoven</p><p>Villain: Jimmy</p>|<p>Town Eindhoven was added to the database.</p><p>Villain Jimmy was added to the database.</p><p>Successfully added Carry to be minion of Jimmy</p>|
## 5. **Change Town Names Casing**
Write a program that **changes all town names to uppercase** for a given country. **Print the** **number of towns that were changed** in the format provided in examples. On the next line **print** the **names that were changed**, separated by coma and a space.

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|Bulgaria|<p>3 town names were affected. </p><p>[SOFIA, PLOVDIV, BURGAS]</p>|
|Italy|No town names were affected.|
## 6. **\*Remove Villain**
Write a program that receives an **ID** of a villain, **deletes him from the database** and **releases his minions** from serving him. As an output print the name of the villain and the number of minions released. Make sure all operations go as planned, **otherwise do not make any changes** to the database. For the output use the format given in the examples.

### **Example**

|**Input**|**Output**|
| :-: | :-: |
|1|<p>Carl was deleted</p><p>16 minions released</p>|
|3|<p>Arabele was deleted</p><p>14 minions released</p>|
|101|No such villain was found|
## 7. **Print All Minion Names**
Write a program that **prints all minion names** from the minions table **in order** first record, last record, first + 1, last – 1, first + 2, last – 2… first + n, last – n. 
###



### **Example**

|**Original Order**|**Output**|
| :-: | :-: |
|<p>May</p><p>Brina</p><p>Roslyn</p><p>Virgie</p><p>Nananne</p><p>Gayleen</p><p>...</p><p>...</p><p>...</p><p>Lu</p><p>Theodor</p><p>Tara</p><p>Brandie</p>|<p>May</p><p>Brandie</p><p>Brina</p><p>Tara</p><p>Roslyn</p><p>Theodor</p><p>...</p><p>...</p><p>...</p><p>Katine</p><p>Skipp</p><p>Chevalier</p><p>Abbe</p>|
## 8. **Increase Minions Age**
Read from the console minion IDs, separated by space. **Increment the age** of those minions **by 1** and make their **names title to lower case**. Finally, **print** the **names** and the **ages** of **all minions** that are in the database. See the examples below.

### **Example**

|**minions**|
| :-: |
|**Id**|**name**|**age**|
|1|May|44|
|2|Brina|43|
|3|Roslyn|50|
|4|Virgie|53|
|5|Nananne|23|
|...|...|...|


|**Input**|**Output**|
| :-: | :- |
|2 1 4|<p>may 45</p><p>brina 44</p><p>Roslyn 50</p><p>virgie 54</p><p>Nananne 23</p><p>...</p>|
## 9. **Increase Age Stored Procedure**
Create a stored procedure **usp\_get\_older** (**directly in the database** using **MySQL Workbench** or any other similar tool) that receives a **minion\_id** and **increases the minion’s years by 1**. Write a program that **uses that stored procedure to increase the age** of a minion, whose **id** will be given as an input from the console. After that **print the name and the age** of that minion.
###


© [Software University Foundation](http://softuni.foundation/). This work is licensed under the [CC-BY-NC-SA](http://creativecommons.org/licenses/by-nc-sa/4.0/) license.

