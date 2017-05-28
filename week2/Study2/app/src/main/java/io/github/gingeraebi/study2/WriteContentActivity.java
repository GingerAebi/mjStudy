package io.github.gingeraebi.study2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class WriteContentActivity extends AppCompatActivity {
    private Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_content);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        dao = new Dao(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.ImageUrlEdit);

                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();

                Contents contents = realm.createObject(Contents.class);
                contents.setImageUrl(editText.getText().toString());

                realm.commitTransaction();

                finish();
            }
        });
    }
}
