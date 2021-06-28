package s5ce26_Diagonal_Star_b;

public class DiagonalStar {

    public static void printSquareStar(int n) {
        if (n < 5) {
            System.out.println("Invalid Value");
        }
        else {
            /* For rows.  */
            for (int i = 1; i <= n; i++) {

                /* For columns.  */
                for (int j = 1; j <= n; j++) {
                    if (i == 1 || j == 1 || i == n || j == n ||
                        i == j || i + j == n + 1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }

                /* Create a new row.  */
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        printSquareStar(4);
        printSquareStar(5);
        printSquareStar(8);
    }

}
