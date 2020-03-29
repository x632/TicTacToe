package com.company;


import java.util.*;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, char circleOrCross, int wins) {
        super(name = "Datorn", circleOrCross, wins);
    }

    @Override
    public boolean doneArtificialThinkingMove(GameBoard gb) {
        char cc = (this.getCircleOrCross());

        //********************************Offensive moves*******************
        //checking vertically | X | X |   |  situation
        for (int i = 0; i < 9; i += 3) {
            if (cc == gb.location(i) && cc == gb.location(i + 1) && gb.isNotOccupied(i + 2)) {
                gb.putCrossOrCircleOnBoard(i + 2, cc);
                return true;
            }
        }
        //checking vertically |   | X | X |  situation
        for (int i = 0; i < 9; i += 3) {
            if (cc == gb.location(i+1) && cc == gb.location(i + 2) && gb.isNotOccupied(i)) {
                gb.putCrossOrCircleOnBoard(i, cc);
                return true;
            }
        }
        //checking same horizontally
        for (int i = 0; i < 3; i++) {
            if (cc == gb.location(i) && cc == gb.location(i + 3) && gb.isNotOccupied(i + 6)) {
                gb.putCrossOrCircleOnBoard(i + 6, cc);
                return true;
            }
        }
        //checking horizontally
        for (int i = 0; i < 3; i++) {
            if (cc == gb.location(i+6) && cc == gb.location(i + 3) && gb.isNotOccupied(i)) {
                gb.putCrossOrCircleOnBoard(i , cc);
                return true;
            }
        }
        //checking vertically | x |   | X | situation
        for (int i = 0; i < 9; i += 3) {
            if (cc == gb.location(i) && cc == gb.location(i + 2) && gb.isNotOccupied(i + 1)) {
                gb.putCrossOrCircleOnBoard(i + 1, cc);
                return true;
            }
        }
        //checking horizontally
        for (int i = 0; i < 3; i++) {
            if (cc == gb.location(i) && cc == gb.location(i + 6) && gb.isNotOccupied(i + 3)) {
                gb.putCrossOrCircleOnBoard(i + 3, cc);
                return true;
            }
        }
        //checking diagonally
        if (cc == gb.location(0) && cc == gb.location( 4) && gb.isNotOccupied( 8)) {
            gb.putCrossOrCircleOnBoard(8, cc);
            return true;
        }
        if (cc == gb.location(8) && cc == gb.location( 4) && gb.isNotOccupied( 0)) {
            gb.putCrossOrCircleOnBoard(0, cc);
            return true;
        }
        if (cc == gb.location(0) && cc == gb.location( 8) && gb.isNotOccupied( 4)) {
            gb.putCrossOrCircleOnBoard(4, cc);
            return true;
        }
        if (cc == gb.location(2) && cc == gb.location( 4) && gb.isNotOccupied( 6)) {
            gb.putCrossOrCircleOnBoard(6, cc);
            return true;
        }
        if (cc == gb.location(6) && cc == gb.location( 4) && gb.isNotOccupied( 2)) {
            gb.putCrossOrCircleOnBoard(2, cc);
            return true;
        }
        if (cc == gb.location(2) && cc == gb.location( 6) && gb.isNotOccupied( 4)) {
            gb.putCrossOrCircleOnBoard(4, cc);
            return true;
        }

        //****************************** Defensive moves ***************************

        int ca;
        if (cc=='X')
        {ca='O';}
        else
        {ca='X';};
        //checking vertically | X | X |   |  situation
        for (int i = 0; i < 9; i += 3) {
            if (ca == gb.location(i) && ca == gb.location(i + 1) && gb.isNotOccupied(i + 2)) {
                gb.putCrossOrCircleOnBoard(i + 2, cc);
                return true;
            }
        }
        //checking vertically |   | X | X |  situation
        for (int i = 0; i < 9; i += 3) {
            if (ca == gb.location(i+1) && ca == gb.location(i + 2) && gb.isNotOccupied(i)) {
                gb.putCrossOrCircleOnBoard(i, cc);
                return true;
            }
        }
        //checking same horizontally
        for (int i = 0; i < 3; i++) {
            if (ca == gb.location(i) && ca == gb.location(i + 3) && gb.isNotOccupied(i + 6)) {
                gb.putCrossOrCircleOnBoard(i + 6, cc);
                return true;
            }
        }
        //checking horizontally
        for (int i = 0; i < 3; i++) {
            if (ca == gb.location(i+6) && ca == gb.location(i + 3) && gb.isNotOccupied(i)) {
                gb.putCrossOrCircleOnBoard(i , cc);
                return true;
            }
        }
        //checking vertically | x |   | X | situation
        for (int i = 0; i < 9; i += 3) {
            if (ca == gb.location(i) && ca == gb.location(i + 2) && gb.isNotOccupied(i + 1)) {
                gb.putCrossOrCircleOnBoard(i + 1, cc);
                return true;
            }
        }
        //checking horizontally
        for (int i = 0; i < 3; i++) {
            if (ca == gb.location(i) && ca == gb.location(i + 6) && gb.isNotOccupied(i + 3)) {
                gb.putCrossOrCircleOnBoard(i + 3, cc);
                return true;
            }
        }
        //checking diagonally
        if (ca == gb.location(0) && ca == gb.location( 4) && gb.isNotOccupied( 8)) {
            gb.putCrossOrCircleOnBoard(8, cc);
            return true;
        }
        if (ca == gb.location(8) && ca == gb.location( 4) && gb.isNotOccupied( 0)) {
            gb.putCrossOrCircleOnBoard(0, cc);
            return true;
        }
        if (ca == gb.location(0) && ca == gb.location( 8) && gb.isNotOccupied( 4)) {
            gb.putCrossOrCircleOnBoard(4, cc);
            return true;
        }
        if (ca == gb.location(2) && ca == gb.location( 4) && gb.isNotOccupied( 6)) {
            gb.putCrossOrCircleOnBoard(6, cc);
            return true;
        }
        if (ca == gb.location(6) && ca == gb.location( 4) && gb.isNotOccupied( 2)) {
            gb.putCrossOrCircleOnBoard(2, cc);
            return true;
        }
        if (ca == gb.location(2) && ca == gb.location( 6) && gb.isNotOccupied( 4)) {
            gb.putCrossOrCircleOnBoard(4, cc);
            return true;
        }
        return false;
    }
    @Override
    public void makeMove(GameBoard gb, Player player,int place) {
        int arrSiz = 0;
        for (int i = 0; i < 9; i++) {
            if (gb.isNotOccupied(i)) arrSiz++;       //extracting how many empty spaces
        }
        int[] EmptySpacesLocations = new int[arrSiz]; //make an array with size equaling number of empty spaces in board array
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (gb.isNotOccupied(i)) {
                EmptySpacesLocations[counter] = i;  //insert locations of empty spaces in board array, into empty spaces array..
                counter++;
            }
        }
        Random rand = new Random();
        int x = rand.nextInt(arrSiz);                               //...generate random number and pick from empty spaces array...
        gb.putCrossOrCircleOnBoard(EmptySpacesLocations[x], player.getCircleOrCross());      //...insert cross or circle there
    }
}
