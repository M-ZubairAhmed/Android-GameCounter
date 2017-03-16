package mzubairahmed.gamescorecounter;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity  {

    public int teamAScore = 0;
    public int teamBScore = 0;
    private boolean timerStatus = false;
    private long startTime = 0L;
    private long timeElapse = 0L;
    private long timeUpdated = 0L;
    private long timeBuff = 0L;
    private Handler handler = new Handler();
    private TextView timer_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.football_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        timer_text = (TextView) findViewById(R.id.football_timer_xml);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportActionBar().hide();
//            timer_text.setTextSize(150);
        }

        timer_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start or resume countdown
                if (!timerStatus){
                    startTime = SystemClock.uptimeMillis();
                    handler.postDelayed(timerThread,0);
                    timerStatus = true;
                    timer_text.setTextColor(Color.parseColor("#4CAF50"));
                }
                else {
                    timeBuff = timeBuff + timeElapse;
                    handler.removeCallbacks(timerThread);
                    timerStatus = false;
                    timer_text.setTextColor(Color.RED);
                }
            }
        });

        
    }

    private Runnable timerThread = new Runnable() {
        @Override
        public void run() {
            timeElapse = SystemClock.uptimeMillis() - startTime;
            timeUpdated = timeBuff + timeElapse;
            int sec = (int) (timeUpdated / 1000);
            int min = sec / 60;
            timer_text.setText(String.format("%02d",min) + " : " + String.format("%02d",sec));
            handler.postDelayed(this,0);
        }
    };


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
                Toast.makeText(SecondActivity.this,"restart",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_end_xml:
                Toast.makeText(SecondActivity.this,"end game",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
