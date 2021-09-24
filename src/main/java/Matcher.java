/*
  @author   george
  @project   bigId-task
  @class  Matcher
  @version  1.0.0 
  @since 22.09.21 - 16.14
*/



import model.Location;
import model.TextBlock;

import java.util.*;
import java.util.function.Supplier;

public class Matcher {
   private String namesAsString;
   private final TextBlock block;


    public Matcher(String namesAsString, TextBlock block) {
        this.namesAsString = namesAsString;
        this.block = block;
    }

    public Matcher(TextBlock block) {
        this.block = block;
        this.namesAsString = Constants.NAMES_AS_STRING;
    }

    public TextBlock getBlock() {
        return block;
    }

    private String getNamesAsString() {
        return namesAsString;
    }

    private String[] getNames(){
        return this.getNamesAsString().split(",");
    }

    public Map<String, List<Location>> getOutputMapForBlock(){
        Map<String, List<Location>> map = new HashMap<>();
        for (int i = 0; i < getNames().length; i++) {
            String keyword = getNames()[i];
            String text = block.getText();
            List<Integer> absMatches = getMatchesAbsPositionsInText(keyword, text);
            List<Integer> lineMatches = getListOfLinesWhereMatches(keyword, text);
            if (absMatches.size() != lineMatches.size()) System.out.println("ERROR");
            List<Location> locations = new ArrayList<>();
            for (int j = 0; j < lineMatches.size() ; j++) {
                int lineOffset = lineMatches.get(j) + this.getBlock().getId() * Constants.LINES_IN_BLOCK;
                long charOffset = absMatches.get(j)  + this.getBlock().getBeginsFrom();
                Location location = new Location(lineOffset, charOffset);
                locations.add(location);
            }
            map.put(keyword, locations);
        }
        return  map;
    }

    public List<Integer> getMatchesAbsPositionsInText(String keyword, String text){
        List<Integer> list =  new ArrayList<>();
        int position = 0;
        text = text.replaceAll("[^A-Za-z]", " ");
        while(true){
            position = text
                    .indexOf(" " + keyword + " ", position);  // surround by spaces to avoid complications
            if(position != -1) {
                list.add(position + 1);  //  + 1  - because of the first space in keyword
                position++;
            }else{
                break;
            }
        }
        return list;
    }

    public List<Integer> getListOfLinesWhereMatches(String keyword, String text){
        List<Integer> list =  new ArrayList<>();
        String[] lines = text.split(System.lineSeparator());
        for (int i = 0; i < lines.length ; i++) {
            int matches = (int) Arrays.stream(lines[i].replaceAll("[^A-Za-z]", " ").split(" "))
                    .filter(word -> word.equals(keyword)).count();
            for (int j = 0; j < matches; j++) {
                list.add(i);
            }
        }
        return list;
    }


}
