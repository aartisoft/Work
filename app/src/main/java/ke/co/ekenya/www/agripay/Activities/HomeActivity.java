package ke.co.ekenya.www.agripay.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ke.co.ekenya.www.agripay.Fragments.SettingsFragment;
import ke.co.ekenya.www.agripay.Fragments.ShopFragment;
import ke.co.ekenya.www.agripay.Fragments.TransactionsFragment;
import ke.co.ekenya.www.agripay.Fragments.WalletFragment;
import ke.co.ekenya.www.agripay.Helper.BottomNavigationViewBehaviour;
import ke.co.ekenya.www.agripay.Helper.BottomNavigationViewHelper;
import ke.co.ekenya.www.agripay.R;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_wallet:
                    initialize();
                    return true;

                case R.id.navigation_shop:
                    ShopFragment fragmentS = new ShopFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionS = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionS.replace(R.id.content, fragmentS);
                    fragmentTransactionS.addToBackStack(null);
                    fragmentTransactionS.commit();
                    return true;

                case R.id.navigation_transactions:
                    TransactionsFragment fragmentT = new TransactionsFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionT = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionT.replace(R.id.content, fragmentT);
                    fragmentTransactionT.commit();
                    return true;

                case R.id.navigation_settings:
                    SettingsFragment fragmentSe = new SettingsFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionSe = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionSe.replace(R.id.content, fragmentSe);
                    fragmentTransactionSe.addToBackStack(null);
                    fragmentTransactionSe.commit();
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

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehaviour());

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initialize();

    }

    private void initialize() {
        WalletFragment fragmentW = new WalletFragment();
        android.support.v4.app.FragmentTransaction fragmentTransactionW = getSupportFragmentManager().beginTransaction();
        fragmentTransactionW.replace(R.id.content, fragmentW);
        fragmentTransactionW.addToBackStack(null);
        fragmentTransactionW.commit();
    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            //fm.popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }
}
