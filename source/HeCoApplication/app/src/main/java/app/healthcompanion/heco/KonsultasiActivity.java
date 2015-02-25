package app.healthcompanion.heco;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class KonsultasiActivity extends ActionBarActivity{

    ListView lv;
    ArrayAdapter<String> adapter;

    EditText konsea;

    ArrayList<HashMap<String, String>> gejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);

        String gejala[] = {"Ruam/Bercak kemerahan. Gatal. Bengkak. Luka lecet",
                            "Bayi mengalami bentol merah dan disertai gatal. Hidung meler/berair. Mata gatal",
                            "Mengi. Batuk. Napas memendek. Napas berat",
                            "Batuk",
                            "Penurunan berat badan drastis. Sering buang air kecil. Volume urine meningkat. Sering haus",
                            "Haus. Frekuensi buang air kecil menurun. Kulit kering. Lemas. Kepala terasa ringan/melayang. Urine berwarna gelap. Penurunan berat badan drastis",
                            "Frekuensi BAB anak meningkat > 3 kali dalam 24 jam",
                            "Pendarahan vagina dan nyeri di abdomen bawah",
                            "Penderita memiliki tekanan darah tinggi (>140/90mmHg)",
                            "Kutu air. Jamur kuku. Kurap. Kurap/Kadas. Scalp. Panu. Thrush",
                            "Penderita mengeluh tidak enak selagi buang air kecil",
                            "Batuk. Pilek. Demam",
                            "Bintil-bintil merah pada wajah, leher, dada, dan/atau punggung",
                            "Kesulitan defekasi. feses keras. Defekasi tidak tuntas. Halangan saat defekasi. Frekuensi < 3 kali dalam seminggu",
                            "Penderita ingin mengetahui cara mencegah kehamilan",
                            "Penderita adalah bayi",
                            "Penderita tampak memiliki kulit kemerahan yang disertai nyeri",
                            "Penderita mengalami nyeri pada salah satu atau kedua sisi kepala",
                            "Penderita mengalami gejala-gejala nyeri tumpul",
                            "Penderita mengalami nyeri pada perut bagian tengah atau atas"};

        lv = (ListView) findViewById(R.id.listkon);
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), AlergiActivity.class));
                        break;
                }
            }
        });

        konsea = (EditText) findViewById(R.id.konsea);

        adapter = new ArrayAdapter<String>(this, R.layout.list_template,
                R.id.items,
                gejala);
        lv.setAdapter(adapter);

        konsea.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

                // When user changed the Text
                KonsultasiActivity.this.adapter.getFilter().filter(cs);
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
        getMenuInflater().inflate(R.menu.menu_konsultasi, menu);
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
}
