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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TextBlockSupplier {
    private final String urlAsString;
    private final URL url;
    private final BufferedReader reader;

    public TextBlockSupplier(String urlAsString) throws IOException {
        this.urlAsString = urlAsString;
        this.url = new URL(this.urlAsString);
        this.reader = new BufferedReader(new InputStreamReader(url.openStream()));
    }

    public BufferedReader getReader() {
        return reader;
    }

    public Map<String, List<Location>> asyncMatching()
            throws IOException, InterruptedException, ExecutionException {
        List<CompletableFuture<Map<String, List<Location>>>> futures = new ArrayList<>();
        List<String> items = new ArrayList<>();





        return null;
    }



    public TextBlock getBlock(){
        int linePosition = 0;
        int charPosition = 0;

        return null;
    }


}
