
**BigID - Backend Dev Task  v1.5**

_Design and implement a simple Java program to find specific strings in a large text..._

Lines and position enumeration begins from 0 according to Java style.

Master branch was design without multi-threading  as a base variant.

This one implements ExecutorService in order to run each matcher in a separate thread.

The diiference from ex-service approach ( https://github.com/gprohorov/big-id-task/tree/com-future )  is in the usage of CompletableFuture instead of Future.

There is no difference in processing time between these approaches.

