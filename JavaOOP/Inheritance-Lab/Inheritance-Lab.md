
# **Lab: Inheritance**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1574/Inheritance-Lab).
# **Part I: Inheritance**
## 1. **Single Inheritance**
Create two classes named **Animal** and **Dog**.

**Animal** with a single public method **eat()** that prints: **"eating…"**

**Dog** with a single public method **bark()** that prints: **"barking…"**

**Dog** should inherit from **Animal**.

![image](https://user-images.githubusercontent.com/67644402/155313822-3b83a4e4-4d3a-48ba-a1b3-d944b22539b2.png)



![image](https://user-images.githubusercontent.com/67644402/155313854-684a98bb-310b-4935-b51e-1cc422f9f563.png)
### **Hints**
Use the **extends** keyword to build a hierarchy.
## 2. **Multiple Inheritance**
Create three classes named **Animal**, **Dog** and **Puppy**. 

**Animal** with a single public method **eat()** that prints: **"eating…"**

**Dog** with a single public method **bark()** that prints: **"barking…"**

**Puppy** with a single public method **weep()** that prints: **"weeping…"**

**Dog** should inherit from **Animal**. **Puppy** should inherit from **Dog**. 

![image](https://user-images.githubusercontent.com/67644402/155313889-9e86ba6a-ac9b-43ec-acd4-b34238758718.png)



![image](https://user-images.githubusercontent.com/67644402/155313917-af1e3457-0c5c-4c82-a189-c577b7ad7666.png)
## 3. **Hierarchical Inheritance**
Create three classes named **Animal**, **Dog** and **Cat**. 

**Animal** with a single public method **eat()** that prints: **"eating…"**

**Dog** with a single public method **bark()** that prints: **"barking…"**

**Cat** with a single public method **meow()** that prints: **"meowing…"**

**Dog** and **Cat** should inherit from **Animal**.

![image](https://user-images.githubusercontent.com/67644402/155313946-b71998c4-25bb-4629-96f6-e5894a82faa8.png)



![image](https://user-images.githubusercontent.com/67644402/155313978-54c614ac-3c3d-4751-9631-a210f0fcab2a.png)
# **Part II: Reusing Classes**
## 4. **Random Array List**
Create a **RandomArrayList** class that has all the functionality of an **ArrayList**.

Add additional function that **returns** and **removes** a random element from the list.

- Public method: **getRandomElement(): Object**
## 5. **Stack of Strings**
Create a class **Stack** which can store only strings and has the following functionality:

- Private field: **data: ArrayList<String>**

- Public method: **push(String item): void**

- Public method: **pop(): String**

- Public method: **peek(): String**

- Public method: **isEmpty(): boolean**

  

![image](https://user-images.githubusercontent.com/67644402/155314020-24d0a912-7918-4326-bf33-3282be7b07e0.png)



### **Hints**
Use composition/delegation in order to have a field in which to store the stack's data.



Follow us:

© SoftUni – [about.softuni.bg](about.softuni.bg). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
