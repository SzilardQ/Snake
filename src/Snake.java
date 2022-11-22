
public class Snake {

    public Direction getLastDirection() {
        return lastDirection;
    }

    public void setLastDirection(Direction lastDirection) {
        this.lastDirection = lastDirection;
    }

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
    private Point[] points ;
    AudColor color = AudColor.BLUE;

    private Direction nextDirection=Direction.UP;
    private Direction lastDirection=Direction.UP;

    public Snake(int x, int y, int length){
        if(length<0){
            throw new RuntimeException("invalid Snake length ");

        }
        points = new Point[length];
        points[0] = new Point(x,y);

    }

    public Snake(int x, int y){
        this(x,y,5);
    }

    public void paint(AudGraphics g){
        g.setColor(color);
        for(int i = 0; i < points.length; i++){
            if(points[i] != null){
                g.fillRect(points[i].getX(), points[i].getY(), SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
            }

        }
    }

    public Direction getNextDirection(){
        return nextDirection;
    }

    public void setNextDirection(Direction direction){
        nextDirection = direction;
    }

    public void step(){
        System.arraycopy(points, 0 , points, 1 , points.length-1);
        switch(nextDirection){

            case RIGHT:
                points[0] = new Point(points[1].getX() + 1, points[1].getY());
                break;
            case DOWN:
                points[0] = new Point(points[1].getX(), points[1].getY() + 1);
                break;
            case LEFT:
                points[0] = new Point(points[1].getX() - 1, points[1].getY());
                break;
            case UP:
                points[0] = new Point(points[1].getX(), points[1].getY() - 1);
                break;

        }
    }



}
