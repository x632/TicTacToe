package com.company;
public class Player {
    protected String name;
    protected char circleOrCross;
    protected int wins;

    public Player(String name, char circleOrCross, int wins) {
        this.name = name;
        this.circleOrCross = circleOrCross;
        this.wins = wins;
    }
    public char getCircleOrCross() {
        return this.circleOrCross;
    }
    public String getName() {
        return this.name;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void makeMove(GameBoard gb, Player player,int place) {
        gb.putCrossOrCircleOnBoard(place, player.getCircleOrCross());
    }
    public boolean doneArtificialThinkingMove(GameBoard gb){
        return false;
    }
    public boolean doneBetterArtificialThinkingMove(GameBoard gb){
        return false;
    }
    public int getWins() {
        return wins;
    }
}