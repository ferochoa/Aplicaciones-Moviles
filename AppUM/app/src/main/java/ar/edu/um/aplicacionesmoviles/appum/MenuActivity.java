package ar.edu.um.aplicacionesmoviles.appum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

    }

    public void register(View view){

        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
    public void login(View view){

        Intent j = new Intent(this, LoginActivity.class);
        startActivity(j);
    }
}
