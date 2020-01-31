import javafx.util.Pair;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class DFA implements FiniteAutomata {
    private String alphabet;
    private ArrayList<Boolean> stateProps;
    private HashMap<Pair<Integer, Character>, Integer> transitionMap;

    private void checkValidSymbol(char symbol) {
        if (alphabet.indexOf(symbol) == -1) {
            throw new InvalidParameterException("The symbol '" + symbol + "' is not in alphabet \"" + alphabet + "\".");
        }
    }

    private int transition(int state, char symbol) {
        return transitionMap.get(new Pair<>(state, symbol));
    }

    public DFA(String alphabet) {
        this.alphabet = alphabet;
        stateProps = new ArrayList<>();
        transitionMap = new HashMap<>();
    }

    @Override
    public void addStates(int amount, boolean accepting) {
        for (int i = 0; i < amount; i++) {
            stateProps.add(accepting);
        }
    }

    @Override
    public void connectStates(int indexFrom, int indexTo, char symbol) {
        checkValidSymbol(symbol);

        if (indexFrom < 0 || indexFrom >= stateProps.size() || indexTo < 0 || indexTo >= stateProps.size()) {
            throw new InvalidParameterException("Either q" + indexFrom + " or q" + indexTo + " is not a valid state.");
        }

        transitionMap.put(new Pair<>(indexFrom, symbol), indexTo);
    }

    @Override
    public boolean validString(String string) {
        int currentState = 0;

        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            checkValidSymbol(symbol);
            currentState = transition(currentState, symbol);
        }

        return stateProps.get(currentState);
    }
}