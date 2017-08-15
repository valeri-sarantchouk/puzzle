package valeri.sudoku;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * SudokuChecker verifies a Sudoku puzzle solution contained in a text file.
 *
 * @author Valeri Sarantchouk
 */
public class SudokuChecker {

    private static final List<Character> COMPLETE_SET = new ArrayList<Character>() {{
        add('1');add('2');add('3');add('4');add('5');add('6');add('7');add('8');add('9');
    }};

    /**
     * Return true if the contents of the given file is a valid solution to a Sudoku puzzle, false otherwise.
     *
     * @param filename  to the file on the classpath
     * @throws IOException
     */
    public boolean checkSudoku(String filename) throws IOException, URISyntaxException {
        char[][] matrix = readFile(filename);
        Grid grid = new Grid(matrix);

        // verify rows
        boolean rowsOk = verify(grid.getRows());

        // verify columns
        boolean columnsOk = verify(grid.getColumns());

        // verify regions
        List<Region> regions = grid.getRegions();
        List regionData = regions.stream().map(r -> r.getCells()).collect(Collectors.toCollection(LinkedList::new));
        boolean regionsOk = verify(regionData);

        return rowsOk && columnsOk && regionsOk;
    }

    /**
     * Verify if a block of cells contains a complete number combination.
     * The block can be either a row, a column, or a region.
     */
    private boolean verify(List<List<Cell>> verifiableBlock) {
        for (List<Cell> row : verifiableBlock) {
            List<Character> rowData = row.stream().map(r -> r.getData()).collect(Collectors.toList());
            if(!rowData.containsAll(COMPLETE_SET)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Read a plain text file into a two-dimensional array of characters.
     *
     * @param filename the path the file on the classpath
     * @return two dimensional array of representing characters the file
     */
    public char[][] readFile(String filename) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        List<char[]> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines.map(line -> line.toCharArray()).forEach(array -> result.add(array));
        }
        char[][] ret = new char[9][9];
        return result.toArray(ret);
    }

}
