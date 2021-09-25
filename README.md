                                      **BigID - Backend Dev Task v1.5**

Design and implement a simple Java program to find specific strings in a large text..

  TextBlockSuplier cut of the portions of 1000 lines one by one from the huge text   .

  Each portion is sent to the Matcher and is processed in a separate thread ( **CompletableFuture** ).

 The result is a list of Map<String, List<Location>>

  The result list is processed by Aggregator.  

  List is flatted to map.

  As was asked in the task.

Advantages: memory load is low.

Processing time: 15% lower than that of the ordinary **ExecutorService** approach.  https://github.com/gprohorov/big-id-task/tree/ex-service
  
In the Main class raw results  are written to console via **aggregator.showRawResults()**

More fine output provides **aggregator.showPretty();** method.