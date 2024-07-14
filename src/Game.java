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
        System.out.println("\nДобро пожадовать в Лото 6 из 45!");
        while (true) {
            Set<Integer> randomSet = numberGenerator.generateNumbers();
            int selection = userInput.getSelection();
            if (selection == 3) {
                System.out.println("Выход из программы.");
                break;
            }

            int numCombinations = userInput.getNumCombinations();
            int bestMatchCount = 0;
            List<Set<Integer>> bestCombinations = new ArrayList<>();

            for (int i = 0; i < numCombinations; i++) {
                Set<Integer> userSet;
                if (selection == 1) {
                    userSet = userInput.getUserNumbers();
                } else if (selection == 2) {
                    userSet = numberGenerator.generateNumbers();
                } else {
                    System.out.println("Неверный выбор.");
                    continue;
                }

                System.out.println("Вы выбрали следующие числа : " + userSet);
                int matchCount = resultChecker.getMatchCount(randomSet, userSet);
                System.out.println("Количество угаданных чисел : " + matchCount);
                if (resultChecker.isJackpot(matchCount)) {
                    System.out.println("!!!JACKPOT!!!");
                } else if (matchCount > 0) {
                    System.out.println("Вам удалось угадать число(а) : "
                            + resultChecker.getMatchingNumbers(randomSet, userSet));
                }

                resultChecker.updateBestCombinations(userSet,
                        matchCount, bestMatchCount, bestCombinations);
                if (matchCount > bestMatchCount) {
                    bestMatchCount = matchCount;
                }
            }

            System.out.println("Наилучший результат: " + bestMatchCount + " угаданных чисел");
            for (Set<Integer> combination : bestCombinations) {
                System.out.println("Комбинация: " + combination);
            }
            System.out.println("Квази Случайно выпавшие числа :  " + randomSet);
        }
    }

}
