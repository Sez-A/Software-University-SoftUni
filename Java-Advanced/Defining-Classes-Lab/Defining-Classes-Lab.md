
# **Lab: Defining Classes**
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1517/Defining-Classes-Lab).
# **Part I: Defining Classes**
## 1. **Car Info**
Create a class named **Car**.

The class should have **public** fields for:

- Brand: **String**
- Model: **String**
- Horsepower: **int**

Create a **new class** and ensure **proper naming:**

![image](https://user-images.githubusercontent.com/67644402/147496931-1c50b0bf-0f34-49e9-9048-27f465332327.png)

Define the fields:

![image](https://user-images.githubusercontent.com/67644402/147496950-265f671b-4806-4e49-aa97-84d42d43f1ba.png)

Create a Test client in the **same** **package:**

![image](https://user-images.githubusercontent.com/67644402/147496958-3ec9ca8a-e0f8-4340-b14b-1fa6661a271a.png)

You should be now able to use your class:

![image](https://user-images.githubusercontent.com/67644402/147496968-fe25cd06-9798-49c9-88f3-06845707fd77.png)

### **Private Fields**
Change the access modifiers of all class fields to **private.**

When done go back to the main method you should have **compilation** errors, like this:

![image](https://user-images.githubusercontent.com/67644402/147496985-bc66e106-4fd4-4982-9e09-af3bfdc8212e.png)

#### **Getters and Setters**
**Create getters** and **setters** for each class field. 

**Getter** for the car brand:

![image](https://user-images.githubusercontent.com/67644402/147497004-d120eec7-7b51-45e7-bba5-98e2bb927829.png)

**Setter** for the car brand:

![image](https://user-images.githubusercontent.com/67644402/147497013-ec8de6dc-f232-431a-9fbb-a9debb794ac0.png)

Do the same for **all** the fields.

**Fix Main Method**

You should **set** and **get** the **values** by using the correct methods

![image](https://user-images.githubusercontent.com/67644402/147497020-9aa7bebf-b064-4d3d-b8b8-fa48f0377f61.png)

### **Create Car Info Method**
This method should return the info about any car object in the following format:

"**The car is: {brand} {model} – {horsePower} HP.**"

You have to figure out how to create a method and to use it in the outside code as shown below:

![image](https://user-images.githubusercontent.com/67644402/147497035-dc205787-7f43-43df-ac52-dc1be0753cf0.png)

**Test the Program** 

Read cars objects, add them to the collection of your choice, and print each one on the console using the **carInfo()** method. The input consists of a single integer **N** the number of lines representing car objects. One each line you will read car info in the following format "**{brand} {model} {horsePower}**"** separated by single space.
#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>3</p><p>Chevrolet Impala 390</p><p>Mercedes Benz 500</p><p>Volga 24 49</p>|<p>The car is: Chevrolet Impala - 390 HP.</p><p>The car is: Mercedes Benz - 500 HP.</p><p>The car is: Volga 24 - 49 HP.</p>|
|<p>5</p><p>This Car 1</p><p>Was Made 2</p><p>Only For 3</p><p>Test Purposes 4</p><p>No Way 5</p>|<p>The car is: This Car - 1 HP.</p><p>The car is: Was Made - 2 HP.</p><p>The car is: Only For - 3 HP.</p><p>The car is: Test Purposes - 4 HP.</p><p>The car is: No Way - 5 HP.</p>|

# **Part II: Constructors**
## 2. **Car Constructors**
Make proper constructors for the Car class so you can create car objects with a different type of input information.

If you miss information about the field of **type String** set the value to "**unknown**",** and for an **integer,** field set **-1.**

First, **declare** a **constructor** which takes only the car brand as a parameter:

![image](https://user-images.githubusercontent.com/67644402/147497052-fc569ffb-2676-4cbb-9dd3-a48ef6163752.png)

Also, create a **constructor** which **sets** all the **fields**:

![image](https://user-images.githubusercontent.com/67644402/147497061-4be61e5f-d002-423f-ba3b-7c5aa9557910.png)

Read information about cars the same way as the previous task, however, this time uses **constructors** to create the objects, not creating an object with the **default** constructor. You should be able to handle **different** **types** of input, the format will be the same as the previous task, but this time some of the data may be missing. For example, you can get only the car **brand** – which means you have to set the car model to "**unknown**"** and the Horsepower value to **-1**. There will be lines with **complete** car data, declare constructor which sets all the fields. 

You have to add the car objects to a **collection** of your choice and print the data as in the previous task. The input will **always** have one or three elements on each line.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>2</p><p>Chevrolet</p><p>Golf Polo 49</p>|<p>The car is: Chevrolet unknown - -1 HP.</p><p>The car is: Golf Polo - 49 HP.</p>|
|<p>4</p><p>Was</p><p>Only For 3</p><p>Test Purposes 4</p><p>No Way 5</p>|<p>The car is: Was unknown - -1 HP.</p><p>The car is: Only For - 3 HP.</p><p>The car is: Test Purposes - 4 HP.</p><p>The car is: No Way - 5 HP.</p>|

## 3. **Bank Account**
Create class **BankAccount**.

The class should have **private fields** for:

- Id: **int** (Starts from **1** and **increments** for every **new** **account**)
- Balance: **double**
- Interest rate: **double** (Shared for all accounts. **Default value: 0.02**)

The class should also have **public** methods for:

- **setInterestRate(double interest):** **void (static)**
- **getInterest(int Years):** **double**
- **deposit(double amount):** **void**

Create a test client supporting the following commands:

- **Create**
- **Deposit {Id} {Amount}**
- **SetInterest {Interest}**
- **GetInterest {ID} {Years}**
- **End**
### **Examples**

|**Input**|**Output**|**Comments**|
| :-: | :-: | :-: |
|<p>Create</p><p>Deposit 1 20</p><p>GetInterest 1 10</p><p>End</p>|<p>Account ID1 created</p><p>Deposited 20 to ID1</p><p>4.00</p>||
|<p>Create</p><p>Create</p><p>Deposit 1 20</p><p>Deposit 3 20</p><p>Deposit 2 10</p><p>SetInterest 1.5</p><p>GetInterest 1 1</p><p>GetInterest 2 1</p><p>GetInterest 3 1</p><p>End</p>|<p>Account ID1 created</p><p>Account ID2 created</p><p>Deposited 20 to ID1</p><p>Account does not exist</p><p>Deposited 10 to ID2</p><p>30.00</p><p>15.00</p><p>Account does not exist</p>|<p>Sets the global interest rate to 1.</p><p>Prints interest for a bank account with id 1 for 1 year period.</p>|
### **Solution**
Create the class as usual and create a **constant** for the default interest rate:

![image](https://user-images.githubusercontent.com/67644402/147497076-4f1c0ead-7db0-457b-b0af-3fc774665220.png)

Create the static and non-static fields, **all private:**

![image](https://user-images.githubusercontent.com/67644402/147497098-702e0a6c-4520-4db8-a835-f749b4a3fceb.png)

Set the id of an account upon creation while **incrementing** the global account count:

![image](https://user-images.githubusercontent.com/67644402/147497104-a00adadd-fcea-44ff-854f-1c821c28143c.png)

Create a setter for the global interest rate. Making the method **static** will let you access it through the class name:

![image](https://user-images.githubusercontent.com/67644402/147497115-60b64e3f-07d1-440d-9b1d-845d408f723f.png)

Implement **deposit()** and **getInterest():**

![image](https://user-images.githubusercontent.com/67644402/147497132-73d5d60e-dbb3-4bba-aa31-2159db2a570a.png)
