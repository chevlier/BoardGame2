import java.util.Scanner;
//try to separate classes into packages and avoid public access modificator where possible
public class BoardGame {
    public static void main (String[] args){
        Printer printer = new Printer();
        Movement startGame = new Movement();//inline
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.next();

        Play movePlayer = startGame;
        Print displayer = printer;

        new Movement().movePlayer(commands);
    }
}
