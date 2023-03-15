public class Express extends Road{


    private int numOfLines;


    public Express(float length, Location start, Location end, int numOfLines) {
        super(length, start, end);
        this.speedLimit=110;
        this.numOfLines = numOfLines;
    }

    public int getNumOfLines() {
        return numOfLines;
    }

    public void setNumOfLines(int numOfLines) {
        this.numOfLines = numOfLines;
    }
}
