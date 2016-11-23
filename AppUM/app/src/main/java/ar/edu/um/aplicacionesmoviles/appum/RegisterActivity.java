package ar.edu.um.aplicacionesmoviles.appum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText name;
    EditText password;
    EditText password2;
    EditText username;
    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        password2 = (EditText)findViewById(R.id.editText6);
        username = (EditText)findViewById(R.id.editText3);
    }

    public void onSignUp(View view)
    {
        String nameStr = name.getText().toString();
        String passStr = password.getText().toString();
        String pass2Str = password2.getText().toString();
        String userStr = username.getText().toString();

        if(!passStr.equals(pass2Str))
        {
            Toast passNotification = Toast.makeText(this, "Password don't match", Toast.LENGTH_LONG);
            passNotification.show();
        }
        else
        {
            Contact c = new Contact();
            c.setName(nameStr);
            c.setPassword(passStr);
            c.setUsername(userStr);

            helper.insertContact(c);

        }
    }
}

