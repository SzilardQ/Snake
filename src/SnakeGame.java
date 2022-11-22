
public class SnakeGame extends AudGameWindow{
    public static final int SQUARE_SIZE = 16;

    public static final int STEP_TIME = 100;

    private int score =0;
    private int width;
    private int height;

    private Snake snake;

    private long lastSnakeUpdate;




    public SnakeGame(){
        setTitle("AuD-Snake - Score:"+ score );
        width = getGameAreaWidth()/SQUARE_SIZE;
        height = getGameAreaHeight()/SQUARE_SIZE;
        snake = new Snake(width * 8, height * 8);
        lastSnakeUpdate = System.currentTimeMillis();


    }

    @Override
    public void updateGame(long time) {
        for(double stamp = (time - lastSnakeUpdate)/STEP_TIME; stamp >= 0; stamp--){
            snake.step();
            lastSnakeUpdate += STEP_TIME;
        }
        lastSnakeUpdate = time;



        

    }

    @Override
    public void paintGame(AudGraphics g) {
    g.drawRect(0,0,getGameAreaWidth(),getGameAreaHeight());
    snake.paint(g);



    }


    @Override
    public void handleInput(int keyCode) {

        switch(keyCode){
            case KeyEvent.VK_UP:
                if(snake.getNextDirection() != Snake.Direction.DOWN){
                    snake.setNextDirection(Snake.Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(snake.getNextDirection() != Snake.Direction.UP){
                    snake.setNextDirection(Snake.Direction.DOWN);
                }

                break;
            case KeyEvent.VK_LEFT:
                    if(snake.getNextDirection() != Snake.Direction.RIGHT){
                        snake.setNextDirection(Snake.Direction.LEFT);
                    }
                break;
            case KeyEvent.VK_RIGHT:
                if(snake.getNextDirection() != Snake.Direction.LEFT){
                    snake.setNextDirection(Snake.Direction.RIGHT);
                }
        }
            snake.setLastDirection(snake.getNextDirection());
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.start();
    }
}
