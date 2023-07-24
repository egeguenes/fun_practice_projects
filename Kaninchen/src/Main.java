import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] map;
    private static int[][] age;
    private static Random rnd = new Random();
    private static int runde = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie die Laenge vom Quadratfeld ein : ");
        int feldLaenge = scan.nextInt();
        age = new int[feldLaenge][feldLaenge];

        /*
        System.out.print("Geben Sie die Anzahl des Experimentes ein : ");
        int expAnzahl = scan.nextInt();


        for ( int i=0 ; i < expAnzahl ; i++ ) {
            createMap( feldLaenge );
            while ( isEmpty() ) {
                kaninchenDetektor();
            }
        }

        double dR = runde / (double) expAnzahl;


        System.out.println("Durchschnittliche Anzahl der Runde in " + expAnzahl + " Experimenten mit " + feldLaenge" Kaninchen : " + dR);
        */


        createMap( feldLaenge );
        draw();

        do {
            kaninchenDetektor();
            draw();
        } while ( isEmpty() );


    }

    public static char[][] createMap( int a ) {
        map = new char[a][a];
        for ( int i=0 ; i < map.length ; i++ ) {
            for ( int j=0 ; j < map[i].length ; j++ ) {
                map[i][j] = '-';
                age[i][j] = 0;                  //<<<<<-------
            }
        }
        int x = rnd.nextInt(a);
        int y = rnd.nextInt(a);
        map[x][y] = 'k';
        return map;
    }

    public static void draw() {
        for ( int i=0 ; i < map.length ; i++ ) {
            for ( int j=0 ; j < map[i].length ; j++ ) {
                System.out.print(map[i][j] + " ");
            } System.out.println();
        }
        System.out.println("Runde Anzahl : " + runde);
    }

    public static void kaninchenDetektor() {
        for ( int i=0 ; i < map.length ; i++ ) {
            for ( int j=0 ; j < map[i].length ; j++ ) {
                if ( map[i][j] == 'k' ) {
                    age[i][j]++;
                    if ( age[i][j] == 8 ) {
                        map[i][j] = 'X';
                    } else if ( age[i][j] >= 4 ) {
                        if ( map[i][j] == 'k' && age[i][j] >= 4 ) {
                            if ( i-1 >= 0 && map[i-1][j] == '-' ) {
                                int randomNum = rnd.nextInt(2);
                                if ( randomNum == 1 ) {
                                    map[i-1][j] = 'd';
                                    age[i-1][j]++;
                                }
                            }
                            if ( j-1 >= 0 && map[i][j-1] == '-' ) {
                                int randomNum = rnd.nextInt(2);
                                if ( randomNum == 1 ) {
                                    map[i][j-1] = 'd';
                                    age[i][j-1]++;
                                }
                            }
                            if ( j+1 < map.length && map[i][j+1] == '-' ) {
                                int randomNum = rnd.nextInt(2);
                                if ( randomNum == 1 ) {
                                    map[i][j+1] = 'd';
                                    age[i][j+1]++;
                                }
                            }
                            if ( i+1 < map.length && map[i+1][j] == '-' ) {
                                int randomNum = rnd.nextInt(2);
                                if ( randomNum == 1 ) {
                                    map[i+1][j] = 'd';
                                    age[i+1][j]++;
                                }
                            }
                        }
                    }
                }
            }
        }
        for ( int i=0 ; i < map.length ; i++ ) {
            for ( int j=0 ; j < map[i].length ; j++ ) {
                if ( map[i][j] == 'd' ) {
                    map[i][j] = 'k';
                }
            }
        }
        runde++;
    }

    public static boolean isEmpty() {
        for ( int i=0 ; i < map.length ; i++ ) {
            for ( int j=0 ; j < map[i].length ; j++ ) {
                if ( map[i][j] == '-' ) {
                    return true;
                }
            }
        }
        return false;
    }

}