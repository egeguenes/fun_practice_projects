import java.util.Random;

public class Map{
	private int groesse;
	private Terrain[][] map;
	private Random rnd = new Random();
	private int punkte = 0;

	public Map(int groesse){
		this.groesse = groesse;
		map = new Terrain[groesse][groesse];
		map[rnd.nextInt(grosse)][rnd.nextInt(groesse)] = new Terrain.generator();
	}

	public boolean isEmpty(int xPos , int yPos) {
		return map[xPos][yPos]==null;
	}

	public boolean isFull(){
		for (int i=0; i<groesse; i++) {
			for (int j=0; j<groesse; j++) { 
				if (isEmpty(i , j)) {
					return false;
				}
			}
		}
	}

	public String draw() {
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<groesse; i++) {
			sb.append(("+---------".repeat(groesse)).append("\n");
			for (int j=0; j<groesse; j++) {
				for (int k=0; k<groesse; k++) {
					if (map[][])
				}
			}
		}

	}

	public int place(Terrain chosen , int xPos , int yPos) {
		if (isEmpty(xPos , yPos)) {
			map[xPos][yPos] = chosen;
			punkte += 10;
		} else {
			System.out.println("Dieser Platz ist besetzt!");
		}

		if (xPos-1>0) {
			if (isEmpty(xPos-1 , yPos)) {
				punkte += 2;
			} else {
				Terrain links = map[xPos-1][yPos];
				if (chosen.getWest()==links.getEast()) {
					punkte += 5;
				} else {
					punkte -= 2;
				}
			}
		}

		if (xPos+1<groesse) {
			if (isEmpty(xPos+1 , yPos)) {
				punkte += 2;
			} else {
				Terrain rechts = map[xPos+1][yPos];
				if (chosen.getEast()==recht.getWest()) {
					punkte += 5;
				} else {
					punkte -= 2;
				}
			}
		}

		if (yPos-1>0) {
			if (isEmpty(xPos , yPos-1)) {
				punkte += 2;
			} else {
				Terrain oben = map[xPos][yPos-1];
				if (chosen.getNorth()==oben.getSouth()) {
					punkte += 5;
				} else {
					punkte -= 2;
				}
			}
		}

		if (yPos+1<groesse) {
			if (isEmpty(xPos , yPos+1)) {
				punkte += 2;
			} else {
				Terrain unten = map[xPos][yPos+1];
				if (chosen.getSouth()==unten.getNorth()) { 
					punkte += 5;
				} else {
					punkte -=
				}
			}
		}
		return punkte;
	}
}