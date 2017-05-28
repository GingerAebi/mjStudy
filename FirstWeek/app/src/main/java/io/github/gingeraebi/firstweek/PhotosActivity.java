package io.github.gingeraebi.firstweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class PhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        ArrayList<Content> contents = new ArrayList<>();


        contents.add(new Content("1일전", "1일전 내용입니다. 알림을 확인하세요.", "14:30").setConentImgUrl("https://s-media-cache-ak0.pinimg.com/564x/55/86/d0/5586d095a5d35b4851eae0695853fdb6.jpg"));
        contents.add(new Content("2일전", "2일전 내용입니다. 알림을 확인하세요.", "11:30").setConentImgUrl("https://s-media-cache-ak0.pinimg.com/564x/8b/95/88/8b9588ca84ae41156a7ea7333d77dfbc.jpg"));
        contents.add(new Content("3일전", "3일전 내용입니다. 알림을 확인하세요.", "15:30").setConentImgUrl("https://s-media-cache-ak0.pinimg.com/236x/b4/e5/b3/b4e5b3bbd1d4e308142d7df7d2ee0c18.jpg"));
        contents.add(new Content("4일전", "4일전 내용입니다. 알림을 확인하세요.", "17:30").setConentImgUrl("https://s-media-cache-ak0.pinimg.com/564x/ed/18/55/ed1855f13995e8354dc1b04381229ec7.jpg"));

        PhotoGridAdapter2 photosGridViewAdapter = new PhotoGridAdapter2(this, R.layout.item_photo_grid, contents);
        gridView.setAdapter(photosGridViewAdapter);
    }
}
