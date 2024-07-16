public enum GameMessage {
    WELCOME("\nДобро пожаловать в Лото 6 из 45!"),
    EXIT("Выход из программы."),
    INVALID_CHOICE("Неверный выбор."),
    SELECTED_NUMBERS("Вы выбрали следующие числа : "),
    MATCH_COUNT("Количество угаданных чисел : "),
    JACKPOT("!!!JACKPOT!!!"),
    MATCHED_NUMBERS("Вам удалось угадать число(а) : "),
    AMOUNT(" угаданное число / угаданных чисел(числа)"),
    BEST_RESULT("Наилучший результат: "),
    COMBINATION("Комбинация: "),
    RANDOM_NUMBERS("Квази Случайно выпавшие числа : ");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public void print(){
        System.out.println(message);
    }
    public void print(String value){
        System.out.println(message + value);
    }
    public String getMessage() {
        return message;
    }
}
