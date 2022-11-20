# Java Basic
Java math, date, string and character are really basic yet useful java APIs.



## Resources:
* Math: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
* Date: https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
* String: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
* Character: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html

# Java Basics
Different than String, StringBuilder and StringBuffer are mutable. Both classes create a mutable sequence of characters. And they are very much similar to each other.

However the StringBuilder provides no guarantee of synchronization whereas the StringBuffer class does. And Regex, aka, regular expression, is used to match or filter out Strings

StringBuilder sb = new StringBuilder("Good Morning");
sb.insert(1, "Friend ");
System.out.println(sb.toString()); 

^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$
An email address regex

## Resources:
* StringBuilder: https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
* StringBuffer: https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html
* Regex: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
