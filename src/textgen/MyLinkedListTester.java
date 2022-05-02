/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 * @author Popov Sergey
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
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
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		int b = longerList.remove(0);
		assertEquals("Remove: check a is correct ", 0, b);
		assertEquals("Remove: check element 0 is correct ", (Integer)1, longerList.get(0));
		assertEquals("Remove: check size is correct ", 9, longerList.size());
		
		try {
			longerList.remove(-1);
			fail("Check index value (should be positive num)");
		}
		catch (IndexOutOfBoundsException e){
		}
		String c = shortList.remove(0);
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		String d = shortList.remove(0);
		assertEquals("Remove: check size is correct ", 0, shortList.size());
		
		try {
			emptyList.remove(0);
			fail("Check index value (should be positive num)");
		}
		catch (IndexOutOfBoundsException e){
		}
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			emptyList.add(null);
			fail("Check element value (should be not null)");
		}
		catch (NullPointerException e){
		}
		try {
			shortList.add(null);
			fail("Check element value (should be not null)");
		}
		catch (NullPointerException e){
		}
		try {
			longerList.add(null);
			fail("Check element value (should be not null)");
		}
		catch (NullPointerException e){
		}
		try {
			list1.add(null);
			fail("Check element value (should be not null)");
		}
		catch (NullPointerException e){
		}
		int tempSize = longerList.size();
		longerList.add(50);
		assertEquals("Test add() method on long list: ", 11, tempSize+1);  
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		assertEquals("Test size() method on empty list:", 0, emptyList.size());
		assertEquals("Test size() method on short list:", 2, shortList.size());
		assertEquals("Test size() method on long list:", 10, longerList.size());
		assertEquals("Test size() method on random list:", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		emptyList.add(0, 10);
		assertEquals("Test addAtIndex() method on empty list:", 1, emptyList.size());
		
		
		try {
			emptyList.get(1);
			fail("Check element value (should be not null)");
		}
		catch (IndexOutOfBoundsException e){
		}
		try {
			emptyList.add(-1, 15);
			fail("Check element value (should be not null)");
		}
		catch (IndexOutOfBoundsException e){
		}
		try {
			emptyList.add(2, 15);
			fail("Check element value (should be not null)");
		}
		catch (IndexOutOfBoundsException e){
		}
		
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			emptyList.set(1, 15);
			fail("Check element value");
		}
		catch (IndexOutOfBoundsException e){
		}
		try {
			shortList.set(-1, "SSS");
			fail("Check element value");
		}
		catch (IndexOutOfBoundsException e){
		}
		//assertEquals("Test set() method on long list:", (Integer)1, (Integer)longerList.set(1,99));
		//assertEquals("Test set() method on long list:", (Integer)11, (Integer)longerList.size());
		//assertEquals("Test set() method on long list:", (Integer)99, (Integer)longerList.get(1));
		try {
			shortList.set(0, null);
			fail("Check element value");
		}
		catch (NullPointerException e){
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
