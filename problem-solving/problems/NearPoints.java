// find `k` closest points from the list of `n` points, `k` < `n`

import java.util.*;

class NearPoints {

  public static void main(String... args) {
    List<Point> points = new LinkedList<>();
    points.add(new Point(1, 7, 10));
    points.add(new Point(2, -3, 14));
    points.add(new Point(3, 1, 1));
    points.add(new Point(4, 70, -45));
    points.add(new Point(5, 0, 1));
    points.add(new Point(6, 10, -3));

    Point pivot = new Point(0, 0, 0);

    // System.out.println("List of points for algo1: " + points);
    // System.out.println("Algo1: " + nearest(pivot, points, 3) + "\n");
    // System.out.println("List of points for algo2: " + points);
    // System.out.println("Algo2 (broken due to TreeSet): " + nearest2(pivot, points, 3));

    int k = 3;
    FixedSizeMaxBinaryHeap<DistantPoint> heap = new FixedSizeMaxBinaryHeap<>(3);

    // number of nodes on a level
    assert(BinaryTrees.placesInLevel(0) == 1);
    assert(BinaryTrees.placesInLevel(1) == 2);
    assert(BinaryTrees.placesInLevel(4) == 16);

    // max nodes in a tree
    assert(BinaryTrees.placesInTreeByLevel(0) == 1);
    assert(BinaryTrees.placesInTreeByLevel(1) == 3);
    assert(BinaryTrees.placesInTreeByLevel(4) == 31);

    // max nodes in a tree (prove me)
    assert(BinaryTrees.placesInTreeByLevelProveMe(0) == 1);
    assert(BinaryTrees.placesInTreeByLevelProveMe(1) == 3);
    assert(BinaryTrees.placesInTreeByLevelProveMe(4) == 31);

  }

  /*
   * Get `k` points nearest to the `pivot` point from list `points` of size `n`.  
   *
   * Current implementation uses Reb-Black Tree to sort the list of points which is linearithmic.
   * Another approach could be to use Max Binary Heap for the problem which is also linearithmic.
   * Yet another approach could be sorting the list of points with MergeSort which is also linearithmic.
   *
   * @param pivot The reference point relative to which calculate the distance.
   * @param points Long list of points
   * @param n The number of nearest points to return
   * 
   * Time complexity: O(n*logn)
   */
  static List<Point> nearest(Point pivot, List<Point> points, int k) {
    TreeMap<Double, List<Point>> pointsByDistance = new TreeMap<>();  

    for (Point point : points) {
      Double d = distance(pivot, point);
      List<Point> equidistant = pointsByDistance.get(d);
      if (equidistant == null) {
        equidistant = new LinkedList<>();
        pointsByDistance.put(d, equidistant);
      }
      equidistant.add(point);
    }

    List<Point> nearest = new ArrayList<>(k);
   
    Iterator<List<Point>> it = pointsByDistance.values().iterator();
    while (it.hasNext() && k > 0) {
      List<Point> topPoints = it.next();  
      for (Point p : topPoints) {  
        nearest.add(p);
        k--;
        if (k == 0) {
          break;
        }
      }
    }
    return nearest;
  }

  static Double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }

  /*
   * Get `k` points nearest to the `pivot` point from list `points` of size `n`.  
   *
   * Current implementation uses Reb-Black Tree to sort the list of points which is linearithmic.
   * Another approach could be to use Max Binary Heap for the problem which is also linearithmic.
   * Yet another approach could be sorting the list of points with MergeSort which is also linearithmic.
   *
   * @param pivot The reference point relative to which calculate the distance.
   * @param points Long list of points
   * @param n The number of nearest points to return
   * 
   * Time complexity: O(n*logk)
   */
  static List<Point> nearest2(Point pivot, List<Point> points, int k) {
    NavigableSet<DistantPoint> nearest = new TreeSet<DistantPoint>();  

    for (Point point : points) {
      Double d = distance(pivot, point);
      DistantPoint dp = new DistantPoint(point, d);
      System.out.println("Distance calculated: " + dp);
      nearest.add(dp);
      System.out.println("Tree set after adding that point: " + nearest);
      if (nearest.size() == k + 1) {
        nearest.pollLast();
      }
      System.out.println("Tree set after removing the farmost point: " + nearest);
    }

    List<Point> result = new ArrayList<>(k);
    for (DistantPoint n : nearest) {
      result.add(n.p);
    }

    return result;
  }

  static List<Point> nearest3(Point pivot, List<Point> points, int k) {
    NavigableSet<DistantPoint> nearest = new TreeSet<DistantPoint>();  

    for (Point point : points) {
      Double d = distance(pivot, point);
      DistantPoint dp = new DistantPoint(point, d);
      System.out.println("Distance calculated: " + dp);
      nearest.add(dp);
      System.out.println("Tree set after adding that point: " + nearest);
      if (nearest.size() == k + 1) {
        nearest.pollLast();
      }
      System.out.println("Tree set after removing the farmost point: " + nearest);
    }

    List<Point> result = new ArrayList<>(k);
    for (DistantPoint n : nearest) {
      result.add(n.p);
    }

    return result;
  }
}

class Point {
  long id;
  int x;
  int y;

  public Point(long id, int x, int y) {
    this.id = id;
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Point)) return false;
    Point p = (Point) o;
    return p.id == this.id && p.x == this.x && p.y == this.y;
  }

  public int hashCode() {
    return (int) id;
  }
}

class DistantPoint implements Comparable<DistantPoint> {
  Point p;
  Double distance;

  DistantPoint(Point p, Double distance) {
    this.p = p;
    this.distance = distance;
  }

  public int compareTo(DistantPoint other) {
    System.out.println("Comparing " + this.p + " to " + other.p);
    return (int) (this.distance - other.distance);
  }

  public String toString() {
    return p.toString() + " " + distance;
  }

  public boolean equals(Object o) {
    if (o == null) return false;

    if (!(o instanceof DistantPoint)) {
      return false;
    }

    DistantPoint dp = (DistantPoint) o;

    return this.p.equals(dp.p);
  }

  public int hashCode() {
    return this.p.hashCode();
  }
}


class FixedSizeMaxBinaryHeap<T extends Comparable<T>> {
  T[] heap;
  int size = 0;

  @SuppressWarnings("unchecked")
  public FixedSizeMaxBinaryHeap(int usefulCapacity) {
    heap = (T[]) new Comparable[usefulCapacity + 1];
  }

  int parent(int i) {
    return (i - 1) / 2;
  }

  // get index of left child of node at index i
  int left(int i) {
    return 2 * i + 1;
  }

  // get index of right child of node at index i
  int right(int i) {
    return 2 * i + 2;
  }

  // to extract the root which is the minimum element
  // int extractMax() {

  // }

  // Decreases item value of key at index i to new_val
  // void increaseKey(int i, T item) {
  //    harr[i] = new_val;
  // while (i != 0 && harr[parent(i)] > harr[i])
  // {
  //    swap(&harr[i], &harr[parent(i)]);
  //    i = parent(i);
  // }
  // }

  // Returns the max key (key at root) from max heap
  T getMax() { 
    return heap[0]; 
  }

  // Deletes a key stored at index i
  // void deleteKey(int i) {

  // }

  private void append(T item) {
    heap[size] = item;
    if (heap.length > size) {
      size++;
    }
  }

  private void bubbleUpLast() {
    int i = size - 1;
    while(i > 0 && heap[parent(i)].compareTo(heap[i]) < 0) {
       T temp = heap[i];
       heap[i] = heap[parent(i)];
       heap[parent(i)] = temp;
       i = parent(i);
    }
  }


  // Inserts a new key 'k'
  void add(T item) {
    append(item);
    bubbleUpLast();
  }

  // heapify a subtree with root at given index
  // void heapify(int root);

  // private int levels() {

  // }

  @Override
  public String toString() {
    return "";
  }
}

class BinaryTrees {

  /**
   * Returns a number of node on a level where levels are counted from zero.
   */
  public static int placesInLevel(int level) {
    return (int) Math.pow(2.0, level);
  }

  /**
   * Returns a number of node on a level where levels are counted from zero.
   */
  public static int placesInTreeByLevel(int maxLevel) {
    int nodes = 0;
    while (maxLevel >= 0) {
      nodes += placesInLevel(maxLevel);
      maxLevel--;
    }
    return nodes;
  }

  /**
   * Returns a number of node on a level where levels are counted from zero.
   */
  public static int placesInTreeByLevelProveMe(int maxLevel) {
    return ((int) Math.pow(2, maxLevel + 1)) - 1;
  }

  public static int numberOfLevelsByNodes(int nodes) {
    return Math.log
  }
}


class MathUtils {
  public static int log2(int n){
    if (n <= 0) throw new IllegalArgumentException();
    return 31 - Integer.numberOfLeadingZeros(n);
  }
}
