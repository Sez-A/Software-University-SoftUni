# **Lab: Iterators and Comparators**

This document defines the lab for [“Java Advanced” course @ Software University](https://softuni.bg/modules/59/java-advanced). Please submit your 
solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1542/Iterators-and-Comparators-Lab).

## 1. **Book**

Create a class **Book** from **UML diagram** below:

|                           **Book**                           |
| :----------------------------------------------------------: |
|                              -                               |
|                              -                               |
|                              -                               |
|                              -                               |
|                              -                               |
|                              -                               |
|                              +                               |
|                              +                               |
|                              +                               |
| You can use only **one constructor**. There **can be no authors**, **one author,** or **many authors**. |

### **Examples**



|                        **Main.java**                         |
| :----------------------------------------------------------: |
| <p>**public static void** main(String[] args) {</p><p>Book bookOne = **new** Book(**"Animal Farm"**, 2003, **"George Orwell"**);</p><p>Book bookThree = **new** Book(**"The Documents in the Case"**, 2002);</p><p>Book bookTwo = **new** Book(**"The Documents in the Case"**, 1930, **"Dorothy Sayers"**, **"Robert Eustace"**);</p><p>List<Book> books = **new** ArrayList<>();<br>books.add(bookOne);<br>books.add(bookTwo);<br>books.add(bookThree); </p><p>}</p> |

### **Solution**



## 2. **Library**

Create a class **Library** from **UML diagram** below:

|       <p>**<<Iterable<Book>>>**</p><p>**Library**</p>        |
| :----------------------------------------------------------: |
|                              -                               |
|                              +                               |
| Create a **nested class** **LibIterator** from **UML diagram** below: |

| <p>**<<Iterator<Book>>>**</p><p>**LibIterator**</p> |
| :-------------------------------------------------: |
|                          -                          |
|                          +                          |
|                          +                          |
|                  ### **Examples**                   |

|                        **Main.java**                         |
| :----------------------------------------------------------: |
| <p>**public static void** main(String[] args) {<br>Book bookOne = **new** Book(**"Animal Farm"**, 2003, **"George Orwell"**);</p><p>Book bookThree = **new** Book(**"The Documents in the Case"**, 2002);<br>Book bookTwo = **new** Book(**"The Documents in the Case"**, 1930, **"Dorothy Sayers"**, **"Robert Eustace"**);<br><br>Library library = **new** Library<>(bookOne, bookTwo, boоkThree);<br><br>**for** (Book book: library) {<br>`	`System.***out***.println(book.getTitle());<br>}</p><p>}</p> |
|                                                              |

### **Solution**



## 3. **Comparable Book**

Expand Book by implementing **Comparable<Book>.**

The book has to be **compared by title**. When the title is equal, **compare** them by **year.**

Expand **Book** from **UML diagram** below:

|        <p>**<<Comparable<Book>>>**</p><p>**Book**</p>        |
| :----------------------------------------------------------: |
|                              -                               |
|                              -                               |
|                              -                               |
|                              -                               |
|                              -                               |
|                              -                               |
|                              +                               |
|                              +                               |
|                              +                               |
|                              +                               |
| You can use only **one constructor**. There **can be no authors**, **one author,** or **many authors**. |


### **Examples**

|                        **Main.java**                         |
| :----------------------------------------------------------: |
| <p>**public static void** main(String[] args) {<br>Book bookOne = **new** Book(**"Animal Farm"**, 2003, **"George Orwell"**);<br>Book bookThree = **new** Book(**"The Documents in the Case"**, 2002);<br>Book bookTwo = **new** Book(**"The Documents in the Case"**, 1930, **"Dorothy Sayers"**, **"Robert Eustace"**);<br><br>**if** (bookOne.compareTo(bookTwo) > 0) {<br>`	`System.***out***.println(String.*format*(**"%s is before %s"**, bookOne, bookTwo));<br>} **else if** (bookOne.compareTo(bookTwo) < 0) {<br>`	`System.***out***.println(String.*format*(**"%s is before %s"**, bookTwo, bookOne));<br>} **else** {<br>`	`System.***out***.println(**"Book are equal"**);<br>}</p><p>}</p> |

## 4. **Book Comparator**

Create a class **BookComparator** from **UML diagram** below: 

| <p>**<<Comparator<Book>>>**</p><p>**BookComparator**</p> |
| :------------------------------------------------------: |
|                            +                             |
|   **BookComparator** has to **compare** two books by:    |

1. Book title.
1. Year of publishing a book.

### **Examples**

|                        **Main.java**                         |
| :----------------------------------------------------------: |
| <p>**public static void** main(String[] args) {<br>Book bookOne = **new** Book(**"Animal Farm"**, 2003, **"George Orwell"**);<br>Book bookThree = **new** Book(**"The Documents in the Case"**, 2002);<br>Book bookTwo = **new** Book(**"The Documents in the Case"**, 1930, **"Dorothy Sayers"**, **"Robert Eustace"**);<br><br>List<Book> books = **new** ArrayList<>();<br>books.add(bookOne);<br>books.add(bookTwo);<br>books.add(bookThree);<br><br>books.sort(**new** BookComparator());<br><br>**for** (Book : books) {<br>`	`System.***out***.println(book.getTitle() + book.getYear());<br>}</p><p>}</p> |
