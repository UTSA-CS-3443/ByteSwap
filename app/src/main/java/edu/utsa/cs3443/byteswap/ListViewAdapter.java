package edu.utsa.cs3443.byteswap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Custom adapter for displaying a list of contacts with a name and a message.
 * This class extends {@link android.widget.BaseAdapter} to handle a custom ListView.
 */
public class ListViewAdapter extends BaseAdapter {
    /**
     * Context of the calling activity or fragment.
     */
    private Context context;
     /**
     * List of string arrays, where each array contains contact name and message.
     */
    private List<String[]> dataList;
     /**
     * Constructor to initialize the adapter with context and data.
     *
     * @param context The context of the calling activity or fragment.
     * @param dataList The data to populate the ListView.
     */

    public ListViewAdapter(Context context, List<String[]> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    /**
     * Returns the total number of items in the data list.
     *
     * @return The size of the data list.
     */

    @Override
    public int getCount() {
        return dataList.size();
    }
    /**
     * Returns the data item at a specific position.
     *
     * @param position The index of the data item.
     * @return The data item at the specified position.
     */

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }
    /**
     * Returns the row ID of the data item at a specific position.
     *
     * @param position The index of the data item.
     * @return The row ID, which is the position itself.
     */

    @Override
    public long getItemId(int position) {
        return position;
    }
     /**
     * Creates and returns the view for a specific data item.
     *
     * @param position The index of the data item.
     * @param convertView The old view to reuse, if possible.
     * @param parent The parent view that this view will attach to.
     * @return The view representing the data item.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_button, parent, false);

        TextView textView = view.findViewById(R.id.contactName);
        textView.setText(dataList.get(position)[0]);

        TextView textView2 = view.findViewById(R.id.contactSub);
        textView2.setText(dataList.get(position)[1]);

        // Set image or other views as needed

        return view;
    }
}
