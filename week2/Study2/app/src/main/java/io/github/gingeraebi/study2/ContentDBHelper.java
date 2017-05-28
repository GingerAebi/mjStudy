package io.github.gingeraebi.study2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gingeraebi on 2017. 5. 28..
 */

public class ContentDBHelper extends SQLiteOpenHelper {

    public ContentDBHelper(Context context) {
        super(context, "Pinter.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contents(_id INTEGER PRIMARY KEY AUTOINCREMENT, image_url TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
