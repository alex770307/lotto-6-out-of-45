import java.util.List;
import java.util.Set;

public class ResultChecker {

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

}
