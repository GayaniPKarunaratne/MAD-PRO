package Model;

public class AddExpense {

    int ID;
    String ExpenseAmount;
    String Date;
    String category;
    String note;

    public AddExpense(int ID, String expenseAmount, String date, String category, String note) {
        this.ID = ID;
        ExpenseAmount = expenseAmount;
        Date = date;
        this.category = category;
        this.note = note;
    }

    public AddExpense(String expenseAmount, String date, String category) {
        ExpenseAmount = expenseAmount;
        Date = date;
        this.category = category;
    }

    public AddExpense(int ID, String expenseAmount, String date, String category) {
        this.ID = ID;
        ExpenseAmount = expenseAmount;
        Date = date;
        this.category = category;
    }

    public AddExpense(){

    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getExpenseAmount() {
        return ExpenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        ExpenseAmount = expenseAmount;
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
