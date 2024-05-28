import java.util.*;
public class Test {

	public static void main(String[] args) {
		PriorityQueue<String[]> q = new PriorityQueue<>(Comparator.comparing(x -> x[1]));

		q.offer(new String[]{"AA" , "BB"});
		q.offer(new String[]{"AC" , "BA"});
		q.offer(new String[]{"AC" , "AB"});

		while(!q.isEmpty()){
			System.out.println(Arrays.toString(q.poll()));
		}
	}

}
