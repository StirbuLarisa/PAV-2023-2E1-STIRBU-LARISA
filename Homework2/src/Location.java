public class Location {

    protected String name;
    protected float x;
    protected float y;

    public Location(){}

    public Location(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean verifyEqualCoords(Location o){
        if (this.x == o.x && this.y == o.y)
            return true;
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Float.compare(location.getX(), getX()) == 0 && Float.compare(location.getY(), getY()) == 0 && getName().equals(location.getName());
    }

}
