public class Karte {
	
	// map = the real map with the mines on it , mapTI = map Terra Incognita : the unrevealed parts ;
	private int[][] map;
	private boolean[][] mapTI;

	public Karte( int mapLength ) {
		this.map = new int[mapLength][mapLength];
		this.mapTI = new boolean[mapLength][mapLength]
		mapTICreate();
	}

	public void mapTICreate() {
		for ( int i = 0 ; i < mapTI.length ; i++ ) {
			for ( int j = 0 ; j < mapTI.length ; j++ ) {
				mapTI[i][j] = false;
			}
		} 
	}

	public void mapCreate() {
		for ( int i = 0 ; i < map.length ; i++ ) {
			for ( int j = 0 ; j < map.length ; j++ ) {
				
			}
		}
	}

}
