package com.example.itunes_app;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppDetailsFragment extends Fragment {

    private static final String DATA = "details";
    private static final String ARG_PARAM_APPDETAILS = "ARG_PARAM_APPDETAILS";
    DataServices.App mApp;

    public AppDetailsFragment() {
        // Required empty public constructor
    }


    public static AppDetailsFragment newInstance(DataServices.App App) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_APPDETAILS, App);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mApp = (DataServices.App)getArguments().getSerializable(ARG_PARAM_APPDETAILS);
        }
    }

    TextView artistName;
    TextView appName;
    TextView releaseDate;
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_app_details, container, false);

        getActivity().setTitle("App Details");

        artistName=view.findViewById(R.id.textViewArtistNameAppDetails);
        appName=view.findViewById(R.id.textViewAppNameAppDetails);
        releaseDate=view.findViewById(R.id.textViewReleaseDateAppDetails);

        artistName.setText(mApp.artistName);
        appName.setText(mApp.name);
        releaseDate.setText(mApp.releaseDate);

        listView=view.findViewById(R.id.listViewAppDetailsGenre);

        adapter =new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,mApp.genres);
        listView.setAdapter(adapter);

        return view;
    }

    AppDetailsListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (AppDetailsFragment.AppDetailsListener) context;
    }

    interface AppDetailsListener {

    }
}