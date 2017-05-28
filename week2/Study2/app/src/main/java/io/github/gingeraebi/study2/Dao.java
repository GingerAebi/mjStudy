package io.github.gingeraebi.study2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gingeraebi on 2017. 5. 28..
 */

public class Dao {
    private Context context;
    private SQLiteDatabase db;
    private ContentDBHelper dbHelper;

    public Dao(Context context) {
        this.context = context;
        this.dbHelper = new ContentDBHelper(context);
    }

    public void insertContent(Contents contents) {
        db = dbHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("image_url", contents.getImageUrl());
        db.insert("contents", null, row);
    }

    public ArrayList<Contents> getContents() {
        db = dbHelper.getReadableDatabase();
        ArrayList<Contents> contents = new ArrayList<>();
        String imageURL;

        String sql = "SELECT * FROM contents";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            imageURL = cursor.getString(1);
            contents.add(new Contents(imageURL));
        }
        cursor.close();

        return contents;
    }


}
