package Models;

public class Bowler {

    public String name;
    public double balls;
    public int runs;
    public int wickets;
    public double economy;

    public Bowler(){
        this.balls = 0;
        this.runs = 0;
        this.wickets = 0;
        this.economy = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalls() {
        return balls;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public String getOvers(){

        return "";
    }
}
