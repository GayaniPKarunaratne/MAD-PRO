package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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



}
