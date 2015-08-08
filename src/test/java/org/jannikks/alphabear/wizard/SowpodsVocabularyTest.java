package org.jannikks.alphabear.wizard;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SowpodsVocabularyTest {
	
	private SimpleTrieVocabulary simpleTrieVocabulary;
	
	@Before
	public void setUp(){
		
		simpleTrieVocabulary = new SimpleTrieVocabulary();
		
		Scanner scan = new Scanner(this.getClass().getClassLoader().getResourceAsStream("sowpods.txt"));
	
		while (scan.hasNextLine()){
			simpleTrieVocabulary.addWord(scan.nextLine().toLowerCase());
		}
		scan.close();
	}
	
	@Test
	public void testContains(){
		Assert.assertTrue(simpleTrieVocabulary.isWord("bridge"));
		Assert.assertTrue(simpleTrieVocabulary.isPrefix("bridge"));

		Assert.assertFalse(simpleTrieVocabulary.isWord("asdfa"));
		
		System.out.println(simpleTrieVocabulary.isWord("valium"));
	}

}
