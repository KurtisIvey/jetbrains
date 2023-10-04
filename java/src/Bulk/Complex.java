package Bulk;

public class Complex {
    double real;
    double image;

    public void add(Complex num) {
        // num is itself an instance of complex class, so it must reference .real & .image
        this.real += num.real;
        this.image += num.image;
    }

    public void subtract(Complex num) {
        this.real -= num.real;
        this.image -= num.image;
    }
}
