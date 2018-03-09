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
    private TextView thename;
    private Button btngocalendar;
    private Button btnback;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertcontent_main);
        thedate = (TextView) findViewById(R.id.date);
        thename = (TextView) findViewById(R.id.name);
        btngocalendar = (Button) findViewById(R.id.bDateButton);
        btnback = (Button) findViewById(R.id.bback2);
        String dateCopy = thedate.getText().toString();

        /*Intent incoming = getIntent();
        if(null!=incoming.getExtras()) {
            String date = incoming.getStringExtra("date");
            if(date!=null) {
                thedate.setText(date);
            }
        }
        else
        {
            thedate.setText(dateCopy);
        }
*/


        Button b1=(Button)findViewById(R.id.bName);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(alertcontentActivity.this, eventName.class), 2);
            }
        });
        btngocalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alertcontentActivity.this,CalendarActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alertcontentActivity.this,MainActivity.class);
                startActivityForResult(intent, 3);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode==RESULT_OK) {
                String date = data.getStringExtra("date");
                thedate.setText(date);
            }
        }
        if (requestCode == 2) {
            if (resultCode==RESULT_OK) {
                String name = data.getStringExtra("name");
                thename.setText(name);


            }
        }
    }

}
