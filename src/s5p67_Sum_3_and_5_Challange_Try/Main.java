package s5p67_Sum_3_and_5_Challange_Try;

public class Main {

    public static void main(String args[]) {
        int sum = 0;
        int count = 0;
        for (int n = 1; n <= 1000; n++) {
            if (n % 3 == 0 && n % 5 == 0) {
                count++;
                System.out.println("#" + count + ":  " + n);
                sum = sum + n;
                if (count == 5) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }

}