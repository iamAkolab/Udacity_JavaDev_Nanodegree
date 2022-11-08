# List
In Java List is an interface, and ArrayList and LinkedList are two common implementation for List. The differences between ArrayList and LinkedList 
are ArrayList uses dynamic array where LinkedList uses a doubly linked list to store elements. I will detail the differences next.

One problem with array is, once the size is defined, you will have to stick with the size. If you have an integer array like

A[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} 
And the statement below will result in a run-time exception.

A[10] = 10;

## Resources:
* ArrayList: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
* LinkedList: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

# Stack and Queue
Stack follows last-in-first-out (LIFO) principle. That’s when you add an element, you add that to the top, when you remove an element, 
you also remove it from the top. Similar to the two methods what we just learned from LinkedList, offerFirst, and removeFirst, which are 
equivalent to Stack’s push and pop.

On the other hand, Queue follows first-in-first-out (FIFO) principle. An excellent example of a queue is a line of customers waiting to 
buy ice cream. The first customer will get the ice cream first, and when they get the ice cream, they will leave the queue. Similar to 
two methods we learned from LinkedList, offerLast, and removeFirst, which are equivalent to Queue’s enqueue, and dequeue.

## Resources:
* Queue: https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
* Stack: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html


<p align="center">
  <img src="https://github.com/iamAkolab/udacity_javadev_nanodegree/blob/main/part2_java_basics/StackAndQueue.png" title="Stack and Queue">
</p>

# Map and Set
Map stores an element in key and element fashion, that is, when you store an element, you will give it a key for Map to retrieve and manipulate it easily. Set stores elements by using hashing.

Two common Map implementations are HashMap and TreeMap.

Two common Set implementations are HashSet and TreeSet.

## Resources:
* Map: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
* Set: https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
