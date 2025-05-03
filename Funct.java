import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Funct {
    private LinkedList<Vars> function;
    private LinkedList<String> symbol;
    private HashMap<Character, Double> rules;

    public Funct() {
        function = new LinkedList<>();
        symbol = new LinkedList<>();
        rules = new HashMap<>();
    }

    /**
     * Adds a new variable object to the fucntion
     * Function = n*(x^b)
     * 
     * @param constant n, a constant double number
     * @param varName  x, variable
     * @param exponent b, exponent number
     */
    public void addVarToFunct(double constant, char varName, double exponent) {
        function.add(new Vars(constant, varName, exponent));
    }

    /**
     * Puts operators in the symbol list
     * 
     * @param sign an operator
     */
    public void addSign(String sign) {
        switch (sign) {
            case "+", "-", "*", "/", "^", "sin[", "cos[", "tan[", "(", ")", "]":
                symbol.add(sign);
                break;
            case "sin", "cos", "tan":
                symbol.add(sign + "[");
                break;
            default:
                System.out.println("Cannot add operator");
        }
    }

    /**
     * Total number of variables in the function
     * 
     * @return the function size
     */
    public int functionSize() {
        return function.size();
    }

    /**
     * Automatically formats function to a string object
     * 
     * @return the string object of the function
     */
    @Override
    public String toString() {
        String arr[] = this.toArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = res + arr[i] + " ";
        }
        return res;
    }

    /**
     * Transforms the Function to an array
     * 
     * @return Function formatted as an array
     */
    public String[] toArray() {
        String[] args = new String[function.size() + symbol.size()];
        Queue<Vars> q1 = copyOfFunctionArray();
        Queue<String> q2 = copyOfSymbolArray();
        int index = 0;
        while (!q2.isEmpty() || index > args.length) {
            String i = q2.peek();
            switch (i) {
                case "(", "sin[", "cos[", "tan[":
                    args[index] = q2.remove();
                    index++;
                    break;
                case ")", "]":
                    args[index] = q1.remove() + "";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    if (!q2.isEmpty()) {
                        args[index] = q2.remove();
                        index++;
                    }
                    break;
                default:
                    args[index] = q1.remove() + "";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    break;
            }
        }
        while (!q1.isEmpty()) {
            args[index] = q1.remove() + "";
            index++;
        }
        return args;
    }

    /**
     * Adds a new variable rule
     * EX: x = 10
     * 
     * @param var the specified variable
     * @param num a number
     */
    public void addVariableRule(char var, double num) {
        rules.put(var, num);
    }

    /**
     * Evaluates using all of the variable rules
     * 
     * @return the final calculations
     */
    public double multiVariableEvaluation() {
        String[] n = toMultiEvaluatedArray();
        String[] eval = Expression.convertToPostfix(n);
        double res = Expression.evaluatePostfix(eval);
        return res;
    }

    /**
     * Calculates using variable rules, then formats funct to array
     * 
     * @return The Array of the function
     */
    public String[] toMultiEvaluatedArray() {
        LinkedList<Double> eval = new LinkedList<>();
        for (int i = 0; i < function.size(); i++) {
            double plugIn = rules.get(function.get(i).getVarName());
            eval.add(function.get(i).solveForX(plugIn));
        }

        String[] args = new String[eval.size() + symbol.size()];
        Queue<Double> q1 = eval;
        Queue<String> q2 = copyOfSymbolArray();
        int index = 0;
        while (!q2.isEmpty() || index > args.length) {
            String i = q2.peek();
            switch (i) {
                case "(", "sin[", "cos[", "tan[":
                    args[index] = q2.remove();
                    index++;
                    break;
                case ")", "]":
                    args[index] = q1.remove() + "";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    if (!q2.isEmpty()) {
                        args[index] = q2.remove();
                        index++;
                    }
                    break;
                default:
                    args[index] = q1.remove() + "";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    break;
            }
        }
        while (!q1.isEmpty()) {
            args[index] = q1.remove() + "";
            index++;
        }

        return args;
    }

    /**
     * Evaluates the function with an inputted variable rule
     * and current variable rules
     * 
     * @param variable the specifed variable
     * @param X        A number to substitute
     * @return The final evaluation of the variable rules
     */
    public double evaluateX(char variable, double X) {
        String[] n = toEvaluatedArray(variable, X);
        String[] eval = Expression.convertToPostfix(n);
        double res = Expression.evaluatePostfix(eval);
        return res;
    }

    /**
     * Calculates using variable rules and a inputted variable rule,
     * then formats funct to array
     * 
     * @param variable the specifed variable
     * @param X        A number to substitute
     * @return an array of the evaluated function
     */
    public String[] toEvaluatedArray(char variable, double X) {
        LinkedList<Double> eval = new LinkedList<>();
        rules.put(variable, X);
        for (int i = 0; i < function.size(); i++) {
            double plugIn = rules.get(function.get(i).getVarName());
            eval.add(function.get(i).solveForX(plugIn));
        }

        String[] args = new String[eval.size() + symbol.size()];
        Queue<Double> q1 = eval;
        Queue<String> q2 = copyOfSymbolArray();
        int index = 0;
        while (!q2.isEmpty() || index > args.length) {
            String i = q2.peek();
            switch (i) {
                case "(", "sin[", "cos[", "tan[":
                    args[index] = q2.remove();
                    index++;
                    break;
                case ")", "]":
                    args[index] = q1.remove() + "";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    if (!q2.isEmpty()) {
                        args[index] = q2.remove();
                        index++;
                    }
                    break;
                default:
                    args[index] = q1.remove() + "";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    break;
            }
        }
        while (!q1.isEmpty()) {
            args[index] = q1.remove() + "";
            index++;
        }

        return args;
    }

    /**
     * Copys the function linked list
     * 
     * @return a copy of the linked list attribute function
     */
    private LinkedList<Vars> copyOfFunctionArray() {
        LinkedList<Vars> copy = new LinkedList<>();
        for (int i = 0; i < function.size(); i++) {
            copy.add(function.get(i));
        }
        return copy;
    }

    /**
     * Copys the symbol linked list
     * 
     * @return a copy of the linked list attribute symbol
     */
    private LinkedList<String> copyOfSymbolArray() {
        LinkedList<String> copy = new LinkedList<>();
        for (int i = 0; i < symbol.size(); i++) {
            copy.add(symbol.get(i));
        }
        return copy;
    }
}
