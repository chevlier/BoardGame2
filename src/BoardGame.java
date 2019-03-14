import java.util.Scanner;

public class BoardGame {
    public static void main (String[] args){
        Printer printer = new Printer();
        Movement startGame = new Movement();
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.next();

        Play movePlayer = startGame;
        Print displayer = printer;

        movePlayer.movePlayer(commands);
    }
}
