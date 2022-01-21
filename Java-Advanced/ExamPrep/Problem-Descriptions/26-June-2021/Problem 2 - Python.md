# **Python**



![image](https://user-images.githubusercontent.com/67644402/149634738-6e58b3d9-6485-4a72-a4d5-a4b960730453.png)



*One of the candidates-intern must solve the task - "Python". He must write a Java code that calculates wheater the python wins or loses the game.*

Here are the rules of the game:

The game starts with a **python length of 1**.

We get as input **the size** of the **screen** in which our python moves. The screen is **always a square**. After that we receive the commands wich represent the directions in wich the python should move.The python **starts** from **s**-position The commands will be: **left/right/up/down.** If the python reaches the side edge of the screen (left or right), it goes to the **opposite side of the same row**. If the python reaches the top/bottom edge of the screen it goes on the **opposite side of the same column** . The possible characters that may appear on the screeen are:

- **\***– that is a regular asterisk; it does nothing
- **e** – represents an enemy. 
- **f** – this is the food
- **s** - the place where the **game starts**

Each time you eat a piece of food your **length increases by one**. Keep track of the length, because **in case you win you have to print it**. If you **step on an enemy the game is over (the python stops moving)** and you have to print the output as shown in the output section. After executing all of the commands there are 3 possible outcomes:

- you have eaten all the food and you win
- you get killed by an enemy
- there is still some food to be eaten

Print the corresponding output depending on the case.
## **Input**
- **Length** of the screen side – an integer number.
- **Commands to move** the python – an array of strings separated by "**,**".
## **Output**
- There are three types of output:
  - If all of the food is eaten print the following output: **"You win! Final python length is {length}"**
  - If there are no left commands and there is still some food to be eaten: **"You lose! There is still {left food} food to be eaten."**
  - If you step on the enemy the game is over and you print **"You lose! Killed by an enemy!"**
## **Constraints**
- The **input numbers** will be a 32-bit integer in the range [0 … 2 147 483 647].
- Allowed working time for your program: 0.1 seconds.
- Allowed memory: 16 MB.
## **Examples**

|**Input**|**Output**|**Comments**|
| :-: | :-: | :-: |
|<p>**5**</p><p>**up, right, right, right, up**</p><p>\* \* e \* \*</p><p>\* \* \* f \*</p><p>\* f \* \* \*</p><p>s \* \* \* \*</p><p>\* \* e \* \*</p>|You win! Final python length is 3|After executing all of the commands the python has eaten all of the food and it is still alive.|
|<p>**4**</p><p>**right, right, right, right, right, down, right**</p><p>\* s \* \*</p><p>\* \* e \*</p><p>\* f \* f</p><p>\* \* \* f</p>|You lose! Killed by an enemy!|The python moves 2 times to the right, then it goes off screen and appears on left side. Then it makes 2 more moves to the right, it goes down, steps on an enemy and the game is over.|
|<p>**6**</p><p>**down, left, left, down, right, right, right, right, right**</p><p>\* \* \* \* s \*</p><p>\* e f \* \* \*</p><p>f \* \* \* \* \*</p><p>\* \* \* f e \*</p><p>\* e \* \* \* \*</p><p>\* \* \* \* \* \*</p>|You lose! There is still 1 food to be eaten.|The python survived but there is still 1 piece of food that the python could not eat.|



