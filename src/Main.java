public class Main {

    public static void main(String[] args) {
        DFA dfa = new DFA("01");
        dfa.addStates(1, true);
        dfa.addStates(3, false);
        dfa.connectStates(0, 1, '1');
        dfa.connectStates(0, 2, '0');
        dfa.connectStates(1, 0, '1');
        dfa.connectStates(1, 3, '0');
        dfa.connectStates(2, 3, '1');
        dfa.connectStates(2, 0, '0');
        dfa.connectStates(3, 2, '1');
        dfa.connectStates(3, 1, '0');
        System.out.println("0011 - " + dfa.validString("0011"));
        System.out.println("00111111 - " + dfa.validString("00111111"));
        System.out.println("01100 - " + dfa.validString("01100"));
        System.out.println("100111000110011001111000 - " + dfa.validString("100111000110011001111000"));
        System.out.println("101010 - " + dfa.validString("10101"));
        System.out.println("1 - " + dfa.validString("1"));
        System.out.println(" - " + dfa.validString(""));
    }

}
