public class Highway extends Road{

    private int numOfExits;

    public Highway(float length, Location start, Location end, int numOfExits) {
        super(length, start, end);
        this.speedLimit = 130;
        this.numOfExits = numOfExits;
    }

    public int getNumOfExits() {
        return numOfExits;
    }

    public void setNumOfExits(int numOfExits) {
        this.numOfExits = numOfExits;
    }
}
