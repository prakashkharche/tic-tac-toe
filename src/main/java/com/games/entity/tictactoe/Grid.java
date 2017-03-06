package com.games.entity.tictactoe;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by prakash.vijay on 05/03/17.
 */
public class Grid {
    private List<Cell> cells;
    private int size;

    private Grid(int size) {
        this.size = size;
        this.cells = Lists.newArrayList();
        initialize();
    }

    public static Grid newGrid(int size) {
        return new Grid(size);
    }

    private void initialize() {
        for (int row = 1; row <=size; row++) {
            for (int column = 1; column<=size; column++) {
                Position position = new Position(row, column);
                cells.add(new Cell(position));
            }
        }
    }

    public Cell getCell(Position position) {
        Optional<Cell> cellOption = cells.stream()
                .filter(cell -> cell.position.equals(position))
                .findFirst();
        if (!cellOption.isPresent()) {
            throw new RuntimeException("Cell with position : "+position+" not present");
        }
        return cellOption.get();
    }

    public List<Cell> getDiagonalCells() {
       return cells.stream()
               .filter(cell -> cell.position.row == cell.position.column)
               .collect(Collectors.toList());
    }

    public List<Cell> getCellsForRow(int row) {
        return cells.stream()
                .filter(cell -> cell.position.row == row)
                .collect(Collectors.toList());
    }

    public List<Cell> getCellsForColumn(int column) {
        return cells.stream()
                .filter(cell -> cell.position.column == column)
                .collect(Collectors.toList());
    }

    public List<Cell> allCells() {
        return cells;
    }
}
