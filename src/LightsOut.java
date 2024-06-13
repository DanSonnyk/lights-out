import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//    Goal:
//    Arrange all pieces on a board such that cell on the board has a final value of 0.
//
//    Restrictions:
//    Board: each cell starts with an initial value and a Global "depth" value.
//    Placing a piece increments the valid value of overlapping cells on the board.
//    If a cell's value reaches the "depth" of the placed piece, it resets to 0.
//    The boards and pieces can have many shapes and sizes
//    All pieces needs to be used
//    The pieces cannot be rotated or exceed the board limits
//    The x,y seams columns, lines coordinates
//    After verify all pieces on the board returns the coordinate for each piece that all board = 0
public class LightsOut {

    public static final String PATHS = "input/%s.txt";

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Display the menu options
    displayMenu();

    // Loop to allow the user to choose options repeatedly
    boolean exit = false;
    while (!exit) {
        System.out.print("Select a file (01-10): ");
        String choice = scanner.nextLine();
        System.out.println("File chosen : "+choice);

    //Read File by param
        try {
            List<String> lines = Files.readAllLines(Paths.get(String.format(PATHS,choice)));

             lines.getFirst();

            //parse initialPieces to piece in matrix
            String[] pieces = lines.get(2).split(" ");

            //parse initial board to matrix
            String depth = lines.get(0);
            String[] rows = lines.get(1).split(",");
            List<List<Integer>> matrix = new ArrayList<>();


            for (String row : rows) {
                String[] stringRows = row.split("\\s+");
                List<Integer> intRow = new ArrayList<>();
                for (String stringRow : stringRows) {
                    for (char stringNum : stringRow.toCharArray()){
                        intRow.add(stringNum-'0');
                    }
                }

                matrix.add(intRow);
            }

            System.out.println();
            matrix.forEach(System.out::println);
            System.out.println();

            System.out.println("Depth: "+depth);
            System.out.println("Pieces: "+Arrays.toString(pieces));
            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Prompt the user to choose another option or exit
        System.out.print("Choose another file? (yes/no): ");
        String continueChoice = scanner.nextLine();
        if (!continueChoice.equalsIgnoreCase("yes")) {
            System.out.println("Exiting the program...");
            exit = true;
        }

    }

    scanner.close();
}

        // Method to display the menu options
        public static void displayMenu() {
            System.out.println("******************");
            System.out.println("Menu Files:");
            System.out.println("01 -> File 01");
            System.out.println("02 -> File 02");
            System.out.println("...");
            System.out.println("10 -> File 10");
            System.out.println("******************");
            System.out.println();
        }
}
