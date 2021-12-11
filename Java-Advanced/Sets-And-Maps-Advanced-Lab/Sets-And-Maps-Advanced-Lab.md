
#                            Lab: Sets and Maps Advanced
This document defines the lab for ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1462/Sets-And-Maps-Advanced-Lab).
## I.**Sets**

### 1.**Parking Lot**
Write a program that:

- Records **car number** for every car that enter in the **parking lot.**
- Removes **car number** when the car go out.

When the parking lot is empty, print **"Parking Lot is Empty".**
#### **Input**
The input will be string in format **{direction, carNumber}.**

The input ends with string **"END".**
#### **Output**
Print the output with all car numbers, which are in parking lot.
#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>IN, CA2844AA</p><p>IN, CA1234TA</p><p>OUT, CA2844AA</p><p>IN, CA9999TT</p><p>IN, CA2866HI</p><p>OUT, CA1234TA</p><p>IN, CA2844AA</p><p>OUT, CA2866HI</p><p>IN, CA9876HH</p><p>IN, CA2822UU</p><p>END</p>|<p>CA9999TT</p><p>CA2844AA</p><p>CA9876HH</p><p>CA2822UU</p>|
|<p>IN, CA2844AA</p><p>IN, CA1234TA</p><p>OUT, CA2844AA</p><p>OUT, CA1234TA</p><p>END</p>|Parking Lot is Empty|
#### **Hints**
- Car numbers are **unique.**
- Use the methods **isEmpty().**
### 2.**SoftUni Party**
There is a party in SoftUni. Many guests are invited, and they are two types: **VIP** and **regular**. 
When guest comes, you have to check if he/she **exist** in any of two reservation lists. All reservation numbers will be with **8 chars.** All **VIP** numbers start with **digit.**

There will be 2 command lines:

- First is **"PARTY"** - party is on and guests start coming.
- Second is **"END"** - then party is over, and no more guest will come.

Output shows all guests, who didn't come to the party (**VIP** must be first).
#### **Examples**

|**Input**|**Output**|**Input**|**Output**|
| :-: | :-: | :-: | :-: |
|<p>7IK9Yo0h</p><p>9NoBUajQ</p><p>Ce8vwPmE</p><p>SVQXQCbc</p><p>tSzE5t0p</p><p>PARTY</p><p>9NoBUajQ</p><p>Ce8vwPmE</p><p>SVQXQCbc</p><p>END</p>|<p>2</p><p>7IK9Yo0h</p><p>tSzE5t0p</p>|<p>m8rfQBvl</p><p>fc1oZCE0</p><p>UgffRkOn</p><p>7ugX7bm0</p><p>9CQBGUeJ</p><p>2FQZT3uC</p><p>dziNz78I</p><p>mdSGyQCJ</p><p>LjcVpmDL</p><p>fPXNHpm1</p><p>HTTbwRmM</p><p>B5yTkMQi</p><p>8N0FThqG</p><p>xys2FYzn</p><p>MDzcM9ZK</p><p>PARTY</p><p>2FQZT3uC</p><p>dziNz78I</p><p>mdSGyQCJ</p><p>LjcVpmDL</p><p>fPXNHpm1</p><p>HTTbwRmM</p><p>B5yTkMQi</p><p>8N0FThqG</p><p>m8rfQBvl</p><p>fc1oZCE0</p><p>UgffRkOn</p><p>7ugX7bm0</p><p>9CQBGUeJ</p><p>END</p>|<p>2</p><p>MDzcM9ZK</p><p>xys2FYzn</p>|

### 3.**"Voina" – Number Game**
Write a program that:

- Reads 20 numbers for both players, separated with " " (single space).
- Every player can hold only **unique** numbers.

Each Round both players get the **top number** from their own deck. Player with the bigger number get both numbers and add it on the **bottom** of his own sequence.

Game ends after **50 rounds** or if any player **lose all** of his numbers.
#### **Input**
- Numbers – **Integer**
#### **Output**
- Output must be **"First player win!"**, **"Second player win!"** or **"Draw!"**
#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>26 58 16 92 44 65 65 77 57 23 71 57 7 52 85 44 32 70 38 23</p><p>43 95 33 51 62 93 57 55 0 31 32 95 68 34 30 51 37 32 11 97</p>|Second player win!|
|<p>74 78 82 42 19 39 29 69 20 42 31 77 57 36 76 26 4 9 83 42</p><p>15 43 80 71 22 88 78 35 28 30 46 41 76 51 76 18 14 52 47 38</p>|First player win!|
#### **Hints**
- Use **Iterator<E>** and **next()** for finding top number in decks.
- Think where to check if any player is **without** cards.
- When you find top number, be sure to **remove** it **immediately** .
#### **Solution**
You might help yourself with the code below:
  
![image](https://user-images.githubusercontent.com/67644402/145672308-a103a21f-5674-4cf3-8847-5711f04810d0.png)

![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.001.png)
## II.**Maps**

### 4.**Count Real Numbers**
Write a program that counts the occurrence of real **numbers**. The input is a single line with real numbers separated by a space. Print the numbers in the order of appearance. All **numbers** must be formatted to **one digit** after the decimal point.

#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>-2.5 4 3 -2.5 -5.5 4 3 3 -2.5 3</p><p></p>|<p>-2.5 -> 3</p><p>4.0 -> 2</p><p>3.0 -> 4</p><p>-5.5 -> 1</p>|
|2.3 4.5 4.5 5.5 5.5 2.3 3.0 3.0 4.5 4.5 3.0 3.0 4.0 3.0 5.5 3.0 2.3 5.5 4.5 3.0|<p>2.3 -> 3</p><p>4.5 -> 5</p><p>5.5 -> 4</p><p>3.0 -> 7</p><p>4.0 -> 1</p>|
#### **Solution**
You might help yourself with the code below:
  
![image](https://user-images.githubusercontent.com/67644402/145672312-3743f7ad-4985-4d58-9788-89d73e51a45b.png)

![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.002.png)
### 5.**Average Students Grades**
Write a program, which reads the **name** of a student and their **grades** and **adds** them to the **student record**, then **prints** **grades** along with their **average grade – ordered the output by the names of the students**.

#### **Input**
On the first line **N** – the number of students, then on the next **N** lines student name with grade.
#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>7</p><p>Stephan 5.20</p><p>Maria 5.50</p><p>Stephan 3.20</p><p>Maria 2.50</p><p>Alex 2.00</p><p>Maria 3.46</p><p>Alex 3.00</p>|<p>Alex -> 2.00 3.00 (avg: 2.50)</p><p>Maria -> 5.50 2.50 3.46 (avg: 3.82)</p><p>Stephan -> 5.20 3.20 (avg: 4.20)</p>|
|<p>4</p><p>Alex 4.50</p><p>Peter 3.00</p><p>Alex 5.00</p><p>Peter 3.66</p>|<p>Alex -> 4.50 5.00 (avg: 4.75)<br>Peter -> 3.00 3.66 (avg: 3.33)</p><p></p>|
|<p>5</p><p>George 6.00</p><p>George 5.50</p><p>George 6.00</p><p>Alex 4.40</p><p>Peter 3.30</p><p>Peter 4.50</p>|<p>Alex -> 4.40 (avg: 4.40)</p><p>George -> 6.00 5.50 6.00 (avg: 5.83)</p><p>Peter -> 3.30 (avg: 3.30)</p>|
#### **Hints**
- Use a **TreeMap** (**String** à **ArrayList<Double>**).
- Check if the name **exists** before adding the grade. If it doesn’t, add it to the map.
- Pass through all **key-value pairs** in the map and print the results. 
- Think of way to get the average grades for each student.
- You can do that with an ordinary loop or with **Stream API.**
### 6.**Product Shop**
Write a program that prints information about food shops in Sofia and the products they store. Until the "**Revision**" command you will receive an input in the format: **"{shop}, {product}, {price}"**

Keep in mind that if you get a store that already exists,	 you need to gather product information in it.

Your output must be ordered by shop name and must be in the format:

"**{shop}->**

**Product: {product}, Price: {price}**"

The price should be formated to **one digit** after the decimal point.
#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>lidl, peach, 1.20</p><p>lidl, juice, 2.30</p><p>fantastico, apple, 1.20</p><p>kaufland, banana, 1.10</p><p>fantastico, grape, 2.20</p><p>Revision</p>|<p>fantastico-></p><p>Product: apple, Price: 1.2</p><p>Product: grape, Price: 2.2</p><p>kaufland-></p><p>Product: banana, Price: 1.1</p><p>lidl-></p><p>Product: peach, Price: 1.2</p><p>Product: juice, Price: 2.3</p>|
|<p>tmarket, peanuts, 2.20</p><p>GoGrill, meatballs, 3.30</p><p>GoGrill, HotDog, 1.40</p><p>tmarket, sweets, 2.20</p><p>Revision</p>|<p>GoGrill-></p><p>Product: meatballs, Price: 3.3</p><p>Product: HotDog, Price: 1.4</p><p>tmarket-></p><p>Product: peanuts, Price: 2.2</p><p>Product: sweets, Price: 2.2</p>|
### 7.**Cities by Continent and Country**
Write a program to read **continents**, **countries** and their **cities**, put them in a **nested map** and **print** them in the order of first appearance.

#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>9</p><p>Europe Bulgaria Sofia</p><p>Asia China Beijing</p><p>Asia Japan Tokyo</p><p>Europe Poland Warsaw</p><p>Europe Germany Berlin</p><p>Europe Poland Poznan</p><p>Europe Bulgaria Plovdiv</p><p>Africa Nigeria Abuja</p><p>Asia China Shanghai</p>|<p>Europe:</p><p>`  `Bulgaria -> Sofia, Plovdiv</p><p>`  `Poland -> Warsaw, Poznan</p><p>`  `Germany -> Berlin</p><p>Asia:</p><p>`  `China -> Beijing, Shanghai</p><p>`  `Japan -> Tokyo</p><p>Africa:</p><p>`  `Nigeria -> Abuja</p>|
|<p>3</p><p>Europe Germany Berlin</p><p>Europe Bulgaria Varna</p><p>Africa Egypt Cairo</p>|<p>Europe:</p><p>`  `Germany -> Berlin</p><p>`  `Bulgaria -> Varna</p><p>Africa:</p><p>`  `Egypt -> Cairo</p>|
|<p>8</p><p>Africa Somalia Mogadishu</p><p>Asia India Mumbai</p><p>Asia India Delhi</p><p>Europe France Paris</p><p>Asia India Nagpur</p><p>Europe Germany Hamburg</p><p>Europe Poland Gdansk</p><p>Europe Germany Danzig</p>|<p>Africa:</p><p>`  `Somalia -> Mogadishu</p><p>Asia:</p><p>`  `India -> Mumbai, Delhi, Nagpur</p><p>Europe:</p><p>`  `France -> Paris</p><p>`  `Germany -> Hamburg, Danzig</p><p>`  `Poland -> Gdansk</p>|
#### **Hints**
- Use a **nested** **Map** (**String** à (**Mapà ArrayList<String>)**) .
- Check if the continent **exists** before adding the country. If it doesn’t, **add** it to the dictionary.
- Check if the country **exists**, before **adding** the city. If it doesn’t, add it to the dictionary.

  ![image](https://user-images.githubusercontent.com/67644402/145672324-f71c8e2d-f087-4b83-90ac-8dbf7b0fdcfa.png)
  
- Pass through all **key-value pairs** in the Map and the values’ key-value pairs and print the results.
### 8.**Academy Graduation**
Write a program that:

- Reads from console **number** of students for a track.
- Reads on **pair of rows**:
  - First line is the **name** of student.
  - Second line is his **score** for different number of courses.
- Print on console **"{name} is graduated with {average scores)".**
#### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>3</p><p>George</p><p>3.75 5</p><p>Maria</p><p>4.25 6</p><p>Peter</p><p>6 4.5</p>|<p>George is graduated with 4.375</p><p>Maria is graduated with 5.125</p><p>Peter is graduated with 5.25</p>|
|<p>5</p><p>George</p><p>4.36 5.50 3.30 5.63 2.57 5.75 2.81 4.89 </p><p>Peter</p><p>3.10 5.35 3.30 3.35 5.64 4.99 2.75 4.68 </p><p>Maria</p><p>3.45 3.23 3.03 5.42 5.46 4.15 2.26 5.95 </p><p>Rosalia</p><p>2.08 3.48 3.36 2.73 2.96 4.54 3.70 3.85</p><p>John</p><p>4.75 4.92 3.78 4.79 4.82 4.75 2.81 2.13</p>|<p>George is graduated with 4.351249999999999</p><p>John is graduated with 4.09375</p><p>Maria is graduated with 4.11875</p><p>Peter is graduated with 4.145</p><p>Rosalia is graduated with 3.3375</p>|
#### **Hints**
- Think about **proper type** of map.
- **Value** can be **array.**
- **Nested loop** and one more **variable** will be need for average score.
#### **Solution**
You might help yourself with the code below:

![image](https://user-images.githubusercontent.com/67644402/145672343-c43af435-90b2-4f5d-b381-aeafd440cd48.png)


Follow us:

© SoftUni – [about.softuni.bg](about.softuni.bg). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.

![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)  ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)   ![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.007.png)

Page  PAGE   \\* MERGEFORMAT 8 of  NUMPAGES   \\* MERGEFORMAT 8
![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.005.png)![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.006.png)![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.008.png)![](Aspose.Words.2bad1266-75f0-41a5-94b7-6d0c4e6dbcd6.009.png)
