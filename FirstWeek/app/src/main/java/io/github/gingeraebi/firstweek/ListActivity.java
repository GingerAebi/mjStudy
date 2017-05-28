package io.github.gingeraebi.firstweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayList<Content> contents = new ArrayList<>();


        contents.add(new Content("1일전", "1일전 내용입니다. 알림을 확인하세요.", "14:30"));
        contents.add(new Content("2일전", "2일전 내용입니다. 알림을 확인하세요.", "11:30"));
        contents.add(new Content("3일전", "3일전 내용입니다. 알림을 확인하세요.", "15:30"));
        contents.add(new Content("4일전", "4일전 내용입니다. 알림을 확인하세요.", "17:30"));

        AlarmListAdapter alarmListAdapter = new AlarmListAdapter(this, contents);

        listView.setAdapter(alarmListAdapter);
    }
}
