package ke.co.ekenya.www.agripay.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import ke.co.ekenya.www.agripay.Helper.BottomNavigationViewHelper;
import ke.co.ekenya.www.agripay.R;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_wallet:
                    //ChatFragment fragment4 = new ChatFragment();
                    //android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction4.replace(R.id.Content, fragment4);
                    //fragmentTransaction4.commit();
                    return true;

                case R.id.navigation_shop:
                    //CreateAdFragment fragment = new CreateAdFragment();
                    //android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction.replace(R.id.Content, fragment);
                   // fragmentTransaction.commit();
                    return true;

                case R.id.navigation_transactions:
                    //MyAdsFragment fragment2 = new MyAdsFragment();
                    //android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                   // fragmentTransaction2.replace(R.id.Content, fragment2);
                   // fragmentTransaction2.commit();
                    return true;

                case R.id.navigation_settings:
                   // ProfileFragment fragment3 = new ProfileFragment();
                    //android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction3.replace(R.id.Content, fragment3);
                    //fragmentTransaction3.commit();
                    return true;

            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
}
