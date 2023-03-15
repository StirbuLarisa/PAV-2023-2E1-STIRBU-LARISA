import java.util.ArrayList;

public class Problem {

    private Map map;
    private Location start;
    private Location end;

    public Problem(){

        map = new Map();
        start = new Location();
        end = new Location();

        City city = new City("Paris", 48.86471f, 2.349014f, 6000000,7.4) ;
        City hood = new City("Bucuresti", 44.439663f, 26.096306f, 2000000,4.4) ;
        GasStation gasStationBuc1 = new GasStation("Lukoil",44.56f,26.78f,6.3,7.2);
        GasStation gasStationBuc2 = new GasStation("Mol",44.56f,26.78f,6.7,7.4);
        Mall mallBuc = new Mall("Plaza",45.1f,27.32f,8.6,4);
        Mall mallPa = new Mall("ParisMall",47.1f,2.472f,14.4,3);

        Location fakeEnd = new Location();

        map.addLocation(city);
        map.addLocation(hood);
        map.addLocation(gasStationBuc1);
        map.addLocation(gasStationBuc2);
        map.addLocation(mallBuc);
        map.addLocation(mallPa);

        Highway parBuc = new Highway(19876,city,hood,52);
        Express parMall = new Express(78,city,mallPa,2);
        National dn1 = new National(21,hood,gasStationBuc1,2);
        National dn3 = new National(21,hood,gasStationBuc2,2);
        National dn2 = new National(23,gasStationBuc1,mallBuc,3);

        map.addRoad(parBuc);
        map.addRoad(parMall);
        map.addRoad(dn1);
        map.addRoad(dn2);
        map.addRoad(dn3);

        start = mallPa;
        end = mallBuc;


    };

    /**
     * Functia verifica daca lungimile drumurilor sunt suficiet de mari pentru a conecta doua locatii
     * @return true, daca lungimile sunt suficiente
     *
     */
    public boolean verifyLength(){

        ArrayList <Road> road = map.getRoads();
        for(int i=0 ;i<road.size();i++){

            double distance = Math.sqrt(Math.pow(road.get(i).getEnd().getX()- road.get(i).getStart().getX(), 2) + Math.pow((road.get(i).getEnd().getY()-road.get(i).getStart().getY()),2));
            if(road.get(i).getLength()<distance){
                System.out.println("\nDrumul nu poate conecta locatiile\n");
                return false;
            }
            else
                System.out.println("\nDrumul poate conecta locatiile\n");

        }
        return true;
    }

    /**
     * Verifica daca locatia finala este inclusa in map
     * @return true, daca este inclusa
     *
     */
    public boolean verifyEnd(){

        ArrayList <Location> locations = map.getLocations();

        for(int i=0 ;i<locations.size();i++){

            if(locations.get(i).equals(end)){
                System.out.println("\nEnd corect\n");
                return true;
            }

        }
        System.out.println("\nEnd gresit\n");
        return false;

    }

    /**
     * verifica daca locatia de start este inclusa in map
     * @return true, daca este inclusa
     *
     */
    public boolean verifyStart(){

        ArrayList <Location> locations = map.getLocations();

        for(int i=0 ;i<locations.size();i++){

            if(locations.get(i).equals(start)){
                System.out.println("\nStart corect\n");
                return true;
            }

        }
        System.out.println("\nStart gresit\n");
        return false;

    }

    /**
     * verifica daca startul si finalul difera
     * @return true, daca difera
     */
    public boolean diffStartEnd(){
        if(end.equals(start))
            return false;
        return true;

    }

    /**
     * verifica daca instanta problemei corespunde cerintelor
     * @return true, daca este corecta
     */

    public boolean isCorrect(){

        if(verifyEnd() && verifyStart() && diffStartEnd() &&verifyLength()){
            System.out.println("\nProblema corect\n");
            return true;

        }
        else{
            System.out.println("\nProblema gresita\n");
            return true;

        }
    }

    /**
     * Dupa verificarea instantei problemei, functia apeleaza un DFS pentru a determina daca exista un drum intre start si end
     * @return true, daca exista si afiseaza ordinea in care au fost vizitate locatiile;
     */
    public boolean isPathBetween(){

        if(isCorrect()){
            ArrayList<Location> visited = new ArrayList<Location>();
            if( DFS(start,end,visited) ){
                System.out.println("exista drum");

                for (Location i: visited){
                    System.out.println(i.getName());
                }
            }

            else
                System.out.println("nu exista drum");
        }

        return false;

    }

    /**
     * Functia foloseste un algoritm DFS pentru un graf neorientat
     * @param current
     * @param end
     * @param visited
     * @return true, daca se gaseste drum
     */
    public boolean DFS (Location current, Location end, ArrayList<Location>visited){

        visited.add(current);
        if (current.equals(end)) {
            return true;
        }

        ArrayList <Road> road = map.getRoads();

        for (int i=0; i<road.size(); i++) {
            if (road.get(i).start.equals(current) && !visited.contains(road.get(i).end)) {
                if (DFS(road.get(i).end, end, visited)) {
                    return true;
                }
            }
            if (road.get(i).end.equals(current) && !visited.contains(road.get(i).start)) {
                if (DFS(road.get(i).start, end, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

}
