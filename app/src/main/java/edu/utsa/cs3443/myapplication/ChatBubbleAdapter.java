package edu.utsa.cs3443.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class ChatBubbleAdapter extends BaseAdapter {
    private Context context;
    private List<String[]> dataList;

    public ChatBubbleAdapter(Context context, List<String[]> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }


    @Override
    public String[] getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chat_bubble, parent, false);




        TextView textView = view.findViewById(R.id.contactName);
        textView.setText(dataList.get(position)[0]);

        TextView textView2 = view.findViewById(R.id.contactSub);
        textView2.setText(dataList.get(position)[1]);


        // Set image or other views as needed

        return view;
    }
}
