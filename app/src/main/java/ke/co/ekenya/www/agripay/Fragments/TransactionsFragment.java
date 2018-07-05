package ke.co.ekenya.www.agripay.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ke.co.ekenya.www.agripay.R;

public class TransactionsFragment extends Fragment {

    public TransactionsFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        return view;
    }

}
