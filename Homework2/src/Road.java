import java.lang.Math;
public class Road {


    protected float length;
    protected float speedLimit;
    protected Location start;
    protected Location end;

    public Road(float length, Location start, Location end) {
        this.length = length;
        this.speedLimit = 80;
        this.start = start;
        this.end = end;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setEnd(Location end) {
        this.end = end;
    }
    public void setLength(float length) {

            this.length = length;

    }
    public float getLength() {
        return length;
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Road{" +
                ", length=" + length +
                ", start=" + start +
                ", end=" + end +
                ", speedLimit=" + speedLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return Float.compare(road.getLength(), getLength()) == 0 && Float.compare(road.getSpeedLimit(), getSpeedLimit()) == 0 && getStart().equals(road.getStart()) && getEnd().equals(road.getEnd());
    }


}
