public class MinHeap {
	private Integer[] heap;
	private int size;
	private int capacity;
	static final int DEFAULT_CAPACITY = 8;
	
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	public MinHeap(int cap) {
		size = 1;
		capacity = cap;
		heap = new Integer[cap];
	}
	
	public MinHeap(Integer... nums) {
		size = 1;
		capacity = nums.length;
		heap = nums;
		buildHeap();
	}
	
	private void buildHeap() {
		for(int i = getSize()/2; i >= 0 ; i--) {
			siftDown(i);
			bubbleUp(i,i);
		}
		
	}
	
	public int getSize() {
		return size -1 ;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int peekMinimum() {
		return heap[1];
	}
	
	public int getLeftChildIndex(int index) {
		return (2*index)+1;
	}
	
	public int getRightChildIndex(int index) {
		return (2*index)+2;
	}
	
	public int getParentIndex(int index) {
		return (index/2);
	}
	
	public void doubleCapacity() {
		capacity = capacity * 2;
		Integer[] oldHeap = heap;
		heap = new Integer[capacity];
		
		for(int i = 0; i < oldHeap.length; i++) {
			heap[i] = oldHeap[i];
		}
		
	}
	public void insert(int value) {
		if(size >= capacity) {
			doubleCapacity();
		}
		heap[size] = value;
		bubbleUp(size, size);
		size++;
	}
	private void bubbleUp(int indexNew, int indexOld) {
		if(indexNew <= 0 || indexOld <= 0) {
			return;
		}
		if(heap[indexNew] > heap[indexOld]) {
			swap(heap, indexOld, indexNew);
		}
		bubbleUp(indexOld/2, indexNew);
	}
	private static final <T> void swap (T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public int popMinimum() {
		int min = peekMinimum();
		siftDown(1);
		return min;
	}
	
	private void siftDown(int index) {
		for(int i = index + 1; i<getSize();i++) {
			heap[i-1] = heap[i];
		}
	}
	
	@Override
	public String toString()
	{
		String output = "";
		for (int i = 1; i <= getSize() ; i++)
			output += heap[i] + ", ";
		return output.substring(0, output.lastIndexOf(","));
	}
	
	public void display() {
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);
		while (j <= this.getSize())
		{
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');
			System.out.print((heap[j] == null)? "" : heap[j]);
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			j++;
		}
		System.out.println("\n" + dots + dots);
	}	
}
