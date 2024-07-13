import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public Set<Integer> getUserNumbers(){
        Set<Integer> userSet = new TreeSet<>();
        System.out.println("Введите 6 чисел от 1 до 45 :");
        while (userSet.size() < 6) {
            userSet.add(scanner.nextInt());
        }
        return userSet;
    }

    public int getSelection(){
        System.out.println("\nВыберите что вы хотите : ");
        System.out.println("1. Вводить числа самостоятельно");
        System.out.println("2. Или предоставить это дело компьютеру");
        System.out.println("3. Выход");
        return scanner.nextInt();
    }

    public int getNumCombinations(){
        System.out.println("Введите количество комбинаций, которые вы хотите ввести/сгенерировать:");
        return scanner.nextInt();
    }
}
