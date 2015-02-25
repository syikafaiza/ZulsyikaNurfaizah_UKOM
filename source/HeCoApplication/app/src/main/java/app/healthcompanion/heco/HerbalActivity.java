package app.healthcompanion.heco;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


public class HerbalActivity extends ActionBarActivity implements View.OnClickListener{

    private ListView lv;
    ArrayAdapter<String> adapter;

    EditText hersea;

    ArrayList<HashMap<String, String>> hpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herbal);

        String hpen[] ={"Alergi",
                        "Alergi pada Bayi",
                        "Asma",
                        "Batuk",
                        "Diabetes",
                        "Diare",
                        "Diare pada Bayi/Anak",
                        "Dismenore",
                        "Hipertensi",
                        "Infeksi jamur",
                        "Infeksi saluran kemih",
                        "Infeksi saluran pernapasan",
                        "Jerawat",
                        "Konstipasi",
                        "Kontrasepsi",
                        "Kolik",
                        "Luka bakar",
                        "Migrain",
                        "Nyeri",
                        "Nyeri lambung"};

        lv = (ListView) findViewById(R.id.listher);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), HalergiActivity.class));
                        break;
                }
            }
        });

        hersea = (EditText) findViewById(R.id.hersea);

        adapter = new ArrayAdapter<String>(this, R.layout.list_template,
                R.id.items,
                hpen);
        lv.setAdapter(adapter);

        hersea.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

                // When user changed the Text
                HerbalActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_herbal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }
}
