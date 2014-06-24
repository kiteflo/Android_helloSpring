package tzhmufl2.android_hellospring;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.net.HttpURLConnection;

import tzhmufl2.android_hellospring.adapters.CharacterListAdapter;
import tzhmufl2.android_hellospring.domain.DTOCharacterResponseList;
import tzhmufl2.android_hellospring.network.AsyncServerCall;
import tzhmufl2.android_hellospring.network.HTTPCallback;


public class MainActivity extends ActionBarActivity implements HTTPCallback{

    private final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // trigger call
        AsyncServerCall call = new AsyncServerCall("http://10.0.0.5:8080/backend/characters",this);
        call.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HttpURLConnection con;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void postExecute(DTOCharacterResponseList result)
    {
        CharacterListAdapter cla = new CharacterListAdapter(getApplicationContext(),
                R.layout.character_row,
                result);

        // fetch UI container and mixin contents...
        ListView lvCharacters = (ListView)findViewById(R.id.listView);
        lvCharacters.setAdapter(cla);
    }

    @Override
    public void preExecute()
    {
        Log.i(LOG_TAG,"Triggering HTTP call...");
    }
}
