package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //********************* get all input values *********************
        System.out.println("\nTRE I RAD\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Vill du spela mot datorn nivå 1 medel (skriv 1), datorn nivå 2 svår (skriv 2) eller en mänsklig spelare (skriv 3)?");
        int inputComputerOrHuman = sc.nextInt();
        boolean compute, compute2 = false;
        if (inputComputerOrHuman == 1 || inputComputerOrHuman == 2) {
            compute = true;
        } else {
            compute = false;
        }
        if (inputComputerOrHuman == 2) compute2 = true;
        Scanner sc1 = new Scanner(System.in);
        String outputFor = (!compute) ? "namn på spelare 1." : "ditt namn.";
        System.out.println("Vänligen, skriv in " + outputFor);
        String name1 = sc1.nextLine();
        System.out.println("Hej " + name1 + "! Vill du ha X (skriv 1) eller O (skriv 2) i spelet?");
        int inputCircleOrCross = sc1.nextInt();
        char pl1Char = ' ';
        char pl2Char = ' ';
        if (inputCircleOrCross == 1) {
            pl1Char = 'X';
            pl2Char = 'O';
        } else {
            pl1Char = 'O';
            pl2Char = 'X';
        }
        System.out.println("Bäst av hur många spel önskas?(1-n)");
        Scanner sc2 = new Scanner(System.in);
        int bestOf = sc2.nextInt();
        String name2;
        if (!compute) {
            System.out.println("Tack! Vänligen, skriv in namn på spelare 2.");
            Scanner sc3 = new Scanner(System.in);
            name2 = sc3.nextLine();
        } else {
            name2 = "Datorn";
        }
        //send in 'number' chars to the array in GameBoard create gb object
        GameBoard gb = new GameBoard();
        for (int i = 0; i < 9; i++) {
            char c = (char) (i + '1');
            gb.putCrossOrCircleOnBoard(i, c);
        }
        gb.drawGameBoard();
        String outputForm = (name2 != "Datorn") ? name1 + " och " + name2 : name1;
        System.out.println(outputForm + ", spelet fungerar på följande sätt: Ovan syns siffror som representerar\n" +
                "varje ruta i spelet. Den spelare vars tur det är skriver in en siffra som motsvarar en ruta\nför att " +
                "placera en cirkel, eller ett kryss där.\n ");

        //************************* creating objects ****************************
        Player player1;
        Player player2;
        player1 = new Player(name1, pl1Char, 0);
        if (!compute) {
            player2 = new Player(name2, pl2Char, 0);
        } else if (!compute2) {
            player2 = new ComputerPlayer("Computer", pl2Char, 0);
        } else {
            player2 = new GoodComputerPlayer("Better computer", pl2Char, 0);
        }

        //**************************** game loop ******************************
        int gameCounter = 0;
        boolean gameEnd = false;
        while (!gameEnd) {
            for (int i = 0; i < 9; i++) {
                gb.putCrossOrCircleOnBoard(i, ' ');
            }
            if (gameCounter > 0) {
                gb.drawGameBoard();
                System.out.println("Detta är spel nummer " + (gameCounter + 1) + " av " + bestOf + "\n" + player1.getName()
                        + ": " + player1.getWins() + ". " + player2.getName() + ": " + player2.getWins() + ".\n");
            }
            if (gameCounter == bestOf - 1) gameEnd = true;

            boolean answer1;
            boolean answer2;
            int counter = 0;
            while (true) {
                boolean emptySpace = false;
                while (!emptySpace) {
                    System.out.println("Varsågod " + player1.name + ", skriv in siffran på rutan i vilken du vill sätta " + player1.circleOrCross + " (1-9)!");
                    Scanner sc4 = new Scanner(System.in);
                    int place;
                    place = -1 + sc4.nextInt();
                    if (gb.isNotOccupied(place)) {
                        player1.makeMove(gb, player1, place);
                        emptySpace = true;
                    } else {
                        System.out.println("Rutan du försöker sätta i är inte tom!\n");
                    }
                }
                gb.drawGameBoard();
                counter++;
                answer1 = gb.haveWon(gb, player1);
                if (answer1) break;
                if (counter == 9) {
                    System.out.println("\nSpelet blev oavgjort!\n");
                    break;
                }
                if (!compute) {
                    emptySpace = false;
                    while (!emptySpace) {
                        System.out.println("Varsågod " + player2.name + ", skriv in siffran på rutan i vilken du vill sätta " + player2.circleOrCross + " (1-9)!");
                        Scanner sc5 = new Scanner(System.in);
                        int place;
                        place = -1 + sc5.nextInt();
                        if (gb.isNotOccupied(place)) {
                            player2.makeMove(gb, player2, place);
                            emptySpace = true;
                        } else {
                            System.out.println("Rutan du försöker sätta i är inte tom!\n");
                        }
                    }
                }
                else if(!compute2){                   // AT level 1
                    boolean haveMadeMove;
                    haveMadeMove = player2.doneArtificialThinkingMove(gb);
                    if (!haveMadeMove) {
                        player2.makeMove(gb, player2, 0);
                    }
                }
                else{
                    boolean haveMadeMove;
                    haveMadeMove = player2.doneBetterArtificialThinkingMove(gb);    //level 2 AT move
                    if (!haveMadeMove) {
                        haveMadeMove=player2.doneArtificialThinkingMove(gb);        //level 1 AT move
                    }
                    if (!haveMadeMove) {
                        player2.makeMove(gb, player2, 0);                 //level random
                    }
                }
                if (compute) {
                    System.out.println("Datorn har gjort sitt drag:");
                }
                gb.drawGameBoard();
                counter++;
                answer2 = gb.haveWon(gb, player2);
                if (answer2) break;
            }
            gameCounter++;
        }

        //**************************** output game result ************************
        int equalGames = bestOf - (player1.getWins() + player2.getWins());
        String out1 = (player1.getWins()==1) ? " vinst " : " vinster ";
        String out2 =  (player2.getWins()==1) ? " vinst " : " vinster ";
        System.out.println("Det sammanlagda resultatet blev  " + player1.getWins() + " - " + player2.getWins() + "\n\n" +
                player1.getName() + ", fick " + player1.getWins() +  out1 + "och " + player2.getName() + " fick " + player2.getWins() + out2+". Oavgjorda: " + equalGames);
    }
}