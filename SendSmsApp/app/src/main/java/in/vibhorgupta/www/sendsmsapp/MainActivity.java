package in.vibhorgupta.www.sendsmsapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button smsButton, emailButton;
    private EditText textSMS;
    private EditText textPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsButton = (Button) findViewById(R.id.sms_send_button);
        emailButton = (Button) findViewById(R.id.email_send_app);
        textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);


        addOnClickListener();
    }

    protected void addOnClickListener() {
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.putExtra("sms_body", "hi how are you?");
                    sendIntent.setType("vnd.android-dir/mms-sms");
                    startActivity(sendIntent);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}