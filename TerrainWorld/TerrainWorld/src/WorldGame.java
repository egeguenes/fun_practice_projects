import java.util.Scanner;
import java.util.Random;

public class WorldGame {

    private static Terrain chosenTile = null;
    private static int tileNum = -1;
    private static int runde = 1;
    private static int[] pp1 = new int[25];
    private static int[] pp2 = new int[25];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        boolean turnFinished = false;
        boolean chosen = false;
        boolean flag = false;


        Map map = new Map(5);
        map.draw();

        System.out.print("Der Name erstes Spielers : ");
        String firstPlayerName = scan.nextLine();
        System.out.print("Der Name zweites Spielers : ");
        String secondPlayerName = scan.nextLine();

        Player player1 = new Player(firstPlayerName);
        Player player2 = new Player(secondPlayerName);

        Player currentPlayer = (rnd.nextInt(2)==0) ? player1 : player2;

        while ( !map.isFull() ) {
            if ( runde % 2 == 1 && flag ) {
                currentPlayer = (pp1[runde-1] > pp2[runde-1]) ? player1 : player2;
            }
            System.out.println(currentPlayer.getName() + " ist Dran!");
            System.out.println("Verfügbare Kommande : points , show , choose[index] , place[index][index] , help");
            turnFinished = false;
            while ( !turnFinished ) {
                System.out.print(">");
                String kommand = scan.nextLine();
                String[] parts = kommand.split(" ");
                try {
                    switch (parts[0]) {
                        case "points" :
                            System.out.println(currentPlayer.getName() + " current points : " + currentPlayer.getPoints());
                            break;
                        case "show" :
                            System.out.println("-------" + currentPlayer.getName() + " Terrains -------\n");
                            currentPlayer.showTiles();
                            break;
                        case "choose" :
                            if ( parts.length != 2 ) {
                                System.out.println("Choose Index muss zwischen 0 und 4 sein!");
                                break;
                            }
                            int num = Integer.parseInt(parts[1]);
                            if ( num >= 0 && num < 4) {
                                tileNum = Integer.parseInt(parts[1]);
                                chosenTile = currentPlayer.playTile(tileNum);
                                chosenTile.print();
                                chosen = true;
                                break;
                            } else {
                                System.out.println("Choose Index muss zwischen 0 und 4 sein!");
                                break;
                            }
                        case "place" :
                            if (chosen) {
                                if ( parts.length != 3 ) {
                                    System.out.println("Player soll die Kordinate eingeben!");
                                    break;
                                }
                                int xPos = Integer.parseInt(parts[1]);
                                int yPos = Integer.parseInt(parts[2]);
                                if ( xPos < 5 && xPos >= 0 && yPos < 5 && yPos >= 0 ) {
                                    if ( map.isEmpty( xPos , yPos )) {
                                        int pointsBekommen = map.place( chosenTile , xPos , yPos );
                                        System.out.println(currentPlayer.getName() + " hat " + pointsBekommen + " Punkte bekommen!");
                                        currentPlayer.addPoints(pointsBekommen);
                                        chosenTile = null;
                                        chosen = false;
                                        currentPlayer = (currentPlayer==player1) ? player2 : player1;
                                        turnFinished = true;
                                        runde++;
                                        pp1[runde] = player1.getPoints();
                                        pp2[runde] = player2.getPoints();
                                        map.draw();
                                        flag = true;
                                        break;
                                    } else {
                                        System.out.println("Dieser Platz wurde schon ausgesucht!");
                                        break;
                                    }
                                } else {
                                    System.out.println("Index Fehler!");
                                    break;
                                }
                            } else {
                                System.out.println("Player soll zuerst ein Terrain aussuchen!");
                                break;
                            }
                        case "help" :
                            System.out.println("Verfügbare Kommande : points , show , choose[index] , place[index][index] , help , draw");
                            break;
                        case "draw" :
                            map.draw();
                            break;
                        default :
                            System.out.println("Ungültige Index!");
                            break;
                    }
                } catch (java.lang.NumberFormatException e) {
                }
            }
            if ( pp1[runde] > pp2[runde] ) {
                System.out.println(player1.getName() + " ist der Gewinner!");
            } else if ( pp1[runde] < pp2[runde] ) {
                System.out.println(player2.getName() + " ist der Gewinner!");
            } else {
                int temp = runde-1;
                while ( pp1[temp] == pp2[temp] ) {
                    if ( pp1[temp] > pp2[temp] ) {
                        System.out.println(player1.getName() + " ist der Gewinner!");
                        break;
                    } else if ( pp1[runde] < pp2[runde] ) {
                        System.out.println(player2.getName() + " ist der Gewinner!");
                        break;
                    }
                }
            }


        }


    }
}
