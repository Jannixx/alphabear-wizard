package org.jannikks.alphabear.wizard;



/**
 * A simple trie based implementation of the {@link Vocabulary} interface.
 * 
 * Complexities, m being word length:
 * 		Time addWord: O(m)
 * 		Time isPrefix: O(m)
 * 		Time isWord: O(m)
 * 
 * @author Christiane Lemke
 *
 */
public class SimpleTrieVocabulary implements Vocabulary{

	private TrieNode rootNode;
	
	public SimpleTrieVocabulary(){
		this.rootNode = new TrieNode();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addWord(String word) {
		// TODO: This is not pretty, as a new string object is created. Ok for the moment as this happens only at initialisation.
		this.rootNode.insert(word.concat("$"));
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isPrefix(String word) {
		TrieNode trieNode = getTrieNodeForWord(word);
		return trieNode != null ? trieNode.isPrefix() : false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isWord(String word) {
		TrieNode trieNode = getTrieNodeForWord(word);
		return trieNode != null ? trieNode.isFinal() : false;
	}
	
	private TrieNode getTrieNodeForWord(String word) {
		
		TrieNode trieNode = this.rootNode;
		for (char c : word.toCharArray()){
			trieNode = trieNode.getChild(c);
			if (trieNode == null){
				break;
			}
		}
		return trieNode;
	}

	@Override
	public String toString() {
		return "SimpleTrieVocabulary [rootNode=" + rootNode + "]";
	}

}
