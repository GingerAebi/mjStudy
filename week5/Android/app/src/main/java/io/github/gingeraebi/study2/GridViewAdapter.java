package io.github.gingeraebi.study2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gingeraebi on 2017. 5. 28..
 */

public class GridViewAdapter extends ArrayAdapter<Contents> {
    private Context context;
    private int resource;
    private List<Contents> contentsList;

    public GridViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Contents> contentsList) {
        super(context, resource, contentsList);

        this.context = context;
        this.resource = resource;
        this.contentsList = contentsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // xml파일을 JAVA에서 핸들링 가능하게 가져오기
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
        }

        // 각 row에서 해야될 일들을 구현하기
        ImageView contentImage = (ImageView) row.findViewById(R.id.photo_image_view);
        Picasso.with(context)
                .load(contentsList.get(position).getImageUrl())
                .fit()
                .centerCrop()
                .into(contentImage);

        return row;
    }

    public void notifyChange() {
        notifyDataSetChanged();
    }
}
