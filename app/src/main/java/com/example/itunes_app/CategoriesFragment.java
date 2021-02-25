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
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {
    ListView listView;
    ArrayAdapter<DataServices> adapter;

    private static final String ARG_PARAM_ACCOUNT = "ARG_PARAM_ACCOUNT";

    private DataServices.Account mAccount;
    public void setAccountDetails(DataServices.Account accountDetails){
        this.mAccount=accountDetails;
    }
    public CategoriesFragment() {
        // Required empty public constructor
    }

    // based on what I am looking it should be factor method
    public static CategoriesFragment newInstance(DataServices.Account account) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_ACCOUNT, account);
        Log.d("test","Account new Instance");
        fragment.setArguments(args);
        return fragment;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

        Button logoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("App Categories");

        View view = inflater.inflate(R.layout.fragment_catagories, container, false);
        //listView = view.findViewById(R.id.categoryList);
        view.findViewById(R.id.categoriesLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.logout();

            }
        });





        return view;
    }

    CategoriesListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (CategoriesListener) context;
    }

    interface CategoriesListener {
        void logout();
    }
}
