package org.jannikks.alphabear.wizard.vocabulary;

import java.util.HashMap;
import java.util.Map;

import org.jannikks.alphabear.wizard.util.Constants;

/**
 * Class representing a node in a trie.
 * @author Christiane Lemke
 *
 */
public class TrieNode {
	
	private Map<Character, TrieNode> children;
	
	/**
	 * Constructor. Initialises map of children.
	 */
	public TrieNode() {
		this.children = new HashMap<>();
	}
	
	/**
	 * Return the child node for the given character.
	 * @param c the character to retrieve the node for
	 * @return the requested {@link TrieNode}, null if it does not exist.
	 */
	public TrieNode getChild(char c){
		return this.children.get(c);
	}
	
	/**
	 * Insert a word into the trie.
	 * @param word
	 */
	public void insert(String word){
		this.addChild(word.charAt(0), word.substring(1));
	}

	/**
	 * Indicates whether the current node represents a complete word.
	 * @return true if the node is a word, false otherwise.
	 */
	public boolean isFinal() {
		return this.children.containsKey(Constants.END_OF_WORD_CHAR);
	}
	
	/**
	 * Indicates whether the current node is a prefix of other words.
	 * @return true if the node is prefix for other words, false otherwise.
	 */
	public boolean isPrefix(){
		return this.getNumberOfChildrenWithoutEOW() > 0 ? true : false;
	}
	

	/*
	 * Internal helper for recursively adding characters to the trie.
	 */
	private void addChild(Character child, String suffix) {

		if (!this.children.containsKey(child)) {
			TrieNode trieNode = new TrieNode();
			this.children.put(child, trieNode);
		}

		if (!suffix.isEmpty()) {
			this.children.get(child).addChild(suffix.charAt(0),
					suffix.substring(1));
		}
	}
	
	/*
	 * Internal helper retrieving the number of children for this node without considering the end of word character.
	 */
	private int getNumberOfChildrenWithoutEOW(){
		
		int number = this.children.size();
		if (this.isFinal()){
			number--;
		}
		return number;
	}

	@Override
	public String toString() {
		return "TrieNode [children=" + children + ", isFinal=" + this.isFinal() + "]";
	}
}
