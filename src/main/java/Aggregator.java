/*
  @author   george
  @project   bigId-task
  @class  Aggregator
  @version  1.0.0 
  @since 23.09.21 - 17.49
*/



import model.Location;

import java.util.*;
import java.util.stream.Collectors;

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
               locations = locations.stream()
                       .sorted(Comparator.comparing(Location::getLineOffset).thenComparing(Location::getCharOffset))
                       .collect(Collectors.toList());
            }
            mapOutput.put(keyword, locations);
        }
        return  mapOutput;
    }

    public void showRawResults(){
        Map<String, List<Location>> map = this.aggregateList();
        for (Map.Entry<String, List<Location>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void showPretty(){
        StringBuilder stringBuilder;
        String spaces = "                       ";
        String key = null;
        Map<String, List<Location>> map = this.aggregateList();
        for (Map.Entry<String, List<Location>> entry : map.entrySet()){
            System.out.println();
            key = entry.getKey();
            stringBuilder = new StringBuilder();
            String prefix = stringBuilder.append(spaces, 0, key.length() + 5).toString();
            System.out.print(entry.getKey() + " -> " );
            if (entry.getValue().isEmpty()) {
                System.out.println("[]");
            }else {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i == 0 ){
                        System.out.println(" " + entry.getValue().get(i));
                    }else{
                        System.out.println(prefix + entry.getValue().get(i));
                    }
                }
            }
        }
    }

}
