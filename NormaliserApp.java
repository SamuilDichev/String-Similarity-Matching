// Name: Samuil Dichev

public class NormaliserApp {
	public static void main(String[] args) {
		String[] testData = {"Java engineer", "C# engineer", "Accountant", "Chief Accountant"};

		String normalisedTitle;
		Double qualityScore;
		Normaliser n = new Normaliser();

		for (int i = 0; i < testData.length; i++) {
			normalisedTitle = n.normalise(testData[i]);
			qualityScore = n.compareStrings(normalisedTitle, testData[i]);
			System.out.printf("\nInput: %s\nOutput: %s\nSimilarity: %.2f\n", testData[i], normalisedTitle, qualityScore);
		}
	}
}