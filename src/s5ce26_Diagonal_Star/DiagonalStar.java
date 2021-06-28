package s5ce26_Diagonal_Star;

public class DiagonalStar {

    public static void printSquareStar(int n) {
        if (n < 5) {
            System.out.println("Invalid Value");
        }
        else {
            // Loop denoting rows.
            for (int i = 0; i < n; i++) {

                // Loop denoting columns.
                for (int j = 0; j < n; j++) {

                    /* Checking boundary conditions and main diagonal and secondary diagonal conditions.
                    * i == 0:  First row.  j == 0:  First column.  i == n - 1:  Last row.  j == n - 1:  Last column.
                    * i == j:  When row # and column # are the same, print * when both row (i) and column (j) are 3.
                    * This part of the conditional statement helps to print out * from top-left to bottom-right.
                     * i + j == n - 1:  For example, i = 1, j = 6, i + j = 7, which equal to n - 1, with n being 8.
                    * This part of the conditional statement helps to print out * from top-right to bottom-left.  */
                    if (i == 0 || j == 0 || i == j
                            || i == n - 1 || j == n - 1
                            || i + j == n - 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        printSquareStar(5);
        printSquareStar(8);
    }

}
