import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col, row;

    public static void input() {
        System.out.print(ox.getCurrentPlayer() + " (col): ");
        col = sc.nextInt();
        System.out.print(ox.getCurrentPlayer() + " (row): ");
        row = sc.nextInt();
    }
    public static void main(String[] args){
        ox = new OX();
        while (true) {
            System.out.print(ox.getTabeString());
            input();
            ox.put(col, row);
            ox.SwitchPlayer();
            if(ox.checkWin(col,row)){
                break;
            }
        }
    }
}
