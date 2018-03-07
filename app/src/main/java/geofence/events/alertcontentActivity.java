package geofence.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

/**
 * Created by DY on 3/6/2018.
 */

public class alertcontentActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertcontent_main);

        Button b1=(Button)findViewById(R.id.bName);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(alertcontentActivity.this, eventName.class));
            }
        });

    }

}
