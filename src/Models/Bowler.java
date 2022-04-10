package Models;

public class Bowler extends Player {

    private double balls;
    private int wickets;


    public Bowler(){
        super();
        this.balls = 0;
        this.wickets = 0;
    }

    public double getBalls() {
        return balls;
    }

    public void setBalls(double balls) {
        this.balls = balls;
    }

    public int getWickets() {
        return wickets;
    }

    public Integer getIntegerWickets() {
        return (Integer)wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
