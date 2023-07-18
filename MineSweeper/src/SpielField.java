import java.util.Random;

public class SpielField {
    private Random rnd = new Random();
    private LandType[][] map;
    private int size;
    private int bombNum;
    private int iAF;  // initial aufgedeckte Felder
    private boolean[][] mapHidden;

    public SpielField(int size , int bombNum , int iAF) {
        this.size = size;
        this.bombNum = bombNum;
        this.iAF = iAF;
        createMap();
    }

    // creates map and places the random bombs
    private void createMap() {
        this.createMapLandType();
        this.createMapHidden();
    }

    // shows the current state of the map
    public void draw() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");

        for ( int i=0 ; i < this.size ; i++ ) {
            sb.append(" | ").append((char)('A' + i));
        }
        sb.append("\n");
        for ( int i=0 ; i < this.size ; i++ ) {
            sb.append(i);
            for ( int j=0 ; j < this.size ; j++ ) {
                if ( mapHidden[i][j] == true ) {
                    if ( map[i][j] == null ) {
                        map[i][j] = new NormalLand();
                        map[i][j].setLand(Character.forDigit(this.detect(i, j), 10));
                        sb.append(" | ").append(map[i][j].toString());
                    } else {
                        sb.append(" | ").append(map[i][j]);
                    }
                } else {
                    sb.append(" | ").append(this.nullToString());
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void change(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < this.size && newY >= 0 && newY < this.size) {
                    mapHidden[newX][newY] = true;
                }
            }
        }
    }

    // shows the number of the bombs of every square adjacent
    private int detect(int xPos, int yPos) {
        int num = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x = xPos + i;
                int y = yPos + j;
                if (x >= 0 && x < this.size && y >= 0 && y < this.size) {
                    if (map[x][y] != null && map[x][y].toString().equals("X")) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    private void createMapLandType() {
        map = new LandType[size][size];
        int bombNumTemp = this.bombNum;
        while ( bombNumTemp > 0 ) {
            int xPos = rnd.nextInt(this.size);
            int yPos = rnd.nextInt(this.size);
            if ( map[xPos][yPos] == null ) {
                map[xPos][yPos] = new MinedLand();
                bombNumTemp--;
            }
        }
    }

    public void createMapHidden() {
        mapHidden = new boolean[size][size];
        for ( int i=0 ; i < size ; i++ ) {
            for ( int j=0 ; j < size ; j++ ) {
                mapHidden[i][j]=false;
            }
        }
    }

    public LandType getPosition( int x , int y ) {
        assert x >= 0 && x < this.size && y >= 0 && y < this.size;
        return map[x][y];
    }

    public boolean allTrue() {
        for ( int i=0 ; i < size ; i++ ) {
            for ( int j=0 ; j < size ; j++ ) {
                if ( mapHidden[i][j] == false ) {
                    return false;
                }
            }
        }
        return true;
    }

    private String nullToString() {
        return " ";
    }

    public int getSize() {
        return size;
    }

    public int getBombNum() {
        return bombNum;
    }

    public int getIAF() {
        return iAF;
    }
}
