﻿
**Упражнение: Повторения с цикли – While цикъл**

Задачи за упражнение и домашно към курса ["Основи на програмирането" в СофтУни](https://softuni.bg/courses/programming-basics).

Тествайте решенията си в **judge системата**: <https://judge.softuni.bg/Contests/2396>
## 1. **Старата Библиотека**
Ани отива до родния си град след много дълъг период извън страната. Прибирайки се вкъщи, тя вижда старата библиотека на баба си и си спомня за любимата си книга. Помогнете на Ани, като напишете програма, в която тя въвежда търсената от нея **книга** (**текст**). **Докато Ани не намери любимата си книга или не провери всички книги в библиотеката, програмата трябва да чете всеки път на нов ред името на всяка следваща книга (текст), която тя проверява. Книгите в библиотеката са свършили щом получите текст "No More Books".**

- **Ако не открие търсената книгата да се отпечата на два реда:** 
- **"The book you search is not here!"**
- **"You checked {брой} books."**
- **Ако открие книгата си се отпечатва един ред:**
  - **"You checked {брой} books and found it."**  
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>Troy</p><p>Stronger</p><p>Life Style</p><p>Troy</p>|You checked 2 books and found it.|Книгата, която Ани търси, в случая е Troy. Първата е Stronger, втората е Life Style, третата книга е търсената – Troy и програмата приключва.|
|<p>The Spot</p><p>Hunger Games</p><p>Harry Potter</p><p>Torronto</p><p>Spotify</p><p>No More Books</p>|<p>The book you search is not here!</p><p>You checked 4 books.</p>|<p>Книгата, която търси Ани е "The Spot".</p><p>Библиотеката съдържа 4 книги.</p><p>Първата е Hunger Games, втората Harry Potter, третата Torronto, а четвъртата Spotify. Понеже няма повече книги в библиотеката четенето на имена приключва. Ани не намери книгата, която търсеше. </p>|
|<p>Bourne</p><p>True Story</p><p>Forever</p><p>More Space</p><p>The Girl</p><p>Spaceship</p><p>Strongest</p><p>Profit</p><p>Tripple</p><p>Stella</p><p>The Matrix</p><p>Bourne</p>|You checked 10 books and found it.||
### **Насоки**
1. Прочетете входните данни от конзолата (**името на книгата, която търси и капацитета на библиотеката**):

  ![image](https://user-images.githubusercontent.com/67644402/141155774-b3d28088-e146-4eac-93f6-ce18aec676cf.png)


1. Създайте **две нови променливи**. Едната ще отчита **броя на проверените книги**. Другата ще е **от булев тип**, като и дадете начална стойност **false** (**т.е. книгата не е открита**). В тази променлива ще държите стойност, която ще показва дали **книгата е открита или не**. Ако променливата е със стойност **true** – **книгата е открита**, в противен случай – **книгата не е**.

  ![image](https://user-images.githubusercontent.com/67644402/141155828-9d676cde-ca7b-43e4-993e-c333d73927e7.png)

1. Създайте нова променлива, която ще съхранява информация за **текущата книга, която ще проверявате**. Направете **while** цикъл, в които четете **по една книга** всеки път, докато **книгата не е намерена или докато не свърши капацитета на библиотеката** (**получите команда "No More Books"**). В цикъла направете проверка **дали въведената книга съвпада с търсената** и ако проверката е вярна, променете **стойността на булевата променлива**, която създадохте в предната стъпка, **на true** (т.е**. книгата е намерена**). В противен случай увеличете с **едно променливата (брояча)**, която създадохте във втората стъпка. 

  ![image](https://user-images.githubusercontent.com/67644402/141155856-7a97f3a1-5f2e-4717-a371-a4610c1a6b0d.png)

1. Когато цикълът приключи, отпечатайте **двата възможни резултата**.

  ![image](https://user-images.githubusercontent.com/67644402/141155894-78cb2ada-56b4-47a1-a31f-b5a3ca857b9a.png)

  ## 2. **Подготовка за изпит**
  Напишете програма, в която Марин решава задачи от изпити, **докато** **не** **получи** съобщение **"Enough"** от** лектора** си. При всяка решена задача, той получава оценка. **Програмата трябва да приключи прочитането на данни при команда "Enough"** **или ако Марин получи определеният брой незадоволителни оценки.**
  **Незадоволителна е всяка оценка, която е по-малка или равна на 4.**
### **Вход**
- **На първи ред - брой незадоволителни оценки - цяло число в интервала [1…5]**
- **След това многократно се четат по два реда:**
  - **Име на задача - текст**
- **Оценка - цяло число в интервала [2…6]**
### **Изход**
- Ако Марин стигне до командата **"Enough", отпечатайте на 3 реда:** 
- **"Average score: {средна оценка}"**
- **"Number of problems: {броя на всички задачи}"**
  - **"Last problem: {името на последната задача}"**
- **Ако получи определения брой незадоволителни оценки:**
- **"You need a break, {брой незадоволителни оценки} poor grades."**

**Средната оценка да бъде форматирана до втория знак след десетичната запетая.** 
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>3</p><p>Money</p><p>6</p><p>Story</p><p>4</p><p>Spring Time</p><p>5</p><p>Bus</p><p>6</p><p>Enough</p>|<p>Average score: 5.25</p><p>Number of problems: 4</p><p>Last problem: Bus</p>|<p>Броя на позволени незадоволителни оценки е 3. Първата задача се казва Money, оценката на Марин е 6.</p><p>Втората задача е Story, оценката на Марин е 4.</p><p>Третата задача е Spring Time, оценката на Марин е 5.</p><p>Четвъртата задача е Bus, оценката на Марин е 6.</p><p>Следващата команда е Enough, програмата приключва.</p><p>Средна оценка: 21 / 4 = 5.25</p><p>Брой решени задачи: 4</p><p>Последна задача: Bus</p>|
|**Вход**|**Изход**|**Обяснения**|
|<p>2</p><p>Income</p><p>3</p><p>Game Info</p><p>6</p><p>Best Player</p><p>4</p>|You need a break, 2 poor grades.|<p>Броят незадоволителни оценки е 2.</p><p>Първата задача е Income, оценката на Марин е 3.</p><p>Втората задача е Game Info, оценката на Марин е 6.</p><p>Третата задача е Best Player, оценката на Марин е 4.</p><p>Марин достигна допустимия брой незадоволителни оценки, време е за почивка.</p>|
### **Насоки**
1. Прочетете входните данни от конзолата:

  ![image](https://user-images.githubusercontent.com/67644402/141155965-d35dcf94-0aae-47df-8cdc-35c844dc13fe.png)

1. Направете **четири помощни променливи** в началото:
   1. **брояч за незадоволителни оценки - с първоначална стойност 0**
   
   1. **брояч за решените упражнения - с първоначална стойност 0**
   
   1. **сумата на всички оценки - с първоначална стойност 0**
   
   1. **коя е последната задача** - **с първоначална стойност празен текст**
   
   1. **дали се е провалил или не
   
     ![image](https://user-images.githubusercontent.com/67644402/141156003-fa9842e5-4cd9-4bf8-b620-f9f1441de139.png)
   
1. Създайте **while** цикъл, който продължава докато **броя на незадоволителни оценки е по-малък от числото, което сте прочели от конзолата**. При **всяко** повторение на цикъла, прочетете **името на задачата и оценката за нея**.

  ![image](https://user-images.githubusercontent.com/67644402/141156032-93442c97-e0ac-4c4c-bc50-7d2cfabfe0e9.png)

1. В случай, че получите команда **Enough** променете стойността на **isfailed** на **true** и **прекратете цикъла**;

1. При **всяко повторение на цикъла**, **прибавете** оценката на Марин към **сбора на всичките му оценки** и увеличете брояча за **оценките**. Ако оценката е **по-ниска или равна на 4** увеличете брояча за **незадоволителни оценки**. Презапишете името на **последната задача**;

  ![image](https://user-images.githubusercontent.com/67644402/141156235-f32dd5a1-11a0-466c-b8fc-f6f1574804fd.png)

1. След цикъла ако броя **незадоволителни оценки** е достигнал **максималните незадоволителни оценки**, принтирайте нужното съобщение:

  ![image](https://user-images.githubusercontent.com/67644402/141156257-60e4c8a1-d1bc-4b0c-a212-3ddc348badaf.png)

  ## 3. **Почивка**
  Джеси е решила да събира пари за екскурзия и иска от вас да ѝ помогнете да разбере **дали ще успее да събере необходимата сума**. **Тя спестява** или **харчи част от** **парите** си **всеки ден**. Ако иска да **похарчи повече от наличните си пари**, то тя ще похарчи **всичките и ще ѝ останат 0 лева**.
### **Вход**
От конзолата се четат:

- **Пари нужни за екскурзията** - **реално** **число в интервала [1.00…25000.00]**
- **Налични пари** - **реално** **число в интервала [0.00...25000.00]**

**След това многократно се четат по два реда:**

- **Вид действие - текст с възможности "spend" и "save"**
  - **Сумата, която ще спести/похарчи - реално число в интервала [0.01…25000.00]**
### **Изход**
Програмата трябва да приключи при следните случаи:

- Ако **5 последователни дни** Джеси **само харчи, на конзолата да се изпише:**
- **"You can't save the money."**
- **"{Общ брой изминали дни}"**
- **Ако** **Джеси събере парите за почивката** на **конзолата се изписва:**
- **"You saved the money for {общ брой изминали дни} days."**
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :- | :- | :- |
|<p>2000</p><p>1000</p><p>spend</p><p>1200</p><p>save</p><p>2000</p>|<p>You saved the money for 2 days.</p><p></p>|<p>Пари, нужни за екскурзията: **2000**</p><p>Налични пари: 1000</p><p>spend - изваждаме от парите следващото число</p><p>`            `(1000 - 1200 = -200, което е по-малко от 0 </p><p>`               `=> налични пари = 0)</p><p>`        `~ последователни дни, в които харчи = 1</p><p>`        `- общо дни : 1</p><p>save - добавяме към парите следващото число</p><p>`           `(0 + 2000 = 2000)</p><p>`        `~ последователни дни, в които харчи = 0</p><p>`        `- общо дни : 2</p><p>Наличните пари (2000) >= Пари, нужни за екскурзията (**2000**)</p>|
|<p>110</p><p>60</p><p>spend</p><p>10</p><p>spend</p><p>10</p><p>spend</p><p>10</p><p>spend</p><p>10</p><p>spend</p><p>10</p>|<p>You can't save the money.</p><p>5</p>|<p>Пари, нужни за екскурзията: **110**</p><p>Налични пари: **60**</p><p>spend – изваждаме от парите следващото число (60 - 10 = 50)</p><p>`        `~ последователни дни, в които харчи = 1</p><p>`         `- общо дни : 1</p><p>spend – изваждаме от парите следващото число (50 - 10 = 40)</p><p>`        `~ последователни дни, в които харчи = 2</p><p>`         `- общо дни : 2</p><p>spend – изваждаме от парите следващото число (40 - 10 = 30)</p><p>`        `~ последователни дни, в които харчи = 3</p><p>`         `- общо дни : 3</p><p>spend – изваждаме от парите следващото число (30 - 10 = 20)</p><p>`        `~ последователни дни, в които харчи = 4</p><p>`         `- общо дни : 4</p><p>spend – изваждаме от парите следващото число (20 - 10 = 10)</p><p>`        `~ последователни дни, в които харчи = 5</p><p>`        `- общо дни : 5</p><p>5 последователни дни харчи => налични пари: 10</p><p>Наличните пари (10) < Пари, нужни за екскурзията (**110**)</p>|
|<p>250</p><p>150</p><p>spend</p><p>50</p><p>spend</p><p>50</p><p>save</p><p>100</p><p>save</p><p>100</p>|You saved the money for 4 days.|<p>Пари, нужни за екскурзията: **250**</p><p>Налични пари: 150</p><p>spend - изваждаме от парите следващото число (150 - 50 = 100)</p><p>`        `~ последователни дни, в които харчи = 1</p><p>`        `- общо дни : 1</p><p>spend - изваждаме от парите следващото число (100 - 50 = 50)</p><p>`        `~ последователни дни, в които харчи = 2</p><p>`        `- общо дни : 2</p><p>save - добавяме към парите следващото число (50 + 100 = 150)</p><p>`        `~ последователни дни, в които харчи = 0</p><p>`        `- общо дни : 3</p><p>save - добавяме към парите следващото число (150 + 100 = 250)</p><p>`        `~ последователни дни, в които харчи = 0</p><p>`         `- общо дни : 4</p><p>Наличните пари (250) >= Пари, нужни за екскурзията (**250**)</p>|
### **Насоки**
1. Прочетете входните данни от конзолата:

  ![image](https://user-images.githubusercontent.com/67644402/141156333-18dc53c0-302d-45e2-939b-0034e73bda57.png)

1. Направете **две помощни променливи** в началото, които да следят **броя изминали дни и броя последователни дни, в които Джеси харчи пари**. Нека и двете променливи да бъдат с първоначална **стойност нула**:

  ![image](https://user-images.githubusercontent.com/67644402/141156419-e1ebdeec-86dd-4ead-b4e1-516d38410448.png)

Създайте **while** цикъл, който продължава, докато парите на Джеси са по-малко от парите, които са ѝ нужни за екскурзията и броячът за последователните дни е по-малък от 5. При **всяко повторение на цикъла** четете от конзолата **два реда** - първият ред е текст -  **spend** или **save**, а вторият – парите, които Джеси е спестила или похарчила. Също така увеличете брояча за дни с 1:![image](https://user-images.githubusercontent.com/67644402/141156451-7c89e2b5-3d3b-4dbc-8424-468543f4e57d.png)

1. Направете проверка дали Джеси **харчи или спестява** за дадения ден:
   1. aко **спестява**, прибавете спестените пари към нейните и **нулирайте брояча за поредните дни**;
   
   1. aко **харчи**, извадете от нейните пари сумата която е похарчила и **увеличете брояча за поредните дни,** в които харчи. Проверете дали парите на Джеси са станали **по-малко от нула** и ако е така, то тя е останала без пари и има нула лева
   
      
   

  ![image](https://user-images.githubusercontent.com/67644402/141156492-93f4a4e8-1b66-48f0-b826-40161dc450ab.png) 

1. След цикъла проверете дали Джеси е харчила пари в **пет последователни дни** и принтирайте съобщението. Също така проверете дали Джеси е **събрала парите** и, ако е успяла, принтирайте съответното съобщение:

  ![image](https://user-images.githubusercontent.com/67644402/141156521-ee1087d6-ba8e-4d3b-a5b5-463e7eb07ebf.png)

  ## 4. **Стъпки**
  Габи иска да започне здравословен начин на живот и си е поставила за цел да върви **10 000 стъпки всеки ден**. Някои дни обаче е много уморена от работа и ще иска да се прибере преди да постигне целта си. Напишете програма, която **чете от конзолата по колко стъпки изминава** тя всеки път като излиза през деня и **когато постигне целта си да се изписва** "**Goal reached! Good job!**"  и колко стъпки повече е извървяла "**{разликата между стъпките} steps over the goal!**".

Ако иска да се **прибере преди това**, тя ще въведе **командата** "**Going home**" и **ще въведе стъпките, които е извървяла докато се прибира**. След което, ако не е успяла да постигне целта си, на конзолата трябва да се изпише: "**{разликата между стъпките} more steps to reach goal.**"
### **Примерен вход и изход**

|**Вход**|**Изход**|**Вход**|**Изход**|
| :- | :- | :- | :- |
|<p>1000</p><p>1500</p><p>2000</p><p>6500</p><p></p>|<p>Goal reached! Good job!</p><p>1000 steps over the goal!</p>|<p>1500</p><p>300</p><p>2500</p><p>3000</p><p>Going home</p><p>200</p>|2500 more steps to reach goal.|
|**Вход**|**Изход**|**Вход**|**Изход**|
|<p>1500</p><p>3000</p><p>250</p><p>1548</p><p>2000</p><p>Going home</p><p>2000</p>|<p>Goal reached! Good job!</p><p>298 steps over the goal!</p>|<p>125</p><p>250</p><p>4000</p><p>30</p><p>2678</p><p>4682</p>|<p>Goal reached! Good job!</p><p>1765 steps over the goal!</p>|

## 5. **Монети**
Производителите на вендинг машини искали да направят машините си да връщат възможно **най-малко монети ресто**. Напишете програма, която приема **сума** - **рестото**, което трябва да се върне и изчислява **с колко най-малко монети може да стане това**.** 

### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :-: | :-: | :-: |
|1.23|4|Рестото ни е 1 лев и 23 стотинки. Машината ни го връща с 4 монети: монета от 1 лев, монета от 20 стотинки, монета от 2 стотинки и монета от 1 стотинка.|
|2|1|Рестото ни е 2 лева. Машината ни го връща с 1 монета от 2 лева.|
|0.56|3|Рестото ни е 56 стотинки. Машината ни го връща с 3 монети: монета от 50 стотинки, монета от 5 стотинки и монета от 1 стотинка.|
|2.73|5|Рестото ни е 2 лева и 73 стотинки. Машината ни го връща с 5 монети: монета от 2 лева, монета от 50 стотинки, монета от 20 стотинки, монета от 2 стотинки и монета от 1 стотинка.|

## 6. **Торта**
Поканени сте на 30-ти рожден ден, на който рожденикът черпи с огромна торта. Той обаче не знае **колко парчета могат да си вземат гостите от нея**. Вашата задача е да напишете програма, която изчислява **броя на парчетата**, които гостите са взели, преди тя да свърши. Ще получите **размерите на тортата в сантиметри** (широчина и дължина – **цели числа** в интервала [1...1000]) и след това на всеки ред, до получаване на командата "**STOP**" или **докато не свърши тортата**, броят на парчетата, които гостите вземат от нея. Парчетата са квадратни с размер  1 см .

Да се **отпечата** на конзолата **един** от следните редове:

- **"{брой парчета} pieces are left."** - ако стигнете до **STOP** и има останали парчета торта.
- **"No more cake left! You need {брой недостигащи парчета} pieces more."**
### **Примерен вход и изход**

|**Вход**|**Изход**|**Обяснения**|
| :-: | :-: | :-: |
|<p>10</p><p>10</p><p>20</p><p>20</p><p>20</p><p>20</p><p>21</p>|No more cake left! You need 1 pieces more.|<p>Тортата е с дължина **10** и широчина **10** </p><p>=> броят на парчетата = **10** \* **10** = **100** </p><p>1-во вземане -> 100 - 20 = 80</p><p>2-ро вземане -> 80 - 20 = 60</p><p>3-то вземане -> 60 - 20 = 40</p><p>4-то вземане -> 40 - 20 = 20</p><p>5-то вземане -> 20 - 21 = -1 < 0</p><p>=> не остава повече торта, 1 парче не достига</p><p></p>|
|<p>10</p><p>2</p><p>2</p><p>4</p><p>6</p><p>STOP</p>|8 pieces are left.|<p>Тортата е с дължина **10** и широчина **2**</p><p>=> броят на парчетата = **10** \* 2 = 20 </p><p>1-во вземане -> 20 - 2 = 18</p><p>2-ро вземане -> 18 - 4 = 14</p><p>3-то вземане -> 14 - 6 = 8</p><p>4-то вземане -> команда STOP</p><p>=>останали парчета: 8</p><p></p>|

## 7. **Преместване**
На осемнадесетия си рожден ден на Хосе взел решение, че ще се изнесе да живее на квартира. Опаковал багажа си в **кашони** и намерил подходяща обява за апартамент под наем. Той започва да пренася своя багаж **на части**, защото не може да пренесе целия наведнъж. Има ограничено **свободно пространство** в новото си жилище, където може да разположи вещите, така че мястото да бъде подходящо за живеене.

Напишете **програма, която изчислява свободния обем от жилището на Хосе, който остава след като пренесе багажа си.** 

**Бележка: Един кашон е с точни размери:  1m. x 1m. x 1m.**

**Вход**

Потребителят въвежда следните данни на отделни редове:

1. **Широчина на свободното пространство - цяло число в интервала [1...1000]**
1. **Дължина на свободното пространство - цяло число в интервала [1...1000]**
1. **Височина на свободното пространство - цяло число в интервала [1...1000]**
1. На следващите редове **(до получаване на команда "Done") -** **брой кашони, които се пренасят в квартирата - цяло число в интервала [1...10000]**

**Програмата трябва да приключи прочитането на данни при команда "Done"** **или ако свободното място свърши.**

**Изход**

Да се **отпечата** на конзолата **един** от следните редове:

- Ако стигнете до командата **"Done"** и има още свободно място:

**"{брой свободни куб. метри} Cubic meters left."**

- Ако свободното място свърши преди да е дошла команда **"Done":**

**"No more free space! You need {брой недостигащи куб. метри} Cubic meters more."**

**Примерен вход и изход**

|**Вход**|**Изход**|**Обяснение**|
| :- | :-: | :-: |
|<p>10</p><p>10</p><p>2</p><p>20</p><p>20</p><p>20</p><p>20</p><p>122</p>|No more free space! You need 2 Cubic meters more.|<p>10 \* 10 \* 2 = 200 кубични метра налични<br>20 + 20 + 20 + 20 + 122 = 202 кубични метра<br>200 - 202 = 2 недостигащи кубични метра</p><p></p>|
|<p>10</p><p>1</p><p>2</p><p>4</p><p>6</p><p>**Done**</p>|10 Cubic meters left.|<p>10 \* 1 \* 2 = 20 кубични метра налични<br>4 + 6 = 10 кубични метра<br>20 - 10 = 10 кубични метра</p><p></p>|

