package app.healthcompanion.heco;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.konkes:
                startActivity(new Intent(HomeActivity.this, KonsultasiActivity.class));
                break;

            case R.id.dafgej:
                startActivity(new Intent(HomeActivity.this, GejalaActivity.class));
                break;

            case R.id.dafoh:
                startActivity(new Intent(HomeActivity.this, HerbalActivity.class));
                break;

            case R.id.dafos:
                startActivity(new Intent(HomeActivity.this, SintetisActivity.class));
                break;

            case R.id.tipkes:
                startActivity(new Intent(HomeActivity.this, TipsActivity.class));
                break;

            case R.id.tenaps:
                startActivity(new Intent(HomeActivity.this, TentangActivity.class));
                break;
        }
    }
}
