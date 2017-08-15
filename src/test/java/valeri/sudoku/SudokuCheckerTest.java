package valeri.sudoku;

import junit.framework.TestCase;
import org.junit.Before;
import valeri.sudoku.SudokuChecker;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for the SudokuChecker.
 *
 * created August 9, 2017
 * @author Valeri Sarantchouk
 */
public class SudokuCheckerTest extends TestCase {

    private SudokuChecker fixture;

    @Before
    public void setUp() {
        this.fixture = new SudokuChecker();
    }

    /**
     * Test sudoku file.
     */
    public void testApp() throws IOException, URISyntaxException {
        boolean sudokuComplte = fixture.checkSudoku("input_sudoku.txt");
        assertThat(sudokuComplte, is(true));
    }

}
