package org.jannikks.alphabear.wizard.run;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.jannikks.alphabear.wizard.permute.StringPermutator;
import org.jannikks.alphabear.wizard.permute.ValidStringPermutator;
import org.jannikks.alphabear.wizard.scoring.Scorer;
import org.jannikks.alphabear.wizard.scoring.TurnsLeftAndLengthScorer;
import org.jannikks.alphabear.wizard.vocabulary.SimpleTrieVocabulary;

/**
 * Running Alphabear-Wizard. It needs information about your board.
 * @author Christiane Lemke
 *
 */
public class Runner {


	private SimpleTrieVocabulary simpleTrieVocabulary;
	private StringPermutator permuter;
	private BoardConfiguration configuration;
	
	private Scorer turnsLeftScorer;

	/**
	 * Constructor.
	 * @param boa
	 */
	public Runner(BoardConfiguration configuration) {

		this.loadDictionary();

		this.configuration = configuration;
		this.permuter = new ValidStringPermutator(simpleTrieVocabulary, this.configuration.getOriginalWord());
		this.turnsLeftScorer = new TurnsLeftAndLengthScorer(configuration);
	}

	/**
	 * Get candidates from given board configuration and sorts them.
	 * @return a sorted list of word candidates.
	 */
	public List<String> run(){
		
		Set<String> permutations = this.permuter.getPermutations();
		return turnsLeftScorer.sortWords(permutations);
	}

	/*
	 * Little helper to load the dictionary.
	 */
	private void loadDictionary() {
		this.simpleTrieVocabulary = new SimpleTrieVocabulary();
		Scanner scan = new Scanner(this.getClass().getClassLoader()
				.getResourceAsStream("sowpods.txt"));

		while (scan.hasNextLine()) {
			this.simpleTrieVocabulary.addWord(scan.nextLine().toLowerCase());
		}
		scan.close();
	}
	

	/**
	 * Main method!!
	 * @param args discarded.
	 */
	public static void main(String[] args) {
		
		// Set up your board here.
		BoardConfiguration configuration = new BoardConfiguration();
		configuration.addLettersForTurn(2, "ft");
		configuration.addLettersForTurn(3, "udi");
		configuration.addLettersForTurn(4, "fo");
		
		// Calculate words
		Runner runner = new Runner(configuration);
		List<String> results = runner.run();
		
		System.out.println(results);

	}

}
