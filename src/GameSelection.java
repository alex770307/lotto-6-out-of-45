public enum GameSelection {
    INPUT(1),
    GENERATION(2),
    EXIT(3);

    private int choice;

    GameSelection(int selection) {
        this.choice = selection;
    }

    public int getChoice() {
        return choice;
    }
}
