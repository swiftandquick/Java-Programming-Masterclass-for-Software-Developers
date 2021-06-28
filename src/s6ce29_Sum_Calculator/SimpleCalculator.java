package s6ce29_Sum_Calculator;

public class SimpleCalculator {

    private double firstNumber;
    private double secondNumber;

    /* Getter:  Retrieve the value of the object's attribute.  */
    public double getFirstNumber() {
        return firstNumber;
    }


    public double getSecondNumber() {
        return secondNumber;
    }


    /* Setter:  Set the value of the object's attribute.  this.firstNumber stores attribute's value in instance variable.  */
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }


    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }


    /* Return the sum of two instance variable.  */
    public double getAdditionResult() {
        return firstNumber + secondNumber;
    }


    public double getSubtractionResult() {
        return firstNumber - secondNumber;
    }


    public double getMultiplicationResult() {
        return firstNumber * secondNumber;
    }


    public double getDivisionResult() {
        if (secondNumber == 0) {
            return 0;
        }
        else {
            return firstNumber / secondNumber;
        }
    }
}
