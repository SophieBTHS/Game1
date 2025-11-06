public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        boolean[] totalGoals = {true, true, true, true, true, true, false, false, true, false, true, true, false, true, true, false};
        int[] points = {200, 100, 500};
        for(int i = 0;i<16; i+=4){
            boolean[] goals = {totalGoals[i], totalGoals[i+1], totalGoals[i+2]};
            g.setup(goals, points, totalGoals[i+3]);
            System.out.println(g.getScore());
        }
    }

}
