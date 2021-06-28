package s6ce34_Complex_Operations;

public class Main {

    public static void main(String[] args) {
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);

        /* one = one + (1.0 + 1.0i):  (1.0 + 1.0i) + (1.0 + 1.0i) = 2.0 + 2.0i */
        one.add(1,1);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());

        /* one = one - number:  (2.0 + 2.0i) - (2.5i + -1.5i) = -0.5 + 3.5i */
        one.subtract(number);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());

        /* number = number - one:  (2.5 + -1.5i) - (-0.5 + 3.5i) = 3.0 + -5.0i */
        number.subtract(one);
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());
    }

}
