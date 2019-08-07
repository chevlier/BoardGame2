
public class Movement implements Play {
   final int BORDER_LENGTH = 4;//try to parametrize board size
   final int BORDER_WIDTH = 4;

    public void movePlayer(String movementCommand){

        int angle = 0;
        int bufferMove = 0;
        char direction = 'N';

        int[] positionCoordinates = {0,0};
        char[] movementCommandArray = movementCommand.toCharArray();//remove arrays, use java.collections.List or Set or whatever

        //Use a factory class that receives a single char - and returns Object (that was of COmmand interface: one method: movePLayer())
        Print print = new Printer();

        for(char e : movementCommandArray){
            switch (e){ //switch is not recommended practice, use polymorphism§
                case'R':
                    angle = angle + 90;
                    direction = directionHandler(angle);
                    break;
                case 'M':
                    positionCoordinates = movementHandler(positionCoordinates,direction);
                    break;
                case 'L':
                    angle -= 90;
                    direction = directionHandler(angle);
                    break;
            }
        }
        print.printPositionMessage(positionCoordinates, direction);
    }

    public  char directionHandler(int angle){

        char currentAngle = 'N';
        if(angle >= 360){
            angle -= 360;
        }
        switch (angle){
            case 0:
                currentAngle = 'N';
                break;
            case 90:
                currentAngle = 'E';
                break;
            case 180:
                currentAngle = 'S';
                break;
            case 270:
                currentAngle = 'W';
                break;
            case 360:
                currentAngle = 'N';
                break;
        }
        return currentAngle;
    }  //Can be private ??? Unit tests will be "covered" while testing moviePLayer method that use this ??

    public boolean allowedPositionHandler(int[] position){
        boolean allowedPosition = false;
        if(position[0]>=0 && position[0]<= BORDER_LENGTH && position[1]<= BORDER_WIDTH && position[1]>=0)
            allowedPosition = true;
        return allowedPosition;
    } //Can be private ???

    public int[] movementHandler(int[] playerPositionCoordinates ,char directionBuffer){
        boolean allowedPosition = false;
        int[] newPosition = {0,0};
        switch(directionBuffer){
            case 'N':
                newPosition[1] = playerPositionCoordinates[1] + 1;
                if(allowedPositionHandler(newPosition)) {playerPositionCoordinates[1] += 1;}
                break;
            case 'S':
                newPosition[1] = playerPositionCoordinates[1] - 1;
                if(allowedPositionHandler(newPosition)) {playerPositionCoordinates[1] -= 1;}
                break;
            case 'W':
                newPosition[0] = playerPositionCoordinates[0] - 1;
                if(allowedPositionHandler(newPosition)) {playerPositionCoordinates[0] -= 1;}
                break;
            case 'E':
                newPosition[0] = playerPositionCoordinates[0] + 1;
                if(allowedPositionHandler(newPosition)) {playerPositionCoordinates[0] += 1;}
                break;
        }
        return playerPositionCoordinates;
    } //Can be private ???

}
