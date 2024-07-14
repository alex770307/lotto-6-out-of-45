import java.util.List;
import java.util.Set;

public class ResultChecker {

    private static final int BEST_MATCH_COUNT = 6;

    public List<Integer> getMatchingNumbers(Set<Integer> generatedNumbers,
                                            Set<Integer> userNumbers) {
        return userNumbers.stream()
                .filter(number -> generatedNumbers.contains(number))
                .toList();
    }

    public int getMatchCount(Set<Integer> generatedNumbers, Set<Integer> userNumbers) {

        return (int) userNumbers.stream()
                .filter(number -> generatedNumbers.contains(number))
                .count();
    }

    public boolean isJackpot(int matchCount) {
        return matchCount == BEST_MATCH_COUNT;
    }

    public void updateBestCombinations(Set<Integer> userSet, int matchCount,
                                       int bestMatchCount, List<Set<Integer>> bestCombinations) {
        if (matchCount > bestMatchCount) {
            bestCombinations.clear();
            bestCombinations.add(userSet);
        } else if (matchCount == bestMatchCount) {
            bestCombinations.add(userSet);
        }
    }
}
