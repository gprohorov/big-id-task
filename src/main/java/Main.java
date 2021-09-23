/*
  @author   george
  @project   big-id-task
  @class  Main
  @version  1.0.0 
  @since 23.09.21 - 20.38
*/


import model.Location;
import model.TextBlock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        String urlAsString = "https://norvig.com/big.txt";
        String namesAsString = "James,John,Robert,Michael,William,David,Richard," +
                "Charles,Joseph,Thomas,Christopher,Daniel,Paul,Mark,Donald" +
                ",George,Kenneth,Steven,Edward,Brian,Ronald,Anthony,Kevin," +
                "Jason,Matthew,Gary,Timothy,Jose,Larry,Jeffrey," +
                "Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory," +
                "Joshua,Jerry,Dennis,Walter,Patrick,Peter,Harold,Douglas," +
                "Henry,Carl,Arthur,Ryan,Roger";

        List<TextBlock> blocks = Utils.splitTextIntoBlocks(urlAsString);
        List<Map<String, List<Location>>> list = new ArrayList<>();

        for (int i = 0; i < blocks.size() ; i++) {
            Matcher matcher = new Matcher(namesAsString, blocks.get(i));
            list.add(matcher.getOutputMapForBlock());
        }

        Aggregator aggregator = new Aggregator(list);
        aggregator.showResult();
    }

}
