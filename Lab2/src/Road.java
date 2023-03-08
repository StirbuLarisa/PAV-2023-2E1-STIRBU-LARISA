import java.lang.Math;
public class Road {

    private RoadType type;
    private float length;
    private float speedLimit;
    private Location start;
    private Location end;

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }
    public void setStart(Location start) {
        this.start = start;
    }

    public void setEnd(Location end) {
        this.end = end;
    }
    public void setLength(float length) {
        double distance = Math.sqrt(Math.pow(end.getX()- start.getX(), 2) + Math.pow((start.getY()-end.getY()),2));
        if(length<distance){
            System.out.println("\nDrumul nu poate conecta locatiile\n");
        }
        else {
            this.length = length;
            System.out.println("Drumul poate conecta locatiile");
        }


    }


    public RoadType getType() {
        return type;
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
                "type=" + type +
                ", length=" + length +
                ", start=" + start +
                ", end=" + end +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
