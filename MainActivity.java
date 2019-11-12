package halla.icsw.mobileproject_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

class dbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "member.db";
    private static final int DATASE_VARSION = 2;
    public dbHelper(Context context){
        super(context,DATABASE_NAME,null,DATASE_VARSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE member (_id TEXT PRIMARY KEY AUTOINCREMENT, "
                  + "password TEXT, name TEXT, tel TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }
}


public class MainActivity extends AppCompatActivity {
    dbHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new dbHelper(this);
        db = helper.getWritableDatabase();
    }


}
