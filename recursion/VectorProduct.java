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
}