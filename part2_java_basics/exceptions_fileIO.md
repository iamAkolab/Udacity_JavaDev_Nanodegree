# Exception
Exception is a problem that arises during run-time. Let’s try the following example in code.

10 / 0
List<Integer> lst = null; int size = lst.size();
String s = "FOOBAR"; int i = Integer.parseInt(s);
Int[] a = {1, 2, 3}; System.out.println(a[3]);
  
If there is no exception handling mechanism, when exception happens, the system basically crash.
  
## Exception keywords:
  
<p align="center">
  <img src="https://github.com/iamAkolab/udacity_javadev_nanodegree/blob/main/part2_java_basics/ExceptionsKeywords.png" title="Big O Notation">
</p>
  
public class JavaExceptionExample{  
  public static void main(String args[]){  
   try{  
      //code that may raise exception  
      int data=100/0;  
   }catch(ArithmeticException e){System.out.println(e);}  
   //rest code of the program   
   System.out.println("rest of the code...");  
  }  
}
  
# File IO
Here we are going to cover Java.IO. Java IO is an API that comes with Java to read and write data. Most of the applications today support IO, for instance, ask user to upload a data feed, ask user to upload a photo, generate a PDF after user complete the form, grade students’ online exam and send the report as email.

IO Stream is like an endless flow of data. You can either read from a stream or write to a stream. A stream is connected to a data source or a data destination. Streams in Java IO can be either byte (reading and writing bytes) based or character based (reading and writing characters).

The File class in the Java IO API gives you access to the underlying file system. Using the File class you can:

* Check if a file or directory exists.
* Create a directory if it does not exist.
* Read the length of a file.
* Rename or move a file.
* Delete a file.
* Check if path is file or directory.
* Read list of files in a directory.
  
## Resources:
* Stream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
* File api: https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html


