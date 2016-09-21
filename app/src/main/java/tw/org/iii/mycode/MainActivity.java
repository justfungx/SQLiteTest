package tw.org.iii.mycode;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyDBHelper dbhelper;
    private SQLiteDatabase db;
    private TextView mesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper = new MyDBHelper(this,"brad", null, 1);
        db = dbhelper.getReadableDatabase();
    }
    public void insert (View v){
        ContentValues data = new ContentValues();
        data.put("came" , "KAO");
        data.put("tel","77885566");
        data.put("birthday","2000-01-01");
        db.insert("cust",null,data);
        query(null);

    }
    public void delete (View v){
        // DELETE FROM cust WHERE id = 3 and cname = 'brad';

        db.delete("cust","id =  ?  and cname = ?", new String[]{"3","KAO"});
        query(null);
    }
    public void update (View v){
        // UPDATE cust SET cname='Kevin', tel='2222' WHERE id=5;

        ContentValues data =  new ContentValues();
            data. put("cname","TONY");
            data.put("tel", "2222111");
        db.update("cust",data,"id = ?",new String[]{"5"});
        query(null);

    }
    public void query (View v){
        // SELECT * FROM cust
        mesg.setText("");
        // SELECT * FROM cust
//        Cursor c = db.query("cust",null,null,null,null,null,null);

        // SELECT * FROM cust ORDER BY cname
        //Cursor c = db.query("cust",null,null,null,null,null,"cname,tel");

        // SELECT * FROM cust WHERE birthday > '1999-02-01' ORDER BY cname
//        Cursor c = db.query("cust",null,"birthday > ?",new String[]{"1999-02-01"},
//                null,null,"cname,tel");

        // SELECT cname, tel, birthday FROM cust WHERE birthday > '1999-02-01' ORDER BY cname
        Cursor c = db.query("cust",new String[]{"cname","tel","birthday"},
                "birthday > ?",new String[]{"1999-02-01"},
                null,null,"cname,tel");

        while (c.moveToNext()){
//            String id = c.getString(c.getColumnIndex("id"));
            String cname = c.getString(c.getColumnIndex("cname"));
            String tel = c.getString(c.getColumnIndex("tel"));
            String birthday = c.getString(c.getColumnIndex("birthday"));
//            mesg.append(id+":"+cname+":"+tel+":"+birthday+"\n");
            mesg.append(cname+":"+tel+":"+birthday+"\n");
        }
    }
}
//BATE 2.0
