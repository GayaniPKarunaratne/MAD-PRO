package Database;

import android.provider.BaseColumns;

public final class WalletUserMaster {

    private WalletUserMaster(){ }

    protected static class Addexpences implements BaseColumns{
        protected static final String TABLE_NAME = "addexpences";
    }
    protected static  class IncomeCategory implements  BaseColumns{
        protected  static  final String TABLE_NAME_INCOME = "income";
        protected  static  final String COLUMN_NAME_INCOMENAME = "name";


    }

}
