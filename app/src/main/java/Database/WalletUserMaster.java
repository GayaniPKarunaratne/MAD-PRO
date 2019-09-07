package Database;

import android.provider.BaseColumns;

public final class WalletUserMaster {

    private WalletUserMaster(){ }

    /*------------------------------------Gayani---------------------------------------------------------------*/
    protected static class Addexpences implements BaseColumns{
        protected static final String TABLE_NAME_ADDEXPENCES = "addexpences";

        protected static final String COLUMN_NAME_EXPENCE = "expences";
        protected static final String COLUMN_NAME_CATEGORI = "category";
        protected static final String COLUMN_NAME_NOTE = "note";


    }
    protected static class Addinvoice implements BaseColumns{
        protected static final String TABLE_NAME_ADDINVOICE = "addinvoice";

        protected static final String COLUMN_NAME_INVOICE = "invoice";
        protected static final String COLUMN_NAME_CATEGORI = "category";
        protected static final String COLUMN_NAME_NOTE = "note";


    }

    //prabhashi's methods=========================================================================

    protected static  class IncomeCategory implements  BaseColumns{
        protected  static  final String TABLE_NAME_INCOME = "income";
        protected  static  final String COLUMN_NAME_INCOMENAME = "name";
    }

    protected static  class ExpensesCategory implements  BaseColumns{
        protected  static  final String TABLE_NAME_Expenses = "income";
        protected  static  final String COLUMN_NAME_EXPENSESNAME = "name";
    }


}
