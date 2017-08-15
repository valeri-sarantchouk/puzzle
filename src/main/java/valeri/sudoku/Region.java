package valeri.sudoku;

import java.util.List;

/**
 * created August 9, 2017
 * @author Valeri Sarantchouk
 */
public class Region {

    private List<Cell> cells;

    public Region(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }
}
