
# **Lab: Hibernate Code First** 

This document defines the lab assignments for the ["Spring Data" course at Software University](https://softuni.bg/trainings/3015/spring-data-october-2020).

# **1. Vehicle Hierarchy**
Your task is to **create a Vehicle hierarchy**. 
### **Vehicle - Abstract Class**
- Has an **Id – Long**
- Has a **Type - String**
- Has a **Model - String**
- Has a **Price - BigDecimal**
- Has a **fuelType - String**

### **Car**
Extends from the **Vehicle** class

- Has **Seats - Integer**

### **Truck**
Extends from the **Vehicle** class

- Has **loadCapacity - Double**

### **Bike**
Extends from the **Vehicle** class
### **Plane**
Extends from the **Vehicle** class

- Has **passengerCapacity** - **Integer**

Use the appropriate **inheritance types** to reach **the diagrams** in the examples. 

![image](https://user-images.githubusercontent.com/67644402/172388339-14df759e-92c6-492d-99b4-ec49b1745734.png)


![image](https://user-images.githubusercontent.com/67644402/172388379-4b0b413a-1d41-40db-a019-b75fc65f3c13.png)


![image](https://user-images.githubusercontent.com/67644402/172388427-1d4776f3-c660-45c7-a2d8-9b171afdf37d.png)
# **2. Relations**
### **Plate\_number**
- Has an **id** - **BigInteger**
- Has a **number - String**
- Has a **one to one** relations with **Cars**

![image](https://user-images.githubusercontent.com/67644402/172388484-3c1e5cd9-1e5b-4e53-b1b2-fc1432d8356f.png)

### **Companies**
- Has an **id** - **BigInteger**
- Has a **name - String**
- Has a **one to many** relations with **Planes**

![image](https://user-images.githubusercontent.com/67644402/172388534-372e7485-56eb-4dda-8bf3-ffb51b73d65e.png)



### **Drivers**
- Has an **id** - **BigInteger**
- Has a **full\_name - String**
- Has a **many to many** relations with **Cars**

![image](https://user-images.githubusercontent.com/67644402/172388591-e0405d4f-8e21-433c-809e-d61c0ef712a9.png)


** 
© SoftUni – [about.softuni.bg](https://about.softuni.bg/). Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
