import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UserInput {

    private static final int COUNTER_MAX_VALUE = 6;
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public Set<Integer> getUserNumbers() {
        Set<Integer> userSet = new TreeSet<>();
        System.out.println("Введите 6 чисел от 1 до 45 :");
        while (userSet.size() < COUNTER_MAX_VALUE) {
            try {
                int number = scanner.nextInt();
                if (number >= 1 && number <= 45) {
                    userSet.add(number);
                } else {
                    System.out.println("Число должно быть в диапазоне от 1 до 45.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
        return userSet;
    }

    public int getSelection() {
        while (true) {
            try {
                System.out.println("\nВыберите что вы хотите: ");
                System.out.println("1. Вводить числа самостоятельно");
                System.out.println("2. Доверить это дело компьютеру");
                System.out.println("3. Закрыть приложение");
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка: вводите коректные значения!");
                System.out.println("Введите целое число от 1 до 3.");
                scanner.next();
            }
        }
    }

    public int getNumCombinations() {
        while (true) {
            try {
                System.out.println("Введите количество комбинаций, которые вы хотите ввести/сгенерировать:");
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }
}