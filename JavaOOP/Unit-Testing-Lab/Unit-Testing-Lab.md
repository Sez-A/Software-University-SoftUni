
# **Lab: Unit Testing**
This document defines the lab for ["Java OOP" course @ Software University](https://softuni.bg/modules/59/java-advanced).
# **Part I: Unit Testing Basics**
## 1. **Create Maven Project**
Maven is build automation tool that takes care of dependencies for your project. Before you can make one, make sure that you enable the plugin in IntelliJ **[File à Settings à Plugins à Maven Integration]**

![image](https://user-images.githubusercontent.com/67644402/157628845-9603064e-6192-4a15-8d44-4ef20cca6112.png)

Now, you can create a Maven project

![image](https://user-images.githubusercontent.com/67644402/157628881-30a9f5fb-af7b-474b-92b8-d82784f28654.png)



Group Id should be separated by dots, Artifact Id should be separated by hyphens

![image](https://user-images.githubusercontent.com/67644402/157628903-43e84611-f474-4c68-a9fd-d927da0e8de6.png)

If everything is ok, you should see the following project structure

![image](https://user-images.githubusercontent.com/67644402/157628943-a8cc3abc-3909-45b3-96ca-bbd48a54891d.png)

Copy the files provided and place them in a package inside **src/main/java** folder

![image](https://user-images.githubusercontent.com/67644402/157628977-3d43da63-0398-4fe1-bcc6-c310369216a2.png)
## 2. **Test Axe**
In **test/java** folder, create a package called **rpg\_tests**

Create a class **AxeTests**

Create the following tests:

- Test if weapon loses durability after each attack
- Test attacking with a broken weapon
### **Solution**
Create the new package **rpg\_tests** and inside create the class **AxeTests**

![image](https://user-images.githubusercontent.com/67644402/157629018-a174828b-9f48-4a1d-9ddf-15d9deb63a2e.png)

Inside the class create your first test

![image](https://user-images.githubusercontent.com/67644402/157629051-004a1273-2697-4ace-b47a-72adb83c711b.png)

Arrange preconditions

![image](https://user-images.githubusercontent.com/67644402/157629087-439a13d5-bc7b-49b9-aab1-04610740cff6.png)

Execute tested behaviour

![image](https://user-images.githubusercontent.com/67644402/157629125-eab2fbb5-8b17-49e1-972c-940235d80671.png)

Assert postconditions

![image](https://user-images.githubusercontent.com/67644402/157629148-21dba7ff-4549-43d5-830c-77841c77f26d.png)

Create your second test method

![image](https://user-images.githubusercontent.com/67644402/157629173-995a5549-40ee-4352-8f2f-6c56f6425099.png)

Arrange preconditions and test behavior

![image](https://user-images.githubusercontent.com/67644402/157629211-5eb5967b-99cc-439f-81bc-62dba23d55a8.png)
## 3. **Test Dummy**
Create a class **DummyTests**

Create the following tests:

- Dummy loses health if attacked
- Dead Dummy throws exception if attacked
- Dead Dummy can give XP
- Alive Dummy can't give XP
### **Hints**
Follow the logic of the previous problem
## 4. **Refactor Tests**
Refactor the tests for **Axe** and **Dummy** classes

Make sure that:

- **Names** of test methods are **descriptive**
- You use **appropriate** **assertions** (assert equals vs assert true)
- You use **assertion** **messages**
- There are **no magic numbers**
- There is **no code duplication** (Don’t Repeat Yourself)
### **Hints**
Extract constants and private fields for **Axe** class

![image](https://user-images.githubusercontent.com/67644402/157629316-e1cfd7ac-0583-4652-a0bb-9fb768dd9d85.png)



Create a method that executes **before each test**

![image](https://user-images.githubusercontent.com/67644402/157629386-45cac74f-f230-4d20-9ff5-8f49c037f2ab.png)

Make use of constants and private fields, as well as add assertion messages

![image](https://user-images.githubusercontent.com/67644402/157629414-b04e1586-f35a-4ee0-a232-5467b76b04c8.png)

Follow the same logic for other test methods and **TestDummy** class
# **Part II: Dependencies**
## 5. **Fake Axe and Dummy**
Test if hero gains XP when target dies

To do this, you need to: 

- Make **Hero** class **testable** (use **Dependency Injection**)
- Introduce **Interfaces** for Axe and Dummy
  - Interface Weapon 
  - Interface Target 

Create fake Weapon and fake Dummy for the test
### **Hints**
Create **Weapon** interface

![image](https://user-images.githubusercontent.com/67644402/157629482-9422d15d-51f4-4b35-9b07-15252f73a7d6.png)

Create **Target** interface

![image](https://user-images.githubusercontent.com/67644402/157629521-f30cb6c1-3913-40d9-8ee1-50f036e4ab8f.png)

Implement interfaces 

![image](https://user-images.githubusercontent.com/67644402/157629569-a460b015-d85a-4358-901e-671936aab9d9.png)

Modify implementation methods to **make use of interfaces**

![image](https://user-images.githubusercontent.com/67644402/157629599-3d2ade44-6929-4e8c-bba8-a9508f69e7ba.png)

Modify both **Axe** and **Dummy** classes

Use **Dependency Injection** for Hero class

![image](https://user-images.githubusercontent.com/67644402/157629628-73abeaba-e060-463e-baca-ed39fc05ba29.png)

Create **HeroTests** class and test gaining XP functionality by faking Weapon and Target classes

![image](https://user-images.githubusercontent.com/67644402/157629770-6c5d0b27-2908-4517-bc03-b08c9d345b18.png)
## 6. **Mocking**
Include **Mockito** in the project dependencies, then:

1. Mock fakes from previous problem
1. Implement **Hero Inventory**, holding unequipped weapons
   1. method - **Iterable<Weapon> getInventory()**
1. Implement Target giving random weapon upon death
   1. field - **private List<Weapon> possibleLoot**
1. Test Hero killing a target getting loot in his inventory
### **Hints**
Locate **pom.xml**

![image](https://user-images.githubusercontent.com/67644402/157629836-3db500d0-89ed-41b6-8673-bb5ed1d5fae5.png)

Add **Mockito** dependency

![image](https://user-images.githubusercontent.com/67644402/157629867-07ebef70-d0be-4e4d-9eda-6d315cc71700.png)

Go to **HeroTests** and refactor the code, making use of **Mockito**

![image](https://user-images.githubusercontent.com/67644402/157629901-93902eed-77bc-4bef-a18d-227be7128e4d.png)

\*Implement hero inventory and **Target** dropping loot functionalities

\*Test **Hero** getting loot upon killing a **Target**



Follow us:

© SoftUni – <https://softuni.org>. Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
