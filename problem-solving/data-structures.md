- Iterator
- Iterable
- Bag
- Stack
- Queue
- Deque
- Priority Queue
- Array
- Resizing array
- Linked list
- Binary heap


Arrays
--------

Resizing Arrays
------------------------------

A typical implementation is that when the array is full, the array doubles in size. Each doubling takes O(n) time, but happens so rarely that its amortized time is still O(1).

- Find a mininum element in an array - iterate and compare
- Find particular element in a sorted array - binary search


Strings
--------

- Charset (alphabet) size - ASCII alphanumeric, full ASCII, Unicode, etc? ASCII strings have short alphabet (256 values). ASCII strings with length > 256 character cannot consist of all unique characters.
- Case-sensitivity
- Significance / insignificance of characters

String Buffers
---------------

Without string buffers concatenation of immutable strings is  O(xn2).

StringBuffer simply creates an array of all the strings,copying them back to a string only when necessary.

Linked lists
-----------------
- Singly-linked
- Doubly-linked 

Detect if a list has a loop (circular (broken) lists) - "Fast Runner / Slow Runner" approach


Tries
-----------

Heap
------------------

- Good at basic ordering and keeping track of max and mins

Binary Heap
------------------
- http://geeksquiz.com/binary-heap/

Binomoial Heap
-----------------

Fibonacci Heap
--------------------

Union-Find
-------------------------

