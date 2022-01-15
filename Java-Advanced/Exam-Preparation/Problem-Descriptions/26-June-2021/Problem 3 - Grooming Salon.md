# **Grooming Salon**



![image](https://user-images.githubusercontent.com/67644402/149634804-2f5d7ff1-d28b-4b81-8d43-8b7fea30dc6a.png)



## **Preparation**
Download the skeleton provided in Judge. **Do not** change the **packages**!

**Pay attention to name the package groomingSalon, all the classes, their fields and methods the same way they are presented in the following document. It is also important to keep the project structure as described.**
## **Problem description**
Your task is to create a repository, which stores items by creating the classes described below.

First, write a Java class **Pet** with the following fields:

- **name: String**
- **age: int**
- **owner: String**

The class **constructor** should receive **all fields.**  You need to create the appropriate **getters and setters**. The class should override the **toString()** method in the following format:

**"{name} {age} - ({owner})"**

**Next**, write a Java class **GroomingSalon** that has **data** (a collection, which stores the Pets). All entities inside the repository have the **same fields**. Also, the **GroomingSalon** class should have those fields:

- **capacity: int**

The class **constructor** should receive **capacity**, also it should initialize the **data** with a new instance of the collection**.** Implement the following features:

- Field **data** – **List** that holds added pets
- Method **add(Pet pet)** – **adds** an **entity** to the data **if** **there** **is** an **empty place** in** the** grooming salon for the pet.
- Method **remove(String name)** – removes the pet by **given name,** if such **exists**, and **returns boolean**.
- Method **getPet(String name, String owner)** – returns the pet with the **given name** and **owner** or **null if no such pet exists**.
- Getter **getCount** – **returns** the **number** of pets.
- **getStatistics()** – **returns** a **String** in the following **format**:
  - **"** **The grooming salon has the following clients:
    {name} {owner}
    {name} {owner}** 

`   `**(…)**"
## **Constraints**
- The **combinations** of **names** and **owners** will **always be unique**.
- The **age** of the pets will always be **positive**.

## **Examples**
This is an example of how the **GroomingSalon** class is **intended to be used**. 

|**Sample code usage**|
| :-: |
|<p>// Initialize the repository</p><p>GroomingSalon salon = new GroomingSalon(20);</p><p></p><p>// Initialize entity</p><p>Pet dog = new Pet("Ellias", 5, "Tim");</p><p></p><p>// Print Pet</p><p>System.out.println(dog); // Ellias 5 - (Tim)</p><p></p><p>// Add Pet</p><p>salon.add(dog);</p><p></p><p>// Remove Pet</p><p>System.out.println(salon.remove("Ellias")); // true</p><p>System.out.println(salon.remove("Pufa")); // false</p><p></p><p>Pet cat = new Pet("Bella", 2, "Mia");</p><p>Pet bunny = new Pet("Zak", 4, "Jon");</p><p></p><p>salon.add(cat);</p><p>salon.add(bunny);</p><p></p><p>// Get Pet</p><p>Pet pet = salon.getPet("Bella", "Mia");</p><p>System.out.println(pet); // Bella 2 - (Mia)</p><p></p><p>// Count</p><p>System.out.println(salon.getCount()); // 2</p><p></p><p>// Get Statistics</p><p>System.out.println(salon.getStatistics());</p><p>// The grooming salon has the following clients:</p><p>//Bella Mia</p><p>//Zak Jon</p>|
## **Submission**
Zip all the files in the project folder except **bin** and **obj** folders

Submit **single .zip file**, containing **groomingSalon package, with the classes inside (Pet, GroomingSalon and the Main class)**, there is no specific content required inside the Main class e. g. you can do any kind of local testing of you program there. However there should be **main(String[] args)** method inside.

