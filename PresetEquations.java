public class PresetEquations {
    /**
     * C = ( a^2 + b^2 ) ^ 0.5
     * Add variable rules to 'a' and 'b'
     * @return C
     */
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

    /**
     * A = ( c^2 - b^2 ) ^ 0.5 
     * Add variable rules to 'c' and 'b'
     * @return A
     */
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

    /**
     * Y = mx + b
     * 'm' and 'b' are initialized
     * Add variable rules to 'x'
     * @param slope m
     * @param constant b
     * @return Y
     */
    public static Funct linearEquation(double slope, double constant){
        Funct lin = new Funct();
        lin.addVarToFunct(slope, 'x', 1);
        lin.addSign("+");
        lin.addVariableRule('b', 1);
        lin.addVarToFunct(constant, 'b', 0);
        return lin;
    }

    /**
     * Y = a*(x^2) + b*(x) + c
     * 'a', 'b', and 'c' are initialized
     * Add variable rules to 'x'
     * @param aConstant a
     * @param bConstant b
     * @param cConstant c
     * @return Y
     */
    public static Funct quadradicEquation(double aConstant, double bConstant, double cConstant){
        Funct quad = new Funct();
        quad.addVarToFunct(aConstant, 'x', 2);
        quad.addSign("+");
        quad.addVarToFunct(bConstant, 'x', 1);
        quad.addSign("+");
        quad.addVarToFunct(cConstant, 'x', 0);
        return quad;
    }

    /**
     * X = (-b+((b^2)-4*a*c)^0.5)/(2*a)
     * Add variable rules to 'a', 'b', and 'c'
     * @return X
     */
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

    /**
     * X = (-b-((b^2)-4*a*c)^0.5)/(2*a)
     * Add variable rules to 'a', 'b', and 'c'
     * @return X
     */
    public static Funct quadradicFormulaLower(){
        Funct quad = new Funct();
        quad.addSign("(");
        quad.addVarToFunct(-1, 'b', 1);
        quad.addSign("-");
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

    /**
     * A = s^2
     * Add variable rules to 's'
     * @return A
     */
    public static Funct areaSquare(){
        Funct area = new Funct();
        area.addVarToFunct(1, 's', 2);
        return area;
    }

    /**
     * A = b*h
     * Add variable rules to 'b' and 'h'
     * @return A
     */
    public static Funct areaRectangle(){
        Funct area = new Funct();
        area.addVarToFunct(1, 'b', 1);
        area.addSign("*");
        area.addVarToFunct(1, 'h', 1);
        return area;
    }

    /**
     * A = 0.5*b*h
     * Add variable rules to 'b' and 'h'
     * @return A
     */
    public static Funct areaTriangle(){
        Funct area = new Funct();
        area.addVarToFunct(0.5, 'b', 1);
        area.addSign("*");
        area.addVarToFunct(1, 'h', 1);
        return area;
    }

    /**
     * A = pi*(r^2)
     * Add variables to 'r'
     * @return A
     */
    public static Funct areaCircle(){
        Funct area = new Funct();
        area.addVarToFunct(Math.PI, 'r', 2);
        return area;
    }

    /**
     * V = pi*(r^2)*(2*h)
     * Add variables to 'r' and 'h'
     * @return V
     */
    public static Funct volumeCylinder(){
        Funct area = new Funct();
        area.addVarToFunct(Math.PI, 'r', 2);
        area.addSign("*");
        area.addVarToFunct(2, 'h', 1);
        return area;
    }

    /**
     * V = (4/3)*pi*(r^3)
     * Add variables to 'r'
     * @return A
     */
    public static Funct volumeSphere(){
        Funct volume = new Funct();
        double num = (4.0/3.0);
        num = num * Math.PI;
        volume.addVarToFunct(num, 'r', 3);
        return volume;
    }

    /**
     * V = s^3
     * Add variables to 's'
     * @return V
     */
    public static Funct volumeCube(){
        Funct area = new Funct();
        area.addVarToFunct(1, 's', 3);
        return area;
    }

    /**
     * C = 2*pi*r
     * Add variables to 'r'
     * @return A
     */
    public static Funct circumference(){
        Funct circumference = new Funct();
        double num = 2*Math.PI;
        circumference.addVarToFunct(num, 'r', 1);
        return circumference;
    }
}
