package valeri.sudoku;

/**
 * created August 9, 2017
 * @author Valeri Sarantchouk
 */
public class Cell {

    private int rowNumber;
    private int colNumber;
    private char data;

    public Cell(int rowNumber, int colNumber, char data) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.data = data;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public char getData() {
        return data;
    }
}
