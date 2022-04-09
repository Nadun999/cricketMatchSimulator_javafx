package Models;

public class Bowler extends Player {

//    public String name;
    public double balls;
//    public int runs;
    public int wickets;


    public Bowler(){
        super();
        this.balls = 0;
        this.runs = 0;
        this.wickets = 0;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public double getBalls() {
        return balls;
    }

//    public int getRuns() {
//        return runs;
//    }

//    public void setRuns(int runs) {
//        this.runs = runs;
//    }

    public int getWickets() {
        return wickets;
    }

    public Integer getIntegerWickets() {
        return (Integer)wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public String getOvers(){

        return "";
    }
}
