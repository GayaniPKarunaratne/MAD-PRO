package Model;

public class ExpensesCategory {
    private String Uname;
    private int ID;


    public ExpensesCategory(String uname , int id) {
        ID = id;
        Uname = uname;
    }
    public ExpensesCategory(){

    }

    public String getUname() {

        return Uname;
    }

    public void setUname(String uname) {

        Uname = uname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
