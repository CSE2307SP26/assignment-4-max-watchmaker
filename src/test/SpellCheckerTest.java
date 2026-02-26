package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    @BeforeEach
    public void setup() {
        SpellChecker sc = new SpellChecker();
    }

    @Test //test 1
    public void wordsKnowsAbout() {
        assertEquals(0, sc.getWordCount());
    }

    @Test //test 2
    public void testWordCountIncreasesWhenNewWordAdded() {
        sc.add("cat");
        assertEquals(1, sc.getWordCount());

        sc.add("dog");
        assertEquals(2, sc.getWordCount());
    }

    @Test //test 3
    public void testAddingDuplicateWordDoesNotIncreaseCount() {
        sc.add("cat");
        sc.add("cat");
        assertEquals(1, sc.getWordCount());
    }

    @Test //test 4
    public void testCorrectlySpelledWordReturnsTrue() {
        sc.add("cat");
        assertTrue(sc.isCorrectlySpelled("cat")); 
		//i am assuming that my isCorrectlySpelled methods looks through the spellchecker object for the word passed in as an argument, and returns a boolean
    }

    @Test //test 5
    public void testIncorrectlySpelledWordReturnsFalse() {
        sc.add("cta");
        assertFalse(sc.isCorrectlySpelled("cta"));
    }

    @Test //test 6
    public void testCaseInsensitiveSpellingCheck() {
        sc.add("cat");
        assertTrue(sc.isCorrectlySpelled("CAT")); //my isCorrectlySpelled method should ignore case when checking if a word is spelled correctly
        assertTrue(sc.isCorrectlySpelled("CaT"));
        assertTrue(sc.isCorrectlySpelled("cat"));
    }

    @Test //test 7
    public void testSuggestReturnsClosestWord() {
        sc.add("bamk");
        assertEquals("bank", sc.suggest("bamk")); 
		
    }
	//i am assuming my suggest method looks thru spellchecker object for the word passed in as argument, and then returns the closest match to that word. 
	//for the isCorrectlySpelled and suggest method, I am assuming that the strings exist in the spellchecker object

    @Test //test 8
    public void testSuggestReturnsOriginalIfAlreadyCorrect() {
        sc.add("bank");
        assertEquals("bank", sc.suggest("bank"));
    }

    @Test //my own test 1
    public void testAddEmptyStringDoesNotIncreaseCount() {
        sc.add("");
        assertEquals(0, sc.getWordCount());
    }

    @Test //my own test 2
    public void testAddNullDoesNotIncreaseCount() {
        sc.add(null);
        assertEquals(0, sc.getWordCount()); 
    }
}
