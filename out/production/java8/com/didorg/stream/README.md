### Stream
###`A Stream in Java can be defined as a sequence of elements from a source that supports aggregate operations on them.`
### `The source here refers to a Collections or Arrays who provides data to a Stream.`

* ## Java Stream vs. Collections
A **Collection is an in-memory data structure**, which holds all the values that the data structure currently has. 
Every element in the Collection has to be computed before it can be added to the Collection. 

A **Stream is a conceptually fixed data structure in which elements are computed on demand**. 

- Stream are created on a source, e.g. a java.util.Collection like lists or sets(**Maps are no supported**). 

### Different ways to create **`Streams`**
- Stream.of(val1, val3, val3, ...)
- Stream.of(arrayOfElements)
- List.stream()

### Core Stream operations 
####**`Intermediate operations`**
- Intermediate operations return the stream it sel so you can chain multiple method calls in a row

####**`Terminal operations`**
- Terminal operations return a result of a certain type instead of again a Stream