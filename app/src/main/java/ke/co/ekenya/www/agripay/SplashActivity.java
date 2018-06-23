package ke.co.ekenya.www.agripay;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView lets_shop, splash_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lets_shop = findViewById(R.id.lets_shop);
        splash_text = findViewById(R.id.splash_text);

        set_fonts();

        lets_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                SplashActivity.this.finish();
            }
        });

    }

    private void set_fonts() {
        Typeface ubuntu_medium = Typeface.createFromAsset(getAssets(), "fonts/ubuntu_medium.ttf");
        Typeface ubuntu_bold = Typeface.createFromAsset(getAssets(), "fonts/ubuntu_medium.ttf");
        splash_text.setTypeface(ubuntu_medium);
        lets_shop.setTypeface(ubuntu_bold);
    }
}
