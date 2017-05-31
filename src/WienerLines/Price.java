package WienerLines;

/**
 * Created by rlukas on 17.02.2016.
 */
public class Price {
    private double normalPriceInEuro;
    private double oneStationInEuro;
    private double endStationInEuro;
    private double crossOverCenterInEuro;
    private double endPrice;

    public void setNormalPriceInEuro(double normalPriceInEuro) {
        this.normalPriceInEuro = normalPriceInEuro;
    }

    public double getNormalPriceInEuro() {
        return normalPriceInEuro;
    }

    public double getOneStationInEuro() {
        return oneStationInEuro;
    }

    public void setOneStationInEuro(double oneStationInEuro) {
        this.oneStationInEuro = oneStationInEuro;
    }

    public double getEndStationInEuro() {
        return endStationInEuro;
    }

    public void setEndStationInEuro(double endStationInEuro) {
        this.endStationInEuro = endStationInEuro;
    }

    public double getCrossOverCenterInEuro() {
        return crossOverCenterInEuro;
    }

    public void setCrossOverCenterInEuro(double crossOverCenterInEuro) {
        this.crossOverCenterInEuro = crossOverCenterInEuro;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }
}
