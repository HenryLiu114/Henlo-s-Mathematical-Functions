import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Funct {
    private LinkedList<Vars> function;
    private LinkedList<String> symbol;
    private HashMap<Character, Double> rules;
    
    public Funct(){
        function = new LinkedList<>();
        symbol = new LinkedList<>();
        rules = new HashMap<>();
    }

    public void addVarToFunct(double constant, char varName, double exponent){
        function.add(new Vars(constant, varName, exponent));        
    }

    public void addSign(String sign){
        switch(sign){
            case "+", "-", "*", "/", "^", "sin[", "cos[", "tan[", "(",")", "]":
                symbol.add(sign);
                break;
            case "sin", "cos", "tan":
                symbol.add(sign + "[");
                break;
            default:
                System.out.println("Cannot add operator");
        }
    }

    public int functionSize(){
        return function.size();
    }

    @Override
    public String toString(){
        String arr[] = this.toArray();
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res = res + arr[i] + " ";
        }
        return res;
    }

    public String[] toArray(){
        String[] args = new String[function.size()+symbol.size()];
        Queue<Vars> q1 = copyOfFunctionArray();
        Queue<String> q2 = copyOfSymbolArray();
        int index = 0;
        while(!q2.isEmpty() || index > args.length){
            String i = q2.peek();
            switch(i){
                case "(", "sin[", "cos[", "tan[":
                    args[index] = q2.remove();
                    index++;
                    break;
                case ")", "]":
                    args[index] = q1.remove()+"";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    if(!q2.isEmpty()){
                        args[index] = q2.remove();
                        index++;
                    }
                break;
                default:
                    args[index] = q1.remove()+"";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    break;
            }
        }
        while(!q1.isEmpty()){
            args[index] = q1.remove()+"";
            index++;
        }
        return args;
    }

    public void addVariableRule(char var, double num){
        rules.put(var, num);
    }

    public double multiVariableEvaluation(){
        String[] n = toMultiEvaluatedArray();
        String[] eval = Expression.convertToPostfix(n);
        double res = Expression.evaluatePostfix(eval);
        return res;
    }

    public String[] toMultiEvaluatedArray(){
        LinkedList<Double> eval = new LinkedList<>();
        for(int i = 0; i < function.size(); i++){
            double plugIn = rules.get(function.get(i).getVarName());
            eval.add(function.get(i).solveForX(plugIn));
        }

        String[] args = new String[eval.size()+symbol.size()];
        Queue<Double> q1 = eval;
        Queue<String> q2 = copyOfSymbolArray();
        int index = 0;
        while(!q2.isEmpty() || index > args.length){
            String i = q2.peek();
            switch(i){
                case "(", "sin[", "cos[", "tan[":
                    args[index] = q2.remove();
                    index++;
                    break;
                case ")", "]":
                    args[index] = q1.remove()+"";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    if(!q2.isEmpty()){
                        args[index] = q2.remove();
                        index++;
                    }
                break;
                default:
                    args[index] = q1.remove()+"";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    break;
            }
        }
        while(!q1.isEmpty()){
            args[index] = q1.remove()+"";
            index++;
        }

        return args;
    }

    public double evaluateX(char variable, double X){
        String[] n = toEvaluatedArray(variable, X);
        String[] eval = Expression.convertToPostfix(n);
        double res = Expression.evaluatePostfix(eval);
        return res;
    }

    public String[] toEvaluatedArray(char variable, double X){
        LinkedList<Double> eval = new LinkedList<>();
        rules.put(variable, X);
        for(int i = 0; i < function.size(); i++){
            double plugIn = rules.get(function.get(i).getVarName());
            eval.add(function.get(i).solveForX(plugIn));
        }

        String[] args = new String[eval.size()+symbol.size()];
        Queue<Double> q1 = eval;
        Queue<String> q2 = copyOfSymbolArray();
        int index = 0;
        while(!q2.isEmpty() || index > args.length){
            String i = q2.peek();
            switch(i){
                case "(", "sin[", "cos[", "tan[":
                    args[index] = q2.remove();
                    index++;
                    break;
                case ")", "]":
                    args[index] = q1.remove()+"";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    if(!q2.isEmpty()){
                        args[index] = q2.remove();
                        index++;
                    }
                break;
                default:
                    args[index] = q1.remove()+"";
                    index++;
                    args[index] = q2.remove();
                    index++;
                    break;
            }
        }
        while(!q1.isEmpty()){
            args[index] = q1.remove()+"";
            index++;
        }

        return args;
    }

    private LinkedList<Vars> copyOfFunctionArray(){
        LinkedList<Vars> copy = new LinkedList<>();
        for(int i = 0; i < function.size(); i++){
            copy.add(function.get(i));
        }
        return copy;
    }

    private LinkedList<String> copyOfSymbolArray(){
        LinkedList<String> copy = new LinkedList<>();
        for(int i = 0; i < symbol.size(); i++){
            copy.add(symbol.get(i));
        }
        return copy;
    }
}
