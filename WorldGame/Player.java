public class Player{
	private String name;
	private int punkte;
	private Terrain[] spielerTerrain;

	Player(String name){ 
		this.name = name;
		punkte = 0;
		for (int i=0; i<4; i++) {
			spielerTerrain[i] = new Terrain();
		}
	}
 

	public String showTiles() {
		String result = "";
    	for (int i = 0; i < 4; i++) {
    	    result += spielerTerrain[i].print() + "\n";
    	}
    	return result;
	}


	public String getName() {
		return name;
	}

	public void addPoints(int punkte) {
		this.punkte += punkte;
	}

	public int getPoints() {
		return punkte;	
	}

	public void generateTiles() {
		Terrain[] temp = new Terrain[spielerTerrain.length];
		for (int i = 0; i < spielerTerrain.length; i++) {
    		temp[i] = spielerTerrain[i];
		}
		for (int i=0; i<4; i++) {
			spielerTerrain[i].generate();
			while (spielerTerrain[i]==temp[i]) {
				spielerTerrain[i].generate();
			}
		}
	}

	public Terrain playTile(int num) {
		return spielerTerrain[num];
	}
}