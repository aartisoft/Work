package ke.co.ekenya.www.agripay.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ke.co.ekenya.www.agripay.R;

public class SignUpFragment extends Fragment {
    EditText edit_text_fullnames, edit_text_email, edit_text_mobile, edit_text_location;
    Button sign_up;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sign_up, container, false);
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        edit_text_fullnames = view.findViewById(R.id.edit_text_fullnames);
        edit_text_email = view.findViewById(R.id.edit_text_email);
        edit_text_mobile = view.findViewById(R.id.edit_text_mobile);
        edit_text_location = view.findViewById(R.id.edit_text_location);
        sign_up = view.findViewById(R.id.sign_up);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
            }
        });

        return view;
    }

}
