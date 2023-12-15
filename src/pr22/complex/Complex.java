package pr22.complex;

public class Complex {
    private int real;
    private int image;

    public Complex(){
        this.real = 0;
        this.image = 1;
    }

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Re: " + real + " Im: " + image;
    }
}
