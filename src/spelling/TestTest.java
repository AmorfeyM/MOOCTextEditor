package spelling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AutoCompleteDictionaryTrie smallDict = new AutoCompleteDictionaryTrie();
//	
		WPTree tree = new WPTree();
		String word1 = "abe";
		String word2 = "accra";

		List<String> path = tree.findPath(word1, word2);

		for (String s : path) {
			System.out.println(s);
		}

        
        		
//        


		

	}

}
