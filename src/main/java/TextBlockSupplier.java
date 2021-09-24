/*
  @author   george
  @project   big-id-task
  @class  TextBlockSupplier
  @version  1.0.0 
  @since 24.09.21 - 13.02
*/

import model.Location;
import model.TextBlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TextBlockSupplier {
    private final String urlAsString;


    public TextBlockSupplier(String urlAsString) throws IOException {
        this.urlAsString = urlAsString;
    }

    public List<Map<String, List<Location>>> asyncMatching()
            throws IOException, InterruptedException, ExecutionException {
        List<CompletableFuture<Void> >futures = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        List<Map<String, List<Location>>> maps = new ArrayList<>();
        int[] cursor = new int[2];  // [0] - number of a block, [1] - value of the 1st char in a block
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        new BufferedReader(new InputStreamReader(new URL(urlAsString).openStream()))
                .lines()
                .forEach(line->{
                    lines.add(line);
                    if(lines.size() % Constants.LINES_IN_BLOCK == 0 || line == null) {
                        String text = getText(lines);
                        TextBlock block = new TextBlock(cursor[0], cursor[1], text);
                        Matcher matcher = new Matcher(block);
                        CompletableFuture< Void > future =
                                CompletableFuture.supplyAsync(matcher::getOutputMapForBlock, executorService)
                                        .thenAcceptAsync(maps::add, executorService);
                        futures.add(future);
                        cursor[0]++;
                        cursor[1] += text.length();
                        lines.clear();
                    }
                });
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get();
        executorService.shutdown();
        return maps;
    }

    private String getText(List<String> list){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < list.size() ; i++) {
            sb.append(list.get(i) + System.lineSeparator());
        }
        return sb.toString();
    }


}
