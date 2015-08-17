package org.jannikks.alphabear.wizard.permute;

import java.util.Set;

import org.jannikks.alphabear.wizard.vocabulary.Vocabulary;

/**
 * Class generating String permutations that are valid words according to the given vocabulary.
 * 
 * @author Christiane Lemke
 *
 */
public class ValidStringPermutator extends AbstractStringPermutator{
	
	private Vocabulary vocabulary;

	/**
	 * Constructor.
	 * @param vocabulary the {@link Vocabulary} implementation for deciding which words are valid and which are not.
	 * @param stringToPermute the {@link String} to permute.
	 */
	public ValidStringPermutator(Vocabulary vocabulary, String stringToPermute) {
		super(stringToPermute);
		this.vocabulary = vocabulary;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<String> getPermutations() {
		permutation("", super.getStringToPermute());
		return super.getPermutations();
	}

	private void permutation(String prefix, String str) {
		int n = str.length();
		// TODO: Early stopping with prefix.
		if (prefix.length() > 0 && this.vocabulary.isWord(prefix)) {
			super.addResult(prefix);
		}
		for (int i = 0; i < n; i++) {
			permutation(prefix + str.charAt(i),
					str.substring(0, i) + str.substring(i + 1, n));
		}
	}

}
