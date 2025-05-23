public class test {
    public static void main(String[] args) {
        Funct quad = PresetEquations.volumeSphere();
        System.out.println("r = 3");
        quad.addVariableRule('r', 3);
        System.out.println("v = " + quad);
        System.out.println("v = " + quad.multiVariableEvaluation());
        
    }
}
