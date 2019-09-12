package Model;

public class AddIncome {

    int ID;
    String IncomeAmount;
    String Date;
    String category;
    String note;

    public AddIncome(int ID, String incomeAmount, String date, String category, String note) {
        this.ID = ID;
        IncomeAmount = incomeAmount;
        Date = date;
        this.category = category;
        this.note = note;
    }


    public AddIncome(String incomeAmount, String date, String category) {
        IncomeAmount = incomeAmount;
        Date = date;
        this.category = category;
    }

    public AddIncome() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIncomeAmount() {
        return IncomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        IncomeAmount = incomeAmount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
