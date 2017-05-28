package io.github.gingeraebi.firstweek;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gingeraebi on 2017. 5. 21..
 */

public class AlarmListAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Content> contents;

    public AlarmListAdapter(Context context, ArrayList<Content> contents) {
        this.context = context;
        this.contents =contents;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null) {
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            row = layoutInflater.inflate(R.layout.item_alarm_list, parent, false);
        }

        TextView timeAgoText = (TextView) row.findViewById(R.id.timeAgoText);
        TextView alarmText = (TextView) row.findViewById(R.id.alarmText);
        TextView timeText = (TextView) row.findViewById(R.id.timeText);

        Content content = contents.get(position);

        timeAgoText.setText(content.timeAgo);
        alarmText.setText(content.alarmConent);
        timeText.setText(content.time);

        return row;
    }
}
