public class Main {
    public static void main(String[] args) {

        int[][] array = {
                {0, 0, 1},
                {0, 1, 1},
                {0, 1, 1}
        };

        //Considering x = line | y=colum of matrix
        // Iterate over each row
        for (int x = 0; x < array.length; x++) {
            // Iterate over each column in the current row
            for (int y = 0; y < array[x].length; y++) {
                // Print the element at current row and column where x = line | y=colum
                System.out.print(x + "," + y + "=" + array[x][y] + " ");
            }
            // Move to the next line after printing all elements in the row
            System.out.println();
        }

        System.out.println();

        //Considering x = colum | y=line of matrix
        // Iterate over each row
        for (int x = 0; x < array.length; x++) {
            // Iterate over each column in the current row
            for (int y = 0; y < array[x].length; y++) {
                // Print the element at current row and column where x = colum | y=line
                System.out.print(y + "," + x + "=" + array[x][y] + " ");
            }
            // Move to the next line after printing all elements in the row
            System.out.println();
        }
    }
}