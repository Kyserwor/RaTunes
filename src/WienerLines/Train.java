package WienerLines;

/**
 * Created by rlukas on 17.02.2016.
 */
public class Train {
    private int startStation;
    private int destinationStation;
    private int startLine;
    private int destinationLine;
    private int limitOfStation;
    private int limitOfCenter;
    private int endOfCenter;

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getDestinationLine() {
        return destinationLine;
    }

    public void setDestinationLine(int destinationLine) {
        this.destinationLine = destinationLine;
    }

    public int getStartStation() {
        return startStation;
    }

    public void setStartStation(int startStation) {
        this.startStation = startStation;
    }

    public int getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(int destinationStation) {
        this.destinationStation = destinationStation;
    }

    public int getLimitOfStation() {
        return limitOfStation;
    }

    public void setLimitOfStation(int limitOfStation) {
        this.limitOfStation = limitOfStation;
    }

    public int getLimitOfCenter() {
        return limitOfCenter;
    }

    public void setLimitOfCenter(int limitOfCenter) {
        this.limitOfCenter = limitOfCenter;
    }

    public int getEndOfCenter() {
        return endOfCenter;
    }

    public void setEndOfCenter(int endOfCenter) {
        this.endOfCenter = endOfCenter;
    }
}
