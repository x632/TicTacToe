package com.company;


public class GameBoard {
    private char[] boardArray = new char[9];
    ;

    public void putCrossOrCircleOnBoard(int loc, char name) {
        boardArray[loc] = name;
    }

    //checks if location in array is empty
    public boolean isNotOccupied(int place) {
        return boardArray[place] == ' ';
    }

    public void drawGameBoard() {
        System.out.println("-------------");
        System.out.println("| " + boardArray[0] + " | " + boardArray[1] + " | " + boardArray[2] + " |");
        System.out.println("----+---+----");
        System.out.println("| " + boardArray[3] + " | " + boardArray[4] + " | " + boardArray[5] + " |");
        System.out.println("----+---+----");
        System.out.println("| " + boardArray[6] + " | " + boardArray[7] + " | " + boardArray[8] + " |");
        System.out.println("-------------");
    }

    public boolean haveWon(GameBoard gb, Player player) {
        if (gb.boardArray[0] == player.getCircleOrCross() &&
                gb.boardArray[1] == player.getCircleOrCross() &&
                gb.boardArray[2] == player.getCircleOrCross() ||
                gb.boardArray[3] == player.getCircleOrCross() &&
                        gb.boardArray[4] == player.getCircleOrCross() &&
                        gb.boardArray[5] == player.getCircleOrCross() ||
                gb.boardArray[6] == player.getCircleOrCross() &&
                        gb.boardArray[7] == player.getCircleOrCross() &&
                        gb.boardArray[8] == player.getCircleOrCross() ||
                gb.boardArray[0] == player.getCircleOrCross() &&
                        gb.boardArray[3] == player.getCircleOrCross() &&
                        gb.boardArray[6] == player.getCircleOrCross() ||
                gb.boardArray[1] == player.getCircleOrCross() &&
                        gb.boardArray[4] == player.getCircleOrCross() &&
                        gb.boardArray[7] == player.getCircleOrCross() ||
                gb.boardArray[2] == player.getCircleOrCross() &&
                        gb.boardArray[5] == player.getCircleOrCross() &&
                        gb.boardArray[8] == player.getCircleOrCross() ||
                gb.boardArray[0] == player.getCircleOrCross() &&
                        gb.boardArray[4] == player.getCircleOrCross() &&
                        gb.boardArray[8] == player.getCircleOrCross() ||
                gb.boardArray[2] == player.getCircleOrCross() &&
                        gb.boardArray[4] == player.getCircleOrCross() &&
                        gb.boardArray[6] == player.getCircleOrCross()) {
            System.out.println("\n");
            System.out.println(player.getName() + " vann omgången.\n");
            int wins;
            wins = player.getWins();
            wins++;
            player.setWins(wins);                    //adds a win to the player
            return true;
        }
        return false;
    }

    public int location(int place) {
        return boardArray[place];
    }
}
