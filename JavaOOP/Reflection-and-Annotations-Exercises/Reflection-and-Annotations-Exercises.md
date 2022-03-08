
# **Exercises: Reflection**
This document defines the exercises for ["Java OOP" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1605/Reflection-Exercises).
## 1. **Harvesting Fields**
You are given a **RichSoilLand** class with lots of fields (look at the provided skeleton). Like the good farmer you are, you must harvest them. Harvesting means that you must print each **field** in a certain format (see output).

### **Input**
You will receive a maximum of 100 lines with one of the following commands:

- **private -** print all private fields
- **protected** - print all protected fields
- **public** - print all public fields
- **all** - print ALL declared fields
- **HARVEST** - end the input
### **Output**
For each command you must print the **fields** that have the **given access modifier** as described in the input section. The format in which the fields should be printed is:

**"<access modifier> <field type> <field name>"**
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>protected</p><p>HARVEST</p>|<p>protected String testString</p><p>protected double aDouble</p><p>protected byte testByte</p><p>protected StringBuilder aBuffer</p><p>protected BigInteger testBigNumber</p><p>protected float testFloat</p><p>protected Object testPredicate</p><p>protected Object fatherMotherObject</p><p>protected String moarString</p><p>protected Exception inheritableException</p><p>protected Stream moarStreamz</p>|
|<p>private</p><p>public</p><p>private</p><p>HARVEST</p>|<p>private int testInt</p><p>private long testLong</p><p>private Calendar aCalendar</p><p>private char testChar</p><p>private BigInteger testBigInt</p><p>private Thread aThread</p><p>private Object aPredicate</p><p>private Object hiddenObject</p><p>private String anotherString</p><p>private Exception internalException</p><p>private Stream secretStream</p><p>public double testDouble</p><p>public String aString</p><p>public StringBuilder aBuilder</p><p>public short testShort</p><p>public byte aByte</p><p>public float aFloat</p><p>public Thread testThread</p><p>public Object anObject</p><p>public int anotherIntBitesTheDust</p><p>public Exception justException</p><p>public Stream aStream</p><p>private int testInt</p><p>private long testLong</p><p>private Calendar aCalendar</p><p>private char testChar</p><p>private BigInteger testBigInt</p><p>private Thread aThread</p><p>private Object aPredicate</p><p>private Object hiddenObject</p><p>private String anotherString</p><p>private Exception internalException</p><p>private Stream secretStream</p>|
|<p>all</p><p>HARVEST</p>|<p>private int testInt</p><p>public double testDouble</p><p>protected String testString</p><p>private long testLong</p><p>protected double aDouble</p><p>public String aString</p><p>private Calendar aCalendar</p><p>public StringBuilder aBuilder</p><p>private char testChar</p><p>public short testShort</p><p>protected byte testByte</p><p>public byte aByte</p><p>protected StringBuilder aBuffer</p><p>private BigInteger testBigInt</p><p>protected BigInteger testBigNumber</p><p>protected float testFloat</p><p>public float aFloat</p><p>private Thread aThread</p><p>public Thread testThread</p><p>private Object aPredicate</p><p>protected Object testPredicate</p><p>public Object anObject</p><p>private Object hiddenObject</p><p>protected Object fatherMotherObject</p><p>private String anotherString</p><p>protected String moarString</p><p>public int anotherIntBitesTheDust</p><p>private Exception internalException</p><p>protected Exception inheritableException</p><p>public Exception justException</p><p>public Stream aStream</p><p>protected Stream moarStreamz</p><p>private Stream secretStream</p>|

## 2. **Black Box Integer**
You are helping a buddy of yours who is still in the OOP Basics course - his name is Peshoslav (not to be mistaken with real people or trainers). He is rather slow and made a class with all private members. Your tasks are to **instantiate** an object from his class (always with start value 0) and then **invoke** the different methods it has. Your restriction is to **not** change anything in the class itself (consider it a black box). You can look at his class but don't touch anything! The class itself is called **BlackBoxInt.** It is a wrapper for the **int** primitive. The methods it has are:

![image](https://user-images.githubusercontent.com/67644402/157199170-1c1b45c7-434a-472a-9f9b-1020b1ec246a.png)
### **Input**
The input will consist of lines in the form:

**"<command name>\_<value>"**

Example: **add\_115**

Input will always be valid and in the format described, so there is no need to check it explicitly. You stop receiving input when you encounter the command "**END**".
### **Output**
Each command (except the **END** one) should print the current value of **innerValue** of the **BlackBoxInt** object you instantiated. **Don't cheat** by overriding **toString** in the class - you must get the value from the **private** field.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>add\_999999</p><p>subtract\_19</p><p>divide\_4</p><p>multiply\_2</p><p>rightShift\_1</p><p>leftShift\_3</p><p>END</p>|<p>999999</p><p>999980</p><p>249995</p><p>499990</p><p>249995</p><p>1999960</p>|

### **BarracksWars – A New Factory**

You are given a small console based project called Barracks (the code for it is included in the provided skeleton).

The general functionality the project has is adding new units to its repository and printing a report with statistics about the units currently in the repository. First let's go over the original task before the project was created:
### **Input**
The input consists of commands each on a separate line. Commands that execute the functionality are:

- **add** <**Archer**/**Swordsman**/**Pikeman/{…}**> - adds a unit to the repository.
- **report** - prints a lexicological ordered statistic about the units in the repository.
- **fight** - ends the input.
### **Output**
Each command except **fight** should print output on the console.

- **add** should print: **"<Archer/Swordsman/Pikeman/{…}> added!"**
- **report** should print all the info in the repository in the format: **"<UnitType> -> <UnitQuantity>"**, sorted by UnitType
### **Constraints**
- Input will consist of no more than **1000** lines
- **report** command will never be given before any valid add command was provided

**Your Task**

\1) You have to **study the code of the project and figure out how it works**. However, there are parts of it that are not implemented (left with TODOs (**TODO** window will be useful)). You must implement the functionality of the **createUnit** method in the **UnitFactoryImpl** class so that it creates a unit based on the unit type received as parameter. Implement it in such a way that whenever you add a new unit it will be creatable without the need to change anything in the **UnitFactoryImpl** class (psst - use reflection). You can use the approach called **Simple Factory**.

\2) Add two new unit classes (there will be tests that require them) - **Horseman** with 50 health and 10 attack and **Gunner** with 20 health and 20 attack.

If you do everything correctly for this problem, you should write code only in the **factories** and **units** packages.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>add Swordsman</p><p>add Archer</p><p>add Pikeman</p><p>report</p><p>add Pikeman</p><p>add Pikeman</p><p>report</p><p>fight</p>|<p>Swordsman added!</p><p>Archer added!</p><p>Pikeman added!</p><p>Archer -> 1</p><p>Pikeman -> 1</p><p>Swordsman -> 1</p><p>Pikeman added!</p><p>Pikeman added!</p><p>Archer -> 1</p><p>Pikeman -> 3</p><p>Swordsman -> 1</p>|
|<p>add Pikeman</p><p>add Pikeman</p><p>add Gunner</p><p>add Horseman</p><p>add Archer</p><p>add Gunner</p><p>add Gunner</p><p>add Horseman</p><p>report</p><p>fight</p>|<p>Pikeman added!</p><p>Pikeman added!</p><p>Gunner added!</p><p>Horseman added!</p><p>Archer added!</p><p>Gunner added!</p><p>Gunner added!</p><p>Horseman added!</p><p>Archer -> 1</p><p>Gunner -> 3</p><p>Horseman -> 2</p><p>Pikeman -> 2</p>|
|||

### **BarracksWars – the Commands Strike Back**

As you might have noticed commands in the project from **Problem 3** are implemented via a switch case with method calls in the **Engine** class. Although this approach works it is flawed when you add a new command because you have to add a new case for it. In some projects you might not have access to the engine and this would not work. Imagine this project will be outsourced and the outsourcing firm will not have access to the engine. Make it so whenever they want to add a new command they won't have to change anything in the **Engine.**

To do so employ the design pattern called [**Command Pattern**](https://www.baeldung.com/java-command-pattern). Here is how the base (abstract) command should look like:

![image](https://user-images.githubusercontent.com/67644402/157199391-cdb8bdb1-f67d-4768-952d-47a6add8ec1a.png)

Notice how all commands that extend this one will have both a **Repository** and a **UnitFactory** although not all of them need these. Leave it like this for this problem, because for the reflection to work we need all constructors to accept the same parameters. We will see how to go around this issue in **Problem 5**.

Once you've implemented the pattern add a new command. It will have the following syntax:

- **retire** <**UnitType**> - All it has to do is **remove** a unit of the provided type from the repository.
  - If there are no such units currently in the repository print: "**No such units in repository.**"
  - If there is such a unit currently in the repository, print: "**<UnitType> retired!**"

To implement this command, you will also have to implement a corresponding method in the **UnitRepository**.

If you do everything correctly for this problem, you should write/refactor code only in the **core** and **data** packages.
### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>retire Archer</p><p>add Pikeman</p><p>add Pikeman</p><p>add Gunner</p><p>add Horseman</p><p>add Archer</p><p>add Gunner</p><p>add Gunner</p><p>add Horseman</p><p>report</p><p>retire Gunner</p><p>retire Archer</p><p>report</p><p>retire Swordsman</p><p>retire Archer</p><p>fight</p>|<p>No such units in repository.</p><p>Pikeman added!</p><p>Pikeman added!</p><p>Gunner added!</p><p>Horseman added!</p><p>Archer added!</p><p>Gunner added!</p><p>Gunner added!</p><p>Horseman added!</p><p>Archer -> 1</p><p>Gunner -> 3</p><p>Horseman -> 2</p><p>Pikeman -> 2</p><p>Gunner retired!</p><p>Archer retired!</p><p>Archer -> 0</p><p>Gunner -> 2</p><p>Horseman -> 2</p><p>Pikeman -> 2</p><p>No such units in repository.</p><p>No such units in repository.</p>|

### **\* BarracksWars – Return of the Dependencies**

In the final part of this epic problem trilogy we will resolve the issue where all Commands received all utility classes as parameters in their constructors. We can accomplish this by using an approach called **dependency injection container**. This approach is used in many frameworks like **Spring** for instance.

We will do a little twist on that approach. Remove all fields from the abstract command except the **data.** Instead put whatever fields each command needs in the concrete class. Create an annotation called **Inject** and make it so it can be used only on fields. Put the annotation over the fields we need to set trough reflection. Once you've prepared all of this, write the necessary reflection code in the **Command Interpreter** (which you should have refactored out from the engine in **Problem 4**).

Use the tests from Problem 4 to test your solution.
Follow us:

© SoftUni – <https://softuni.org>. Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
