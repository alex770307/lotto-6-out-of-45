import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    private LotteryNumberGenerator numberGenerator;
    private UserInput userInput;
    private ResultChecker resultChecker;

    public Game(LotteryNumberGenerator numberGenerator,
                UserInput userInput, ResultChecker resultChecker) {
        this.numberGenerator = numberGenerator;
        this.userInput = userInput;
        this.resultChecker = resultChecker;
    }

    public void start() {
        GameMessage.WELCOME.print();
        while (true) {
            Set<Integer> randomSet = numberGenerator.generateNumbers();
            int selection = userInput.getSelection();
            if (selection== GameSelection.EXIT.getChoice()) {
                GameMessage.EXIT.print();
                break;
            }

            int numCombinations = userInput.getNumCombinations();
            int bestMatchCount = 0;
            List<Set<Integer>> bestCombinations = new ArrayList<>();


            for (int i = 0; i < numCombinations; i++) {
                Set<Integer> userSet;
                if (selection == GameSelection.INPUT.getChoice()) {
                    userSet = userInput.getUserNumbers();
                } else if (selection == GameSelection.GENERATION.getChoice()) {
                    userSet = numberGenerator.generateNumbers();
                } else {
                    GameMessage.INVALID_CHOICE.print();
                    continue;
                }
                GameMessage.SELECTED_NUMBERS.print(userSet.toString()) ;
                int matchCount = resultChecker.getMatchCount(randomSet, userSet);
                GameMessage.MATCH_COUNT.print(String.valueOf(matchCount));
                if (resultChecker.isJackpot(matchCount)) {
                    GameMessage.JACKPOT.print();
                } else if (matchCount > 0) {
                    GameMessage.MATCHED_NUMBERS.print
                            (resultChecker.getMatchingNumbers(randomSet,userSet).toString());
                }

                resultChecker.updateBestCombinations(userSet,
                        matchCount, bestMatchCount, bestCombinations);
                if (matchCount > bestMatchCount) {
                    bestMatchCount = matchCount;
                }
            }

            GameMessage.BEST_RESULT.print(bestMatchCount + GameMessage.AMOUNT.getMessage() ) ;
            for (Set<Integer> combination : bestCombinations) {
                GameMessage.COMBINATION.print(combination.toString());
            }
            GameMessage.RANDOM_NUMBERS.print(randomSet.toString());
        }
    }
}
