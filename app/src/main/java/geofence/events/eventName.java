package geofence.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DY on 3/6/2018.
 */

public class eventName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventname_main);

        Button b1=(Button)findViewById(R.id.bBack);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etLocation = (EditText) findViewById(R.id.editText);
                Intent intent = new Intent(eventName.this, alertcontentActivity.class );
                intent.putExtra("location", etLocation.getText().toString());
                setResult(RESULT_OK, intent);
                finish();


            }
        });

    }
}

