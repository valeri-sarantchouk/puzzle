package valeri.sudoku;

import java.util.LinkedList;
import java.util.List;

/**
 * created August 9, 2017
 * @author Valeri Sarantchouk
 */
public class Grid {

    public static final int GRID_MAX_ROWS = 9;
    public static final int GRID_MAX_COLS = 9;
    public static final int REGION_MAX_ROWS = 3;
    public static final int REGION_MAX_COLS = 3;

    private List<List<Cell>> data;

    public Grid(char[][] matrix) {
        // transform incoming char array into something more manageable:
        // list of a lists of cells so that we can work with horizontal and vertical indices
        List<List<Cell>> data = new LinkedList<>();
        for (int row = 0; row < matrix.length && row < GRID_MAX_ROWS; row++) {
            List<Cell> rowData = new LinkedList<>();
            for (int col = 0; col < GRID_MAX_COLS; col++) {
                char c = matrix[row][col];
                rowData.add(new Cell(row, col, c));
            }
            data.add(rowData);
        }
        this.data = data;
    }

    public List<Cell> getRow(int rowIndex) {
        return this.data.get(rowIndex);
    }

    private List<Cell> getRow(int rowIndex, int startCol, int endCol) {
        List<Cell> rowData = this.data.get(rowIndex);
        List<Cell> subList = rowData.subList(startCol, endCol);
        return subList;
    }

    public List<Cell> getCol(int colIndex) {
        return getCol(colIndex, 0, GRID_MAX_ROWS - 1);
    }

    private List<Cell> getCol(int colIndex, int startRow, int endRow) {
        List<Cell> colData = new LinkedList<>();
        for (int row = startRow; row <= endRow; row++) {
            List<Cell> rowData = this.data.get(row);
            colData.add(rowData.get(colIndex));
        }
        return colData;
    }

    /**
     * Get a specific region.
     * The coordinates (rowIndex, colIndex) should point to a cell in the top left corner of the region.
     */
    private Region getRegion(int rowIndex, int colIndex) {
        List<Cell> regionData = new LinkedList<>();
        for (int i = rowIndex; i < rowIndex + REGION_MAX_ROWS; i++) {
            List<Cell> subList = getRow(i, colIndex, colIndex + REGION_MAX_COLS);
            regionData.addAll(subList);
        }
        return new Region(regionData);
    }

    /**
     * Get all Regions.
     */
    public List<Region> getRegions() {
        List<Region> regions = new LinkedList<>();
        for (int rows = 0; rows < GRID_MAX_ROWS; rows += REGION_MAX_ROWS) {
            for (int cols = 0; cols < GRID_MAX_COLS; cols += REGION_MAX_COLS) {
                Region region = getRegion(rows, cols);
                regions.add(region);
            }
        }
        return regions;
    }

    /**
     * Get vertical slice of data.
     */
    public List<List<Cell>> getColumns() {
        List<List<Cell>> columns = new LinkedList<>();
        for (int i = 0; i < GRID_MAX_COLS; i++) {
            List<Cell> column = getCol(i);
            columns.add(column);
        }
        return columns;
    }

    /**
     * Get horizontal slice of data.
     */
    public List<List<Cell>> getRows() {
        return this.data;
    }

}
