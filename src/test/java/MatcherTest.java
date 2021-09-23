import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/*
  @author   george
  @project   big-id-task
  @class  MatcherTest
  @version  1.0.0 
  @since 23.09.21 - 20.57
*/

public class MatcherTest {

    private final String text= new String(Files.readAllBytes(Paths.get("test.txt")));;

    public MatcherTest() throws IOException {
    }

    @org.junit.Test
    public void whenNameArthurThenThreeLinesMatching() {
        Matcher matcher = new Matcher(null, null);
        List<Integer> lines = matcher.getListOfLinesWhereMatches("Arthur", text);
        Assert.assertEquals(3, lines.size());
        int actual = lines.get(0);
        Assert.assertEquals(1, actual);
         actual = lines.get(1);
        Assert.assertEquals(2, actual);
         actual = lines.get(2);
        Assert.assertEquals(28, actual);
    }

    @org.junit.Test
    public void whenNameArthurThenThreeCharMatching() {
        Matcher matcher = new Matcher(null, null);
        List<Integer> matchings = matcher.getMatchesAbsPositionsInText("Arthur", text);
        Assert.assertEquals(3, matchings.size());
        int actual = matchings.get(0);
        Assert.assertEquals(71, actual);
         actual = matchings.get(1);
        Assert.assertEquals(116, actual);
         actual = matchings.get(2);
        Assert.assertEquals(1078, actual);
    }


}