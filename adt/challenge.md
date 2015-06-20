How to solve a problem
-----------------------

1. Create variable names from the problem description.
2. Think on the data structures
3. Think on the algorithms
4. Write pseudocode
5. Write real code
 
- Choose approach (Examplify, Pattern Matching, Simplify and Generalise, Base Case and Build (Recursion), Data Structure Brainstorm)
- Calculate space and time complexity. Tweak between them.
- Big size problem case
- Write your code at a moderate pace on paper.
  + Use Data Structures Generously 
  + Don't Crowd Your Coding 
- Test on paper.
  + Extreme (base) cases: 0, negative, null, maximums, minimums.
  + Error cases: What happens if the user passes in null or a negative value?
  + General cases: Test the normal case. 
- Type your paper code as-is into a computer. You will probably make a bunch of mistakes. Start a list of all the errors you make so that you can keep these in mind in the real interview.

**For each data structure and algorithms be sure to practice implementing them from scratch.**
   
| Data Structures      | Algorithms                | Concepts                 |
| :------------------: | :-----------------------: | :----------------------: |
| Linked Lists         | Breadth First Search      | Bit Manipulation         |
| Binary Trees         | Depth First Search        | Singleton Design Pattern |
| Tries                | Binary Search             | Factory Design Pattern   |
| Stacks               | Merge Sort                | Memory (Stack vs. Heap)  |
| Queues               | Quick Sort                | Recursion                |
| Array Lists          | Tree Insert / Find / etc. | Big-O Time               |
| Hash Tables          |                           |                          |


Data Types 
-------------

Values can be logically constrained to a some user-defined domain data type (ages, SSN identifiers, etc.) which can influence problem solving.

Custom data type: max, min, uniqueness, storage size.

Size of problem can influence the problem.

Algorithms 
-------------

A logical arithmetical or computational procedure that if correctly applied ensures the solution of a problem.

**Turing Machine** - a hypothetical universal computing machine able to modify its original instructions by reading, erasing, or writing a new symbol on a moving tape of fixed length that acts as its program. The concept was instrumental in the early development of computer systems.

## Computational Complexity

A mathematical characterization of the difficulty of a mathematical problem which describes the resources required by a computing machine to solve the problem. The mathematical study of such characterizations is called computational complexity theory and is important in many branches of theoretical computer science, especially cryptography. 

The exact number or formula is not usually so important as the highest power of N involved.

## Time Complexity (scalability)

The way in which the number of steps required by an algorithm varies with the size of the problem it is solving. Time complexity is normally expressed as an order of magnitude, e.g. O(N^2) means that if the size of the problem (N) doubles then the algorithm will take four times as many steps to complete. 

## Space Complexity (scalability)

The way in which the amount of storage space required by an algorithm varies with the size of the problem it is solving. Space complexity is normally expressed as an order of magnitude, e.g. O(N^2) means that if the size of the problem (N) doubles then four times as much working storage will be needed. 

## Search

## Breadth First Search

## Depth First Search

## Binary Search

## Sort

A formula used to reorder data into a new sequence. **Sorting is expensive.**  

## Merge Sort (divide and conquer)

A sorting technique that sequences data by continuously merging items in the list. Every single item in the original unordered list is merged with another, creating groups of two. Every two-item group is merged, creating groups of four and so on until there is one ordered list.

## Quick Sort 

A sorting algorithm with O(nlogn) average time complexity. One element, x (pivot point) of the list to be sorted is chosen and the other elements are split into those elements less than x and those greater than or equal to x. These two lists are then sorted recursively using the same algorithm until there is only one element in each list, at which point the sublists are recursively recombined in order yielding the sorted list.

Time complexity O(nlogn) why not O(n2)?
Space complexit O(n2)

- Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations. Used by Java SE `Arrays.sort` family of methods and imlemented in `DualPivotQuickSort.java`.

## Tree Insert / Find / etc.

Data Structures
------------------

Data structures with a hash function like HashSet or HashMap will have fast lookups by key.

## Arrays

Arrays has O(1) access for all elements (Random Access).

## Strings

Strings are array-based

- Charset (alphabet) size - ASCII alphanumeric, full ASCII, Unicode, etc? ASCII strings have short alphabet (256 values). ASCII strings with length > 256 character cannot consist of all unique characters.
- Case-sensitivity
- Significance / insignificance of characters

## String Buffers

Without string buffers concatenation of immutable strings is  O(xn2).

StringBuffer simply creates an array of all the strings,copying them back to a string only when necessary.

## Vectors / ArrayLists / Dynamically Resizing Arrays

Vectors are array-based

- O(1) access

 A typical implementation is that when the array is full, the array doubles in size. Each doubling takes O(n) time, but happens so rarely that its amortized time is still O(1).

- Find a mininum element in an array - iterate and compare
- Find particular element in a sorted array - binary search

## Linked lists
- Singly-linked
- Doubly-linked 

Detect if a list has a loop (circular (broken) lists) - "Fast Runner / Slow Runner" approach

`java.util.LinkedList` - worst case time complexity

### mutation
- head/tail insert/replace/remove O(1)
- indexed insert/replace/remove O(n/2)
- remove all O(n)

### access
- head/tail O(1)
- indexed O(n/2)

### search
- search O(n)
- search and get/replace/remove O(n)

## Binary Trees

- Binary tree balancing

## Tries

## Stacks

## Queues

## Hash Tables
- Maps key to values
- Efficient lookup
- Consists of an array, a hash function

A hash table is a data structure that maps keys to values for highly efficient lookup. In a very simple implementation of a hash table, the hash table has an underlying array and a hash function. When you want to insert an object and its key, the hash function maps the key to an integer, which indicates the index in the array. The object is then stored in a linked list at that index modulus array length.

Alternatively, we can implement the hash table with a binary search tree. We can then guarantee an 0 (lo g n) lookup time, since we can keep the tree balanced. Additionally, we may use less space, since a large array no longer needs to be allocated in the very beginning.

## Heap

- Good at basic ordering and keeping track of max and mins

Concepts
----------------

## Bit Manipulation

## Singleton Design Pattern

## Factory Design Pattern

## Memory (Stack vs Heap)

## Recursion

Recursion has a base case and a number of recursive cases. Recursive method has an outline (checking for the base case and 'recurse' step) and the 'meat' logic which handles recursive cases. When the recursion moves down the stack it passes data in method params. When the recursion unwinds it returns data as 'recurse' method return value. Sometime the final result should be of a different type than the data we need when unwinding the stack. In this case we can create two methods: `myMethod` and `myMethodRecurse` and ajust the return type in the former.

## Big-O Time

Coding
------------------

- **Correct** on expected and unexpected inputs
- **Efficient** in asymptotic (Big-O) and real-life efficiency.
- **Simple** means short
- **Readable** means has comments when necessary and implementing things in an easily understandable way.
- **Maintainable** means adaptable.
- Use Data Structures Generously (Classes)
- Appropriate Code Reuse (DRY)
- Modular (more testable and maintainable because we can more easily isolate problems if smth breaks)
- Flexible and Robust (if code can solve more a more general problem it should)
- Error Checking (validate input)