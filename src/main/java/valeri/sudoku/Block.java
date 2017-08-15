package valeri.sudoku;

import java.util.LinkedList;

/**
 * Block interface is to make Grid, Region and Cell behave alike,
 * and be able to navigate / drill-down between them.
 *
 * created August 9, 2017
 * @author Valeri Sarantchouk
 */
public interface Block {

    LinkedList<Cell> getRow(int rowIndex);

    LinkedList<Cell> getCol(int colIndex);

}
