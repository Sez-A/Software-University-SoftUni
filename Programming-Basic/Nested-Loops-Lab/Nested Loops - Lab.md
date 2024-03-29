﻿
# **Лаб: Вложени цикли**
Задачи за упражнение в клас и за домашно към курса ["Основи на програмирането" @ СофтУни](https://softuni.bg/courses/programming-basics).

**Тествайте** решенията си в **Judge системата**: <https://judge.softuni.bg/Contests/2397>
## 1. **Часовник**
Напишете програма, която отпечатва **часовете в денонощието от 0:0 до 23:59**, всеки на отделен ред. Часовете трябва да се изписват във формат **"{час}:{минути}"**.

### **Примерен вход и изход**

|**Вход**|**Изход**|
| :- | :- |
|*(няма вход)*|<p>0:0</p><p>0:1</p><p>0:2</p><p>0:3</p><p>0:4</p><p>0:5</p><p>0:6</p><p>0:7</p><p>0:8</p><p>0:9</p><p>0:10</p><p>...</p><p>23:50</p><p>23:51</p><p>23:52</p><p>23:53</p><p>23:54</p><p>23:55</p><p>23:56</p><p>23:57</p><p>23:58</p><p>23:59</p>|
### **Насоки**
1. Създайте 2 вложени for-цикъла, с които да итерирате през всяка една минута и час от денонощието:

![image](https://user-images.githubusercontent.com/67644402/141338680-4a773fcb-5f92-44f3-a0b9-aa5ef1077e9f.png)

2. Отпечатайте резултата:

![image](https://user-images.githubusercontent.com/67644402/141338722-3b076a46-ed92-4d7c-97b0-ea526771cc25.png)

## 2. **Таблица за умножение**
Отпечатайте на конзолата таблицата за умножение за числата от 1 до 10 във формат: 
**"{първи множител} \* {втори множител} = {резултат}"**. 

### **Примерен вход и изход**

|**Вход**|**Изход**|
| :- | :- |
|*(няма вход)*|<p>1 \* 1 = 1</p><p>1 \* 2 = 2</p><p>1 \* 3 = 3</p><p>1 \* 4 = 4</p><p>1 \* 5 = 5</p><p>1 \* 6 = 6</p><p>1 \* 7 = 7</p><p>1 \* 8 = 8</p><p>1 \* 9 = 9</p><p>1 \* 10 = 10</p><p>...</p><p>10 \* 1 = 10</p><p>10 \* 2 = 20</p><p>10 \* 3 = 30</p><p>10 \* 4 = 40</p><p>10 \* 5 = 50</p><p>10 \* 6 = 60</p><p>10 \* 7 = 70</p><p>10 \* 8 = 80</p><p>10 \* 9 = 90</p><p>10 \* 10 = 100</p>|
### **Насоки**
1. Създайте 2 вложени for-цикъла, с които да итерирате всяка възможна стойност на двата множителя от 1 до 10:

![image](https://user-images.githubusercontent.com/67644402/141338741-eaf7b4f9-3d0d-439e-ba10-d0598f0ee830.png)

2. Намерете произведението на двата множителя и отпечатайте резултата:

![image](https://user-images.githubusercontent.com/67644402/141338759-52795945-843e-4455-886e-e7a433fa27d7.png)

## 3. **Комбинации**
Напишете програма, която изчислява **колко решения в естествените числа** (включително и нулата) има уравнението:

**x1 + x2 + x3 = n**

**Числото n е цяло число и се въвежда от конзолата.** 

### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|**Вход**|**Изход**|**Вход**|**Изход**|
| :- | :- | :-: | :- | :- | :- | :- |
|25|351|<p>Генерираме всички комбинации от 3 числа, като първата е:</p><p>0+0+0=0, но понеже не е равна на 25, продължаваме:</p><p>0+0+1=1 – също не е 25 и т.н.</p><p>Стигаме до първата валидна комбинация:</p><p>0 + 0 + 25 = 25, увеличаваме броя на валидни комбинации с 1,втората валидна комбинация е:</p><p>0 + 1 + 24 = 25</p><p>Третата:</p><p>0 + 2 + 23 = 25  и т.н.</p><p>След генериране на всички възможни комбинации, броят на валидните е 351.</p>|20|231|<p>5</p><p></p>|<p>21</p><p></p><p></p>|
### **Насоки**
1. Прочетете входните данни от конзолата – **едно цяло число:**

![image](https://user-images.githubusercontent.com/67644402/141338775-3731d1ab-4c5f-4f91-adb9-eef6f3cbb903.png)

2. Създайте 3 вложени **for**-цикъла, с които да итерирате всяка възможна стойност на едно от 3те числа в уравнението:

![image](https://user-images.githubusercontent.com/67644402/141338804-fc2e0ede-5bb5-4074-bc2f-55b23fa2ea0d.png)

3. Направете проверка в най-вътрешния вложен цикъл за стойностите на **x1**, **x2**, **x3** във всяка една итерация. За да бъде валидно уравнението техният сбор трябва да е равен на **n**. Създайте променлива **validCombinationsCount**, която да пази броя на валидните комбинации и добавяйте 

към нея всеки път, когато генерирате такава:

![image](https://user-images.githubusercontent.com/67644402/141338823-e9dc37b4-e569-4737-bfaa-c5ff33f476e3.png)

![image](https://user-images.githubusercontent.com/67644402/141338846-2a32eeee-90b6-400b-bfb5-628a7a09dc7c.png)

4. Накрая принтирайте броя на валидните комбинации (**validCombinationsCount**).

## 4. **Сума от две числа**
Напишете програма която проверява **всички възможни комбинации от двойка числа** **в интервала от две дадени числа**. На изхода се отпечатва, **коя поред е комбинацията** чиито **сбор от числата** **е равен** на дадено **магическо число**. Ако няма **нито една комбинация** отговаряща на условието се отпечатва **съобщение, че не е намерено**.

### **Вход**
Входът се чете от конзолата и се състои от **три реда**:

- **Първи ред** – **начало на интервала** – **цяло число** в интервала **[1...999]**
- **Втори ред** – **край на интервала** – **цяло число** в интервала **[по-голямо от първото число...1000]**
- **Трети ред – магическото число – цяло число** в интервала **[1...10000]**
### **Изход**
На конзолата трябва да се отпечата **един ред,** според резултата:

- Ако **е намерена** **комбинация** чиито **сбор на числата е равен на магическото число**
  - **"Combination N:{пореден номер} ({първото число} + {второ число} = {магическото число})"**
- Ако **не е намерена** комбинация отговаряща на условието
  - **"{броят на всички комбинации} combinations - neither equals {магическото число}"**
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|**Вход**|**Изход**|
| :- | :- | :- | :- | :- |
|<p>1</p><p>10</p><p>5</p>|Combination N:4 (1 + 4 = 5)|<p>Всички комбинации  от две числа между 1 и 10 са:</p><p>1 1, 1 2, 1 3, **1 4**, 1 5, ... 2 1, 2 2, ... 4 9, 4 10, 5 1 ... 10 9, 10 10</p><p>Първата комбинация, чиито сбор на числата е равен на магическото число 5 е **четвъртата (1 и 4)**</p><p></p>|<p>88</p><p>888</p><p>1000</p>|Combination N:20025 (112 + 888 = 1000)|
|**Вход**|**Изход**|**Обяснения**|**Вход**|**Изход**|
|<p>23</p><p>24</p><p>20</p>|4 combinations - neither equals 20|<p>Всички комбинации  от две числа между 23 и 24 са: 23 23, 23 24, 24 23, 24 24 (общо 4)</p><p>Няма двойки числа, чиито сбор е равен на магическото 20</p>|<p>88</p><p>888</p><p>2000</p>|641601 combinations - neither equals 2000|
## 5. **Пътуване**
Ани обича да пътува и иска тази година да посети **няколко** различни дестинации. Като си избере дестинация, ще прецени **колко пари ще й трябват**, за да отиде до там и ще започне да **спестява**. Когато е спестила **достатъчно**, ще може да пътува.

От **конзолата всеки път ще се четат първо дестинацията и минималния бюджет**, който ще е нужен за пътуването, **реално число**. 

След това ще се четат **няколко суми, реални числа**, които Ани спестява като работи и **когато успее да събере достатъчно за пътуването, ще заминава, като на конзолата трябва да се изпише:**

` `**"Going to {дестинацията}!"** 

Когато е посетила всички дестинации, които иска, **вместо дестинация ще въведе "End"** и програмата ще приключи.
### **Примерен вход и изход**

|**Вход**|**Изход**|**Вход**|**Изход**|
| :- | :- | :- | :- |
|<p>Greece</p><p>1000</p><p>200</p><p>200</p><p>300</p><p>100</p><p>150</p><p>240</p><p>Spain</p><p>1200</p><p>300</p><p>500</p><p>193</p><p>423</p><p>End</p>|<p>Going to Greece!</p><p>Going to Spain!</p>|<p>France</p><p>2000</p><p>300</p><p>300</p><p>200</p><p>400</p><p>190</p><p>258</p><p>360</p><p>Portugal</p><p>1450</p><p>400</p><p>400</p><p>200</p><p>300</p><p>300</p><p>Egypt</p><p>1900</p><p>1000</p><p>280</p><p>300</p><p>500</p><p>End</p>|<p>Going to France!</p><p>Going to Portugal!</p><p>Going to Egypt!</p>|
## 6. **Сграда**
Напишете програма, която извежда на конзолата номерата на стаите в една сграда (в низходящ ред), като са изпълнени следните условия:

- На **всеки четен етаж има само офиси**
- На **всеки нечетен етаж има само апартаменти**
- Всеки **апартамент** се означава по следния начин : **А**{**номер на етажа**}{**номер на апартамента**}, **номерата на апартаментите започват от 0.**
- Всеки **офис** се означава по следния начин : **О**{**номер на етажа**}{**номер на офиса**}, **номерата на** **офисите** **също започват от 0.**
- **На последният етаж винаги има апартаменти** и те са по-големи от останалите, за това **пред номера им пише 'L', вместо 'А'. Ако има само един етаж, то има само големи апартаменти!**

От конзолата се прочитат две **цели числа - броят на етажите и броят на стаите за един етаж.** 
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>**6**</p><p>**4**</p>|<p>L60 L61 L62 L63</p><p>A50 A51 A52 A53</p><p>O40 O41 O42 O43</p><p>A30 A31 A32 A33</p><p>O20 O21 O22 O23</p><p>A10 A11 A12 A13</p>|Имаме общо **6** етажа, с по **4** стаи на етаж. Нечетните етажи имат само апартаменти, а четните само офиси.|
|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>9</p><p>5</p>|<p>L90 L91 L92 L93 L94</p><p>O80 O81 O82 O83 O84</p><p>A70 A71 A72 A73 A74</p><p>O60 O61 O62 O63 O64</p><p>A50 A51 A52 A53 A54</p><p>O40 O41 O42 O43 O44</p><p>A30 A31 A32 A33 A34</p><p>O20 O21 O22 O23 O24</p><p>A10 A11 A12 A13 A14</p>|<p>4</p><p>4</p>|<p>L40 L41 L42 L43</p><p>A30 A31 A32 A33</p><p>O20 O21 O22 O23</p><p>A10 A11 A12 A13</p>|

