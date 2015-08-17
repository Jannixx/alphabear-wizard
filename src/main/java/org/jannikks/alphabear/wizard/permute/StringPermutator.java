package org.jannikks.alphabear.wizard.permute;

import java.util.Set;

/**
 * Interface for generating permutations of Strings.
 * @author Christiane Lemke
 *
 */
public interface StringPermutator {
	
	/** return permutations of a given String */
	public Set<String> getPermutations();

}
