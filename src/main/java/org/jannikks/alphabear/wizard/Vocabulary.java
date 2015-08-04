package org.jannikks.alphabear.wizard;

/**
 * Interface for a vocabulary data structure.
 * @author Christiane Lemke
 */
public interface Vocabulary {

	/**
	 * Add a word to the underlying data structure.
	 * @param word a {@link String} to add.
	 */
	public void addWord(String word);
	
	/**
	 * Determine weather the given character sequence is prefix of valid words.
	 * @param word the {@link String} to check
	 * @return true if the given word is a prefix, false otherwise.
	 */
	public boolean isPrefix(String word);
	
	/**
	 * Determine weather the given character sequence is a valid word.
	 * @param word  the {@link String} to check
	 * @return true if the given word is in the underlying structure, false otherwise.
	 */
	public boolean isWord(String word);
	
}
