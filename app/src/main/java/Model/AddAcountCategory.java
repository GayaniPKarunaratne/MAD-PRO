package Model;

import java.util.ArrayList;

public class AddAcountCategory {
    int ID;
    String acount;
    String amount;
    String text;

    public AddAcountCategory(int ID, String acount, String amount, String text) {
        this.ID = ID;
        this.acount = acount;
        this.amount = amount;
        this.text = text;
    }

    public AddAcountCategory() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
