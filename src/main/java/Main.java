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
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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
        List<Map<String, List<Location>>> list;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Future<Map<String, List<Location>>>> futures = new ArrayList<>();
        for (TextBlock block : blocks) {
            Future<Map<String, List<Location>>> taskSubmited = executorService.submit(() -> {
                Matcher matcher = new Matcher(namesAsString, block);
                return matcher.getOutputMapForBlock();
            });
            futures.add(taskSubmited);
        }
        list = futures.stream().map(Main::getResult).collect(Collectors.toList());
        executorService.shutdown();
        Aggregator aggregator = new Aggregator(list);
        aggregator.showResult();
    }

    private static Map<String, List<Location>> getResult(Future<Map<String, List<Location>>> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

}
