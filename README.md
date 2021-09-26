
**BigID - Backend Dev Task  v1.5**

_Design and implement a simple Java program to find specific strings in a large text..._

The approach implements **ExecutorService** in order to run each matcher in a separate thread.

The difference from the  **ex-service** approach ( https://github.com/gprohorov/big-id-task/tree/com-future )  is in the usage of **CompletableFuture** instead of **Future**.

There is no difference in processing time between these approaches.

