package Model;

public class AddAcountCategory {
    int ID;
    String acount;
    String amount;

    public AddAcountCategory(int ID, String acount, String amount) {
        this.ID = ID;
        this.acount = acount;
        this.amount = amount;
    }

    public AddAcountCategory(String acount, String amount) {
        this.acount = acount;
        this.amount = amount;
    }

    public AddAcountCategory(String acounttype) {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
