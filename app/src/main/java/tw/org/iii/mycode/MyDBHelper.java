package tw.org.iii.mycode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016/9/21.
 */
public class MyDBHelper extends SQLiteOpenHelper{

    private final String createTabel =
            "CREATE TABLE IF NOT EXISTS cust (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "cname TEXT,tel TEXT,birthday DATE)";

    public MyDBHelper(Context context,
                      String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTabel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
