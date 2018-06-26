package ke.co.ekenya.www.agripay.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.www.agripay.Fragments.SignInFragment;
import ke.co.ekenya.www.agripay.Fragments.SignUpFragment;
import ke.co.ekenya.www.agripay.R;

public class SignInActivity extends AppCompatActivity {
    private FrameLayout sign_n_or_sign_up_content;
    TextView sign_in, sign_up;
    ImageView bottom_sign_in, bottom_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sign_n_or_sign_up_content = findViewById(R.id.sign_n_or_sign_up_content);
        sign_in = findViewById(R.id.sign_in);
        sign_up = findViewById(R.id.sign_up);
        bottom_sign_in = findViewById(R.id.bottom_sign_in);
        bottom_sign_up = findViewById(R.id.bottom_sign_up);

        initialize();

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlight_sign_in();
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlight_sign_up();
            }
        });
    }

    private void highlight_sign_up() {
        bottom_sign_in.setVisibility(View.INVISIBLE);
        bottom_sign_up.setVisibility(View.VISIBLE);

        SignUpFragment fragment = new SignUpFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sign_n_or_sign_up_content, fragment);
        fragmentTransaction.commit();
    }

    private void highlight_sign_in() {
        bottom_sign_up.setVisibility(View.INVISIBLE);
        bottom_sign_in.setVisibility(View.VISIBLE);

        SignInFragment fragment = new SignInFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sign_n_or_sign_up_content, fragment);
        fragmentTransaction.commit();
    }

    private void initialize() {
        SignInFragment fragment = new SignInFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sign_n_or_sign_up_content, fragment);
        fragmentTransaction.commit();

        bottom_sign_up.setVisibility(View.INVISIBLE);
    }
}
