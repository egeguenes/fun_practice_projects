import java.util.Random;

public class Mehrfachgenerierung{
    static char[] type = new char[4];

    public static void main(String[] args){
        if (args.length > 0){
            int test = Integer.parseInt(args[0]);
            for (int i=0; i<test; i++){
                generate();
                print();
            }
        }else{
            generate();
            print();
         }
    }
    public static void generate(){
        Random random = new Random();
        for (int i=0; i<4 ; i++){
            int wurfel = random.nextInt(3);
            if (wurfel==0){
                type[i] = '*';
            } else if (wurfel==1){
                type[i] = 'o';
            } else {
                type[i] = '-';
            }
        }
    }
    public static void print(){
        System.out.println((type[3]==type[0] ? type[0] + " " : "\\ ") + type[0] + " " + type[0] + " " + type[0] + " " + (type[0]==type[1]? type[0] : "/"));
        System.out.println(type[3] + " " + (type[3]==type[0] ? type[3] + " " : "\\ ") + type[0] + " " + (type[0]==type[1] ? type[1] + " ": "/" + " ") + type[1]); 
        System.out.println(type[3] + " " + type[3] + " x " + type[1] + " " + type[1]);
        System.out.println(type[3] + " " + (type[3]==type[2] ? type[3] + " " : "/ " ) + type[2] + " " + (type[2]==type[1] ? type[2] + " " : " \\ ") + type[1]);
        System.out.println((type[3]==type[2] ? type[3] + " " : "/ ") + type[2] + " " + type[2]  + " " + type[2] + " " + (type[2]==type[1] ? type[2] + " " : " \\ "));
    }
}