package geofence.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DY on 3/6/2018.
 */

public class alertcontentActivity  extends AppCompatActivity{
    private TextView thedate;
    private Button btngocalendar;
    private Button btnTime;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertcontent_main);
        thedate = (TextView) findViewById(R.id.date);
        btngocalendar = (Button) findViewById(R.id.bDateButton);
        Button b1=(Button)findViewById(R.id.bName);
        btnTime = (Button) findViewById(R.id.bTime);

        Intent incoming = getIntent();
        String date = incoming.getStringExtra("date");
        thedate.setText(date);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(alertcontentActivity.this, eventName.class));
            }
        });
        btngocalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alertcontentActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(alertcontentActivity.this, TimeActivity.class));
            }
        });


    }

}
