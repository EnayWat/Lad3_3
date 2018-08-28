import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col, row;

    public static void input() {
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " (col) :");
            col = sc.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (row) :");
            row = sc.nextInt();
            canPut = ox.put(col, row);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }
        }while (!canPut);
    }
    public static void main(String[] args){
        ox = new OX();
        while (true) {
            printTable();
            input();
            ox.SwitchPlayer();

        }
    }

    private static void printTable() {
        System.out.print(ox.getTabeString());
    }
}
