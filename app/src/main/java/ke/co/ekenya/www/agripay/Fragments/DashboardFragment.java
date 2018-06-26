package ke.co.ekenya.www.agripay.Fragments;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import ke.co.ekenya.www.agripay.R;

public class DashboardFragment extends Fragment {
    TextView cash, spend, today_dashboard, weekly_dashboard, monthly_dashboard;
    ImageView today_dashboard_highlight, weekly_dashboard_highlight, monthly_dashboard_highlight;
    ListView dashboard_list;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dashboard, container, false);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        cash = view.findViewById(R.id.cash);
        spend = view.findViewById(R.id.spend);
        today_dashboard = view.findViewById(R.id.today_dashboard);
        weekly_dashboard = view.findViewById(R.id.weekly_dashboard);
        monthly_dashboard = view.findViewById(R.id.monthly_dashboard);
        today_dashboard_highlight = view.findViewById(R.id.today_dashboard_highlight);
        weekly_dashboard_highlight = view.findViewById(R.id.weekly_dashboard_highlight);
        monthly_dashboard_highlight = view.findViewById(R.id.monthly_dashboard_highlight);
        dashboard_list = view.findViewById(R.id.dashboard_list);

        today_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                initialize();
            }
        });

        weekly_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                initializeWeekly();
            }
        });

        monthly_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                initializeMonthly();
            }
        });

        initialize();

        return view;
    }

    private void initialize() {
        Typeface ubuntu_light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ubuntu_light.ttf");
        Typeface ubuntu_bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ubuntu_bold.ttf");

        today_dashboard.setTypeface(ubuntu_bold);
        weekly_dashboard.setTypeface(ubuntu_light);
        monthly_dashboard.setTypeface(ubuntu_light);

        today_dashboard.setTextColor(Color.parseColor("#568832"));
        weekly_dashboard.setTextColor(Color.parseColor("#bdc3c7"));
        monthly_dashboard.setTextColor(Color.parseColor("#bdc3c7"));

        today_dashboard_highlight.setVisibility(View.VISIBLE);
        weekly_dashboard_highlight.setVisibility(View.INVISIBLE);
        monthly_dashboard_highlight.setVisibility(View.INVISIBLE);

    }

    private void initializeWeekly() {
        Typeface ubuntu_light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ubuntu_light.ttf");
        Typeface ubuntu_bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ubuntu_bold.ttf");

        today_dashboard.setTypeface(ubuntu_light);
        weekly_dashboard.setTypeface(ubuntu_bold);
        monthly_dashboard.setTypeface(ubuntu_light);

        today_dashboard.setTextColor(Color.parseColor("#bdc3c7"));
        weekly_dashboard.setTextColor(Color.parseColor("#568832"));
        monthly_dashboard.setTextColor(Color.parseColor("#bdc3c7"));

        today_dashboard_highlight.setVisibility(View.INVISIBLE);
        weekly_dashboard_highlight.setVisibility(View.VISIBLE);
        monthly_dashboard_highlight.setVisibility(View.INVISIBLE);
    }

    private void initializeMonthly() {
        Typeface ubuntu_light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ubuntu_light.ttf");
        Typeface ubuntu_bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ubuntu_bold.ttf");

        today_dashboard.setTypeface(ubuntu_light);
        weekly_dashboard.setTypeface(ubuntu_light);
        monthly_dashboard.setTypeface(ubuntu_bold);

        today_dashboard.setTextColor(Color.parseColor("#bdc3c7"));
        weekly_dashboard.setTextColor(Color.parseColor("#bdc3c7"));
        monthly_dashboard.setTextColor(Color.parseColor("#568832"));

        today_dashboard_highlight.setVisibility(View.INVISIBLE);
        weekly_dashboard_highlight.setVisibility(View.INVISIBLE);
        monthly_dashboard_highlight.setVisibility(View.VISIBLE);
    }
}
