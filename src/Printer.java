import java.util.Arrays;

public class Printer implements Print {
    public void printPositionMessage(int[] position , char directory){
        Arrays.stream(position).forEach(System.out::print);
        System.out.println(directory);
    }
}
