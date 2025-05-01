//
// Name: Liu, Henry
// Project: #2
// Due: 10/21/2024
// Course: cs-2400-01-f24
//
// Description:
// Formats and Evaluates infix expressions into postfix expressions
//

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Expression {
    /**
     * Converts a infix array into a postfix array
     * @param infix The desired array that is converted
     * @return An array of string formatted into postfix format.
     *         Throws RuntimeException otherwise.
     */
    public static String[] convertToPostfix(String[] infix){
        Stack<String> operatorStack = new Stack<>();
        Stack<String> postStack = new Stack<>(); 
        String[] result = new String[infix.length];
        String x1; 
        String x2;
        String curOp; 
        int trueLength = 0; 
        boolean hasNumBefore = false;
        for(String i : infix){
            switch(i){
                case "]":
                    hasNumBefore = false;
                    curOp = operatorStack.pop();
                    while(!(curOp.equals("sin[")) && !(curOp.equals("cos[")) && !(curOp.equals("tan["))){
                        x2 = postStack.pop();
                        x1 = postStack.pop();
                        postStack.push(x1);
                        postStack.push(x2);
                        postStack.push(curOp);
                        curOp = operatorStack.pop();
                    }
                    postStack.push(curOp.substring(0, 3));
                    trueLength++;
                    break;
                case "(", "sin[", "cos[", "tan[":
                    operatorStack.push(i);
                    hasNumBefore = false;
                    break;
                case ")":
                    hasNumBefore = false;
                    curOp = operatorStack.pop();
                    while(!(curOp.equals("("))){
                        x2 = postStack.pop();
                        x1 = postStack.pop();
                        postStack.push(x1);
                        postStack.push(x2);
                        postStack.push(curOp);
                        curOp = operatorStack.pop();
                    }
                    break;
                case "*", "/", "+", "-", "^":
                    hasNumBefore = false;
                    trueLength++;
                    while (!operatorStack.isEmpty() && findPresedence(i) <= findPresedence(operatorStack.peek()) && findPresedence(operatorStack.peek()) != 3){
                        if(findPresedence(i) != -1 || findPresedence(operatorStack.peek()) != -1){
                            curOp = operatorStack.pop();
                            x2 = postStack.pop();
                            x1 = postStack.pop();
                            postStack.push(x1);
                            postStack.push(x2);
                            postStack.push(curOp);
                        } 
                    }
                    
                    operatorStack.push(i);
                    break;
                default:
                    try{
                        Double.parseDouble(i);
                    }
                    catch(NumberFormatException e){
                        throw new RuntimeException("Invaild Format!!");
                    }
                    if(hasNumBefore){
                        String trueNum = postStack.pop() + i;
                        postStack.push(trueNum);
                    }
                    else{
                        trueLength++;
                        postStack.push(i);
                        hasNumBefore = true;
                    }
                    break;
                    
             }
        }
            while(!operatorStack.isEmpty()){
                curOp = operatorStack.pop();
                x2 = postStack.pop();
                x1 = postStack.pop();
                postStack.push(x1);
                postStack.push(x2);
                postStack.push(curOp);
            }
        result = Arrays.copyOf(result, trueLength);
        for(int i = result.length-1; i >= 0; i--){
            result[i] = postStack.pop();
        }
        return result;
    }
    
    /**
     * Evauates a postfix expression
     * @param postfix The desired array that is evaluated
     * @return The result of the postfix expression in the 
     *         form of an int, throws a RuntimeException
     *         otherwise.
     */
    public static double evaluatePostfix(String[] postfix){
        double result = 0;
        Stack<Double> valueStack = new Stack<>();
        double x1;
        double x2;
        for(String i : postfix){
            switch (i) {
                case "sin":
                    x1 = valueStack.pop();
                    valueStack.push(Math.sin(x1));
                    break;
                case "cos":
                    x1 = valueStack.pop();
                    valueStack.push(Math.cos(x1));
                    break;
                case "tan":
                    x1 = valueStack.pop();
                    valueStack.push(Math.tan(x1));
                    break;
                case "+":
                    try{
                        x2 = valueStack.pop();
                        x1 = valueStack.pop();
                        valueStack.push(x1+x2);
                    }
                    catch(NoSuchElementException e){
                        throw new RuntimeException("Invaild Format!");
                    }
                    break;
                case "-":
                    try{
                        x2 = valueStack.pop();
                        x1 = valueStack.pop();
                        valueStack.push(x1-x2);
                    }
                    catch(NoSuchElementException e){
                        throw new RuntimeException("Invaild Format!");
                    }
                    break;
                case "*":
                    try{
                        x2 = valueStack.pop();
                        x1 = valueStack.pop();
                        valueStack.push(x1*x2);
                    }
                    catch(NoSuchElementException e){
                        throw new RuntimeException("Invaild Format!");
                    }
                    break;
                case "/":
                    try{
                        x2 = valueStack.pop();
                        x1 = valueStack.pop();
                        valueStack.push(x1/x2);
                    }
                    catch(NoSuchElementException e){
                        throw new RuntimeException("Invaild Format!");
                    }
                    break;
                case "^":
                    try{
                    x2 = valueStack.pop();
                    x1 = valueStack.pop();
                    valueStack.push(Math.pow(x1, x2));
                    }
                    catch(NoSuchElementException e){
                        throw new RuntimeException("Invaild Format!");
                    }
                    break;
                default:
                    try{
                        valueStack.push(Double.parseDouble(i));                    
                    }
                    catch(NumberFormatException e){
                        throw new RuntimeException("Not an integer");
                    }
                    break;
            }
        }
        result = valueStack.pop();
        return result;
    }
    
    /**
     * Determines the presedence of an operation
     * @param i The desired operation to find the presedence
     * @return -1 if i is "(" or ")", 2 for "*" or "/", 1 for
     *          "+" or "-", or throws an NoSuchElementException
     *          otherwise.
     */
    private static int findPresedence(String i){
        switch(i){
            case "^":
            return 3;
            case "(", ")", "sin[", "cos[", "tan[", "]":
                return -1;
            case "*", "/":
                return 2;
            case "+", "-":
                return 1;
            
            default:
                throw new NoSuchElementException("String i is not a operator");
        }
    }   
}