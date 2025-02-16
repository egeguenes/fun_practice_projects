public class Player{
	private String name;
	private int punkte;
	private Terrain[] spielerTerrain;

	Player(String name){ 
		this.name = name;
		this.punkte = 0;
		spielerTerrain = new Terrain[4];
		generateTiles();
	}
 

	public String showTiles() {
		String result = "";
    	for (int i = 0; i < spilerTerrain.length(); i++) {
    	    result += spielerTerrain[i].print() + "\n";
    	}
    	return result;
	}

	public Terrain[] getTerrain() {
		return spielerTerrain;
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
		for (int i=0; i<spielerTerrain.length(); i++) {
			Terrain newTerrain = new Terrain().generate();
			while (isDuplicate(newTerrain)) {
				newTerrain = new Terrain().generate();
			}
			spielerTerrain[i] = newTerrain;
		}
	}

	private boolean isDuplicate(Terrain terrain) {
		for (Terrain t : spielerTerrain) {
			if (t!=null && t.equals(spielerTerrain)) {
				return true;
			}
		}
		return false;
	}

	public Terrain playTile(int num) {
		if (num<=0 && num<spielerTerrain) {
			return spielerTerrain[num];
		}
		return null;
	}
}