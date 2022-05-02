package textgen;

public class TestList {
	public static void main(String[] args) {

		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(10);
		testList.add(20);
		testList.add(40);
		
		
		MyLinkedList<String> shortList;
		MyLinkedList<Integer> emptyList;
		MyLinkedList<Integer> longerList;
		MyLinkedList<Integer> list1;
		
		final int LONG_LIST_LENGTH = 10;
		
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		
		emptyList = new MyLinkedList<Integer>();
		
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
		
		
		//System.out.println(shortList.size());
		//System.out.println(shortList.get(0));
		
		System.out.println(longerList.size());
		System.out.println(longerList.get(0));
		
		System.out.println(longerList.set(1,99));
		//System.out.println(longerList.get(0));
		//System.out.println(longerList.size());
//		System.out.println(longerList.get(1));
		
//		System.out.println(emptyList.size());
//		emptyList.set(0, 10);
//		System.out.println(emptyList.size());
//		System.out.println(emptyList.get(0));

		
	}

}
