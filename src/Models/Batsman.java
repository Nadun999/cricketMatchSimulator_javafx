package Models;

public class Batsman {

    public String name;
    public int runs;
    public int balls;
    public String methodOfDissmal;
    public String bowlerName;
    public Integer battingOrder;


    public Batsman(){
        this.runs = 0;
        this.balls = 0;
        this.methodOfDissmal = "";
        this.bowlerName = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public Integer getIntegerRuns() {
        return (Integer) runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public String getMethodOfDissmal() {
        return methodOfDissmal;
    }

    public void setMethodOfDissmal(String methodOfDissmal) {
        this.methodOfDissmal = methodOfDissmal;
    }

    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public Integer getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

}
