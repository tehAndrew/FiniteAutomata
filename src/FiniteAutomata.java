public interface FiniteAutomata {
    void addStates(int amount, boolean accepting);
    void connectStates(int indexFrom, int indexTo, char symbol);
    boolean validString(String string);
}
