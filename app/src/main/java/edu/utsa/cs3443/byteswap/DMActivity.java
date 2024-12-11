package edu.utsa.cs3443.byteswap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import edu.utsa.cs3443.byteswap.ListViewAdapter;
import edu.utsa.cs3443.byteswap.R;

public class DMActivity extends Fragment implements View.OnClickListener {

    private ListView list;
    private edu.utsa.cs3443.byteswap.ListViewAdapter adapter;
    private ArrayList<String[]> arrayList;

    private static String extraName = "contactName";

    private View viewM;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewM = inflater.inflate(R.layout.activity_dmactivity, container, false);
        super.onCreate(savedInstanceState);


        setupButton(R.id.backButton, viewM);

        list = viewM.findViewById(R.id.messagesList);

        arrayList = new ArrayList<String[]>();

        arrayList.add(getContactEntry("Brooke"));
        arrayList.add(getContactEntry("Raina"));
        arrayList.add(getContactEntry("Jib"));
        arrayList.add(getContactEntry("Reese"));
        arrayList.add(getContactEntry("Iqra"));
        arrayList.add(getContactEntry("Dr.Hosseini"));
        arrayList.add(getContactEntry("Sam"));

        adapter = new ListViewAdapter(viewM.getContext(), arrayList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                            String[] names = (String[])adapterView.getAdapter().getItem(i);

                                            Intent intent = new Intent(view.getContext(), MessageChatActivity.class);
                                            intent.putExtra("contactName", names[0]);
                                            startActivity(intent);

                                        }
                                    }

        );

        return viewM;
    }

    public static String decodeExtra(Intent intent)
    {
        return intent.getStringExtra(extraName);
    }

    public String[] getContactEntry(String contactName) {
        ArrayList<String[]> messages = MessageChatActivity.populateChatHistory(contactName);

        if (messages.isEmpty()) {
            return new String[]{contactName, "No history"};
        }
        return new String[]{contactName, messages.get(messages.size()-1)[1]};
    }

    public void onClick(View view)
    {
        if (view.getId() == R.id.backButton)
        {
            try {
                getActivity().getFragmentManager().popBackStack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setupButton(int buttonId, View view)
    {
        Button button = view.findViewById(buttonId);
        button.setOnClickListener(this);
    }
}