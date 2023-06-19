import java.util.Random;

public class Terrain{
	private Random rnd = new Random();
	private String[] type = new String[4];


	public Terrain(){
		generate();
	}

	public Terrain generate(){
		for (int i=0; i<4; i++){
			int t = rnd.nextInt(3);
			if (t==0){
				type[i] = "*";
			} else if(t==1){
				type[i] = "-";
			} else {
				type[i] = "o";
			}
		}
		return this;
	}

	public String print(){
		StringBuilder sb = new StringBuilder();
		sb.append((type[0]==type[3] ? type[0] + " " : "\\ ") + type[0] + " " + type[0] +  " " + type[0] + (type[0]==type[1] ? type[0] + " " : " /"))
			.append("\n")
			.append(type[3] + " " + (type[0]==type[3] ? type[0] + " " : "\\ ") + type[0] + " " + (type[0]==type[1] ? type[0] + " " : "/ ") + type[1])
			.append("\n")
			.append(type[3] + " " + type[3] + " x " + type[1] + " " + type[1])
			.append("\n")
			.append(type[3] + " " + (type[2]==type[3] ? type[2] + " " : "/ ") + type[2] + " " + (type[1]==type[2] ? type[2] + " " : "\\ ") + type[1])
			.append("\n")
			.append((type[2]==type[3] ? type[2] + " " : "/ ") + type[2] + " " + type[2] +  " " + type[2] + (type[1]==type[2] ? type[1] + " " : " \\"));
		return sb.toString();
	}

	public String getNorth(){
		return type[0];
	}

	public String getEast(){
		return type[1];
	}

	public String getSouth(){
		return type[2];
	}

	public String getWest(){
		return type[3];
	}
}