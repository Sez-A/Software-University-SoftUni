
# **Lab: Arrays**
Problems for exercises and homework for the ["Technology Fundamentals" course @ SoftUni.](https://softuni.bg/trainings/3448/programming-fundamentals-with-java-september-2021)

You can check your solutions in [Judge.](https://judge.softuni.bg/Contests/1248/)
## 1. **Day of Week**
Enter a **day number** [1…7] and print the **day name** (in English) or "**Invalid day!**". Use an **array of strings**.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|1|Monday|
|2|Tuesday|
|7|Sunday|
|0|Invalid day!|
### **Hints**
- Use an **array of strings** holding the day names: {"**Monday**", "**Tuesday**", "**Wednesday**", "**Thursday**", "**Friday**", "**Saturday**", "**Sunday**"}.
- Print the element at index (**day-1**) when it is in the range [1…7] or "**Invalid Day!**" otherwise.
## 2. **Print Numbers in Reverse Order**
Read n numbers and print them in reverse order.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>3</p><p>10</p><p>20</p><p>30</p>|30 20 10|
|<p>3</p><p>30</p><p>20</p><p>10</p>|10 20 30|
|<p>1</p><p>10</p>|10|
### **Solution**
First, we need to read **n** from the console.
![image](https://user-images.githubusercontent.com/67644402/142737080-1b66711c-219c-443d-b619-840eeada2c82.png)



Create an **array of integer** with **n** size.

![image](https://user-images.githubusercontent.com/67644402/142737083-5c7bd884-ddc4-4c42-9778-f3ab5c882c85.png)
Read **n** numbers using for loop and fill the array.

![image](https://user-images.githubusercontent.com/67644402/142737089-8be8e258-ac24-4431-adc7-df58d42c95c8.png)
Print the array in reversed order.

![image](https://user-images.githubusercontent.com/67644402/142737094-18c4527e-e835-417f-8ecd-d4fbc4134956.png)

## 3. **Sum Even Numbers**
Read an array from the console and sum only the even numbers.

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|1 2 3 4 5 6|12|
|3 5 7 9|0|
|2 4 6 8 10|30|
### **Solution**
First, we need to read the array.
![image](https://user-images.githubusercontent.com/67644402/142737098-32054b9b-5a0d-48f8-8463-0d87bdb97853.png)

We will need a variable for the sum. 	

![image](https://user-images.githubusercontent.com/67644402/142737103-fb4c9f9b-b0a6-4829-8e5f-c7fead910a3b.png)
Iterate through all elements in the array with for loop. If the number is even add it to the sum. 

![image](https://user-images.githubusercontent.com/67644402/142737106-2bea9f31-46d5-453d-994e-1126001f5a8f.png)
Print the total sum.

## 4. **Reverse an Array of Strings**
Write a program to read **an array of strings**, **reverse** it and **print** its elements. The input consists of a sequence of space separated strings. Print the output on a single line (space separated).

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|a b c d e|e d c b a|
|-1 hi ho w|w ho hi -1|
### **Hints**
- Read the array of strings.
- **Exchange** the **first** element (at index 0) with the **last** element (at index n-1).
- **Exchange** the **second** element (at index 1) with the element **before the** **last** (at index n-2).
- Continue the same way until the middle of the array is reached.
![image](https://user-images.githubusercontent.com/67644402/142737113-b49739dc-fce8-46a2-8f35-a64e86ef2afe.png)
## 5. **Even and Odd Subtraction**
Write a program that calculates the difference between the sum of the even and the sum of the odd numbers in an array.

### **Examples**

|**Input**|**Output**|**Comments**|
| :-: | :-: | :-: |
|1 2 3 4 5 6|3|<p>2 + 4 + 6 = 12</p><p>1 + 3 + 5 = 9</p><p>12 – 9 = 3</p>|
|3 5 7 9|-24||
|2 4 6 8 10|30||
### **Solution**
First, we need to read the array.
![image](https://user-images.githubusercontent.com/67644402/142737121-9b44625e-3e7c-4451-89e0-7f98f677448c.png)

We will need two variables – even and odd sum.

![image](https://user-images.githubusercontent.com/67644402/142737126-1e5c0d27-478c-49fa-9083-fa9e2391696f.png)
Iterate through all elements in the array. Check the current number – if it is even add it to the even sum, otherwise add it to the odd sum.

![image](https://user-images.githubusercontent.com/67644402/142737134-75df2b34-602a-43d2-964d-9d65d4a6ebdf.png)
Print the difference.

![image](https://user-images.githubusercontent.com/67644402/142737138-a442a2b6-ed20-4e9e-a22f-93234869b558.png)

## 6. **Equal Arrays**
Read two arrays and print on the console whether they are identical or not. Arrays are identical if their elements are equal. If the arrays are identical find the sum of the first one and print on the console following message: "**Arrays are identical. Sum: {sum}**", otherwise find the first index where the arrays differ and print on the console following message: "**Arrays are not identical. Found difference at {index} index.**"

### **Examples**

|**Input**|**Output**|
| :-: | :-: |
|<p>10 20 30</p><p>10 20 30</p>|Arrays are identical. Sum: 60|
|<p>1 2 3 4 5</p><p>1 2 4 3 5</p>|Arrays are not identical. Found difference at 2 index.|
|<p>1</p><p>10</p>|Arrays are not identical. Found difference at 0 index.|
### **Hints**
First, we need to read two arrays.
![image](https://user-images.githubusercontent.com/67644402/142737143-da2e9310-a0a1-4844-9992-56db217ced15.png)

Iterate through arrays and compare element. If the elements are not equal print the required message and break the loop.

![image](https://user-images.githubusercontent.com/67644402/142737146-e9aaacb1-6100-4d18-8b56-b602309ea637.png)
Think about how to solve the other part of the problem.

## 7. **Condense Array to Number**
Write a program to read **an array of integers** and **condense** them by **summing** adjacent couples of elements until a **single integer** is obtained. For example, if we have 3 elements {2, 10, 3}, we sum the first two and the second two elements and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.

### **Examples**

|**Input**|**Output**|**Comments**|
| :-: | :-: | :-: |
|2 10 3|25|2 10 3 à 2+10 10+3 à 12 13 à 12 + 13 à 25|
|5 0 4 1 2|35|5 0 4 1 2 à 5+0 0+4 4+1 1+2 à 5 4 5 3 à 5+4 4+5 5+3 à 9 9 8 à 9+9 9+8 à 18 17 à 18+17 à 35|
|1|1|1 is already condensed to number|
### **Hints**
While we have more than one element in the array **nums[]**, repeat the following:

- Allocate a new array **condensed[]** of size **nums.Length-1**.
- Sum the numbers from **nums[]** to **condensed[]**:
  - **condensed[i] = nums[i] + nums[i+1]**
- **nums[] = condensed[]**

The process is illustrated below:

![image](https://user-images.githubusercontent.com/67644402/142737156-6f1a0ad4-93c9-42ab-b555-6cd0ae80243a.png)



![image](https://user-images.githubusercontent.com/67644402/142737164-5f12afc4-a125-4bd2-8124-6978f3ba20c8.png)

