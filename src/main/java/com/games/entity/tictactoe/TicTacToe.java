package com.games.entity.tictactoe;

import com.games.entity.Game;
import com.games.entity.Player;
import com.games.entity.Result;

import java.util.*;

/**
 * Created by prakash.vijay on 05/08/16.
 */
public class TicTacToe extends Game {
    private Grid grid;
    private int size;

    private Player player1;
    private Player player2;

    private TicTacToe(int size, Player player1, Player player2) {
        this.size = size;
        this.grid = Grid.newGrid(size);

        this.player1 = player1;
        this.player2 = player2;
        this.player1.setGame(this);
        this.player2.setGame(this);

        player1.mark = Mark.CIRCLE;
        player2.mark = Mark.CROSS;
    }

    public static TicTacToe newGame(int size, Player player1, Player player2) {
        return new TicTacToe(size, player1, player2);
    }

    public Result markCell(Position position, Mark mark) {
        Cell cell = grid.getCell(position);
        cell.mark = mark;
        return result(mark);
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
        List<Cell> diagonalCells = grid.getDiagonalCells();
        return diagonalCells.stream().allMatch(cell -> cell.mark == mark);
    }

    private boolean isHorizontalMatch(Mark mark) {
        for (int row = 1; row <= size; row++) {
            List<Cell> cells = grid.getCellsForRow(row);
            boolean isMatch = cells.stream().allMatch(cell -> cell.mark == mark);
            if (isMatch) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalMatch(Mark mark) {
        for (int column = 1; column <= size; column++) {
            List<Cell> cells = grid.getCellsForColumn(column);
            boolean isMatch = cells.stream().allMatch(cell -> cell.mark == mark);
            if (isMatch) {
                return true;
            }
        }
        return false;
    }

    private boolean areAllCellsMarked() {
        List<Cell> cells = grid.allCells();
        return cells.stream().allMatch(cell -> cell.mark != null);
    }

    public Player getPlayer(String id) {
        if (player1.uuid.equalsIgnoreCase(id)) {
            return player1;
        }
        if (player2.uuid.equalsIgnoreCase(id)) {
            return player2;
        }
        throw new RuntimeException("Wrong player id +" + id);
    }

    public Player getOtherPlayer(String id) {
        if (player1.uuid.equalsIgnoreCase(id)) {
            return player2;
        }
        if (player2.uuid.equalsIgnoreCase(id)) {
            return player1;
        }
        throw new RuntimeException("Wrong player id +" + id);
    }
//    public static void main(String[] args) {
//        TicTacToe ticTacToe = newGame(3);
//        ticTacToe.markCell(new Position(2,1), Mark.CIRCLE);
//        ticTacToe.markCell(new Position(2,2), Mark.CIRCLE);
//        ticTacToe.markCell(new Position(2,3), Mark.CIRCLE);
//        System.out.print(ticTacToe.result(Mark.CIRCLE));
//    }
}

