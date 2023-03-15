import java.util.ArrayList;

public class Map {

    private ArrayList<Location> locations;
    private ArrayList <Road> roads;

    public Map() {
        this.locations = new ArrayList<Location>();
        this.roads = new ArrayList<Road>();
    }

    /**
     * Functia adauga in lista de locatii obiectuldat ca parametru, verificand daca acesta nu a fost adaugat in prealabil
     * @param obj
     *
     */
    public void addLocation(Location obj){

        for (int i=0; i<locations.size(); i++){

            if(locations.get(i).verifyEqualCoords(obj)){
                System.out.println("Aceasta locatie deja este adaugata");
                return;
            }
        }
        locations.add(obj);
        System.out.println("Locatie adaugata cu succes");
    }

    /**
     * Functia adauga in lista de drumuri obiectul dat ca parametru, verificand daca acesta nu a fost adaugat in prealabil
     * @param obj
     */
    public void addRoad(Road obj){

        for (int i=0; i<roads.size(); i++){

            if(roads.get(i).equals(obj)){
                System.out.println("Acest drum deja este adaugat");
                return;
            }
        }
        roads.add(obj);
        System.out.println("Drum adaugat cu succes");
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }
}

