// Name: Samuil Dichev

import java.util.ArrayList;
import java.util.List;

public class Normaliser {
	public String normalise(String input) {
		String[] n = {"Architect", "Software engineer", "Quantity surveyor", "Accountant"};
		String normalisedTitle = null;
		double q = 0;

		for (int i = 0; i < n.length; i++) {
			double result = compareStrings(input, n[i]);

			if (result > q || q == 0) {
				q = result;
				normalisedTitle = n[i];
			}
		}
		return normalisedTitle;
	}

	public double compareStrings(String str1, String str2) {
		List<String> pairs1 = wordLetterPairs(str1.toUpperCase());
		List<String> pairs2 = wordLetterPairs(str2.toUpperCase());
		int intersection = 0;
		int union = pairs1.size() + pairs2.size();
		for (int i = 0; i < pairs1.size(); i++) {
			Object pair1 = pairs1.get(i);
			for(int j = 0; j < pairs2.size(); j++) {
				Object pair2 = pairs2.get(j);
				if (pair1.equals(pair2)) {
					intersection++;
					pairs2.remove(j);
					break;
				}
			}
		}
		return (2.0 * intersection) / union;
	}

	private List<String> wordLetterPairs(String str) {
		List<String> allPairs = new ArrayList<String>();
		String[] words = str.split("\\s");
		for (int w = 0; w < words.length; w++) {
			String[] pairsInWord = letterPairs(words[w]);
			for (int p = 0; p < pairsInWord.length; p++) {
				allPairs.add(pairsInWord[p]);
			}
		}
		return allPairs;
	}

	private String[] letterPairs(String str) {
		int numPairs = str.length() - 1;
		String[] pairs = new String[numPairs];
		for (int i = 0; i < numPairs; i++) {
			pairs[i] = str.substring(i, i + 2);
		}
		return pairs;
	}
}