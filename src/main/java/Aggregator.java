/*
  @author   george
  @project   bigId-task
  @class  Aggregator
  @version  1.0.0 
  @since 23.09.21 - 17.49
*/



import model.Location;

import java.util.*;

public class Aggregator {

    private final List<Map<String, List<Location>>> listOfMaps;

    public Aggregator(List<Map<String, List<Location>>> listOfMaps) {
        this.listOfMaps = listOfMaps;
    }

    public List<Map<String, List<Location>>> getListOfMaps() {
        return listOfMaps;
    }

    public Map<String, List<Location>> aggregateList(){
        Map<String, List<Location>> mapOutput = new HashMap<>();
        Set<String> keywords = this.getListOfMaps().get(0).keySet();
        for ( String keyword: keywords ){
            List<Location> locations = new ArrayList<>();
            for (Map<String, List<Location>> map: this.getListOfMaps()){
               locations.addAll(map.get(keyword));
            }
            mapOutput.put(keyword, locations);
        }
        return  mapOutput;
    }

    public void showResult(){
        Map<String, List<Location>> map = this.aggregateList();

        for (Map.Entry<String, List<Location>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }


}
