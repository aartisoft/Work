package ke.co.ekenya.www.agripay.Fragments;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import ke.co.ekenya.www.agripay.Activities.HomeActivity;
import ke.co.ekenya.www.agripay.Activities.SignInActivity;
import ke.co.ekenya.www.agripay.R;

public class SignInFragment extends Fragment {
    EditText edit_text_username, edit_text_password;
    TextView text_forgot_password;
    Button sign_in;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sign_in, container, false);
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        edit_text_username = view.findViewById(R.id.edit_text_username);
        edit_text_password = view.findViewById(R.id.edit_text_password);
        text_forgot_password = view.findViewById(R.id.text_forgot_password);
        sign_in = view.findViewById(R.id.sign_in);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                goToHome();
            }
        });

        text_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
            }
        });

        return view;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void goToHome() {
        startActivity(new Intent(getActivity(), HomeActivity.class));
        Objects.requireNonNull(getActivity()).finish();
    }

}
