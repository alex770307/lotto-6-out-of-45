/**
 * Проект - классическая лотерея
 * <p>
 * Программа при запуске генерирует 6 уникальных чисел (от 1 до 45)
 * <p>
 * У Пользователя есть возможность вводить самостоятельно 6 чисел, либо их генерировать.
 * <p>
 * Программа определяет, сколько чисел пользователь угадал и выводит результат.
 * В случае попадания во все 6 цифр - сообщает о джекпоте.
 * <p>
 * Есть возможность множественного ввода комбинаций цифр.
 * Соответственно, при выводе информации, так-же выводится самая удачная комбинация.
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