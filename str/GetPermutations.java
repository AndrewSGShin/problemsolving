	import java.util.*;

	public class GetPermutations {

		public static void main(String... args) {
			String str = args[0];
			System.out.println(permutations(str));
		}

		static List<String> permutations(String string) {
		    List<String> permutations = new LinkedList<>();
		    Deque<WorkUnit> workQueue = new LinkedList<>(); 

		    // We need to permutate the whole string and haven't done anything yet.
		    workQueue.add(new WorkUnit(string, ""));

		    while (!workQueue.isEmpty()) { // Do we still have any work?
		        WorkUnit work = workQueue.poll();

		        // Permutate each character.
		        for (int i = 0; i < work.todo.length(); i++) {
		            String permutation = work.done + work.todo.charAt(i);

		            // Did we already build a complete permutation?
		            if (permutation.length() == string.length()) {
		                permutations.add(permutation);
		            } else {

		                // Otherwise what characters are left? 
		                String stillTodo = work.todo.substring(0, i) + work.todo.substring(i + 1);
		                workQueue.add(new WorkUnit(stillTodo, permutation));
		            }
		        }
		    }
		    return permutations; 
		}
	}

	/**
	 * Immutable unit of work
	 */
	class WorkUnit {

		/**
		 * A piece of string we still need to permutate.
		 */
		final String todo;

		/**
		 * A piece of string we already permutated.
		 */
		final String done;
		
		WorkUnit(String todo, String done) {
			this.todo = todo;
			this.done = done;
		}
	}