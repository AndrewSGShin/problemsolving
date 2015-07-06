A formula used to reorder data into a new sequence. **Sorting is expensive.**  

Insertion Sort
----------------

Selection Sort
-----------------

Shellsort
-----------

Radix Sort
-------------------

Heap Sort
-------------------

Merge Sort
----------------

Merge Sort is faster than Insertion, Selection and Bubble sorts because we use the transitive nature of comparison relations and take into account all previous compares we already made. No selection sort nor insertion sort utilize transitive nature of previous comparisons so they are slower for big randomly sorted inputs.

A sorting technique that sequences data by continuously merging items in the list. Every single item in the original unordered list is merged with another, creating groups of two. Every two-item group is merged, creating groups of four and so on until there is one ordered list.

Quick Sort 
-----------

A sorting algorithm with O(nlogn) average time complexity. One element, x (pivot point) of the list to be sorted is chosen and the other elements are split into those elements less than x and those greater than or equal to x. These two lists are then sorted recursively using the same algorithm until there is only one element in each list, at which point the sublists are recursively recombined in order yielding the sorted list.

Time complexity O(nlogn) why not O(n2)?
Space complexit O(n2)

- Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations. Used by Java SE `Arrays.sort` family of methods and imlemented in `DualPivotQuickSort.java`.