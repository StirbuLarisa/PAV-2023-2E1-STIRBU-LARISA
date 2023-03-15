public class National extends Road{

    private int numOfLines;


    public National(float length, Location start, Location end, int numOfLines) {
        super(length, start, end);
        this.speedLimit = 90;
        this.numOfLines = numOfLines;
    }

    public int getNumOfLines() {
        return numOfLines;
    }

    public void setNumOfLines(int numOfLines) {
        this.numOfLines = numOfLines;
    }
}
