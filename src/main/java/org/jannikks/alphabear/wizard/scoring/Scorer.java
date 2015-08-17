package org.jannikks.alphabear.wizard.scoring;

import java.util.List;
import java.util.Set;

/**
 * Interface for 
 * @author Christiane Lemke
 *
 */
public interface Scorer {
	
	public List<String> sortWords(Set<String> words);
}
