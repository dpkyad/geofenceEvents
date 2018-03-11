package geofence.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    DatabaseHelper myDb;








    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);


        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, alertcontentActivity.class));
            }
        });

        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //**Toast.makeText(MainActivity.this,"ALERT 2",Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(MainActivity.this, alertcontentActivity.class));
                //testing
            }
        });

        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //**Toast.makeText(MainActivity.this,"ALERT 3",Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(MainActivity.this, alertcontentActivity.class));
            }
        });

        b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //**Toast.makeText(MainActivity.this,"ALERT 4",Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(MainActivity.this, alertcontentActivity.class));
            }
        });
    }
}
