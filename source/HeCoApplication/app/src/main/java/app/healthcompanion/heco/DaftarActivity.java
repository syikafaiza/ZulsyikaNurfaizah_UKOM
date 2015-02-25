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


public class DaftarActivity extends ActionBarActivity {

    EditText iuname, ipass, ikpass;
    Button iddaftar;
    DatabaseHelper dbHelper;

    public void clear() {
        iuname.setText("");
        ipass.setText("");
        ikpass.setText("");
        iuname.requestFocus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        dbHelper = new DatabaseHelper(getApplicationContext());

        iuname = (EditText) findViewById(R.id.idnama);
        ipass = (EditText) findViewById(R.id.idpass);
        ikpass = (EditText) findViewById(R.id.idkpass);

        iddaftar = (Button) findViewById(R.id.iddaftar);
        iddaftar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String uname = iuname.getText().toString();
                String pass = ipass.getText().toString();
                String kpass = ikpass.getText().toString();

                if (uname.equals("") || pass.equals("") || kpass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Kosong", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!pass.equals(kpass)) {
                    Toast.makeText(getApplicationContext(), "Password tidak sesuai", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    dbHelper.insert(uname, kpass);
                    Toast.makeText(getApplicationContext(), "Daftar berhasil", Toast.LENGTH_LONG).show();
                    clear();
                    Intent Kembali = new Intent(DaftarActivity.this, AdminActivity.class);
                    startActivity(Kembali);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        dbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_daftar, menu);
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
