public class City extends Location{

    private int population;
    private double areaKm;

    public City(String name, float x, float y, int population, double areaKm) {
        super(name, x, y);
        this.population = population;
        this.areaKm = areaKm;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAreaKm(double areaKm) {
        this.areaKm = areaKm;
    }

    public int getPopulation() {
        return population;
    }

    public double getAreaKm() {
        return areaKm;
    }
}
