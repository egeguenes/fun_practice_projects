import java.util.Scanner;
import java.util.Random;

public class WorldGame {

    private static Terrain chosenTile = null;
    private static int tileNum = -1;
    private static int runde = 1;
    private static int[] pp1 = new int[25];
    private static int[] pp2 = new int[25];
    static Scanner scan = new Scanner(System.in);
    static Random rnd = new Random();
    static boolean turnFinished = false;
    static boolean chosen = false;
    static Player player1;
    static Player player2;
    static Map map = new Map(5);

    public static void main(String[] args) {
        System.out.println("Wilkommen zu Terrain World Ultimate ");
        System.out.print("SinglePlayer : [S] / Multiplayer : [M] --> ");
        String s = scan.nextLine().toUpperCase();

        if ( s.equals("S") ) {
            System.out.print("\nDifficulty : [E]asy / [H]ard : ");
            String difficulty = scan.nextLine().toUpperCase();
            if ( difficulty.equals("E") ) {
                singlePlayerModeEasy();
            } else if ( difficulty.equals("H") ) {
                singlePlayerModeHard();
            } else {
                System.out.println("Spiel wurde beendet!\n");
                return;
            }
            werGewinnt( player1 , player2 );
        } else if ( s.equals("M") ) {
            multiPlayerMode();
            werGewinnt( player1 , player2 );
        } else {
            System.out.println("\nDas Spiel wurde beendet!\nCiao!\n");
        }
    }

    public static void multiPlayerMode() {

        System.out.println("----------\n\nMultiplayer Mode!\n\n----------\n");
        System.out.print("Der Name erstes Spielers : ");
        player1 = new Player(nameInput());
        System.out.print("Der Name zweites Spielers : ");
        player2 = new Player(nameInput());

        Player currentPlayer = (rnd.nextInt(2)==0) ? player1 : player2;

        map.draw();

        while (!map.isFull()) {
            System.out.println(currentPlayer.getName() + " ist Dran!");
            System.out.println("Verfügbare Kommande : points , show , choose[index] , place[index][index] , draw , help");
            turnFinished = false;
            turnMech( currentPlayer );
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            runde++;
        }
    }

    public static void singlePlayerModeHard() {
        System.out.println("Singleplayer Mode-Hard!");

        System.out.print("Player name : ");
        player1 = new Player( nameInput() );
        player2 = new Player("Bot Compi");

        map.draw();

        Player currentPlayer = ( rnd.nextInt(2) == 1 ) ? player1 : player2;

        while ( !map.isFull() ) {
            System.out.println(currentPlayer.getName() + " ist Dran!");
            turnFinished = false;
            if ( currentPlayer==player1 ) {
                System.out.println("Verfügbare Kommande : points , show , choose[index] , place[index][index] , draw , help");
                turnMech( player1 );
                currentPlayer = player2;
            } else {
                int punkte = map.bestFor( player2 );
                System.out.println( player2.getName() + " hat " + punkte + " punkte bekommen!");
                player2.generateTiles();
                map.draw();
                pp1[runde] = player1.getPoints();
                pp2[runde] = player2.getPoints();
                currentPlayer = player1;
            }
            runde++;
        }
    }

    public static void singlePlayerModeEasy() {
        System.out.println("Singleplayer Mode-Easy!");

        System.out.print("Player name : ");
        player1 = new Player(nameInput());
        player2 = new Player("Bot Compi");
        map.draw();

        Player currentPlayer = (rnd.nextInt(2) == 1) ? player1 : player2;

        while (!map.isFull()) {
            System.out.println(currentPlayer.getName() + " ist Dran!");
            turnFinished = false;
            if (currentPlayer == player1) {
                System.out.println("Verfügbare Kommande : points , show , choose[index] , place[index][index] , draw , help");
                turnMech(player1);
                currentPlayer = player2;
            } else {
                while( currentPlayer == player2 ) {
                    int tileRandom = rnd.nextInt(4);
                    int xRandom = rnd.nextInt(5);
                    int yRandom = rnd.nextInt(5);
                    if ( map.isEmpty( xRandom , yRandom ) ) {
                        map.place( player2.getTerrain(tileRandom) , xRandom , yRandom );
                        int punkteBotEasy = map.placeTry( player2.getTerrain(tileRandom) , xRandom , yRandom );
                        System.out.println( player2.getName() + " hat " + punkteBotEasy + " punkte bekommen!");
                        player2.generateTiles();
                        map.draw();
                        pp1[runde] = player1.getPoints();
                        pp2[runde] = player2.getPoints();
                        currentPlayer = player1;
                    }
                }
            }
            runde++;
        }
    }

    public static void turnMech(Player currentPlayer) {
        while ( !turnFinished ) {
            System.out.print(">");
            String kommand = scan.nextLine();
            String[] parts = kommand.split(" ");
            try {
                switch (parts[0]) {
                    case "points":
                        System.out.println(currentPlayer.getName() + " current points : " + currentPlayer.getPoints());
                        break;
                    case "show":
                        System.out.println("-------" + currentPlayer.getName() + " Terrains -------\n");
                        currentPlayer.showTiles();
                        break;
                    case "choose":
                        if (parts.length != 2) {
                            System.out.println("Choose Index muss zwischen 0 und 4 sein!");
                            break;
                        }
                        int num = Integer.parseInt(parts[1]);
                        if (num >= 0 && num < 4) {
                            tileNum = Integer.parseInt(parts[1]);
                            chosenTile = currentPlayer.playTile(tileNum);
                            chosenTile.print();
                            chosen = true;
                            break;
                        } else {
                            System.out.println("Choose Index muss zwischen 0 und 4 sein!");
                            break;
                        }
                    case "place":
                        if (chosen) {
                            if (parts.length != 3) {
                                System.out.println("Player soll die Kordinate eingeben!");
                                break;
                            }
                            int xPos = Integer.parseInt(parts[1]);
                            int yPos = Integer.parseInt(parts[2]);
                            if (xPos < 5 && xPos >= 0 && yPos < 5 && yPos >= 0) {
                                if (map.isEmpty(xPos, yPos)) {
                                    map.place(chosenTile, xPos, yPos);
                                    int pointsBekommen = map.placeTry(chosenTile, xPos, yPos);
                                    System.out.println(currentPlayer.getName() + " hat " + pointsBekommen + " Punkte bekommen!");
                                    currentPlayer.addPoints(pointsBekommen);
                                    chosenTile = null;
                                    chosen = false;
                                    turnFinished = true;
                                    pp1[runde] = player1.getPoints();
                                    pp2[runde] = player2.getPoints();
                                    map.draw();
                                    currentPlayer.generateTiles();
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
                    case "help":
                        System.out.println("Verfügbare Kommande : points , show , choose[index] , place[index][index] , help , draw");
                        break;
                    case "draw":
                        map.draw();
                        break;
                    default:
                        System.out.println("Ungültige Index!");
                        break;
                }
            } catch (java.lang.NumberFormatException e) {
            }
        }
    }

    public static void werGewinnt( Player p1 , Player p2 ) {
        if ( pp1[runde] > pp2[runde] ) {
            System.out.println(p1.getName() + " ist der Gewinner!");
        } else if ( pp1[runde] < pp2[runde] ) {
            System.out.println(p2.getName() + " ist der Gewinner!");
        } else {
            int temp = runde-1;
            while ( pp1[temp] == pp2[temp] ) {
                if ( pp1[temp] > pp2[temp] ) {
                    System.out.println(p1.getName() + " ist der Gewinner!");
                    break;
                } else if ( pp1[runde] < pp2[runde] ) {
                    System.out.println(p2.getName() + " ist der Gewinner!");
                    break;
                }
            }
        }
    }

    public static String nameInput() {
        return scan.nextLine();
    }
}
