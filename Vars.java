public class Vars {
    private double constant;
    private double exponent;
    private char varName;

    public Vars(double constant, char varName, double exponent) {
        this.constant = constant;
        this.varName = varName;
        this.exponent = exponent;
    }

    /**
     * Gets the exponent of the vars
     * 
     * @return the exponent of the vars
     */
    public double getExponent() {
        return exponent;
    }

    /**
     * Changes the exponent of vars
     * 
     * @param exponent The new exponent double
     */
    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    /**
     * Gets the name of the variable in vars object
     * 
     * @return the name of the variable
     */
    public char getVarName() {
        return varName;
    }

    /**
     * Changes the variable name of the vars object
     * 
     * @param varName The new name of the variable
     */
    public void setVarName(char varName) {
        this.varName = varName;
    }

    /**
     * Gets the constant number of the vars object
     * 
     * @return the constant number in the vars object
     */
    public double getConstant() {
        return constant;
    }

    /**
     * Changes the constant number in a vars object
     * 
     * @param constant the new constant number
     */
    public void setConstant(double constant) {
        this.constant = constant;
    }

    /**
     * Changes the vars to string object
     * 
     * @return the string object of the vars object
     */
    @Override
    public String toString() {
        if (constant == 0 || exponent == 0) {
            return constant + "";
        } else if (constant == 1 && exponent == 1) {
            return varName + "";
        } else if (constant == -1) {
            return "-" + varName + "";
        } else if (constant == 1.0) {
            return varName + "^" + exponent;
        } else if (exponent == 1.0) {
            return constant + "" + varName;
        } else {
            return constant + "*(" + varName + "^" + exponent + ")";
        }
    }

    /**
     * Solves the funct based on the number
     * 
     * @param X plug in number
     * @return the evaluation of the plugging in X
     */
    public double solveForX(double X) {
        double y1 = Math.pow(X, exponent);
        y1 = constant * y1;
        return y1;
    }

}
