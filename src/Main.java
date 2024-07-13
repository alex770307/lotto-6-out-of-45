
import java.util.*;

/**
 * Программа при запуске генерирует 6 чисел из 45 (от 1 до 45),
 * числа должны быть уникальные.
 * Пользователь вводит свои 6 вариантов чисел.
 * Программа определяет, сколько чисел пользователь угадал и выводит результат.
 * В случае попадания во все 6 цифр - сообщает о джекпоте.
 */
public class Main {
    public static void main(String[] args) {
       //Scanner scanner = new Scanner(System.in);

        LotteryNumberGenerator generator = new LotteryNumberGenerator();
        UserInput userInput = new UserInput();
        ResultChecker resultChecker = new ResultChecker();
        Set<Integer> randomSet = generator.generateNumbers();

        System.out.println("\nДобро пожадовать в Лото 6 из 45!");
        while (true) {

            int selection = userInput.getSelection();

            if (selection == 3) {
                System.out.println("Выход из программы.");
                break; // Завершение выполнения цикла и программы
            }

            int numCombinations = userInput.getNumCombinations();

            int bestMatchCount = 0;

            List<Set<Integer>> bestCombinations = new ArrayList<>();

            for (int i = 0; i < numCombinations; i++) {
                Set<Integer> userSet = new TreeSet<>();

                if (selection == 1) {
                    userSet = userInput.getUserNumbers();
                } else if (selection == 2) {
                    userSet = generator.generateNumbers();
                } else {
                    System.out.println("Неверный выбор.");
                    continue; // Переход к следующей итерации цикла
                }

                System.out.println("Вы выбрали следующие числа : " + userSet);

                List<Integer> list  = resultChecker.getMatchingNumbers(randomSet,userSet);

                int matchCount = resultChecker.getMatchCount(randomSet,userSet);
                System.out.println("Количество угаданных чисел : " + matchCount);
                if (matchCount == randomSet.size()) {
                    System.out.println("!!!JACKPOT!!!");
                } else if (matchCount > 0) {
                    System.out.println("Вам удалось угадать число(а) : " + list);
                }

                if (matchCount > bestMatchCount) {
                    bestMatchCount = matchCount;
                    bestCombinations.clear();
                    bestCombinations.add(userSet);
                } else if (matchCount == bestMatchCount) {
                    bestCombinations.add(userSet);
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