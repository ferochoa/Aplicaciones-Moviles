package ar.edu.um.aplicacionesmoviles.appum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
    }

    public void exeMenu(View view)
    {
      Intent i = new Intent(this,MenuActivity.class) ;
        startActivity(i);

    }
}
