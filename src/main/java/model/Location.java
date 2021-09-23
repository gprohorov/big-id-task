package model;
/*
  @author   george
  @project   test-pro
  @class  Location
  @version  1.0.0 
  @since 21.09.21 - 22.55
*/

public class Location {
    private int lineOffset;
    private long charOffset;

    public Location() {
    }

    public Location(int lineOffset, long charOffset) {
        this.lineOffset = lineOffset;
        this.charOffset = charOffset;
    }

    public int getLineOffset() {
        return lineOffset;
    }

    public void setLineOffset(int lineOffset) {
        this.lineOffset = lineOffset;
    }

    public long getCharOffset() {
        return charOffset;
    }

    public void setCharOffset(int charOffset) {
        this.charOffset = charOffset;
    }

    @Override
    public String toString() {
        return "[" +
                "lineOffset=" + lineOffset +
                ", charOffset=" + charOffset +
                ']';
    }
}
