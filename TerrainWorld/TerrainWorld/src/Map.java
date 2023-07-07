import java.util.Random;

public class Map {
    private int size;
    private int points;
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
        for ( int i=0 ; i < size ; i++ ) {
            sb.append("+---------".repeat(size)).append("+\n");
            for ( int j=0 ; j < size ; j++ ) {
                for ( int k=0 ; k < size ; k++ ) {
                    sb.append("|");
                    if (!isEmpty( i , k )) {
                        sb.append(map[i][k].getRow(j));
                    } else {
                        sb.append("         ");
                    }
                }
                sb.append("|\n");
            }
        }
        sb.append("+---------".repeat(size)).append("+\n");
        System.out.println(sb.toString());
    }

    public boolean isFull() {
        for ( int i = 0 ; i < this.size ; i++ ) {
            for ( int j = 0 ; j < this.size ; j++ ) {
                if ( isEmpty( i , j )) return false;
            }
        } return true;
    }

    public int place( Terrain chosen , int xPos , int yPos) {
        assert xPos >= 0 && xPos < this.size && yPos >= 0 && yPos < this.size;
        assert chosen != null;

        map[xPos][yPos] = chosen;

        if ( xPos > 0 ) {
            if ( isEmpty( xPos - 1 , yPos )) {
                points += 2;
            } else {
                Terrain other = map[xPos-1][yPos];
                if ( chosen.getNorth() == other.getSouth() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        } else if ( xPos < size ) {
            if ( isEmpty( xPos + 1 , yPos )) {
                points += 2;
            } else {
                Terrain other = map[xPos+1][yPos];
                if ( chosen.getSouth() == other.getNorth() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        } else if ( yPos < size ) {
            if ( isEmpty( xPos , yPos + 1 )) {
                points += 2;
            } else {
                Terrain other = map[xPos][yPos+1];
                if ( chosen.getEast() == other.getWest() ) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }
        } else if ( yPos > 0 ) {
            if (isEmpty(xPos, yPos - 1)) {
                points += 2;
            } else {
                Terrain other = map[xPos][yPos - 1];
                if (chosen.getWest() == other.getEast()) {
                    points += 5;
                } else {
                    points -= 2;
                }
            }

        }
        return points;
    }







}
