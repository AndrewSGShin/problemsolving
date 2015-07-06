- binary tree balancing

Binary search over sorted array
---------------------------------

Binary Search Tree
---------------------

Red-black Tree
-------------------

Hash Tables
------------------
- Maps key to values
- Efficient lookup
- Consists of an array, a hash function

A hash table is a data structure that maps keys to values for highly efficient lookup. In a very simple implementation of a hash table, the hash table has an underlying array and a hash function. When you want to insert an object and its key, the hash function maps the key to an integer, which indicates the index in the array. The object is then stored in a linked list at that index modulus array length.

Alternatively, we can implement the hash table with a binary search tree. We can then guarantee an 0 (lo g n) lookup time, since we can keep the tree balanced. Additionally, we may use less space, since a large array no longer needs to be allocated in the very beginning.