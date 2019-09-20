package cn.devld.hc_05demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        final Intent intent2 = new Intent(this, dashboard.class);

        Button btnSignUp = (Button) findViewById(R.id.btnSignUp);
        final Intent intent = new Intent(this, SignUp.class);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

    }




}
