import java.util.Random;

public class Map {
    private int size;
    private Terrain[][] map;
    private Random rnd= new Random();

    public Map( int size ) {
        this.size = size;
        map = new Terrain[size][size];
        Terrain randomTerrain = new Terrain();
        map[rnd.nextInt(size)][rnd.nextInt(size)] = randomTerrain;
    }

    public boolean isEmpty( int xPos , int yPos ) {
        assert xPos >= 0 && xPos < this.size && yPos >= 0 && yPos < this.size;
        if ( map[xPos][yPos] == null ) {
            return true;
        }
        return false;
    }

    public void draw() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.size; i++) {
            sb.append("+---------".repeat(this.size)).append("+\n");
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < this.size; k++) {
                    if (map[k][i] != null) {
                        String[] terrainZeilen = map[k][i].toString().split("\n");
                        sb.append("|" + terrainZeilen[j]);
                    } else {
                        sb.append("|         ");
                    }
                }
                sb.append("|\n");
            }
        }
        sb.append("+---------".repeat(this.size)).append("+");

        System.out.println(sb.toString());
    }

    public boolean isFull() {
        for ( int i = 0 ; i < this.size ; i++ ) {
            for ( int j = 0 ; j < this.size ; j++ ) {
                if ( isEmpty( i , j ))
                    return false;
            }
        }
        return true;
    }

    public int bestFor(Player p) {
        int terrainNum = 0;
        int xNum = 0;
        int yNum = 0;
        int max = 0;

        for ( int i=0 ; i < this.size ; i++ ) {
            for ( int j=0 ; j < this.size ; j++ ) {
                for ( int k=0 ; k < p.getFelderAnzahl() ; k++ ) {
                    if ( isEmpty( i , j ) ) {
                        if ( pointsFromPlace( p.getTerrain(k) , i , j ) > max ) {
                            terrainNum = k;
                            xNum = i;
                            yNum = j;
                            max = pointsFromPlace( p.getTerrain(k) , i , j );
                        }
                    }
                }
            }
        }
        System.out.println("coordinates : " + xNum + " , " + yNum);
        place( p.getTerrain(terrainNum) , xNum , yNum );
        return max;
    }

    public int pointsFromPlace( Terrain chosen , int x , int y) {
        assert x >= 0 && x < this.size && y >= 0 && y < this.size;
        assert chosen != null;

        int points = 10;

        if ( x - 1 >= 0 ) {
            if ( map[x-1][y] == null ) {
                points += 2;
            } else {
                Terrain other = map[x-1][y];
                if ( chosen.getWest() == other.getEast() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        }
        if ( y - 1 >= 0 ) {
            if ( map[x][y-1] == null ) {
                points += 2;
            } else {
                Terrain other = map[x][y-1];
                if ( chosen.getNorth() == other.getSouth() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        }
        if ( x + 1 < this.size ) {
            if ( map[x+1][y] == null ) {
                points += 2;
            } else {
                Terrain other = map[x+1][y];
                if ( chosen.getEast() == other.getWest() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        }
        if ( y + 1 < this.size ) {
            if ( map[x][y+1] == null ) {
                points += 2;
            } else {
                Terrain other = map[x][y+1];
                if ( chosen.getSouth() == other.getNorth() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        }

        return points;
    }

    public void place( Terrain chosen , int xPos , int yPos) {
        assert (xPos >= 0 && xPos < this.size) && (yPos >= 0 && yPos < this.size);
        assert chosen != null;
        map[xPos][yPos] = chosen;
    }
}
