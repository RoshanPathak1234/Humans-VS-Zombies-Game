import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter GameFile = new FileWriter("./GameFile.csv");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the initial humans count : \t");
        int HumanCount = scan.nextInt();
        System.out.println("Enter the Human Kill Rate : \t");
        int HumanKillRate = scan.nextInt();
        System.out.println("Enter initial zombie count : \t");
        int ZombieCount = scan.nextInt();
        System.out.println("Enter the zombie kill Rate : \t");
        int ZombieKillRate = scan.nextInt();
        System.out.println("************************************************************");
        Game newGame = new Game(HumanCount, HumanKillRate, ZombieCount, ZombieKillRate, GameFile);
        newGame.start(0.01, 200);
        newGame.PrintResult();
        System.out.println("*************************************************************");

        
        GameFile.close();
        scan.close();
    }
}