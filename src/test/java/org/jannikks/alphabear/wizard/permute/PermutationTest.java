package org.jannikks.alphabear.wizard.permute;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christiane Lemke
 */
public class PermutationTest {
	
	private AllStringsPermutator permuatator = new AllStringsPermutator("abcd");
	
	
	@Test
	public void testPermutation(){
		Set<String> permutedStrings = permuatator.getPermutations();
	
		Assert.assertTrue(permutedStrings.contains("a"));
		Assert.assertTrue(permutedStrings.contains("ab"));
		Assert.assertTrue(permutedStrings.contains("cab"));
		Assert.assertTrue(permutedStrings.contains("cabd"));
		
		Assert.assertEquals(64, permutedStrings.size());
	}

}
