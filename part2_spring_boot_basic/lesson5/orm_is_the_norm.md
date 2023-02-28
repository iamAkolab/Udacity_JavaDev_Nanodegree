# ORM is the Norm
The first step in using ORM is to define the data model. Consider the relationship between the following tables:
* user - A table containing the user ID, username, and password for each user.
* user_cart - We are assuming, any user can have one cart at max. The cart would have multiple items (inventory). This table stores the user ID, inventory ID, and the quantity of inventory the user wants to purchase. In this table, the user ID, and inventory ID are the foreign keys respectively. Together, the combination of the user ID and inventory ID can act as a primary key.
* inventory - It stores the inventory ID, name, and unit price of each inventory.

We can represent their relationship in SQL with this image below.
![image](https://user-images.githubusercontent.com/77028341/221786330-54fda033-c9e3-4632-bd76-19bf9ef1d6df.png)
Imaage shows Relationship Between SQL Tables - Image showing the relationship between the user, user_cart, and inventory tables in SQL

A primary feature of ORM is that this type of relationship should have a natural mapping to Java classes. We can represent this same data in Java using a simple class diagram.
![image](https://user-images.githubusercontent.com/77028341/221786459-b45a33b2-a1dc-418d-8abb-889d9689c6dc.png)
Class Diagram Corresponding to SQL Tables - The class diagram shows that the columns of the SQL diagram becomes fields of the Java objects User, CartItem, and InventoryItem
