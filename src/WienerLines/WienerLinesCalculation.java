package WienerLines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rlukas on 17.02.2016.
 */
public class WienerLinesCalculation {

    private WienerLinesCalculation wienerLinesCalculation = new WienerLinesCalculation();
    private Train train = new Train();
    private Price price = new Price();
    private int startNumber = 0;
    private int endNumber = 0;

    public static void main(String[] args) throws IOException {
        WienerLinesCalculation wienerLinesCalculation = new WienerLinesCalculation();
        wienerLinesCalculation.setPrice();
        wienerLinesCalculation.setTrain();
        wienerLinesCalculation.setStartEndNumber();
        wienerLinesCalculation.setLineAndStation();

    }

    public void setPrice(){
        this.price.setOneStationInEuro(1);
        this.price.setEndStationInEuro(1);
        this.price.setCrossOverCenterInEuro(1);
    }

    public void setTrain(){
        this.train.setLimitOfStation(6);
        this.train.setLimitOfCenter(3);
    }

    public void setStartEndNumber() throws IOException {
        this.startNumber = wienerLinesCalculation.readInput("Geben sie ihre Startstation ein: ");
        this.endNumber = wienerLinesCalculation.readInput("Geben sie ihre Zielstation ein: ");
    }

    public int readInput(String out) throws IOException {
        System.out.println(out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        return Integer.parseInt(input);
    }

    public void setLineAndStation(){
        this.train.setStartLine(wienerLinesCalculation.getNumberOfIndex(startNumber, 0));
        this.train.setStartStation(wienerLinesCalculation.getNumberOfIndex(startNumber, 1));

        this.train.setDestinationLine(wienerLinesCalculation.getNumberOfIndex(endNumber, 0));
        this.train.setDestinationStation(wienerLinesCalculation.getNumberOfIndex(endNumber, 1));
    }

    public int getNumberOfIndex(int number, int index) {
        String temp = Integer.toString(number);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess[index];
    }


}
