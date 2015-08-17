package org.jannikks.alphabear.wizard.run;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;

/**
 * Class representing the configuration of the Board.
 * @author Christiane Lemke
 *
 */
public class BoardConfiguration {
	
	private Map<Integer, Set<Character>> turnsLeftMap;
	
	public BoardConfiguration(){
		this.turnsLeftMap = new HashMap<Integer, Set<Character>>();
	}
	
	/**
	 * Add letters for a number of turns left.
	 * @param turnsLeft the number of turns left on the current letters
	 * @param charString the letters as a String, no particular order assumed.
	 */
	public void addLettersForTurn(int turnsLeft, String charString){
		Set<Character> characters = new HashSet<>();
		for (int i = 0; i< charString.length(); i++){
			characters.add(charString.charAt(i));
		}
		
		this.turnsLeftMap.put(turnsLeft, characters);
	}
	
	/**
	 * Reconstruct original word from underlying map.
	 * @return the original Word.
	 */
	public String getOriginalWord() {
		StringBuilder sb = new StringBuilder();
		for (Set<Character> chars : this.turnsLeftMap.values()){
			for (Character c : chars){
				sb.append(c);
			}
		}
		return sb.toString();
	}
	

	/**
	 * Get number of letters that match for a given turn.
	 * @param word the word to check
	 * @param turn the turn to check
	 * @return the number of times letters for the given turn appear in the given word.
	 */
	public int getNumberOfLettersForTurn(String word, int turn) {

		Preconditions.checkArgument(0 < turn,
				"Expecting a positive turn number.");
		int number = 0;
		Set<Character> charactersForTurn = turnsLeftMap.get(turn);

		if (charactersForTurn != null) {

			for (int i = 0; i < word.length(); i++) {
				if (charactersForTurn.contains(word.charAt(i))) {
					// TODO: How to deal with duplicate letters?
					number++;
				}
			}
		}
		return number;
	}

}
