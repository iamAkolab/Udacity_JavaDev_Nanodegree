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

# Stream
Stream is like an endless flow of data. You can either read from a stream or write to a stream. A stream is connected to a data source or a data destination. Streams in Java IO can be either byte (reading and writing bytes) based or character based (reading and writing characters).

A program that needs to read data from some source needs an InputStream or a Reader. A program that need to write data to some destination needs an OutputStream or a Writer. Can show a graph like

[source] -> [input stream/reader] -> [program]

[program] -> [output stream/writer] -> [destination]

FileInputStream and FileOutputStream are common input and output stream classes. FileReader and FileWriter are common reader and writer classes.
We are going to be digging more in the next few videos
  
# FileInputStream
FileInputStream obtains input bytes from a file. It’s used for reading byte-oriented data such as image data, audio, videos. You can also read character-stream data. But, it’s recommended to use FileReader class to read character stream data.

Java FileOutputStream is an output stream used for writing data to a file. If you have to write primitive values into a file, use FileOutputStream class. You can write byte-oriented as well as character-oriented data through FileOutputStream class. But, for character-oriented data, it is preferred to use FileWriter than FileOutputStream.

FileReader is used to read character-oriented data from a file and FileWriter class is used to write character-oriented data to a file.

## Resources:
* FileInputStream: https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
* FileOutputStream: https://docs.oracle.com/javase/8/docs/api/?java/io/FileOutputStream.html
* FileReader: https://docs.oracle.com/javase/9/docs/api/?java/io/FileReader.html
* FileWriter: https://docs.oracle.com/javase/9/docs/api/?java/io/FileWriter.html
