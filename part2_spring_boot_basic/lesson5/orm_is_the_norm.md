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

The data types of these class attributes correspond to the data types of the SQL columns. Some Java types can be mapped to many different SQL types, and some SQL types can be mapped to multiple Java types, but in this case the type mappings are obvious. For a full list of the MyBatis type mapping, consult the MyBatis 3 TypeHandlers list.

Once you have defined your data types, MyBatis can automatically map Java objects to SQL statements.
![image](https://user-images.githubusercontent.com/77028341/221786622-dd2a3cba-ee71-46b7-81e3-7707fdb397b5.png)
ORM Process Visualization

The diagram above shows the ORM Process Visualization, displaying how createUser(user) is converted into SQL that inserts a row in a table, and getUserByName(name) is converted into SQL that returns a result which becomes a Java object.

## Key Terms
* ORM: Object-Relational Mapping. A general term describing a set of technology that can be used to automatically convert data between database representation and application representation.
* Mapping: Drawing a relationship between a field in a Java class and a column in a SQL table.
* One to One: A relationship between two objects in which one entity is on each side of the relationship.
* Many to Many: A relationship between two objects in which multiple copies of each entity can be related to multiple copies of the other entity.
