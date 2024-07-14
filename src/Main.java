
import java.util.*;

/**
 * Проект - классическая лотерея
 * Программа при запуске генерирует 6 чисел из 45 (от 1 до 45),
 * числа должны быть уникальные.
 * Пользователь вводит свои 6 вариантов чисел.
 * Программа определяет, сколько чисел пользователь угадал и выводит результат.
 * В случае попадания во все 6 цифр - сообщает о джекпоте.
 * Доп. задание:
 * Добавить возможность множественного выбора цифр (можно выбрать несколько раз по 6 цифр).
 * Соответственно, выбрать среди всех комбинаций - самую удачную
 */
public class Main {
    public static void main(String[] args) {

        LotteryNumberGenerator generator = new LotteryNumberGenerator();
        UserInput userInput = new UserInput();
        ResultChecker resultChecker = new ResultChecker();

        Game game = new Game(generator,userInput,resultChecker);
        game.start();

    }
}