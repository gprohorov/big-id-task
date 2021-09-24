/*
  @author   george
  @project   big-id-task
  @class  Main
  @version  1.0.0 
  @since 23.09.21 - 20.38
*/


import model.Location;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        String urlAsString = "https://norvig.com/big.txt";
        String namesAsString = "James,John,Robert,Michael,William,David,Richard," +
                "Charles,Joseph,Thomas,Christopher,Daniel,Paul,Mark,Donald" +
                ",George,Kenneth,Steven,Edward,Brian,Ronald,Anthony,Kevin," +
                "Jason,Matthew,Gary,Timothy,Jose,Larry,Jeffrey," +
                "Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory," +
                "Joshua,Jerry,Dennis,Walter,Patrick,Peter,Harold,Douglas," +
                "Henry,Carl,Arthur,Ryan,Roger";

        List<Map<String, List<Location>>> list = new TextBlockSuplier(urlAsString).asyncMatching();
        Aggregator aggregator = new Aggregator(list);
        aggregator.showResult();
    }

}
