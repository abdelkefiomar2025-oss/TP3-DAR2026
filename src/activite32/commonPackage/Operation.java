package activite32.commonPackage;

import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    private double a;
    private double b;
    private char operateur;

    public Operation(double a, char operateur, double b) {
        this.a = a;
        this.operateur = operateur;
        this.b = b;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public char getOperateur() { return operateur; }
}