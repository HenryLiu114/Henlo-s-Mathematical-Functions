public class PresetEquations {
    public static Funct pythTheoremHyp(){
        Funct pyth = new Funct();
        pyth.addSign("(");
        pyth.addVarToFunct(1, 'a', 2);
        pyth.addSign("+");
        pyth.addVarToFunct(1, 'b', 2);
        pyth.addSign(")");
        pyth.addSign("^");
        pyth.addVarToFunct(0.5, 'c', 0);
        pyth.addVariableRule('c', 1);
        return pyth;
    }

    public static Funct pythTheoremLeg(){
        Funct pyth = new Funct();
        pyth.addSign("(");
        pyth.addVarToFunct(1, 'c', 2);
        pyth.addSign("-");
        pyth.addVarToFunct(1, 'b', 2);
        pyth.addSign(")");
        pyth.addSign("^");
        pyth.addVarToFunct(0.5, 'a', 0);
        pyth.addVariableRule('a', 1);
        return pyth;
    }

    public static Funct linearEquation(double slope, double constant){
        Funct lin = new Funct();
        lin.addVarToFunct(slope, 'x', 1);
        lin.addSign("+");
        lin.addVariableRule('b', 1);
        lin.addVarToFunct(constant, 'b', 0);
        return lin;
    }

    public static Funct quadradicEquation(double aConstant, double bConstant, double cConstant){
        Funct quad = new Funct();
        quad.addVarToFunct(aConstant, 'x', 2);
        quad.addSign("+");
        quad.addVarToFunct(bConstant, 'x', 1);
        quad.addSign("+");
        quad.addVarToFunct(cConstant, 'x', 0);
        return quad;
    }

    public static Funct quadradicFormulaUpper(){
        Funct quad = new Funct();
        quad.addSign("(");
        quad.addVarToFunct(-1, 'b', 1);
        quad.addSign("+");
        quad.addSign("(");
        quad.addVarToFunct(1, 'b', 2);
        quad.addSign("-");
        quad.addVarToFunct(4, 'a', 1);
        quad.addSign("*");
        quad.addVarToFunct(1, 'c', 1);
        quad.addSign(")");
        quad.addSign("^");
        quad.addVarToFunct(0.5, 'b', 0);
        quad.addSign(")");
        quad.addSign("/");
        quad.addSign("(");
        quad.addVarToFunct(2, 'a', 1);
        quad.addSign(")");
        return quad;
    }

    public static Funct areaSquare(){

    }

    public static Funct areaRectangle(){
        
    }

    public static Funct areaTriangle(){
        
    }

    public static Funct areaCircle(){
        
    }

    public static Funct volumeCylinder(){
        
    }

    public static Funct volumeSphere(){
        
    }

    public static Funct volumeCube(){
        
    }

    public static Funct circumference(){
        
    }

    public static Funct areaSquare(){
        
    }


}
