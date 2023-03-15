public class Mall extends Location{

    private double coffePrice;
    private int numOfLevels;

    public Mall(String name, float x, float y, double coffePrice, int numOfLevels) {
        super(name, x, y);
        this.coffePrice = coffePrice;
        this.numOfLevels = numOfLevels;
    }

    public double getCoffePrice() {
        return coffePrice;
    }

    public void setCoffePrice(double coffePrice) {
        this.coffePrice = coffePrice;
    }

    public int getNumOfLevels() {
        return numOfLevels;
    }

    public void setNumOfLevels(int numOfLevels) {
        this.numOfLevels = numOfLevels;
    }
}
