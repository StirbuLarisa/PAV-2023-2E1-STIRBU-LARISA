public class GasStation extends Location{

    private double gasPrice;
    private double dieselPrice;

    public GasStation(String name, float x, float y, double gasPrice, double dieselPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
        this.dieselPrice = dieselPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(double dieselPrice) {
        this.dieselPrice = dieselPrice;
    }
}
