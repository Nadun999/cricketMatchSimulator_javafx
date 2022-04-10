package Models;

public class Batsman extends Player {

    protected int balls;
    protected String methodOfDissmal;
    protected String bowlerName;
    protected Integer battingOrder;


    public Batsman(){
        super();
        this.balls = 0;
        this.methodOfDissmal = "";
        this.bowlerName = "";
    }

    public Integer getIntegerRuns() {
        return (Integer) runs;
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
