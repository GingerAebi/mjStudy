package io.github.gingeraebi.study2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();

        GridView gridView = (GridView) findViewById(R.id.grid_view);


        RealmQuery<Contents> query = realm.where(Contents.class);
        ArrayList<Contents> contentsArrayList = new ArrayList<>(query.findAll());

        gridViewAdapter = new GridViewAdapter(this, R.layout.item_photos_grid, contentsArrayList);
        gridView.setAdapter(gridViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WriteContentActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        gridViewAdapter.notifyDataSetChanged();
    }
}
