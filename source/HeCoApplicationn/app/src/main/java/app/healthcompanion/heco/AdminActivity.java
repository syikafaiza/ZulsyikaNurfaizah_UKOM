package app.healthcompanion.heco;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AdminActivity extends ActionBarActivity {

    EditText nama, sandi;
    Button masuk, daftar;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        dbHelper = new DatabaseHelper(getApplicationContext());

        masuk = (Button) findViewById(R.id.masuk);
        daftar = (Button) findViewById(R.id.daftar);
        nama = (EditText) findViewById(R.id.inama);
        sandi = (EditText) findViewById(R.id.ipass);

        daftar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent Daftar = new Intent(AdminActivity.this, DaftarActivity.class);
                startActivity(Daftar);
            }
        });


        masuk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String uname = nama.getText().toString();
                String pass = sandi.getText().toString();

                String cari = dbHelper.getSignInId(uname);
                if (pass.equals(cari)) {
                    Toast.makeText(AdminActivity.this, "Akses diberikan. Selamat datang Admin!", Toast.LENGTH_LONG).show();
                    Intent Masuk = new Intent(AdminActivity.this, HecoActivity.class);
                    startActivity(Masuk);

                } else {
                    Toast.makeText(AdminActivity.this, "Nama Pengguna dan Kata Sandi salah", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
