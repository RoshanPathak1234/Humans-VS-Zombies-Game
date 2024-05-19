import java.io.FileWriter;
import java.io.IOException;

public class Game {
    private Player Humans;
    private Player zombies;
    private Player winner;
    public FileWriter filePointer;

    public Game() {}

    public Game(int HumanCount,int HumanKillRate,int ZombieCount,int ZombieKillRate,FileWriter filePointer) {
        Humans = new Player(Player.PlayerType.HUMAN , HumanCount , HumanKillRate);
        zombies = new Player(Player.PlayerType.ZOMBIE , ZombieCount , ZombieKillRate);
        this.filePointer = filePointer;
        Humans.Info();
        zombies.Info();
        System.out.println("============================================================");
    }

    public void setHumans(int HumanCount , int HumanKillRate) {
        Humans = new Player();
        Humans.setPlayer(Player.PlayerType.HUMAN);
        Humans.setNumbers(HumanCount);
        Humans.setKillRate(HumanKillRate);
    }

    public void setZombies(int ZombieCount , int ZombieKillRate) {
        zombies = new Player();
        zombies.setPlayer(Player.PlayerType.ZOMBIE);
        zombies.setNumbers(ZombieCount);
        zombies.setKillRate(ZombieKillRate);
    }

    public void setFilePointer(FileWriter filePointer) {
        this.filePointer = filePointer;
    }
    public Player getHumans() {
        return Humans;
    }
    public Player getZombies() {
        return zombies;
    }
    public void setWinner(Player player) {
        winner = new Player();
        winner.setPlayer(player.getPlayer());
    }
    public Player getWinner() {
        return winner;
    }
    public void start(double timeStep, double simulationTime) throws IOException {
        double curr_time = 0;
        int curr_Humans = Humans.getNumbers();
        int curr_Zombies = zombies.getNumbers();

        double initial_rate_dHdt = - zombies.getKillRate() * curr_Zombies;
        double initial_rate_dZdt = - Humans.getKillRate() * curr_Humans;
        
        filePointer.write("Time," + "Humans," + "Zombies\n");

        while(curr_Humans > 0 && curr_Zombies > 0 && curr_time < simulationTime) {
            
            filePointer.append(curr_time + "," + curr_Humans + "," + curr_Zombies + "\n");

            double dHdt = - zombies.getKillRate() * curr_Zombies;
            double dZdt = - Humans.getKillRate() * curr_Humans;

            curr_Humans = (int) (curr_Humans + timeStep * (initial_rate_dHdt + dHdt ) / 2);
            curr_Zombies = (int) (curr_Zombies + timeStep * (initial_rate_dZdt + dZdt) / 2);

            curr_time += timeStep;

            initial_rate_dHdt = dHdt;
            initial_rate_dZdt = dZdt;
        }

        winner = curr_Humans > 0 ? Humans : zombies;

    }

    public void PrintResult() {
        System.out.println("Winner is  :  " + winner.getPlayer());
    }
}
