package com.games.entity.tic_tac_toe;

import com.games.entity.Game;
import com.games.entity.Result;

import java.util.*;

/**
 * Created by prakash.vijay on 05/08/16.
 */
public class TicTacToe extends Game {
    private Map<Position, Cell> cellMap;
    private List<Diagonal> diagonals;
    private int size;

    private TicTacToe(int size) {
        this.cellMap = new HashMap<Position, Cell>();
        this.size = size;
        initialize();
    }

    public static TicTacToe newGame(int size) {
        return new TicTacToe(size);
    }

    private void initialize() {
        for (int row = 1; row <=size; row++) {
            for (int column = 1; column<=size; column++) {
                Position position = new Position(row, column);
                cellMap.put(position, new Cell(position));
            }
        }
        initializeDiagonals();
    }

    private void initializeDiagonals() {
        this.diagonals = new ArrayList<Diagonal>();
        int row = 1;
        int column = 1;
        List<Position> positions = new ArrayList<Position>();
        while (row <= size && column <= size) {
            positions.add(new Position(row, column));
            row++;
            column++;
        }
        this.diagonals.add(new Diagonal(positions));

        row = size;
        column = 1;
        positions = new ArrayList<Position>();
        while (row >=1 && column <= size) {
            positions.add(new Position(row, column));
            row--;
            column++;
        }
        this.diagonals.add(new Diagonal(positions));
    }

    public void markCell(Position position, Mark mark) {
        Cell cell = cellMap.get(position);
        cell.mark = mark;
    }

    public Result result(Mark mark) {
        if (isDiagonalMatch(mark) || isHorizontalMatch(mark) || isVerticalMatch(mark)) {
            return Result.WON;
        }
        if (areAllCellsMarked()) {
            return Result.DRAW;
        }
        return Result.NO_RESULT;
    }

    private boolean isDiagonalMatch(Mark mark) {
        for (Diagonal diagonal : diagonals) {
            int sum = 0;
            for (Position position : diagonal.positions) {
                if (cellMap.get(position).mark == mark) {
                    sum++;
                }
            }
            if (sum == size) {
                return true;
            }
        }
        return false;
    }

    private boolean isHorizontalMatch(Mark mark) {
        for (int row = 1; row <= size; row++) {
            int sum = 0;
            for (int column = 1; column <= size; column++) {
                if (cellMap.get(new Position(row, column)).mark == mark) {
                    sum++;
                }
            }
            if (sum == size) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalMatch(Mark mark) {
        for (int column = 1; column <= size; column++) {
            int sum = 0;
            for (int row = 1; row <= size; row++) {
                if (cellMap.get(new Position(row, column)).mark == mark) {
                    sum++;
                }
            }
            if (sum == size) {
                return true;
            }
        }
        return false;
    }

    private boolean areAllCellsMarked() {
        for (int row = 1; row <= size ; row++) {
            for (int column = 1; column <= size; column++) {
                if (cellMap.get(new Position(row, column)).mark == null) {
                    return false;
                }
            }
        }
        return true;
    }
    private class Diagonal {
        List<Position> positions;

        Diagonal(List<Position> positions) {
            this.positions = positions;
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = newGame(3);
        ticTacToe.markCell(new Position(2,1), Mark.CIRCLE);
        ticTacToe.markCell(new Position(2,2), Mark.CIRCLE);
        ticTacToe.markCell(new Position(2,3), Mark.CIRCLE);
        System.out.print(ticTacToe.result(Mark.CIRCLE));
    }
}

