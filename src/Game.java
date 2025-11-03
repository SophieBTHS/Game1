public class Game {
    private boolean bonus = false;
    public void makeBonus(){bonus = true;}
    private Level levelOne = new Level();
    private Level levelTwo = new Level();
    private Level levelThree = new Level();
    private Level[] levels = {levelOne, levelTwo, levelThree};
    public boolean isBonus(){
        return bonus;
    }
    public void setup(boolean[] goals, int[] points){
        for(int i = 0; i<3;i++){
            levels[i].setGoalReached(goals[i]);
            levels[i].setPoints(points[i]);
        }

    }
    public int getScore(){
        int points = 0;
        for(int i = 0;i<3;i++){
            if(levels[i].goalReached()){
                points += levels[i].getPoints();
                if (bonus){
                    points *= 3;
                }
            }
            else{
                return points;
            }
        }
        return points;
   }
}
