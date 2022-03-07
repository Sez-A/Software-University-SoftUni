
# **Lab: Reflection and Annotations**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1604/Reflection-Lab).
# **Part I: Reflection**
## 1. **Reflection**
Import "**Reflection.java**" to your "**src**" folder in your project. Try to use **reflection** and print some information about this class. Print everything on new line:

- **This class type**
- **Super class type** 
- **All interfaces** that are implemented by this class
- **Instantiate object** using reflection and print it too

**Don’t change anything in "Reflection class"!** 
### **Solution**
![image](https://user-images.githubusercontent.com/67644402/157071962-9179ed9a-e134-4752-a626-06717edda102.png)
## 2. **Getters and Setters**
Using reflection to get all **Reflection** methods. Then prepare an algorithm that will recognize, which methods are **getters** and **setters**. Sort each collection **alphabetically** by methods names. Print to console each **getter** on new line in format:

- **"{name} will return class {Return Type}"**

Then print all **setters** in format:

- **"{name} and will set field of class {Parameter Type}"**

**Do this without changing anything in "Reflection.java"**

## 3. **High Quality Mistakes**
You are already expert of **High Quality Code**, so you know what kind of **access modifiers** must be set to members of class. Time for **revenge** has come. Now you have to check code produced by your "**Beautiful and Smart**" trainers in class **Reflection**. Check all **fields and methods access modifiers**. Sort each category of members **alphabetically**. Print on console all **mistakes** in format:

- For Fields:

**{fieldName} must be private!**

- For Getters:

**{methodName} have to be public!**

- For Setters:

**{methodName} have to be private!**
# **Part II: Annotations**
## 4. **Create Annotation**
Create annotation **Subject** with a **String[]** element called **categories**, that: 

- Should be available at runtime
- Can be placed only on types
### ` `**Examples**
![image](https://user-images.githubusercontent.com/67644402/157072140-4cbf7db6-9361-4dc1-94fa-6e6b5c6bcbef.png)
## 5. **Coding Tracker**
Create annotation **Author** with a **String** element called **name**, that:

- Should be available at runtime
- Can be placed only on methods

Create a class **Tracker** with a method:

- **public static void printMethodsByAuthor()**
### ` `**Examples**
![image](https://user-images.githubusercontent.com/67644402/157072183-4ffc4e80-21c8-4384-be33-8114f7aec8ac.png)
### **Output**
![image](https://user-images.githubusercontent.com/67644402/157072216-89bcdb06-1e51-48d9-af54-35ff5dca5969.png)




Follow us:

© SoftUni – [about.softuni.bg](about.softuni.bg). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
