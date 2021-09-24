/*
  @author   george
  @project   bigId-task
  @class  Utils
  @version  1.0.0 
  @since 23.09.21 - 16.00
*/



import model.TextBlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<TextBlock> splitTextIntoBlocks(String urlAsString) throws IOException {

        List<TextBlock> blocks = new ArrayList<>();
        URL url = new URL(urlAsString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String text = "";
        String line;
        int countBlock = 0;
        int beginsFrom = 0;
        int countLine = 0;

        while (true) {
            line = reader.readLine();
            countLine++;
            text += line + System.lineSeparator();
            if (countLine == Constants.LINES_PER_BLOCK || line == null) {
                TextBlock block = new TextBlock(countBlock, beginsFrom, text);
                blocks.add(block);
                if (line == null) {
                    break;
                }
                countBlock++;
                beginsFrom += text.length();
                countLine = 0;
                text = "";
            }
        }
        reader.close();
        return blocks;
    }


}
