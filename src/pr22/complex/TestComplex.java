package pr22.complex;

import pr22.complex.Complex;
import pr22.complex.ConcreteFactory;

public class TestComplex {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        Complex z1 = factory.CreateComplex(1, -1);
        System.out.println(z1);
        Complex z2 = factory.createComplex();
        System.out.println(z2);
    }
}
