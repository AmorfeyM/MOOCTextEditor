package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 * @author Popov Sergey
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
   public DictionaryBST() {
	   dict = new TreeSet<String>();
   }

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	String wordLC = word.toLowerCase();
    	if (this.isWord(wordLC)) {
    		return false;
    	}
    	else {
    		dict.add(wordLC);
    		return true;
    	}
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
    	String wordLC = s.toLowerCase();
    	if (dict.contains(wordLC)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
