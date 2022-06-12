
# **Exercises: JSON Processing**
This document defines the exercise assignments for the ["Spring Data" course @ SoftUni](https://softuni.bg/courses/spring-data).
## 1. **Products Shop**	
A products shop holds **users**, **products** and **categories** **for the products**. Users can **sell** and **buy** products.

- Users have an **id**, **first** **name** (optional) and **last** **name** (at least 3 characters) and **age** (optional).
- Products have an **id**, **name** (at least 3 characters), **price**, **buyerId** (optional) and **sellerId** as IDs of users.
- Categories have an **id** and **name** (from **3** to **15** characters)

Using Code First approach create a database following the above description.

![image](https://user-images.githubusercontent.com/67644402/173225915-73fbae55-9cbe-4164-adf9-3a3170660074.png)

Configure the following relations in your models:

- **Users** should have **many products sold** and **many products bought**. 
- **Products** should have **many categories**.
- **Categories** should have **many products**.
- **Users** should have **many friends** (i.e. users).
## 2. **Seed the Database**
**Import** the data from the provided files (**users.json**, **products.json**, **categories.json**).

Import the **users** first. When importing the products, randomly **select the buyer** and **seller** from the existing users. Leave out some **products** that have **not been sold** (i.e. buyer is null).

Randomly **generate categories** for each product from the existing categories.
## 3. **Query and Export Data**
Write the below described queries and **export** the returned data to the specified **format**. 

**Query 1 – Products in Range**

Get all products in a specified **price range** (e.g. 500 to 1000), which have **no buyer**. Order them by price (from lowest to highest). Select only the **product name**, **price** and the **full name** **of the seller**. Export the result to JSON.

|**products-in-range.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"name": "TRAMADOL HYDROCHLORIDE",</p><p>`    `"price": 516.48,</p><p>`    `"seller": "Christine Gomez"</p><p>`  `},</p><p>`  `{</p><p>`    `"name": "Allopurinol",</p><p>`    `"price": 518.50,</p><p>`    `"seller": "Kathy Gilbert"</p><p>`  `},</p><p>`  `{</p><p>`    `"name": "Parsley",</p><p>`    `"price": 519.06,</p><p>`    `"seller": "Jacqueline Perez"</p><p>`  `},</p><p>`  `...</p><p>]</p>|
**Query 2 – Successfully Sold Products**

Get all users who have **at least 1 item sold** with a **buyer**. Order them by **last name**, then by **first name**. Select the person's **first** and **last name**. For each of the **products** **sold** (products with buyers), select the product's **name**, **price** and the buyer's **first** and **last name**. 

|**users-sold-products.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"firstName": "Carl",</p><p>`    `"lastName": "Daniels",</p><p>`    `"soldProducts": [</p><p>`      `{</p><p>`        `"name": "Peter Island Continous sunscreen kids",</p><p>`        `"price": 471.30,</p><p>`        `"buyerFirstName": "Anna",</p><p>`        `"buyerLastName": "Parker"</p><p>`      `},</p><p>`      `{</p><p>`        `"name": "Warfarin Sodium",</p><p>`        `"price": 1379.79,</p><p>`        `"buyerFirstName": "Brandon",</p><p>`        `"buyerLastName": "Fuller"</p><p>`      `}</p><p>`    `]</p><p>`  `},</p><p>`  `...</p><p>]</p>|
**Query 3 – Categories by Products Count**

Get **all** **categories**. Order them by the **number of products** in each category (a product can be in many categories). For each category select its **name**, the **number of products**, the **average price of those products** and the **total revenue** (total price sum) of those products (regardless if they have a buyer or not).

|**categories-by-products.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"category": "Sports",</p><p>`    `"productsCount": 49,</p><p>`    `"averagePrice": 754.327755,</p><p>`    `"totalRevenue": 36962.06</p><p>`  `},</p><p>`  `{</p><p>`    `"category": "Adult",</p><p>`    `"productsCount": 46,</p><p>`    `"averagePrice": 905.283478,</p><p>`    `"totalRevenue": 41643.04</p><p>`  `},</p><p>`  `...</p><p>]</p>|
**Query 4 – Users and Products**

Get all users who have **at least 1 product sold**. Order them by the **number of products sold** (from highest to lowest), then by **last name** (ascending). Select only their **first** and **last name**, **age** and for each product - **name** and **price**.

Export the results to **JSON**. Follow the format below to better understand how to structure your data.  

|**users-and-products.json**|
| :-: |
|<p>{</p><p>"usersCount":35,</p><p>"users": </p><p>[</p><p>`	`{</p><p>`		`"firstName":"Carl",</p><p>`		`"lastName":"Daniels",</p><p>`		`"age":59,</p><p>`		`"soldProducts": </p><p>`		`{</p><p>`			`"count":10,</p><p>`			`"products":</p><p>`			`[</p><p>`			`{</p><p>`				`"name":"Finasteride",</p><p>`				`"price":1374.01</p><p>`			`},</p><p>`			`{</p><p>`				`"name":"Peter Island Continous sunscreen kids",</p><p>`				`"price":471.30</p><p>`			`},</p><p>`			`{</p><p>`				`"name":"Warfarin Sodium",</p><p>`				`"price":1379.79</p><p>`			`},</p><p>`			`{</p><p>`				`"name":"Gilotrif",</p><p>`				`"price":1454.77</p><p>`			`},</p><p>`			`{</p><p>`				`"name":"Cold and Cough",</p><p>`				`"price":218.14</p><p>`			`},</p><p>`			`...</p><p>`			`]</p><p>`		`}</p><p>`	`},</p><p>`	`{</p><p>`		`"firstName": null,</p><p>`		`"lastName": "Harris",</p><p>`		`"age": 0,</p><p>`		`"soldProducts": </p><p>`		`{</p><p>`			`"count":9,</p><p>`			`"products":</p><p>`			`[</p><p>`			`{</p><p>`				`"name":"Clarins Paris Skin Illusion – 114 cappuccino",</p><p>`				`"price":811.42</p><p>`			`},</p><p>`			`...</p><p>`			`]</p><p>`		`}</p><p>`	`},</p><p>`	`...</p><p>]</p><p>}</p>|
## 4. **Car Dealer**
A car dealer needs information about cars, their parts, parts suppliers, customers and sales. 

- **Cars** have **make, model**, **and travelled distance** in kilometers.
- **Parts** have **name**, **price** and **quantity**.
- Part **supplier** have **name** and info whether he **uses imported parts**.
- **Customer** has **name**, **date of birth** and info whether he/she **is a young driver** (Young driver is a driver that has **less than 2 years of experience**. Those customers get **additional 5% off** for the sale.).
- **Sale** has **car**, **customer** and **discount percentage**.

A **price of a car** is formed by the **total price of its parts**.

Using Code First approach create a database following the above description.

![image](https://user-images.githubusercontent.com/67644402/173225973-e00ccc68-90b0-48a0-b7bf-90db7b9c8233.png)

Configure the following relations in your models:

- A **car** has **many parts** and **one part** can be placed **in many cars**
- **One supplier** can supply **many parts** and each **part** can be delivered by **only one supplier**
- In **one sale**, only **one car** can be sold
- **Each sale** has **one customer** and **a customer** can buy **many cars**
## 5. **Car Dealer Import Data**
Import data from the provided files (**suppliers.json, parts.json, cars.json, customers.json**).

First import the **suppliers**. When importing the **parts**, set to each part a **random supplier** from the already imported suppliers. Then, when importing the cars add **between 3 and 5 random parts** to each car. Then import **all customers**. Finally, import the **sales records** by **randomly** selecting a **car, customer** and the amount of **discount to be applied** (discounts can be 0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).
## 6. **Car Dealer Query and Export Data**
Write the below described queries and **export** the returned data to the specified **format**. 

#### **Query 1 – Ordered Customers**
Get all **customers**, ordered by their **birthdate in ascending order**. If two customers are born on the same date, **first print those, who are not young drivers** (e.g. print experienced drivers first). **Export** the list of customers **to JSON** in the format provided below.



|**ordered-customers.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"Id": 29,</p><p>`    `"Name": "Louann Holzworth",</p><p>`    `"BirthDate": " 1960-10-01T00:00:00",</p><p>`    `"IsYoungDriver": false,</p><p>`    `"Sales": [],</p><p>`  `},</p><p>`  `{</p><p>`    `"Id": 28,</p><p>`    `"Name": "Donnetta Soliz",</p><p>`    `"BirthDate": " 1963-10-01T00:00:00",</p><p>`    `"IsYoungDriver": true,</p><p>`    `"Sales": [],</p><p>`  `},</p><p>`  `...</p><p>]</p>|
**Query 2 – Cars from Make Toyota**

Get all **cars** from make **Toyota** and **order them by model alphabetically** and then by **travelled distance descending**. **Export** the list of **cars to JSON** in the format provided below.

|**toyota-cars.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"Id": 117,</p><p>`    `"Make": "Toyota",</p><p>`    `"Model": "Camry Hybrid",</p><p>`    `"TravelledDistance": 954775807,</p><p>`  `},</p><p>`  `{</p><p>`    `"Id": 112,</p><p>`    `"Make": "Toyota",</p><p>`    `"Model": "Camry Hybrid",</p><p>`    `"TravelledDistance": 92275807,</p><p>`  `},</p><p>...</p><p>]</p>|
#### **Query 3 – Local Suppliers**
Get all **suppliers** that **do not import parts from abroad**. Get their **id**, **name** and the **number of parts** they can offer to supply. Export the list of suppliers to JSON in the format provided below.

|**local-suppliers.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"Id": 2,</p><p>`    `"Name": "Agway Inc.",</p><p>`    `"partsCount": 6</p><p>`  `},</p><p>`  `{</p><p>`    `"Id": 4,</p><p>`    `"Name": "Airgas, Inc.",</p><p>`    `"partsCount": 5</p><p>`  `},</p><p>`  `...</p><p>]</p>|
#### **Query 4 – Cars with Their List of Parts**
Get all **cars along with their list of parts**. For the **car** get only **make, model** and **travelled distance**. For the **parts** get only the **name** and the **price**. **Export** the list of **cars and their parts to JSON** in the format provided below.

|**cars-and-parts.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"car": {</p><p>`      `"Make": "Opel",</p><p>`      `"Model": "Omega",</p><p>`      `"TravelledDistance": 2147483647,</p><p>`    `},</p><p>`    `"parts": [</p><p>`      `{</p><p>`        `"Name": "Front Left Side Outer door handle",</p><p>`        `"Price": 999.99</p><p>`      `},</p><p>`      `{</p><p>`        `"Name": "Gudgeon pin",</p><p>`        `"Price": 44.99</p><p>`      `},</p><p>`      `{</p><p>`        `"Name": "Oil pump",</p><p>`        `"Price": 100.19</p><p>`      `},</p><p>`      `{</p><p>`        `"Name": "Transmission pan",</p><p>`        `"Price": 106.99</p><p>`      `}</p><p>`    `]</p><p>`  `},</p><p>`  `{</p><p>`    `"car": {</p><p>`      `"Make": "Opel",</p><p>`      `"Model": "Astra",</p><p>`      `"TravelledDistance": 9223372036854775807</p><p>`    `},</p><p>`    `"parts": [</p><p>`      `{</p><p>`        `"Name": "Overflow tank",</p><p>`        `"Price": 1200.99</p><p>`      `},</p><p>`      `...</p><p>`    `]</p><p>`  `},</p><p>...</p><p>]</p>|
#### **Query 5 – Total Sales by Customer**
Get all **customers** that have bought **at least 1 car** and get their **names**, **count of cars bought** and **total money spent** on cars. **Order** the result list **by total money spent in descending order** then by **total cars** **bought** again in **descending** order. Export the list of customers to JSON in the format provided below.

|**customers-total-sales.json**|
| :-: |
|<p>[</p><p>`  `{</p><p>`    `"fullName": "Hipolito Lamoreaux",</p><p>`    `"boughtCars": 5,</p><p>`    `"spentMoney": 8360.48</p><p>`  `},</p><p>`  `{</p><p>`    `"fullName": "Francis Mckim",</p><p>`    `"boughtCars": 4,</p><p>`    `"spentMoney": 7115.50</p><p>`  `},</p><p>`  `{</p><p>`    `"fullName": "Johnette Derryberry",</p><p>`    `"boughtCars": 4,</p><p>`    `"spentMoney": 5337.72</p><p>`  `},</p><p>...</p><p>]</p>|
#### **Query 6 – Sales with Applied Discount**
Get all **sales** with information about the **car**, the **customer** and the **price** of the sale **with and without discount**. Export the list of sales to JSON in the format provided below.

|**sales-discounts.json**|
| :-: |
|<p>` `[</p><p>`  `{</p><p>`    `"car": {</p><p>`      `"Make": "Peugeot",</p><p>`      `"Model": "405",</p><p>`      `"TravelledDistance": 92036854775807</p><p>`    `},</p><p>`    `"customerName": "Donnetta Soliz",</p><p>`    `"Discount": 0.3,</p><p>`    `"price": 1402.53,</p><p>`    `"priceWithDiscount": 981.771</p><p>`  `},</p><p>`  `{</p><p>`    `"car": {</p><p>`      `"Make": "Mercedes",</p><p>`      `"Model": "W124",</p><p>`      `"TravelledDistance": 2147647</p><p>`    `},</p><p>`    `"customerName": "Carri Knapik",</p><p>`    `"Discount": 0.2,</p><p>`    `"price": 254.96999999999997,</p><p>`    `"priceWithDiscount": 203.97599999999997</p><p>`  `},</p><p>`  `...</p><p>]</p>|



Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
