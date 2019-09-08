package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Users;

import static android.content.ContentValues.TAG;

public class WalletDBhelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "wallet.db";

    public WalletDBhelper(Context context){
        super(context,DB_NAME,null,1 );

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        /*----------------------------prabhashi-----------------------*/

        String crete_table_income = "CREATE TABLE " + WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME + " ("+
                WalletUserMaster.IncomeCategory._ID + " INTEGER PRIMARY KEY, " +
                WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME + " TEXT);";

        db.execSQL(crete_table_income);

        /*----------------------------end prabhashi-----------------------*/

        /*-----------------------------------------Gayani-------------------------------------------------------------*/

        String create_table_addexpences = "CREATE TABLE " + WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES + " ("+
                WalletUserMaster.Addexpences._ID + " INTEGER PRIMARY KEY, " +
                WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_CATEGORI + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_NOTE + " TEXT);";

        db.execSQL(create_table_addexpences);

        String create_table_addincome = "CREATE TABLE " + WalletUserMaster.Addincome.TABLE_NAME_ADDINCOME + " ( " +
                WalletUserMaster.Addincome.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                WalletUserMaster.Addincome.COLUMN_NAME_INCOME + " REAL," +
                WalletUserMaster.Addincome.COLUMN_NAME_CATEGORI + " TEXT," +
                WalletUserMaster.Addincome.COLUMN_NAME_DATE + " TEXT," +
                WalletUserMaster.Addincome.COLUMN_NAME_NOTE + " TEXT);";

        db.execSQL(create_table_addincome );

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



    public boolean addIncome(String income,String note , String category){

        SQLiteDatabase db = getWritableDatabase();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();

        ContentValues contentValues = new ContentValues();

        contentValues.put(WalletUserMaster.Addincome.COLUMN_NAME_INCOME ,income);
        contentValues.put(WalletUserMaster.Addincome.COLUMN_NAME_NOTE ,note);
        contentValues.put(WalletUserMaster.Addincome.COLUMN_NAME_CATEGORI , category );
        contentValues.put(WalletUserMaster.Addincome.COLUMN_NAME_DATE , formatter.format(today) );


        long result = db.insert(WalletUserMaster.Addincome.TABLE_NAME_ADDINCOME ,null,contentValues);

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

        ArrayList<Users> users2 = new ArrayList<>();

        while(values.moveToNext()){
            String userName = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME));
            users2.add(new Users(userName));
        }
        return users2;
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


    /*---------------------------thenuka------------------------------------------*/

    public boolean addAccountCategory(String acounttype,String amount){
      SQLiteDatabase db = getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE,acounttype);
      contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT,amount);
      long result = db.insert(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT,null,contentValues);
     if(result > 0){
         return  true;
     }
     else {
         return false;
     }
    }

    public ArrayList<Users> readAllInforAcount(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE,WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT};

        String sortOrder1 = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE;
        String sortOrder2 = WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT;
        Cursor values = db.query(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT,projection, null,null,null,null,sortOrder1,sortOrder2);

        ArrayList<Users> users = new ArrayList<>();

        while (values.moveToNext()){
            String userName1 = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE));
            String userName2 = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT));
            users.add(new Users(userName1));
            users.add(new Users(userName2));
        }
    return users;
    }



    public void AddAcountCategoryDelete(String userName){
        SQLiteDatabase db = getReadableDatabase();
        String selection = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE + "LIKE ?" + WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT + "LIKE ?";

        String[] SelectionArgs = {userName};

         db.delete(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT, selection,  SelectionArgs);
    }



    public void AddAcountCateroyUpdate(String userName1,String userName2){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE, userName1);
        contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT, userName2);


        String Selection = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE + "LIKE ?" + WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT + "LIKE ?";
        Log.i("DB", Selection);

        String[] SelectionArg = {userName1, userName2};

        db.update(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT, contentValues, Selection , SelectionArg);

    }

    /*---------------------------end thenuka------------------------------------------*/
}
