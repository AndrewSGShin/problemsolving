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
   */
  static List<List<Integer>> vectorProduct3 (List<List<Integer>> tuples) {
    
    // initial setup to start multiplying tuples
    List<List<Integer>> products = new LinkedList<>();
    products.add(new LinkedList<>());

    for (List<Integer> tuple : tuples) {
      List<List<Integer>> buffer = new LinkedList<>();
      for (List<Integer> product : products) {
        for (Integer multiplier : tuple) {
          List<Integer> newProduct = new LinkedList<>(product);
          newProduct.add(multiplier);
          buffer.add(newProduct);
        }
      }
      products = buffer;

    }
    return products;
  } 
}