package game_of_life;

public class Cell {

    private boolean isAlive;
    private int livingNeighboursCount;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }


    public void checkNextLifeState() {
        if(isAlive){
            if(livingNeighboursCount < 2 || livingNeighboursCount > 3){
                isAlive = false;
            }
        }
        else{
            if(livingNeighboursCount == 3){
                isAlive = true;
            }
        }
    }

    public boolean isAlive() {
        return isAlive;
    }
}
