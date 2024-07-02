import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


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
public class Main {
    public static final String PATHS = "input/%s.txt";

    public void processCoordinates(String scenario){

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(String.format(PATHS,scenario)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String depth = lines.get(0);

        //parse initial rows to board
        String[] rows = lines.get(1).split(",");
        List<List<Integer>> board = new ArrayList<>();

        for (String row : rows) {
            String[] stringRows = row.split("\\s+");
            List<Integer> intRow = new ArrayList<>();
            for (String stringRow : stringRows) {
                for (char stringNum : stringRow.toCharArray()){
                    intRow.add(stringNum-'0');
                }
            }

            board.add(intRow);
        }

        //parse initialPieces to piece in board
        String[] piecesInLine = lines.get(2).split(" ");


        Map<Integer, List<int[][]>> mapPossiblePositionsPieces = new HashMap<>();

        //TODO: Generate all possible positions for a piece in the board
        for (int i = 0; i < piecesInLine.length; i++) {
            List<int[][]> allPossiblePositions = calculateAllPossiblePositions(board, piecesInLine, i);
            mapPossiblePositionsPieces.put(i, allPossiblePositions);

        }

        // TODO: Apply depth rules in a combinatorial analysis approach

        System.out.println("Scenario: "+scenario+".txt");
        System.out.println();
        System.out.println("Board");
        board.forEach(System.out::println);
        System.out.println();

        System.out.println("Depth: "+depth);
        System.out.println("Pieces: "+ Arrays.toString(piecesInLine));
        mapPossiblePositionsPieces.forEach((pieceNum, pieces) -> {
            System.out.println("Piece: "+pieceNum);
            for (int[][] piece : pieces){
                Arrays.stream(piece).forEach(possiblePosition -> System.out.println(Arrays.toString(possiblePosition)));
                System.out.println();
            }
        });
    }

    private List<int[][]> calculateAllPossiblePositions(List<List<Integer>> board, String[] piecesInLine, int pieceIndex) {

        List<int[][]> result = new ArrayList<>();

        for (int i = 0; i < board.getFirst().size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                try{
                    result.add(pieceToMatrix(piecesInLine, pieceIndex, board, i,j));
                }catch (IndexOutOfBoundsException _){

                }
            }
        }
        return result;
    }

    private int[][] pieceToMatrix(String[] piecesInLine, int pieceIndex, List<List<Integer>> board, int line, int col) {

        String[] pieceRows = piecesInLine[pieceIndex]
                .replace('X', '1')
                .replace('.', '0')
                .split(",");

        int[][] pieceMatrix = new int[board.size()][board.getFirst().size()];

        for (int i = 0; i < pieceRows.length; i++) {
            for (int j = 0; j < pieceRows[0].toCharArray().length; j++) {
                pieceMatrix[i+line][j+col] = pieceRows[i].toCharArray()[j]-'0';
            }
        }

        return pieceMatrix;
    }

    private void calculateCoordinates(List<List<Integer>> matrix, String[] pieces, String depth) {

    }

}