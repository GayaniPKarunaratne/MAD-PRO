package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import Model.Users;

public class WalletDBhelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "wallet.db";

    public WalletDBhelper(Context context){
        super(context,DB_NAME,null,1 );

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String crete_table_income = "CREATE TABLE " + WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME + " ("+
                WalletUserMaster.IncomeCategory._ID + " INTEGER PRIMARY KEY, " +
                WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME + " TEXT);";

        db.execSQL(crete_table_income);
        /*-----------------------------------------Gayani-------------------------------------------------------------*/

        String create_table_addexpences = "CREATE TABLE " + WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES + " ("+
                WalletUserMaster.Addexpences._ID + " INTEGER PRIMARY KEY, " +
                WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_CATEGORI + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_NOTE + " TEXT);";

        db.execSQL(create_table_addexpences);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*-------------------------------------------------Gayani------------------------------------------------------------*/


    public boolean addExpences(String expences,String note){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE,expences);
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_NOTE,note);
        long result = db.insert(WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES,null,contentValues);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addInvoice(String invoice,String note){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.Addinvoice.COLUMN_NAME_INVOICE,invoice);
        contentValues.put(WalletUserMaster.Addinvoice.COLUMN_NAME_NOTE,note);
        long result = db.insert(WalletUserMaster.Addinvoice.TABLE_NAME_ADDINVOICE,null,contentValues);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }

    //prabhashi's methods=========================================================================

    public boolean addIncomeCategory(String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME,name);
        long result = db.insert(WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME,null,contentValues);
        if(result > 0){
            return true;

        }
        else{
            return  false;
        }
    }

    public ArrayList<Users> readAllInfor() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {WalletUserMaster.IncomeCategory._ID, WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME};

        String sortOrder = WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME;
        Cursor values = db.query(WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME, projection, null, null, null, null, sortOrder);

        ArrayList<Users> users = new ArrayList<>();

        while(values.moveToNext()){
            String userName = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME));
            users.add(new Users(userName));
        }
        return users;
    }

    public  void incomecatDelete(String userName){
        SQLiteDatabase db = getReadableDatabase();
        String selection = WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME + " LIKE ?";
        String[] SelectionArgs = {userName};

        db.delete(WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME , selection , SelectionArgs);
    }

    public void incomeCatUpdate(String username){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME , username);

        String Selection = WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME + " LIKE ? ";
        Log.i("DB" , Selection);

        String[] SelectionArgs = {username};

        db.update(WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME , contentValues , Selection , SelectionArgs);


    }








    public boolean addeXPENSESCategory(String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME,name);
        long result = db.insert(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses,null,contentValues);
        if(result > 0){
            return true;

        }
        else{
            return  false;
        }
    }

    public ArrayList<Users> readAllInfor2() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {WalletUserMaster.ExpensesCategory._ID, WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME};

        String sortOrder = WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME;
        Cursor values = db.query(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses, projection, null, null, null, null, sortOrder);

        ArrayList<Users> users = new ArrayList<>();

        while(values.moveToNext()){
            String userName = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME));
            users.add(new Users(userName));
        }
        return users;
    }

    public  void ExpensescatDelete(String userName){
        SQLiteDatabase db = getReadableDatabase();
        String selection = WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME + " LIKE ?";
        String[] SelectionArgs = {userName};

        db.delete(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses , selection , SelectionArgs);
    }

    public void ExpensesCatUpdate(String username){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME , username);

        String Selection = WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME + " LIKE ? ";
        Log.i("DB" , Selection);

        String[] SelectionArgs = {username};

        db.update(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses , contentValues , Selection , SelectionArgs);


    }

    //=========================end prabashi's methods=============================================


}
