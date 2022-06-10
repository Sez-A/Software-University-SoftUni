
# **Lab: Spring Data – Account System**
This document defines the lab assignments for the ["Spring Data" course @ Software University](https://softuni.bg/trainings/3352/spring-data-june-2021).

Your task is to create a simple account system that has users with accounts and manages money transfer or withdrawal. Build the system using code-first and Spring Data. The goal is to implement services and repositories.
## 1. **Project Setup**
Create new Spring project: 

![image](https://user-images.githubusercontent.com/67644402/173038551-c096814a-b166-4e01-b3fc-5150d0b385ea.png)

Add name and version:

Add Spring Data JPA:

![image](https://user-images.githubusercontent.com/67644402/173038605-1fb35fce-02e6-417f-8901-14d168ac94cd.png)

In the resources folder, add new **applications.properties** file, which will hold the Spring configuration of the project:

![image](https://user-images.githubusercontent.com/67644402/173038636-bc4d8d7f-b5bf-45a0-a51d-5f436ee2b343.png)


Start splitting the java directory into packages. Create several ones to help you organize your project:

- **models** – the directory of our database models(entities)
- **repositories** – the package where we will hold the repository interfaces
- **services** – where our service interfaces and implementations will be stored
## 2. **Database Models**
Start by setting up the database models. Each one of them will be as follows:

- **User**
- **Id** – long value**, primary key**
- **Username** – **unique** for each user
- **Age** – integer value
- **Accounts** – each user can have **many accounts**, which will be **identified by their id**
- **Account** 
- **Id** – long value, **primary key**
- **Balance** – BigDecimal
- **User** – an account can be owned by a **single user**

Set up appropriate tables, columns, column properties and table relations.
## 3. **Repositories**
Spring Data reduces the amount of boiler-plate code by using a central interface **Repository**. 
The **JpaRepository** interface contains methods like:

- **save(E entity)** 
- **findOne(Id primaryKey)** 
- **findAll()** 
- **count()** 
- **delete(E** **entity)** 
- **exists(Id primaryKey)** 

You can define a **custom repository**, which extends the **JpaRepository** and defines several methods for operating with data besides those exposed by the greater interface. The query builder mechanism of Spring Data requires following several rules when you define custom methods. Query creation is done by parsing method names by prefixes like **find…By**, **read…By**, **query…By**, **count…By**, and **get…By**. You can add more criteria by concatenating **And** and **Or** or apply ordering with **OrderBy** with sorting direction **Asc** or **Desc**.

Create two Repository interfaces – **UserRepository** and **AccountRepository**. 

![image](https://user-images.githubusercontent.com/67644402/173038729-f3d551ed-ca38-446b-a902-992766e831a9.png)

![image](https://user-images.githubusercontent.com/67644402/173038782-2d3b7114-763a-4250-a2fb-b5a7a9db9303.png)

Add several methods to help you look up the data source, for example **getByUsername(String username)** in the **UserRepository** interface.
## 4. **Services**
In bigger applications mixing business logic and crud operations to the database is not wanted. Having a repository objects is implementing the **Domain Driven Design**. Repositories are classes responsible **only for write/transactional operations** towards the data source. Any business logic like validation, calculations and so on is implemented by **a Service Layer**. One of the most important concepts to keep in mind is that a **service** should **never expose details of the internal processes,** or the business entities used within the application. 

Define several service **interfaces**:

![image](https://user-images.githubusercontent.com/67644402/173039030-06b65be4-32c0-4c60-927b-4ebf4796b2d2.png)

![image](https://user-images.githubusercontent.com/67644402/173039072-bcb590da-dddd-48ce-88f1-81abb170cae9.png)

Implement those services with classes **AccountServiceImpl** and **UserServiceImpl**. Those classes will do the business logic of the application. To do that, they should have certain type of **Repository** available – **AccountRepository** or **UserRepository** according to the service type.

![image](https://user-images.githubusercontent.com/67644402/173039119-804aa8ba-1f7f-4034-b03a-3f2e2fac2b86.png)

![image](https://user-images.githubusercontent.com/67644402/173039164-d13d8fd2-92c5-427b-9133-1752b1396e30.png)

In Spring Data Framework, the usage of **@Service**, **@Repository** or **@Component** annotations is needed to separate different “**layers**” in the application. They are mainly used for programmers to know a class’s role and which logical layer it belongs to.

The **@Autowired** annotation is required when **injecting a resource**, e.g., **Repository** to **Service**.

The implementation of the methods is up to you. Here are some several tips:

- **AccountServiceImpl**
  - Money withdrawal – should only happen if account **is present** in the database, **belongs to user** and **has enough balance**
  - Money transfer – should only happen if **account belongs to user** and transfer value **is not negative**
- **UserServiceImpl**
  - User registration – should only happen if user does not exist in the database
## 5. **ConsoleRunner and Application**
We will test our application in a ConsoleRunner class. Create such and inject needed repositories:

![image](https://user-images.githubusercontent.com/67644402/173039211-d665e7fe-7222-4ef5-a6f4-7585c80627cf.png)

## 6. **Test**
Test the application by adding some logic in the **ConsoleRunner** class’s method **run**:

![image](https://user-images.githubusercontent.com/67644402/173039258-39144f70-3ac9-4ca4-bd70-0ec1d1131697.png)

If you have written everything correctly, an **account\_system** database should be created with tables:

- **users**
- **accounts**
- **users\_accounts** 
Follow us:

© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
