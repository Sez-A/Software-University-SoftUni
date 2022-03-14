
**Design Patterns – Lab**

Lab problems for the ["Java Advanced" course @ Software University](https://softuni.bg/modules/59/java-advanced/1179).
## **1. Singleton**
We are going to create a simple program to demonstrate what Singleton is used for. So, to start off, let’s create a single interface:

![image](https://user-images.githubusercontent.com/67644402/158206467-7fd64a49-8cfe-4c24-b040-b16ccf2589c1.png)

After that, we have to create a class to implement the SingletonContainer interface. We are going to call it SingletonDataContainer:

![image](https://user-images.githubusercontent.com/67644402/158206509-c939187f-f67d-4b25-ad69-1a742f24bbd9.png)

So, we have a Map in which we store the capital names and their population. As we can see, in our constructor we are initializing it. And that is all good. Now we are ready to use this class in any consumer by simply instantiating it. But is this really what we need to do, to instantiate the class which uses data which never changes (in this particular project. Population of the cities is changing daily). Of course not, so obviously using a Singleton pattern would be very useful here. Let’s implement it:

After we hid the constructor from the consumer classes by making it private, we will need to create a single instance of our class and exposed it like this:

![image](https://user-images.githubusercontent.com/67644402/158206541-3080b031-ed67-452d-a42e-bfc5a3ee01bd.png)

At this point, we can call the Instance property as many times as we want, but our object is going to be instantiated only once and shared for every other call. 

Let’s check if our program works:

![image](https://user-images.githubusercontent.com/67644402/158206575-2a725d22-94bd-47c5-8f1a-59d332ce7679.png)

The expected output should be something like this:

![image](https://user-images.githubusercontent.com/67644402/158206616-40facf9c-c43b-43f4-9379-68dc3abaac45.png)
2. ## **Façade**
Now we will take a look at a Façade example implementation.

We will start off by creating a class to work with:

![image](https://user-images.githubusercontent.com/67644402/158206659-48755ed2-f299-431a-b869-a9d3a8264250.png)

We have the info part and the address part of our object, so we are going to use two builders to create this whole object.

We need a façade, let’s create one:

![image](https://user-images.githubusercontent.com/67644402/158206692-2b775d56-808f-4308-86d9-c6bd65768558.png)

We instantiate the **Car** object, which we want to build and expose it through the Build method.

What we need now is to create concrete builders. So, let’s start with the **CarInfoBuilder** which needs to inherit from the facade class:

![image](https://user-images.githubusercontent.com/67644402/158206732-b684aba9-79c9-4103-be81-5796cf175c40.png)

We receive, through the constructor, an object we want to build and use the fluent interface for building purpose.

Let’s do the same for the **CarAddresBuilder** class:

![image](https://user-images.githubusercontent.com/67644402/158206773-59c5afc7-c891-468b-bdc3-75cd2e009c64.png)

At this moment we have both builder classes, but we can’t start building our object yet because we haven’t exposed our builders inside the facade class. Well, let’s do that:

![image](https://user-images.githubusercontent.com/67644402/158206814-d4544579-bf9a-4cba-b550-aeb010217079.png)

That’s it, we can start building our object:

![image](https://user-images.githubusercontent.com/67644402/158206853-d4f95734-e750-45aa-bd5b-b6c048e59ed4.png)

And the output should be:

![image](https://user-images.githubusercontent.com/67644402/158206889-1a9b08c0-0d3e-471c-8f54-df3b6953d2d3.png)
2. ## **Façade 2**
Here is another example about the Façade Pattern.

<https://howtodoinjava.com/design-patterns/structural/facade-design-pattern/>
2. ## **Command Pattern**
The Command design pattern consists of the Invoker class, Command class/interface, Concrete command classes and the Receiver class.  Having that in mind, in our example, we are going to follow the same design structure.

So, what we are going to do is write a simple app in which we are going to modify the price of the product that will implement the Command design pattern.

That being said, let’s start with the **Product** receiver class, which should contain the base business logic in our app:

![image](https://user-images.githubusercontent.com/67644402/158206938-e4566f81-ff3a-4ee9-9931-7b84ff8ebfa7.png)

Now the Client class can instantiate the **Product** class and execute the required actions. But the Command design pattern states that we shouldn’t use receiver classes directly. Instead, we should extract all the request details into a special class - Command. Let’s do that.

The first thing we are going to do is to add the **Command** interface:

![image](https://user-images.githubusercontent.com/67644402/158206973-7da99dc1-dca4-4a62-874b-b6b4a32b8c38.png)

Finally, let’s add the **DecreaseProductPriceCommand** and **IncreaseProductPriceCommand** class:

![image](https://user-images.githubusercontent.com/67644402/158207008-588c0781-6a5c-4270-9783-0e0968703c4a.png)

![image](https://user-images.githubusercontent.com/67644402/158207040-065d1be0-6e24-4049-96a8-dc4a92711699.png)

To continue on, let’s add the **ModifyPrice** class, which will act as Invoker:

![image](https://user-images.githubusercontent.com/67644402/158207073-2a0ae8d8-800a-4ec0-9e77-bddbf02e4582.png)

This class can work with any command that implements the **Command** interface and store all the operations as well.

Now, we can start working with the client part:

![image](https://user-images.githubusercontent.com/67644402/158207103-68d361d0-f449-4350-b0b4-6f1fc5bfae80.png)

The output should be like this:

![image](https://user-images.githubusercontent.com/67644402/158207154-e227073c-56c4-405d-9889-434d5b1fe410.png)



Follow us:

© SoftUni – <https://softuni.org>. Copyrighted document. Unauthorized copy, reproduction or use is not permitted.
