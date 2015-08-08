package org.jannikks.alphabear.wizard;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Christiane Lemke
 */
public class MiniVocabularyTest {
	
	private String[] testWords = {
		"house",
		"homework",
		"homeworker",
		"cat",
	};
	
	private Vocabulary vocabulary = new SimpleTrieVocabulary();
	
	@Before
	public void setUp(){
		for (String word : testWords){
			vocabulary.addWord(word);
		}
	}
	
	@Test
	public void testIsPrefix(){

		Assert.assertFalse(vocabulary.isPrefix("house"));
		Assert.assertFalse(vocabulary.isPrefix("cat"));

		Assert.assertTrue(vocabulary.isPrefix("home"));
		Assert.assertTrue(vocabulary.isPrefix("homework"));
		Assert.assertTrue(vocabulary.isPrefix("homewo"));
		Assert.assertTrue(vocabulary.isPrefix("ca"));
	}
	
	@Test
	public void isWord(){
		Assert.assertTrue(vocabulary.isWord("cat"));
		Assert.assertTrue(vocabulary.isWord("house"));
		Assert.assertTrue(vocabulary.isWord("homework"));

		Assert.assertFalse(vocabulary.isWord("home"));
		Assert.assertFalse(vocabulary.isWord("homewo"));
		Assert.assertFalse(vocabulary.isWord("ca"));
	}
	

}
