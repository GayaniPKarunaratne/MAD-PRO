package Database;

import android.provider.BaseColumns;

public final class WalletUserMaster {

    private WalletUserMaster(){ }

    protected static class Addexpences implements BaseColumns{
        protected static final String TABLE_NAME_ADDEXPENCES = "addexpences";
        protected static final String COLUMN_NAME_EXPENCE = "expences";
        protected static final String COLUMN_NAME_CATEGORI = "category";
        protected static final String COLUMN_NAME_NOTE = "note";


    }
    protected static  class IncomeCategory implements  BaseColumns{
        protected  static  final String TABLE_NAME_INCOME = "income";
        protected  static  final String COLUMN_NAME_INCOMENAME = "name";


    }

}
