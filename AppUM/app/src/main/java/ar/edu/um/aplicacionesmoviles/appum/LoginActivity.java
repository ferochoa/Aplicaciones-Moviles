package ar.edu.um.aplicacionesmoviles.appum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

EditText edt1 ;
EditText edt2;
    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt1 = (EditText)findViewById(R.id.editText4);
        edt2 = (EditText)findViewById(R.id.editText5);
    }
    public void check(View view)
    {
        String strName = edt1.getText().toString();
        String strPass = edt1.getText().toString();

        String password = helper.searchPass(strName);

        if(strPass.equals(password))
        {
            Intent i = new Intent(this, PrincipalActivity.class);
            startActivity(i);
        }
        else
        {
            Toast notification = Toast.makeText(this, "Username and Password don't match", Toast.LENGTH_LONG);
            notification.show();
        }

    }
}
