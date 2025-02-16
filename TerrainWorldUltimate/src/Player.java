public class Player {

    private String name;
    private int points;
    private Terrain[] felder = new Terrain[4];

    public Player(String name) {
        this.name = name;
        generateTiles();
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void showTiles() {
        for (int i=0 ; i < felder.length ; i++) {
            System.out.println(felder[i].toString());
        }
    }

    public Terrain playTile(int num) {
        assert num >= 0 && num < felder.length;
        return felder[num];
    }

    public void generateTiles() {
        for ( int i=0 ; i < felder.length ; i++) {
            felder[i] = new Terrain();
        }
        for ( int i=0 ; i < felder.length/2 ; i++) {
            for ( int j=felder.length/2 ; j < felder.length ; j++) {
                if ( felder[i].toString().equals(felder[j].toString())) {
                    generateTiles();
                }
            }
        }
    }

    public int getFelderAnzahl() {
        return felder.length;
    }

    public Terrain getTerrain(int num) {
        assert num >= 0 && num < 4;
        return this.felder[num];
    }
}
