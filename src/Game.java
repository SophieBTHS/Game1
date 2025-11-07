import java.util.Scanner;
public class Game {
    private boolean bonus = false;
    private Level levelOne = new Level();
    private Level levelTwo = new Level();
    private Level levelThree = new Level();
    private Level[] levels = {levelOne, levelTwo, levelThree};
    public boolean isBonus(){
        return bonus;
    }
    public Game(boolean[] goals, int[] points, boolean bonus){
        for(int i = 0; i<3;i++){
            levels[i].setGoalReached(goals[i]);
            levels[i].setPoints(points[i]);
        }
        this.bonus = bonus;
    }
    public Game(){}
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
   public void play(){
        bonus = false;
        Scanner s = new Scanner(System.in);
        System.out.println("Testing mode?");
        if(s.nextBoolean()){
            System.out.println("How many points did you earn?");
            levelOne.setPoints(s.nextInt());
            levelOne.setGoalReached(true);
            levelTwo.setGoalReached(false);
        }
        else{
            System.out.println("Welcome to the number guessing game!!!");
            System.out.println("Choose a difficulty level from 1 to 20");
            int difficulty = 21 - s.nextInt();
            int i = 0;
            while(i<3) {
                System.out.println("How many points do you want to try for in Level " + (i+1) + "?");
                int points = s.nextInt();
                levels[i].setPoints(points);
                System.out.println("Choose a random number from 0 to " + ((points / (difficulty)) * (i + 1) - 1));
                int randNum = (int)(Math.random() * (points/difficulty) * (i+1));
                if(s.nextInt() == randNum) {
                    System.out.println("You got it!\n");
                    levels[i].setGoalReached(true);
                }
                else{
                    System.out.println("That's wrong :(, it was "+randNum+ "\n");
                    levels[i].setGoalReached(false);
                    i = 100;
                }
                i++;
            }
            if(this.getScore() > 50){
                System.out.println("How many points do you have right now if it was multiplied by 3 and subtracted from 200?");
                if(s.nextInt() == (200 - (3 * this.getScore()))){
                    bonus = true;
                    System.out.println("That's right!!!\n");
                }
                else System.out.println("WRONG\n");
            }
            System.out.println("You got " + this.getScore() + " points!");
        }
   }
   public int playManyTimes(int num){
        int result = 0;
        for(int i = 0; i<num;i++){
            this.play();
            if (this.getScore() > result) result = this.getScore();
        }
        System.out.println("Your best score was " + result);
        return result;
   }
}
