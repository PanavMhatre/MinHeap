
import java.text.DecimalFormat;
import java.util.Random;

public class BuildHeapTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		Random rand = new Random();
		
	
		final int NUM_VALUES = 20_000_000; 
		
		Integer[] nums = rand.ints(NUM_VALUES).boxed().toArray(Integer[]::new);
		
		long time = System.currentTimeMillis();
		
		MinHeap myHeap = new MinHeap(nums); //construct the heap from initial values with buildHeap (O(n))
		
		long goodTime = System.currentTimeMillis() - time;
		
		System.out.println("Build Heap occurs in: " + goodTime + " milliseconds");
		
		time = System.currentTimeMillis();
		
		MinHeap insertHeap = new MinHeap(10_000_000); //construct empty heap with N elements
		
		for (Integer i : nums) //perform N inserts (O(n log n))
			insertHeap.insert(i);
		
		long badTime = (System.currentTimeMillis() - time);
		
		System.out.println("Insert Heap occurs in: " + badTime + " milliseconds");
		
		String percentageBoost = new DecimalFormat("#.##").format((((double) badTime / goodTime) - 1) * 100);
		
		System.out.println("Your build heap runs " + percentageBoost + "% faster");
	}
}