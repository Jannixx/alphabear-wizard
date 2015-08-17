package org.jannikks.alphabear.wizard.permute;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class for generating String permutations in different ways.
 * @author Christiane Lemke
 *
 */
public abstract class AbstractStringPermutator implements StringPermutator{
	
	private String stringToPermute;
	private Set<String> permutations;
	
	/**
	 * Constructor.
	 * @param stringToPermute the String to permute.
	 */
	public AbstractStringPermutator(String stringToPermute) {
		this.stringToPermute = stringToPermute;
		this.permutations = new HashSet<>();
	}
	
	/**
	 * Add a String to the underlying result set.
	 * @param result the new result to add.
	 */
	public void addResult(String result){
		this.permutations.add(result);
	}
	
	public String getStringToPermute() {
		return stringToPermute;
	}

	/**
	 * Return the result set.
	 * @return a {@link Set} containing the results.
	 */
	public Set<String> getPermutations() {
		return permutations;
	}

}
