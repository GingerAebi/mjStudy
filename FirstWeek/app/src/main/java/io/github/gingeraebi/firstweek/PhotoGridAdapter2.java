package io.github.gingeraebi.firstweek;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class PhotoGridAdapter2 extends ArrayAdapter<Content> {
    private Context context;
    private int resourceId;
    private List<Content> contents;


    public PhotoGridAdapter2(@NonNull Context context, @LayoutRes int resource, @NonNull List<Content> contents) {
        super(context, resource, contents);
        this.contents = contents;
        this.context = context;
        this.resourceId = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            row = layoutInflater.inflate(resourceId, parent, false);
        }

        Content content = contents.get(position);

        ImageView contentImage = (ImageView) row.findViewById(R.id.contentImage);
        Picasso.with(context)
                .load(content.contentImgUrl)
                .fit()
                .centerCrop()
                .into(contentImage);

        return row;
    }
}
