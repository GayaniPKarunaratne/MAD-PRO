package Model;

public class IncomeCategory {
    private String Uname;
    private int ID;


    public IncomeCategory(String uname , int id) {
        ID = id;
        Uname = uname;
    }
    public IncomeCategory(){

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
