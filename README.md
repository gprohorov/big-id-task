
**BigID - Backend Dev Task  v1.5**

_Design and implement a simple Java program to find specific strings in a large text..._

Lines and position enumeration begins from 0 according to Java style.

 A huge text is sliced into an intermediate set of blocks (1000 lines per block).  

  After that each block is processed by Matcher in a thread via **ExecutorService**

Such a way is proposed because slicing process takes a short time compared with matching one. 

Disadvantage: memory overload;
Processing time:  35% lower than that of non-multithreading approach.

In the branch  **async**   https://github.com/gprohorov/big-id-task/tree/async
 the algorithm is more optimized on the base of **CompletableFuture** 