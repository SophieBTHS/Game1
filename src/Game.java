public class Game {
    private boolean bonus = false;
    private Level levelOne = new Level();
    private Level levelTwo = new Level();
    private Level levelThree = new Level();
    private Level[] levels = {levelOne, levelTwo, levelThree};
    public boolean isBonus(){
        return bonus;
    }
    public void setup(boolean[] goals, int[] points, boolean bonus){
        for(int i = 0; i<3;i++){
            levels[i].setGoalReached(goals[i]);
            levels[i].setPoints(points[i]);
        }
        this.bonus = bonus;
    }
    public int getScore(){
        int points = 0;
        for(int i = 0;i<3;i++){
            int levelPoints = levels[i].getPoints();
            if(levels[i].goalReached()){
                if (this.isBonus()){
                    levelPoints *= 3;
                }
                points += levelPoints;
            }
            else{
                return points;
            }
        }
        return points;
   }
}
