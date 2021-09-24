                                      **BigID - Backend Dev Task v1.5**

Design and implement a simple Java program to find specific strings in a large text..

  TextBlockSuplier cut from a huge text  portions of 1000 lines one by one.
  Each portion is processed by the Matcher in a separate thread ( **CompletableFuture** ).
 The result is a list of Map<String, List<Location>>
  The result list is processed by Aggregator.  
  List is flatted to map.
  As was asked in the task.