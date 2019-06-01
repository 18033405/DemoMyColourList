package sg.edu.rp.c346.demomycolourlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editColour;
    Button btnAddItem;
    Button btnRemoveItem;
    ListView lv;

    ArrayList<String> al;
    ArrayAdapter<String> aa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editColour=findViewById(R.id.editTextColour);
        btnAddItem=findViewById(R.id.buttonAddItem);
        btnRemoveItem=findViewById(R.id.buttonRemoveItem);
        lv=findViewById(R.id.listViewColour);


        al = new ArrayList<>();
        al.add("Red");
        al.add("Orange");

        aa= new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);

        btnAddItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String data=editColour.getText().toString();
                al.add(data);
                aa.notifyDataSetChanged();
            }


        });

        btnRemoveItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                al.remove(0);
                aa.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                al.remove(i);
                aa.notifyDataSetChanged();

            }
        });















    }
}
