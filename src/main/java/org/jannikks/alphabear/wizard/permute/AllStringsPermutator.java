package org.jannikks.alphabear.wizard.permute;

import java.util.Set;

/**
 * Simple implementation of String permutation generation. Returns all
 * permutations from length 1 to the length of the original String.
 * 
 * @author Christiane Lemke
 * 
 */
public class AllStringsPermutator extends AbstractStringPermutator {

	public AllStringsPermutator(String stringToPermute) {
		super(stringToPermute);
	}

	public Set<String> getPermutations() {
		permutation("", super.getStringToPermute());
		return super.getPermutations();
	}

	private void permutation(String prefix, String str) {
		int n = str.length();
		if (prefix.length() > 0) {
			super.addResult(prefix);
		}
		for (int i = 0; i < n; i++) {
			permutation(prefix + str.charAt(i),
					str.substring(0, i) + str.substring(i + 1, n));
		}
	}

}
