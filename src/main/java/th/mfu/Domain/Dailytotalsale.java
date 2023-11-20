package th.mfu.Domain;

public class Dailytotalsale {
    private String baristaId;
    private double saleAmount;
    public String getBaristaId() {
        return baristaId;
    }
    public void setBaristaId(String baristaId) {
        this.baristaId = baristaId;
    }
    public double getSaleAmount() {
        return saleAmount;
    }
    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }
    
    public Dailytotalsale(String baristaId, double saleAmount) {
        this.baristaId = baristaId;
        this.saleAmount = saleAmount;
    }
 
}
