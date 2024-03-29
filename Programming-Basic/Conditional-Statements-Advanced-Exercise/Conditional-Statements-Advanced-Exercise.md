﻿
# **Упражнения: Вложени условни конструкции**
Задачи за упражнение в клас и за домашно към курса ["Основи на програмирането" @ СофтУни](https://softuni.bg/courses/programming-basics).

**Тествайте** решението си в **judge системата**: <https://judge.softuni.bg/Contests/2392>
## 1. **Кино**
В една кинозала столовете са наредени в правоъгълна форма в **r** реда и **c** колони. Има три вида прожекции с билети на различни цени:

- **Premiere** – премиерна прожекция, на цена **12.00** лева.
- **Normal** – стандартна прожекция, на цена **7.50** лева.
- **Discount** – прожекция за деца, ученици и студенти на намалена цена от **5.00** лева.

Напишете програма, която чете **тип прожекция** (стринг), брой **редове** и брой **колони** в залата (цели числа), въведени от потребителя, и изчислява общите приходи от билети при пълна зала. Резултатът да се отпечата във формат като в примерите по-долу, с 2 знака след десетичната точка.  
### **Примерен вход и изход**

|**вход**|**изход**||**вход**|**изход**||**вход**|**изход**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|<p>Premiere</p><p>10</p><p>12</p>|1440.00 leva||<p>Normal</p><p>21</p><p>13</p>|2047.50 leva||<p>Discount</p><p>12</p><p>30</p>|1800.00 leva|
### **Насоки**
1. Прочетете входните данни от конзолата.

  ![image](https://user-images.githubusercontent.com/67644402/140500792-75c16101-fb8c-45bf-88e8-1e3953975826.png)

1. Инициализирайте променлива "**income**" от тип "**double**" с начална стойност **0**.

  ![image](https://user-images.githubusercontent.com/67644402/140500827-0b277c03-c0cc-44ef-b7a1-1619880837b1.png)

1. Направете серия от проверки, използвайки метода за сравнение на **string** "**.equals()**" , като за всеки тип прожекция ("**Premiere**, **Normal**, **Discount**"), присвоявайте съответната цена към променливата "**income**" и накрая отпечатайте крайния резултат.

  ![image](https://user-images.githubusercontent.com/67644402/140500840-8218efb5-7a69-478e-bda7-2f3695c80558.png)

  ## 2. **Лятно облекло**
  Лято е с много променливо време и Виктор има нужда от вашата помощ. Напишете програма която **спрямо времето от денонощието** **и градусите** да препоръча на Виктор какви дрехи да си облече. Вашия приятел има различни планове за всеки етап от деня, които изискват и различен външен вид, тях може да видите от **таблицата.**

**От конзолата се четат точно два реда:**

- **Градусите - цяло число в интервала [10…42]**
- **Текст, време от денонощието - с възможности - "Morning", "Afternoon", "Evening"**

|**Време от денонощието / градуси**|<p></p><p>Мorning</p>|<p></p><p>Afternoon</p>|<p></p><p>Evening</p>|
| :-: | :-: | :-: | :-: |
|10 <= градуси <= 18|<p>Outfit = Sweatshirt</p><p>Shoes = Sneakers</p>|<p>Outfit = Shirt</p><p>Shoes = Moccasins</p>|<p>Outfit = Shirt</p><p>Shoes = Moccasins</p>|
|18 < градуси <= 24|<p>Outfit = Shirt</p><p>Shoes = Moccasins</p>|<p>Outfit = T-Shirt</p><p>Shoes = Sandals</p>|<p>Outfit = Shirt</p><p>Shoes = Moccasins</p>|
|градуси >= 25|<p>Outfit = T-Shirt</p><p>Shoes = Sandals</p>|<p>Outfit = Swim Suit</p><p>Shoes = Barefoot</p>|<p>Outfit = Shirt</p><p>Shoes = Moccasins</p>|









**Да се отпечата на конзолата на един ред:** **"It's {градуси} degrees, get your {облекло} and {обувки}."**
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>16</p><p>Morning</p>|It's 16 degrees, get your Sweatshirt and Sneakers.|Сутрин когато градусите са 16, Виктор си взима суичър и маратонки.|
|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>22</p><p>Afternoon</p>|It's 22 degrees, get your T-Shirt and Sandals.|<p>28</p><p>Evening</p>|It's 28 degrees, get your Shirt and Moccasins.|
### **Насоки**
1. Прочетете входните данни от конзолата, и инициализирайте две променливи "**outfit**, **shoes**" от тип "**String**", с начална стойност празен **String** "".

  ![image](https://user-images.githubusercontent.com/67644402/140500878-418151de-3d29-4af5-8661-c5bf2574742e.png)

1. Направете серия от проверки за етапа от деня, а именно "**Morning**, **Afternoon**, **Evening**", и в тялото на всяка проверка направете серия от проверки за градусите с помощта на логически оператор "**и**" – "**&&**", като за всеки диапазон от градуси променяйте адекватно стойността на променливите "**outfit** и **shoes**", използвайки таблицата в условието на задачата.

  ![image](https://user-images.githubusercontent.com/67644402/140500913-b6e553b8-7523-47e5-8f7e-998011e74ac0.png)

1. Отпечатайте на конзолата крайния резултат.

  ![image](https://user-images.githubusercontent.com/67644402/140500936-b22ab769-c97f-44e5-90e3-615dcb654f10.png)

  ## 3. **Нов дом**
  Марин и Нели си купуват къща не далеч от София. Нели толкова много обича цветята, че Ви убеждава да **напишете програма** която да **изчисли колко  ще им струва**, да си засадят определен брой цветя и **дали наличния бюджет ще им е достатъчен. Различните цветя са с различни цени.** 

|**цвете**|**Роза**|**Далия**|**Лале**|**Нарцис**|**Гладиола**|
| :-: | :-: | :-: | :-: | :-: | :-: |
|**Цена на брой в лева**|5|3.80|2.80|3|2.50|
**Съществуват следните отстъпки:**

- **Ако Нели купи повече от 80 Рози - 10% отстъпка от крайната цена**
- **Ако Нели купи повече от 90  Далии - 15% отстъпка от крайната цена**
- **Ако Нели купи повече от 80 Лалета - 15% отстъпка от крайната цена**
- **Ако Нели купи по-малко от 120 Нарциса - цената се оскъпява с 15%**
- **Ако Нели Купи по-малко от 80 Гладиоли - цената се оскъпява с 20%**

**От конзолата се четат 3 реда:**

- **Вид цветя - текст с възможности - "Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"**
- **Брой цветя - цяло число в интервала [10…1000]**
- **Бюджет - цяло число в интервала [50…2500]**

Да се **отпечата** на конзолата **на един ред:**

- **Ако бюджета им е достатъчен - "Hey, you have a great garden with {броя цвета} {вид цветя} and {останалата сума} leva left."**
- **Ако бюджета им е НЕ достатъчен -** **"Not enough money, you need {нужната сума} leva more."**

**Сумата да бъде форматирана до втория знак след десетичната запетая.**
###
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>Roses</p><p>55</p><p>250</p>|Not enough money, you need 25.00 leva more.|<p>Нели иска 55 броя Рози. Цената на една роза е 5лв., следователно за 55 броя Нели ще трябва да плати: 55 \* 5 = 275.</p><p>Тя обаче разполага с 250 лв. бюджет. <br>Понеже 275 > 250 , то не и достигат 25 лв.</p>|
|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>Tulips</p><p>88</p><p>260</p>|Hey, you have a great garden with 88 Tulips and 50.56 leva left.|<p>Narcissus</p><p>119</p><p>360</p><p></p>|Not enough money, you need 50.55 leva more.|
## 4. **Лодка за риболов**
Тони и приятели много обичали да ходят за риба, те са толкова запалени по риболова, че решават да отидат на риболов с кораб. Цената за наема на кораба зависи от **сезона и броя рибари.**

**Цената зависи от сезона:**

- **Цената за наем на кораба през пролетта е  3000 лв.**
- **Цената за наем на кораба през лятото и есента е  4200 лв.**
- **Цената за наем на кораба през зимата е  2600 лв.**

**В зависимост от броя си групата ползва отстъпка:**

- **Ако групата е до 6 човека включително  –  отстъпка от 10%.**
- **Ако групата е от 7 до 11 човека включително  –  отстъпка от 15%.**
- **Ако групата е от 12 нагоре  –  отстъпка от 25%.** 

Рибарите ползват допълнително **5% отстъпка ако са четен брой освен ако не е есен - тогава нямат допълнителна отстъпка.** 

**Напишете програма**, която да **пресмята** дали** рибарите** ще **съберат достатъчно пари.** 
### **Вход**
**От конзолата се четат точно три реда.**

- **Бюджет на групата – цяло число в интервала [1…8000]**
- **Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"**
- **Брой рибари – цяло число в интервала [4…18]**
### **Изход**
Да се **отпечата** на конзолата **един ред**:

- Ако **бюджетът е достатъчен:**

"**Yes! You have {останалите пари} leva left.**"

- Ако **бюджетът НЕ Е достатъчен**:

"**Not enough money! You need {сумата**, **която** **не** **достига} leva.**"

**Сумите** трябва да са **форматирани с точност до два знака след десетичната запетая**.
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>3000</p><p>Summer</p><p>11</p>|Not enough money! You need 570.00 leva.|<p>Лятото риболовния туризъм струва 4200 лв., **11 рибари ползват 15% отстъпка -> 4200 - 15% = 3570** лв., **нечетен брой са и не ползват допълнителна отстъпка,.**</p><p>3000 <= 3570, следователно не им достигат 570.00 лв.</p>|
|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>3600</p><p>Autumn</p><p>6</p>|Not enough money! You need 180.00 leva.|<p>2000</p><p>Winter</p><p>13</p><p></p>|Yes! You have 50.00 leva left.|
## 5. **Пътешествие**
Странно, но повечето хора си плануват от рано почивката. Млад програмист разполага с **определен бюджет** и свободно време в даден **сезон**. Напишете програма, която да приема **на входа бюджета и сезона**, а **на изхода** да изкарва, **къде ще почива** програмиста и **колко ще похарчи**.

**Бюджета определя дестинацията, а** **сезона определя колко от бюджета ще изхарчи**. Ако е **лято** ще почива на **къмпинг**, а **зимата в хотел**. Ако е в **Европа**, **независимо от сезона** ще почива в **хотел**. Всеки **къмпинг** или **хотел**, **според дестинацията**, има **собствена цена** която отговаря на даден **процент от бюджета**: 

- При **100лв. или по-малко** – някъде в **България**
  - **Лято** – **30%** от бюджета
  - **Зима** – **70%** от бюджета
- При **1000лв. или по малко** – някъде на **Балканите**
  - **Лято** – **40%** от бюджета
  - **Зима** – **80%** от бюджета
- При **повече от 1000лв**. – някъде из **Европа**
  - При пътуване из Европа, независимо от сезона ще похарчи **90% от бюджета**.
### **Вход**
Входът се чете от конзолата и се състои от **два реда**, въведени от потребителя:

- **Първи ред** – Бюджет, **реално число** в интервала **[10.00...5000.00].**
- **Втори ред** –  Един от двата възможни сезона: **„summer”** или **“winter”**
### **Изход**
На конзолата трябва да се отпечатат **два реда**.

- **Първи ред** – "**Somewhere in [дестинация]**“ измежду "**Bulgaria**", "**Balkans**" и "**Europe**"
- **Втори ред** – "{**Вид почивка**} – {**Похарчена сума**}"
  - **Почивката** може да е между "**Camp**" и "**Hotel**"
  - **Сумата** трябва да е **закръглена с точност до вторият знак след запетаята**.
### **Примерен вход и изход**

|**вход**|**изход**|
| :-: | :-: |
|<p>50</p><p>summer</p>|<p>Somewhere in Bulgaria</p><p>Camp - 15.00</p>|
|<p>75</p><p>winter</p>|<p>Somewhere in Bulgaria</p><p>Hotel - 52.50</p>|
|<p>312</p><p>summer</p>|<p>Somewhere in Balkans</p><p>Camp - 124.80</p>|
|<p>678.53</p><p>winter</p>|<p>Somewhere in Balkans</p><p>Hotel - 542.82</p>|
|<p>1500</p><p>summer</p>|<p>Somewhere in Europe</p><p>Hotel - 1350.00</p>|
## 6. **Операции между числа**
Напишете програма, която чете **две цели числа (N1 и N2)** и **оператор,** с който да се **извърши** дадена **математическа операция** с тях. Възможните операции са: **Събиране(+)**, **Изваждане(-)**, **Умножение(\*)**, **Деление(/)** и **Модулно деление(%).** При **събиране**, **изваждане** и **умножение** на конзолата **трябва да се отпечатат резултата** и дали той е **четен** или **нечетен**. При **обикновеното деление** – **резултат**а. При **модулното деление** – **остатъка**. Трябва да се има предвид, че **делителят може да е равен на 0(нула)**, а **на нула не се дели**. В този случай трябва да се отпечата **специално съобщениe**.

### **Вход**
От конзолата се прочитат **3 реда**, въведени от потребителя:

- **N1** – **цяло число** в интервала **[0...40 000]**
- **N2** – **цяло число** в интервала **[0...40 000]**
- **Оператор** – **един символ** измеду: „**+**“, „**-**“, „**\***“, „**/**“, „**%**“
### **Изход**
Да се отпечата на конзолата **един ред**:

- Ако операцията е **събиране**, **изваждене** или **умножение**:
  - ` `**„{N1} {оператор} {N2} = {резултат} – {even/odd}“**
- Ако операцията е **деление**:
  - **„{N1} / {N2} = {резултат}“** – резултатът е **фораматиран** до **вторият знак след дес.запетая**
- Ако операцията е **модулно деление**: 
  - **„{N1} % {N2} = {остатък}“**
- В случай на **деление с 0(нула)**: 
  - **„Cannot divide {N1} by zero“**
### **Примерен вход и изход**

|**вход**|**изход**|**вход**|**изход**|**вход**|**изход**|
| :-: | :-: | :-: | :-: | :-: | :-: |
|<p>10</p><p>12</p><p>+</p>|10 + 12 = 22 - even|<p>123</p><p>12</p><p>/</p>|123 / 12 = 10.25|<p>112</p><p>0</p><p>/</p>|Cannot divide 112 by zero|
|<p>10</p><p>1</p><p>-</p>|10 – 1 = 9 - odd|<p>10</p><p>3</p><p>%</p>|10 % 3 = 1|<p>10</p><p>0</p><p>%</p>|Cannot divide 10 by zero|
|<p>7</p><p>3</p><p>\*</p>|7 \* 3 = 21 - odd|

## 7. **Хотелска стая**
Хотел предлага **2 вида стаи**: **студио и апартамент**. Напишете програма, която изчислява **цената за целия престой за студио и апартамент**. **Цените** зависят от **месеца** на престоя:

|**Май и октомври**|**Юни и септември**|**Юли и август**|
| :- | :- | :- |
|Студио – **50** лв./нощувка|Студио – **75.20** лв./нощувка|Студио – **76** лв./нощувка|
|Апартамент – **65** лв./нощувка|Апартамент – **68.70** лв./нощувка|Апартамент – **77** лв./нощувка|
Предлагат се и следните **отстъпки**:

- За **студио**, при **повече** от **7** нощувки през **май и октомври** : **5% намаление**.
- За **студио**, при **повече** от **14** нощувки през **май и октомври** : **30% намаление**.
- За **студио**, при **повече** от **14** нощувки през **юни и септември**: **20% намаление**.
- За **апартамент**, при **повече** от **14** нощувки**, без значение от месеца : 10% намаление.**
### **Вход**
Входът се чете от **конзолата** и съдържа **точно 2 реда**, въведени от потребителя:

- На **първия** ред е **месецът** – **May, June, July, August, September** или **October**
- На **втория** ред е **броят на нощувките** – **цяло число в интервала [0 ... 200]**
### **Изход**
Да се **отпечатат** на конзолата **2 реда**:

- На **първия ред**: “**Apartment: {цена за целият престой} lv.**”
- На **втория ред**: “**Studio: {цена за целият престой} lv.**“

**Цената за целия престой** **форматирана с точност до два знака след десетичната запетая**.
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>May</p><p>15</p>|<p>Apartment: 877.50 lv.</p><p>Studio: 525.00 lv.</p>|<p>**През май**, при повече от **14** нощувки, намаляваме цената на студиото с **30%** (50 – 15 = 35), а на апартамента – с **10%** (65 – 6.5 =58.5).</p><p>Целият престой в **апартамент** – **877.50 лв**.</p><p>Целият престой в **студио** – **525.00 лв**.</p>|
|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>June</p><p>14</p>|<p>Apartment: 961.80 lv.</p><p>Studio: 1052.80 lv.</p>|<p>August</p><p>20</p>|<p>Apartment: 1386.00 lv.</p><p>Studio: 1520.00 lv.</p>|
## 8. **Навреме за изпит**
Студент трябва да отиде **на** **изпит** **в** **определен час**. Той идва в изпитната зала в даден **час на пристигане**. Счита се, че студентът е дошъл **навреме**, ако е пристигнал в часа на изпита или до половин час преди това. Ако е пристигнал по-рано повече от 30 минути, той е **подранил**. Ако е дошъл след часа на изпита, той е **закъснял**. Напишете програма, която прочита време на изпит и време на пристигане и отпечатва дали студентът е дошъл **навреме**, дали е **подранил** или е **закъснял** и **с колко часа или минути** е подранил или закъснял.

### **Вход**
От конзолата се четат **4 цели числа** (по едно на ред), въведени от потребителя:

- Първият ред съдържа **час на изпита** – цяло число от 0 до 23.
- Вторият ред съдържа **минута на изпита** – цяло число от 0 до 59.
- Третият ред съдържа **час на пристигане** – цяло число от 0 до 23.
- Четвъртият ред съдържа **минута на пристигане** – цяло число от 0 до 59.
### **Изход**
На първият ред отпечатайте:

- “**Late**”, ако студентът пристига по-късно от часа на изпита.
- “**On time**”, ако студентът пристига точно в часа на изпита или до 30 минути по-рано.
- “**Early**”, ако студентът пристига повече от 30 минути преди часа на изпита.

Ако студентът пристига с поне минута разлика от часа на изпита, отпечатайте на следващия ред:
### **Примерен вход и изход**

|**Вход**|**Изход**||**Вход**|**Изход**||**Вход**|**Изход**|
| :- | :- | :- | :- | :- | :- | :- | :- |
|<p>9</p><p>30</p><p>9</p><p>50</p>|<p>Late</p><p>20 minutes after the start</p>||<p>9</p><p>00</p><p>10</p><p>30</p>|<p>Late</p><p>1:30 hours after the start</p>||<p>10</p><p>00</p><p>10</p><p>00</p>|On time|
|<p>9</p><p>00</p><p>8</p><p>30</p>|<p>On time</p><p>30 minutes before the start</p>||<p>14</p><p>00</p><p>13</p><p>55</p>|<p>On time</p><p>5 minutes before the start</p>||c|<p>Early</p><p>35 minutes before the start</p>|
|<p>16</p><p>00</p><p>15</p><p>00</p>|<p>Early</p><p>1:00 hours before the start</p>||<p>11</p><p>30</p><p>8</p><p>12</p>|<p>Early</p><p>3:18 hours before the start</p>||<p>11</p><p>30</p><p>12</p><p>29</p>|<p>Late</p><p>59 minutes after the start</p>|

## 9. **Ски почивка**
Атанас решава да прекара отпуската си в Банско и да кара ски. Преди да отиде обаче, трябва да резервира хотел и да изчисли **колко ще му струва престоя**. Налични са следните видове помещения, със следните цени за престой:

- **"room for one person" – 18.00 лв за нощувка**
- "**apartment**" – **25.00 лв за нощувка** 
- **"president** **apartment**" – **35.00 лв за нощувка**

Според **броят на дните**, в които ще остане в хотела (**пример: 11 дни = 10 нощувки**) и **видът на помещението**, което ще избере, той може да ползва различно **намаление**. 

Намаленията са както следва:

|**вид помещение**|**по-малко от 10 дни**|**между 10 и 15 дни**|**повече от 15 дни**|
| :-: | :-: | :-: | :-: |
|**room for one person**|не ползва намаление|не ползва намаление|не ползва намаление|
|**apartment**|**30%** от крайната цена|**35%** от крайната цена|**50%** от крайната цена|
|**president apartment**|**10%** от крайната цена|**15%** от крайната цена|**20%** от крайната цена|
След престоя, оценката на Атанас за услугите на хотела може да е **позитивна (positive)** или **негативна (negative)** . Ако оценката му е **позитивна**, към цената **с вече приспаднатото намаление** Атанас добавя **25%** от нея. Ако оценката му е **негативна** приспада от цената **10%**.
### **Вход**
Входът се чете от конзолата и се състои от **три реда**:

- **Първи ред** - **дни за престой** - **цяло число** в интервала **[0...365]**
- **Втори ред** - **вид помещение -** "**room for one person**", "**apartment**" или "**president** **apartment**"
- **Трети ред** - **оценка** - "**positive**"  или "**negative**"
### **Изход**
На конзолата трябва да се отпечата **един ред**:

- **Цената за престоят му в хотела, форматирана до втория знак след десетичната запетая.**
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>14</p><p>apartment</p><p>positive</p>|264.06|<p>**14 дни => 13 нощувки** => 13 \* 25.00 = 325 лв.</p><p>**10 < 13 дни < 15** => 325 – 35%= 211.25 лв.</p><p>**Оценката е positive** => 211.25 + 25% = 264.0625 -> 264.06 лв.</p>|
|**Вход**|**Изход**|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>30</p><p>president apartment</p><p>negative</p>|730.80|<p>12</p><p>room for one person</p><p>positive</p>|247.50|<p>2</p><p>apartment</p><p>positive</p>|21.88|



