import java.util.*;

class VectorProduct {
  public static void main(String... args) {
    List<Integer> a = Arrays.asList(1, 2, 3);
    List<Integer> b = Arrays.asList(4, 5);
    List<Integer> c = Arrays.asList(6, 7, 8);
    List<List<Integer>> input = Arrays.asList(a, b, c);

    System.out.println("Using string builder pattern:");
    vectorProduct(new StringBuilder(), input, 0);   

    System.out.println();
    System.out.println("Using immutable strings:");
    List<String> results = new ArrayList<>();
    vectorProduct(input, 0, "", results);
    System.out.println(results);

    System.out.println();
    System.out.println("Without recursion:");
    List<List<Integer>> products = vectorProduct3(input);
    System.out.println(products);

    System.out.println();
    System.out.println("Print product recursive:");
    printProduct(input, 0, "(");
    System.out.println();

    System.out.println();
    System.out.println("Recursively from end:");
    List<List<Integer>> fromEnd = possibleEnds(input, 0);
    System.out.println(fromEnd);
  }

  /**
   * Given `lists` of size N it recurses N-1 times.
   * Running time: L(N-1) + L(N-1)*L(N-2) + L(N-1)*L(N-2)*L(N-3) + ... + L(N-1)*L(N-2)*L(N-3)*...*L3*L2*L1.
   */
  static List<List<Integer>> possibleEnds(List<List<Integer>> lists, int listIndex) {
    if (listIndex == lists.size() - 1) { // last
      List<List<Integer>> result = new LinkedList<>();
      for (Integer i : lists.get(listIndex)) {
        List<Integer> product = new LinkedList<>();
        product.add(i);
        result.add(product);
      }
      return result; 
    } else {
      List<List<Integer>> ends = possibleEnds(lists, listIndex + 1);
      List<List<Integer>> result = new LinkedList<>();
      for (Integer i : lists.get(listIndex)) {
        for (List<Integer> end : ends) {
          List<Integer> newEnd = new LinkedList<>(end);
          newEnd.add(0, i);
          result.add(newEnd);
        }
      }
      return result;
    }
  }   


  // let we have n lists: L1, L2, ..., LN with sizes S1, S2, ..., SN accordingly.
  // The recursion tree shows that we will recurse S1 + S1*S2 + S1*S2*S3 + S1*S2*S3*...*SN-1 times.
  static void printProduct(List<List<Integer>> lists, int listIndex, String tuple) {
    if (listIndex == lists.size() - 1) { // last
      for (Integer i : lists.get(listIndex)) {
        System.out.print(tuple + i + ") ");
      }
      System.out.println(); 
    } else {
      for (Integer i : lists.get(listIndex)) {
        printProduct(lists, listIndex + 1, tuple + i + ' ');
      } 
    }
  }   
  
  
  /*
   * Time comlexity O(n^2)
   * Uses string builder pattern
   */
  static void vectorProduct (StringBuilder builder, List<List<Integer>> lists, int level) {
    for (Integer i : lists.get(level)) {
      builder.append(i).append(' ');
      if (level == lists.size() - 1) {
        builder.append(' ');
        System.out.print(builder);
        builder.deleteCharAt(builder.length() - 1);
      } else {
        vectorProduct(builder, lists, level + 1);
      }
      builder.delete(builder.length() - 2, builder.length());
    }
  }  

  /*
   * Time comlexity O(n^2)
   * Uses immutable strings, less computationally and space efficient
   */
  static void vectorProduct (List<List<Integer>> lists, int level, String tuple, List<String> result) {
    for (Integer i : lists.get(level)) {
      if (level == lists.size() - 1) {
        result.add(tuple + i);
      } else {
        vectorProduct(lists, level + 1, tuple + i + ' ', result);
      }
    }
  }   

  /**
   * Accepts tuples list [[1, 2, 3], [4, 5, 6], ...]
   * Returns products list [[1, 4], [1, 5], [1, 6], [2, 4], [2, 5], [2, 6], ...]
   *
   * Total running time for a list of lists N(a,b,c...m) = a + a*b + a*b*c + a*b*c*...*m where number of members to add in expression is N.
   */
  static List<List<Integer>> vectorProduct3 (List<List<Integer>> tuples) {
    
    // initial setup to start multiplying tuples
    List<List<Integer>> products = new LinkedList<>();
    products.add(new LinkedList<>());

    for (List<Integer> tuple : tuples) { // n
      List<List<Integer>> buffer = new LinkedList<>();
      for (List<Integer> product : products) { // 1, a, a*b, a*b*c
        for (Integer multiplier : tuple) { // a, b, c

          // shallow copy
          List<Integer> newProduct = new LinkedList<>(product);
          
          // add multiplier
          newProduct.add(multiplier);
          
          // add to partial results
          buffer.add(newProduct);
        }
      }
      products = buffer;

    }
    return products;
  } 
}