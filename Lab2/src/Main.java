public class Main {
    public static void main(String[] args) {
        Location city = new Location() ;
        city.setName("Paris");
        city.setType(LocationType.CITY);
        city.setX(48.86471f);
        city.setY(2.349014f);

        Location hood = new Location();
        hood.setName("Bucuresti");
        hood.setType(LocationType.CITY);
        hood.setX(44.439663f);
        hood.setY(26.096306f);

        Location gasStation = new Location();
        gasStation.setName("Lukoil");
        gasStation.setType(LocationType.GAS_STATION);
        gasStation.setX(44.56f);
        gasStation.setY(26.78f);

        Road dn1 = new Road();
        dn1.setType(RoadType.EXPRESS);
        dn1.setSpeedLimit(40);
        dn1.setStart(hood);
        dn1.setEnd(gasStation);
        dn1.setLength(20);

        Road highway = new Road();
        highway.setType(RoadType.HIGHWAY);
        highway.setSpeedLimit(160);
        highway.setStart(hood);
        highway.setEnd(city);
        highway.setLength(0);

        System.out.println(city.toString());
        System.out.println(hood.toString());
        System.out.println(gasStation.toString());
        System.out.println(dn1.toString());
        System.out.println(highway.toString());

    }
}