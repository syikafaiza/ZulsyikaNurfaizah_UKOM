package app.healthcompanion.heco;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zulsyika Nurfaizah on 2/16/2015.
 */
public class HecoActivity extends ActionBarActivity implements View.OnClickListener
{
    EditText lihat, sakit, gejala1, gejala2, gejala3, gejala4, gejala5, herbal, sintetis, tips;
    List<Heco> listheco;
    DatabaseHelper dbHelper;
    ListView listViewHeco;
    Integer idHeco;
    Boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heco);

        sakit = (EditText) findViewById(R.id.isakit);
        lihat = (EditText) findViewById(R.id.ilihat);
        gejala1 = (EditText) findViewById(R.id.igejala1);
        gejala2 = (EditText) findViewById(R.id.igejala2);
        gejala3 = (EditText) findViewById(R.id.igejala3);
        gejala4 = (EditText) findViewById(R.id.igejala4);
        gejala5 = (EditText) findViewById(R.id.igejala5);
        herbal = (EditText) findViewById(R.id.iherbal);
        sintetis = (EditText) findViewById(R.id.isintetis);
        tips = (EditText) findViewById(R.id.itips);

        dbHelper = new DatabaseHelper(getApplicationContext());

        listheco = dbHelper.getAllHeco();

        Log.d("LIST_HECO", " :"+ listheco.size());
        reloadList();
    }

    public void reloadList()
    {
        listViewHeco = (ListView) findViewById(R.id.listheco);
        listheco = dbHelper.getAllHeco();
        listViewHeco.setAdapter(new ListHecoAdapter());
        listViewHeco.setOnItemClickListener(new ListHecoClickListener());
    }

    public void reset(View view)
    {
        clear();
    }

    public void clear()
    {
        sakit.setText("");
        lihat.setText("");
        gejala1.setText("");
        gejala2.setText("");
        gejala3.setText("");
        gejala4.setText("");
        gejala5.setText("");
        herbal.setText("");
        sintetis.setText("");
        tips.setText("");
        idHeco = null;
        sakit.clearFocus();
        lihat.clearFocus();
        gejala1.clearFocus();
        gejala2.clearFocus();
        gejala3.clearFocus();
        gejala4.clearFocus();
        gejala5.clearFocus();
        herbal.clearFocus();
        sintetis.clearFocus();
        tips.clearFocus();
    }

    public void save(View view)
    {
        final Heco heco = new Heco();
        if(idHeco == null)
        {
            valid = true;

            if(valid)
            {
                heco.setSakit(sakit.getText().toString());
                heco.setLihat(lihat.getText().toString());
                heco.setGejala1(gejala1.getText().toString());
                heco.setGejala2(gejala2.getText().toString());
                heco.setGejala3(gejala3.getText().toString());
                heco.setGejala4(gejala4.getText().toString());
                heco.setGejala5(gejala5.getText().toString());
                heco.setHerbal(herbal.getText().toString());
                heco.setSintetis(sintetis.getText().toString());
                heco.setTips(tips.getText().toString());
                dbHelper.save(heco);
                clear();
                reloadList();
            }
        }
        else
        {
            AlertDialog.Builder dialogEdit = new AlertDialog.Builder(HecoActivity.this);
            dialogEdit.setTitle("Are you sure want to Edit ?");
            dialogEdit.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    // TODO Auto-generated method stub
                }
            });
            dialogEdit.setPositiveButton("Yes", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    // TODO Auto-generated method stub
                    valid = true;

                    if(valid)
                    {
                        heco.setSakit(sakit.getText().toString());
                        heco.setLihat(lihat.getText().toString());
                        heco.setGejala1(gejala1.getText().toString());
                        heco.setGejala2(gejala2.getText().toString());
                        heco.setGejala3(gejala3.getText().toString());
                        heco.setGejala4(gejala4.getText().toString());
                        heco.setGejala5(gejala5.getText().toString());
                        heco.setHerbal(herbal.getText().toString());
                        heco.setSintetis(sintetis.getText().toString());
                        heco.setTips(tips.getText().toString());
                        dbHelper.update(heco);
                        clear();
                        reloadList();
                    }
                }
            });
            (dialogEdit.create()).show();
        }
    }

    private class ListHecoAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            // TODO Auto-generated method stub
            return listheco.size();
        }

        @Override
        public Heco getItem(int heco)
        {
            // TODO Auto-generated method stub
            return listheco.get(heco);
        }

        @Override
        public long getItemId(int heco)
        {
            // TODO Auto-generated method stub
            return heco;
        }

        @Override
        public View getView(int sehat, View view, ViewGroup parent)
        {
            // TODO Auto-generated method stub
            View item = view;
            if(view == null)
            {
                item = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_template, parent, false);
            }
            Heco heco = getItem(sehat);
            if(heco != null)
            {
                TextView sakit = (TextView) item.findViewById(R.id.items);
                sakit.setText(heco.getSakit());
            }
            return item;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_heco, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class ListHecoClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int sehat, long id)
        {
            // TODO Auto-generated method stub
            final Heco heco = (Heco) adapter.getItemAtPosition(sehat);
            idHeco = heco.getId();

            final CharSequence[] items = {
                    "Edit", "Delete"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(HecoActivity.this);
            builder.setTitle("Action");
            builder.setItems(items, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int item) {
                    // TODO Auto-generated method stub
                    if(item == 0)
                    {
                        sakit.setText(heco.getSakit());
                        lihat.setText(heco.getLihat());
                        gejala1.setText(heco.getSakit());
                        gejala2.setText(heco.getLihat());
                        gejala3.setText(heco.getSakit());
                        gejala4.setText(heco.getLihat());
                        gejala5.setText(heco.getSakit());
                        herbal.setText(heco.getLihat());
                        sintetis.setText(heco.getSakit());
                        tips.setText(heco.getLihat());
                    }
                    else
                    {
                        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(HecoActivity.this);
                        dialogDelete.setTitle("Are You Sure to Delete ?");
                        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub

                            }
                        });
                        dialogDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dbHelper.delete(idHeco);
                                idHeco = null;
                                reloadList();
                            }
                        });
                        (dialogDelete.create()).show();
                    }

                }
            });

            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    // TODO Auto-generated method stub
                    idHeco = null;
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

    }

    @Override
    public void onClick(View v)
    {

    }
}
