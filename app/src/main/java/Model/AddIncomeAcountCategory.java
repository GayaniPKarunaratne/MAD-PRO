package Model;

public class AddIncomeAcountCategory {
    int ID;
    String incomeacount;
    String incomeamount;

    public AddIncomeAcountCategory(int ID, String incomeacount, String incomeamount) {
        this.ID = ID;
        this.incomeacount = incomeacount;
        this.incomeamount = incomeamount;
    }

    public AddIncomeAcountCategory() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIncomeacount() {
        return incomeacount;
    }

    public void setIncomeacount(String incomeacount) {
        this.incomeacount = incomeacount;
    }

    public String getIncomeamount() {
        return incomeamount;
    }

    public void setIncomeamount(String incomeamount) {
        this.incomeamount = incomeamount;
    }
}
