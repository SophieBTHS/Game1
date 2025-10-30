public class Level {
    private boolean goalReached;
    private int points;
    public void setGoalReached(boolean goalReached){this.goalReached = goalReached;}
    public void setPoints(int points){this.points = points;}
    public boolean goalReached(){
        return goalReached;
    }
    public int getPoints(){
        if(goalReached){
            return points;
        }
        else{
            return 0;
        }
    }
}
