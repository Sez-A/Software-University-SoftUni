
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

Define the fields:

Create a Test client in the **same** **package:**

You should be now able to use your class:


### **Private Fields**
Change the access modifiers of all class fields to **private.**

When done go back to the main method you should have **compilation** errors, like this:


#### **Getters and Setters**
**Create getters** and **setters** for each class field. 

**Getter** for the car brand:



**Setter** for the car brand:



Do the same for **all** the fields.

**Fix Main Method**

You should **set** and **get** the **values** by using the correct methods


### **Create Car Info Method**
This method should return the info about any car object in the following format:

"**The car is: {brand} {model} – {horsePower} HP.**"

You have to figure out how to create a method and to use it in the outside code as shown below:



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



Also, create a **constructor** which **sets** all the **fields**:



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

Create the static and non-static fields, **all private:**

Set the id of an account upon creation while **incrementing** the global account count:

Create a setter for the global interest rate. Making the method **static** will let you access it through the class name:

Implement **deposit()** and **getInterest():**



