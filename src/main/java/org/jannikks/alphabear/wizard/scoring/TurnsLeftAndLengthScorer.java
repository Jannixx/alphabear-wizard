package org.jannikks.alphabear.wizard.scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.jannikks.alphabear.wizard.run.BoardConfiguration;

/**
 * Scorer based on the number of characters in a word that need to be used soon,
 * for example words containing the most letters only available for one round
 * are preferred.
 * 
 * @author Christiane Lemke
 * 
 */
public class TurnsLeftAndLengthScorer implements Scorer {

	private Comparator<String> comparator;

	public TurnsLeftAndLengthScorer(BoardConfiguration configuration) {
		this.comparator = new TurnsLeftComparator(configuration);

	}

	@Override
	public List<String> sortWords(Set<String> words) {

		List<String> sortedWords = new ArrayList<>(words);
		Collections.sort(sortedWords, this.comparator);

		return sortedWords;
	}

	/**
	 * Nested class taking care of word comparisons
	 * @author Christiane Lemke
	 *
	 */
	private static class TurnsLeftComparator implements Comparator<String> {

		private BoardConfiguration configuration;

		public TurnsLeftComparator(BoardConfiguration configuration){
			this.configuration = configuration;
		}
		
		@Override
		public int compare(String o1, String o2) {
			
			double score1 = getScoreForWord(o1);
			double score2 = getScoreForWord(o2);
			
			if (Math.abs(score1 - score2) < 1E-10){
				// equal, go for length
				return Integer.compare(o2.length(), o1.length());
			}
			
			return Double.compare(getScoreForWord(o2), getScoreForWord(o1));
		}
		

		private double getScoreForWord(String word) {
			
			double score = 0;
			for (int i = 1; i < 10; i++) {
				score = score + this.configuration.getNumberOfLettersForTurn(word, i)
						* Math.pow(10, -i);
			}
			return score;
		}
	}
}
