public abstract class GameItem {
    private Point position;



    public GameItem(int x, int y){
        position = new Point(x,y);

    }

    public Point getPosition(){
        return position;
    }

    public abstract void paint(AudGraphics g);
}
