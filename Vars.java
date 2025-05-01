public class Vars {
    private double constant;
    private double exponent;
    private char varName;

    public Vars(double constant, char varName, double exponent){
        this.constant = constant;
        this.varName = varName;
        this.exponent = exponent;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    public char getVarName() {
        return varName;
    }

    public void setVarName(char varName) {
        this.varName = varName;
    }

    public double getConstant() {
        return constant;
    }

    public void setConstant(double constant) {
        this.constant = constant;
    }

    @Override
    public String toString(){
        if(constant == 0 || exponent == 0){
            return constant+"";
        }
        else if(constant == 1 && exponent == 1){
            return varName+"";
        }
        else if(constant == -1){
            return "-"+varName+"";
        }
        else if(constant == 1.0){
            return varName + "^" + exponent;
        }
        else if(exponent == 1.0){
            return constant + "" + varName;
        }
        else {
            return constant + "*(" + varName + "^" + exponent + ")";
        }
    }

    public double solveForX(double X){
        double y1 = Math.pow(X, exponent);
        y1 = constant * y1;
        return y1;
    }


}
