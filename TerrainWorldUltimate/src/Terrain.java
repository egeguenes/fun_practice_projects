import java.util.Random;

public class Terrain {
    private char[] type = new char[4];
    private Random rnd = new Random();

    public Terrain() {
        generate();
    }

    public void print() {
        System.out.println(((type[3] == type[0]) ? type[0] + " " : "\\ ") + type[0] + " " + type[0] + " " + type[0] + ((type[0] == type[1]) ?  " " + type[0]  : " /"));
        System.out.println(type[3] + ((type[3] == type[0]) ? " " + type[0] + " " : " \\ ") + type[0] + ((type[0] == type[1]) ? " " + type[0] + " " : " / ") + type[1]);
        System.out.println(type[3] + " " + type[3] + " x " + type[1] + " " + type[1]);
        System.out.println(type[3] + ((type[2] == type[3]) ? " " + type[2] + " " : " / ") + type[2] + ((type[1] == type[2]) ? " " + type[1] + " " : " \\ ") + type[1]);
        System.out.println(((type[2] == type[3]) ? type[2] + " " : "/ ") + type[2] + " " + type[2] + " " + type[2] + ((type[1] == type[2]) ? " " + type[1] : " \\"));
    }

    public String getRow(int n) {
        assert n >= 0 && n < 5;
        switch (n) {
            case 0 :
                return ((type[3] == type[0]) ? type[0] + " " : "\\ ") + type[0] + " " + type[0] + " " + type[0] + ((type[0] == type[1]) ?  " " + type[0]  : " /");
            case 1 :
                return type[3] + ((type[3] == type[0]) ? " " + type[0] + " " : " \\ ") + type[0] + ((type[0] == type[1]) ? " " + type[0] + " " : " / ") + type[1];
            case 2 :
                return type[3] + " " + type[3] + " x " + type[1] + " " + type[1];
            case 3 :
                return type[3] + ((type[2] == type[3]) ? " " + type[2] + " " : " / ") + type[2] + ((type[1] == type[2]) ? " " + type[1] + " " : " \\ ") + type[1];
            case 4 :
                return ((type[2] == type[3]) ? type[2] + " " : "/ ") + type[2] + " " + type[2] + " " + type[2] + ((type[1] == type[2]) ? " " + type[1] : " \\");
        }
        return "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<5 ; i++) {
            sb.append(this.getRow(i) + "\n");
        }
        return sb.toString();
    }

    public char getNorth() {
        return type[0];
    }

    public char getEast() {
        return type[1];
    }

    public char getSouth() {
        return type[2];
    }

    public char getWest() {
        return type[3];
    }

    public void generate() {
        for (int i = 0 ; i < type.length ; i++) {
            int a = rnd.nextInt(3);
            if (a == 0) {
                type[i] = '*';
            } else if (a == 1) {
                type[i] = 'o';
            } else {
                type[i] = '-';
            }
        }
    }
}
