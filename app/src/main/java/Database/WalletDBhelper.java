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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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
