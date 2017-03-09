package mzubairahmed.gamescorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle intentExtras = getIntent().getExtras();
        TextView show2 = (TextView) findViewById(R.id.show2);
        TextView show1 = (TextView) findViewById(R.id.show1);
        show1.setVisibility(TextView.GONE);
        show2.setVisibility(TextView.GONE);

        if (intentExtras.getBoolean("show1")){
            show1.setVisibility(TextView.VISIBLE);
        }
        else if (intentExtras.getBoolean("show2")){
            show2.setVisibility(TextView.VISIBLE);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.menu_restart_xml:
                Toast.makeText(SecondActivity.this,"adf",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_end_xml:
                Toast.makeText(SecondActivity.this,"adf",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
