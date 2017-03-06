package com.games.entity.tictactoe;

/**
 * Created by prakash.vijay on 06/08/16.
 */
//public class TicTacToeEnvironment extends GameEnvironment {
//    private TicTacToe ticTacToe;
//    private Map<String, Player> idToPlayerMap;
//
//    private TicTacToeEnvironment(Player player1, Player player2) {
//        this.ticTacToe = TicTacToe.newGame(3);
//        this.idToPlayerMap = new HashMap<String, Player>();
//        this.uuid = UUID.randomUUID().toString();
//
//        player1.mark = Mark.CIRCLE;
//        player2.mark = Mark.CROSS;
//        idToPlayerMap.put(player1.uuid, player1);
//        idToPlayerMap.put(player2.uuid, player2);
//    }
//
//    public static TicTacToeEnvironment newGame(Player player1, Player player2) {
//        return new TicTacToeEnvironment(player1, player2);
//    }
//
//    public Result takeTurn(String playerId, Position position) {
//        Mark mark = idToPlayerMap.get(playerId).mark;
//        ticTacToe.markCell(position, mark);
//        return ticTacToe.result(mark);
//    }
//}
