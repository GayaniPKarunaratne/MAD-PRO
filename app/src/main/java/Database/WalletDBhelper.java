package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.StatementEvent;

import Model.AddAcountCategory;
import Model.AddExpense;
import Model.AddIncome;
import Model.AddIncomeAcountCategory;
import Model.ExpensesCategory;
import Model.IncomeCategory;
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

        /***********************************************************   Gayani   *******************************************************************/

        String create_table_addexpences = "CREATE TABLE " + WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES + " ( "+
                WalletUserMaster.Addexpences.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_CATEGORI + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_DATE + " TEXT," +
                WalletUserMaster.Addexpences.COLUMN_NAME_NOTE + " TEXT);";

        db.execSQL(create_table_addexpences);

        String create_table_addincome = "CREATE TABLE " + WalletUserMaster.Addincome.TABLE_NAME_ADDINCOME + " ( " +
                WalletUserMaster.Addincome.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                WalletUserMaster.Addincome.COLUMN_NAME_INCOME + " REAL," +
                WalletUserMaster.Addincome.COLUMN_NAME_CATEGORI + " TEXT," +
                WalletUserMaster.Addincome.COLUMN_NAME_DATE + " TEXT," +
                WalletUserMaster.Addincome.COLUMN_NAME_NOTE + " TEXT);";

        db.execSQL(create_table_addincome );

        /*------------------------------Thenuka -----------------------------------------------------------------------*/

        String create_table_addAcount = "CREATE TABLE " + WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT + " ("+
                WalletUserMaster.AddAcountCategory._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE + " TEXT," +
                WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT + " TEXT);";

        db.execSQL(create_table_addAcount);

        String create_table_addIncomeAcount = "CREATE TABLE " + WalletUserMaster.AddIncomeAcountCategory.TABLE_NAME_INCOME_ACCOUNT + " ( "+
                WalletUserMaster.AddIncomeAcountCategory._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_ACOUNT_TYPE + "TEXT," +
                WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_AMOUNT + "TEXT);";

        db.execSQL(create_table_addIncomeAcount);

        /*------------------------------end Thenuka -----------------------------------------------------------------------*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /***********************************************************  Gayani   *******************************************************************/

    public boolean addExpences(String expences,String note ,String category){
        SQLiteDatabase db = getWritableDatabase();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();

        ContentValues contentValues = new ContentValues();

        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE,expences);
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_NOTE,note);
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_CATEGORI , category );
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_DATE , formatter.format(today) );

        long result = db.insert(WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES,null,contentValues);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }


    public ArrayList<AddExpense>  readAllExpense() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE , WalletUserMaster.Addexpences.COLUMN_NAME_CATEGORI , WalletUserMaster.Addexpences.COLUMN_NAME_DATE};

        String sortOrder = WalletUserMaster.Addexpences.COLUMN_NAME_DATE;
        Cursor values = db.query(WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES , projection, null, null, null, null, sortOrder);

        ArrayList<AddExpense> arrayList = new ArrayList<>();

        while(values.moveToNext()){
            String  Amount = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE ));
            String  Category = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addexpences.COLUMN_NAME_CATEGORI ));
            String  Date = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addexpences.COLUMN_NAME_DATE));
            arrayList.add( new AddExpense( Amount, Date, Category ));
        }
        return arrayList;
    }

    public void deleteExpense(int id){
        SQLiteDatabase db = getReadableDatabase();

        String Selection = WalletUserMaster.Addexpences._ID + " = ?";
        String[] SelectionArgs = { String.valueOf(id)};

        db.delete(WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES,Selection,SelectionArgs);
        Log.i("DB","Delete :" + id);
    }

    public void editExpense( String id , String expense,String note ){

        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_EXPENCE ,expense);
        contentValues.put(WalletUserMaster.Addexpences.COLUMN_NAME_NOTE ,note);

        String Selection = WalletUserMaster.Addexpences.COLUMN_NAME_ID + " = ? ";
        String SelectionArgs[] = { id };

        db.update( WalletUserMaster.Addexpences.TABLE_NAME_ADDEXPENCES , contentValues , Selection , SelectionArgs );


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

    public ArrayList<AddIncome>  readAllIncome() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = { WalletUserMaster.Addincome.COLUMN_NAME_ID ,  WalletUserMaster.Addincome.COLUMN_NAME_INCOME , WalletUserMaster.Addincome.COLUMN_NAME_CATEGORI , WalletUserMaster.Addincome.COLUMN_NAME_DATE , WalletUserMaster.Addincome.COLUMN_NAME_NOTE};

        String sortOrder = WalletUserMaster.Addincome.COLUMN_NAME_DATE;
        Cursor values = db.query(WalletUserMaster.Addincome.TABLE_NAME_ADDINCOME , projection, null, null, null, null, sortOrder);

        ArrayList<AddIncome> arrayList = new ArrayList<>();

        while(values.moveToNext()){
            int ID = values.getInt( values.getColumnIndexOrThrow( WalletUserMaster.Addincome.COLUMN_NAME_ID ));
            String  Amount = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addincome.COLUMN_NAME_INCOME ));
            String  Category = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addincome.COLUMN_NAME_CATEGORI ));
            String  Date = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addincome.COLUMN_NAME_DATE));
            String  Note = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.Addincome.COLUMN_NAME_NOTE));

            arrayList.add( new AddIncome( ID ,  Amount, Date, Category  , Note ));
        }
        return arrayList;
    }

    public void deleteIncome(int id){
        SQLiteDatabase db = getReadableDatabase();

        String Selection = WalletUserMaster.Addincome._ID + " = ?";
        String[] SelectionArgs = { String.valueOf(id)};

        db.delete(WalletUserMaster.Addincome.TABLE_NAME_ADDINCOME,Selection,SelectionArgs);
        Log.i("DB","Delete :" + id);
    }


    public void editIncome( String id , String income,String note ){

        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.Addincome.COLUMN_NAME_INCOME ,income);
        contentValues.put(WalletUserMaster.Addincome.COLUMN_NAME_NOTE ,note);

        String Selection = WalletUserMaster.Addincome.COLUMN_NAME_ID + " = ? ";
        String SelectionArgs[] = { id };

        db.update( WalletUserMaster.Addincome.TABLE_NAME_ADDINCOME , contentValues , Selection , SelectionArgs );


    }


    /***********************************************************  End Of Gayani  *******************************************************************/



    //prabhashi's methods=========================================================================

    public boolean addCategoryOsu(String name){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME,name);


        long result = db.insert(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses,null,contentValues);

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }
    public boolean addincomeCatishu(String name){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME,name);


        long result = db.insert(WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME,null,contentValues);

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }

    public ArrayList<ExpensesCategory> readAllCategoriesOsa() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME , WalletUserMaster.ExpensesCategory._ID };

        String sortOrder = WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME;

        Cursor values = db.query(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses ,projection,null,null,null,null,sortOrder);
        ArrayList<ExpensesCategory> CATEGORIES = new ArrayList<ExpensesCategory>();
        while (values.moveToNext()){
            ExpensesCategory category = new ExpensesCategory();
            String categoryname = values.getString( values.getColumnIndexOrThrow( WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME ));
            category.setUname( categoryname);
            category.setID( values.getInt( values.getColumnIndexOrThrow(WalletUserMaster.ExpensesCategory._ID) )  );
            CATEGORIES.add( category );
        }
        return CATEGORIES;
    }

    public ArrayList<IncomeCategory> readAllCategoriesIshu() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection2 = {WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME , WalletUserMaster.IncomeCategory._ID };

        String sortOrder2 = WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME;

        Cursor values2 = db.query(WalletUserMaster.IncomeCategory.TABLE_NAME_INCOME ,projection2,null,null,null,null,sortOrder2);

        ArrayList<IncomeCategory> CATEGORIES2 = new ArrayList<>();

        while (values2.moveToNext()){
            IncomeCategory category2 = new IncomeCategory();
            String categoryname2 = values2.getString( values2.getColumnIndexOrThrow( WalletUserMaster.IncomeCategory.COLUMN_NAME_INCOMENAME ));
            category2.setUname( categoryname2);
            category2.setID( values2.getInt( values2.getColumnIndexOrThrow(WalletUserMaster.IncomeCategory._ID) )  );
            CATEGORIES2.add( category2 );


        }
        return CATEGORIES2;
    }

    public boolean deleteuser(String username){
        SQLiteDatabase db = getReadableDatabase();
        String Selection = WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME + " LIKE ?";
        String[] SelectionArgs = { username };

        long result  = db.delete(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses , Selection , SelectionArgs );
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean userUpdate(String username ){
        SQLiteDatabase db  = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME , username );

        String Selection = WalletUserMaster.ExpensesCategory.COLUMN_NAME_EXPENSESNAME + " Like ? ";
        Log.i("DB" , Selection  );
        String[] SelectionArgs = { username };

        long result  =db.update(WalletUserMaster.ExpensesCategory.TABLE_NAME_Expenses ,contentValues , Selection , SelectionArgs);

        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }

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

    public ArrayList<AddAcountCategory> readAllInforAcount(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE, WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT, WalletUserMaster.AddAcountCategory._ID};
        String sortOrder = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE;
        Cursor values = db.query(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT,projection,null,null,null,null,sortOrder);

        ArrayList<AddAcountCategory> acount = new ArrayList<>();


        while (values.moveToNext()){
            AddAcountCategory ac = new AddAcountCategory();

            String acounttype = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE));
            String amount = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT));

            ac.setAcount(acounttype);
            ac.setAmount(amount);
            ac.setID(values.getInt(values.getColumnIndexOrThrow(WalletUserMaster.AddAcountCategory._ID)));
            acount.add(ac);
        }
        return acount;
    }

    public boolean expensesEditAcount(String id, String acounttype, String amount ){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE,acounttype);
        contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT,amount);

        String Selection = WalletUserMaster.AddAcountCategory._ID + " = ? " ;
        String SelectionArge[] = { id };

        int r = db.update(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT, contentValues , Selection , SelectionArge);

        if(r>0){
            return true;
        }else{
            return false;
        }
    }

    public void deleteExpensesAcount(int id){
        SQLiteDatabase db = getReadableDatabase();
        String Selection = WalletUserMaster.AddAcountCategory._ID + " = ?";
        //String selection = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE + " LIKE ?";
        String[] SelectionArgs = {String.valueOf(id)};

        db.delete(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT,Selection,SelectionArgs);
        Log.i("DB", "Delete :" + id);
    }

    
    public boolean addIncomeAcountCategory(String incomeacounttype, String incomeamount){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_ACOUNT_TYPE,incomeacounttype);
        contentValues.put(WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_AMOUNT,incomeamount);
        long result = db.insert(WalletUserMaster.AddIncomeAcountCategory.TABLE_NAME_INCOME_ACCOUNT,null,contentValues);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }



    public ArrayList<AddIncomeAcountCategory> readAllIncomeAcount(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_ACOUNT_TYPE,WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_AMOUNT,WalletUserMaster.AddIncomeAcountCategory._ID};
        String sortOrder = WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_ACOUNT_TYPE;
        Cursor values = db.query(WalletUserMaster.AddIncomeAcountCategory.TABLE_NAME_INCOME_ACCOUNT,projection,null,null,null,null,sortOrder);

        ArrayList<AddIncomeAcountCategory> Incomeacount = new ArrayList<>();

        while (values.moveToNext()) {
            AddIncomeAcountCategory ac = new AddIncomeAcountCategory();

            String incomeacounttype = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_ACOUNT_TYPE));
            String incomeamount = values.getString(values.getColumnIndexOrThrow(WalletUserMaster.AddIncomeAcountCategory.COLUME_NAME_INCOME_AMOUNT));


            ac.setIncomeacount(incomeacounttype);
            ac.setIncomeamount(incomeamount);
            ac.setID(values.getInt(values.getColumnIndexOrThrow(WalletUserMaster.AddIncomeAcountCategory._ID)));
            Incomeacount.add(ac);

        }
        return Incomeacount;
    }



   /* public void AddAcountCategoryDelete(String acount){
        SQLiteDatabase db = getReadableDatabase();
        String selection = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE + "LIKE ?" + WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT + "LIKE ?";

        String[] SelectionArgs = {acount};

        db.delete(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT, selection,  SelectionArgs);
    }*/



   /* public void AddAcountCateroyUpdate(String acounttype,String amount){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE, acounttype);
        contentValues.put(WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT, amount);


        String Selection = WalletUserMaster.AddAcountCategory.COLUME_NAME_ACOUNT_TYPE + "LIKE ?" + WalletUserMaster.AddAcountCategory.COLUME_NAME_AMOUNT + "LIKE ?";
        Log.i("DB", Selection);

        String[] SelectionArg = {acounttype, amount};

        db.update(WalletUserMaster.AddAcountCategory.TABLE_NAME_ACCOUNT, contentValues, Selection , SelectionArg);

    }*/

    /*---------------------------end thenuka------------------------------------------*/
}
