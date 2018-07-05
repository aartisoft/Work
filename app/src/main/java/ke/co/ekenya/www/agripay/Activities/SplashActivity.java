package ke.co.ekenya.www.agripay.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ke.co.ekenya.www.agripay.R;

public class SplashActivity extends AppCompatActivity {
    TextView splash_text;

    Button lets_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lets_shop = findViewById(R.id.lets_shop);
        splash_text = findViewById(R.id.splash_text);

        lets_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });

    }

    private void goToLogin() {
        startActivity(new Intent(SplashActivity.this, SignInActivity.class));
        SplashActivity.this.finish();
    }
}
