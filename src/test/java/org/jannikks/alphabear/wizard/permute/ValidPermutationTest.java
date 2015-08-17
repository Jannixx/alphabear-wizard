package org.jannikks.alphabear.wizard.permute;

import java.util.Set;

import org.junit.Assert;

import org.jannikks.alphabear.wizard.vocabulary.SimpleTrieVocabulary;
import org.jannikks.alphabear.wizard.vocabulary.Vocabulary;
import org.junit.Before;
import org.junit.Test;

public class ValidPermutationTest {

	private Vocabulary vocabulary;
	private ValidStringPermutator permuatator;

	private String[] validWords = { "cat", "tact" };

	@Before
	public void setUp() {
		this.vocabulary = new SimpleTrieVocabulary();
		for (String validWord : validWords) {
			this.vocabulary.addWord(validWord);
		}
		this.permuatator = new ValidStringPermutator(vocabulary, "actt");
	}

	@Test
	public void testValidStringPermutation() {
		Set<String> results = this.permuatator.getPermutations();

		for (String validWord : validWords) {
			Assert.assertTrue(results.contains(validWord));
		}
		Assert.assertEquals(2, results.size());
	}

}
