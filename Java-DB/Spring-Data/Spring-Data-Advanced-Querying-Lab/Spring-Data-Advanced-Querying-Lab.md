
# **Lab: Spring Data Advanced Querying**
This document defines the lab assignments for the ["Spring Data" course @ Software University](https://softuni.bg/courses/spring-data).

You are **given** a simpler implementation of the **Shampoo Company**. Now it's time to start writing some query methods to retrieve data. 
**Before you start, insert the data from the "shampoo-company-insert.sql" file!**
## 1. **Select Shampoos by Size**
Create a method that selects all shampoos with a **given size**, **ordered by shampoo id.**

### **Example:**

|**Input**|**Output**|
| :- | :- |
|**MEDIUM**|<p>Nature Moments Mediterranean Olive Oil & Aloe Vera MEDIUM 6.50lv.</p><p>Volume & Fullness Lavender MEDIUM 5.50lv.</p><p>Rose Shine & Hydration MEDIUM 6.50lv.</p><p>Color Protection & Radiance MEDIUM 6.75lv.</p><p>Heavenly Long Long-Hair MEDIUM 7.50lv.</p><p>Sea Buckthorn Vital MEDIUM 6.50lv.</p><p>Fresh it Up! MEDIUM 7.65lv.</p><p>Nectar Nutrition MEDIUM 6.85lv.</p>|
## 2. **Select Shampoos by Size or Label**
Create a method that selects all shampoos with a **given size or label id**. Sort the result **ascending by price**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|**MEDIUM<br>10**|<p>Volume & Fullness Lavender MEDIUM 5.50lv.</p><p>Intense-Charm Brunette SMALL 5.50lv.</p><p>Nature Moments Mediterranean Olive Oil & Aloe Vera MEDIUM 6.50lv.</p><p>Rose Shine & Hydration MEDIUM 6.50lv.</p><p>Sea Buckthorn Vital MEDIUM 6.50lv.</p><p>Color Protection & Radiance MEDIUM 6.75lv.</p><p>Nectar Nutrition MEDIUM 6.85lv.</p><p>Heavenly Long Long-Hair MEDIUM 7.50lv.</p><p>Fresh it Up! MEDIUM 7.65lv.</p><p>Active-Caffeine SMALL 7.80lv.</p>|
## 3. **Select Shampoos by Price**
Create a method that selects all shampoos, which price is **higher than a given price**. Sort the result **descending** **by price**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|5|<p>Superfruit Nutrition LARGE 13.80lv.</p><p>Cotton Fresh LARGE 13.60lv.</p><p>Color Protection & Radiance LARGE 11.50lv.</p><p>Rose Shine & Hydration LARGE 10.70lv.</p><p>Nectar Nutrition LARGE 10.50lv.</p><p>Keratin Strong SMALL 8.80lv.</p><p>Superfruit Nutrition SMALL 8.80lv.</p><p>Cotton Fresh SMALL 8.80lv.</p><p>Keratin Strong LARGE 8.80lv.</p><p>Volume & Fullness Lavender LARGE 8.50lv.</p><p>…</p>|
## 4. **Select Ingredients by Name**
Create a method that selects all **ingredients**, which **name starts with given letters**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|M|<p>Macadamia Oil</p><p>Mineral-Collagen</p><p>Micro Crystals</p>|
## 5. **Select Ingredients by Names**
Create a method that selects all **ingredients**, which are **contained in a given list**. Sort the result **ascending by price**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|<p>Lavender</p><p>Herbs</p><p>Apple</p>|<p>Apple</p><p>Lavender</p><p>Herbs</p>|
## 6. **Count Shampoos by Price**
Create a method that **counts all shampoos** with **price lower than a given price**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|8.50|15|
# **JPQL Querying**
## 7. **Select Shampoos by Ingredients**
Create a method that selects all **shampoos** **with ingredients** included** in a **given list**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|<p>Berry</p><p>Mineral-Collagen</p>|<p>Superfruit Nutrition</p><p>Color Protection & Radiance</p><p>Volume & Fullness Lavender</p><p>Keratin Strong</p><p>Nature Moments Mediterranean Olive Oil & Aloe Vera</p><p>Nectar Nutrition</p><p>Fresh it Up!</p>|
## 8. **Select Shampoos by Ingredients Count**
Create a method that selects all **shampoos** **with ingredients less than a given number**.

### **Example:**

|**Input**|**Output**|
| :- | :- |
|2|<p>Moroccan Argan Oil & Macadamia</p><p>Volume & Fullness Lavender</p><p>Sea Buckthorn Vital</p><p>Active-Caffeine</p>|

## 9. **Delete Ingredients by Name**

Create a method that **deletes ingredients by a given name**. Use named query.

## 10. **Update Ingredients by Price**

Create a method that **increases the price of all ingredients by 10%**. Use named query.
## 11. **Update Ingredients by Names**
Create a method that **updates the price** of all ingredients, which names are in a given list.


Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
