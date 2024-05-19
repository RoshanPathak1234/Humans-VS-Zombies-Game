
public class Player {
    public enum PlayerType {
        HUMAN,
        ZOMBIE
    }

    private int numbers;
    private double killRate;
    private PlayerType player;

    public Player(PlayerType player, int numbers, double killRate) {
        this.player = player;
        this.numbers = numbers;
        this.killRate = killRate;
    }

    public Player() {}

    public void setPlayer(PlayerType player) {
        this.player = player;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setKillRate(double killRate) {
        this.killRate = killRate;
    }

    public PlayerType getPlayer() {
        return player;
    }

    public int getNumbers() {
        return numbers;
    }

    public double getKillRate() {
        return killRate;
    }

    public void Info() {
        System.out.println("============================================================");
        System.out.println("\n Player  :  " + player + "\n Numbers  :  " + numbers + "\n Kill Rate  :  " + killRate + "\n"); 
        System.out.println("............................................................");
    }

}
