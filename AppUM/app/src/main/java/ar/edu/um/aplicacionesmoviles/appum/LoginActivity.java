package ar.edu.um.aplicacionesmoviles.appum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

EditText edt1 ;
EditText edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt1 = (EditText)findViewById(R.id.editText4);
        edt2 = (EditText)findViewById(R.id.editText5);
    }
    public void check(View view)
    {
        //String str = edt1.getText().toString();
    }
}
