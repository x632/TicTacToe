package com.company;
import java.util.Random;

public class GoodComputerPlayer extends ComputerPlayer {


    public GoodComputerPlayer(String name, char circleOrCross, int wins) {
        super(name, circleOrCross, wins);
    }

    @Override
    public boolean doneBetterArtificialThinkingMove(GameBoard gb) {
        int counter = 0;
        char cc = (this.getCircleOrCross());
        for (int i = 0; i < 9; i++) {
            if (gb.isNotOccupied(i)) {
                counter += 1;
            }
        }
        if (counter == 8 && gb.isNotOccupied(4)) {
            gb.putCrossOrCircleOnBoard(4, cc);
            return true;
        } else if (counter == 8 && !gb.isNotOccupied(4)) {

            Random rand = new Random();                        //pick random corner
            int x = rand.nextInt(4);
            switch (x) {
                case 0:
                    gb.putCrossOrCircleOnBoard(0, cc);
                    return true;
                case 1:
                    gb.putCrossOrCircleOnBoard(2, cc);
                    return true;
                case 2:
                    gb.putCrossOrCircleOnBoard(6, cc);
                    return true;
                case 3:
                    gb.putCrossOrCircleOnBoard(8, cc);
                    return true;
            }
        } return false;
    }
}


