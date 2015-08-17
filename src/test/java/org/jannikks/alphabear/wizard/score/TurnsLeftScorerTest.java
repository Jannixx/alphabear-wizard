package org.jannikks.alphabear.wizard.score;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jannikks.alphabear.wizard.run.BoardConfiguration;
import org.jannikks.alphabear.wizard.scoring.Scorer;
import org.jannikks.alphabear.wizard.scoring.TurnsLeftAndLengthScorer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnsLeftScorerTest {

	private Scorer turnsLeftScorer;
	private Set<String> testWords;

	@Before
	public void setUp() {
		testWords = new HashSet<>();
		testWords.add("foot");
		testWords.add("cat");
		testWords.add("cad");

		BoardConfiguration configuration = new BoardConfiguration();
		configuration.addLettersForTurn(1, "ad");
		turnsLeftScorer = new TurnsLeftAndLengthScorer(configuration);

	}

	@Test
	public void testTurnsLeftSort() {
		List<String> results = turnsLeftScorer.sortWords(testWords);

		System.out.println(results);
		Assert.assertEquals(3, results.size());

		Assert.assertEquals("foot", results.get(2));
		Assert.assertEquals("cat", results.get(1));
		Assert.assertEquals("cad", results.get(0));

	}

}
