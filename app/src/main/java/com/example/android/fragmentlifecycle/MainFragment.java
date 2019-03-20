package com.example.android.fragmentlifecycle;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment implements View.OnClickListener{
    private static boolean isTwoPane = false;
    private static final String TAG = "MainFragment";
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView()");
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated()");
        if(getActivity().findViewById(R.id.container) != null){
            isTwoPane = true;
        }
        Button button = (Button)getView().findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG,"onDetach()");
        super.onDetach();
    }

        @Override
        public void onClick(View view) {
            if(isTwoPane){
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container,new SubFragment());
                transaction.commit();
            }else{
                Intent intent = new Intent(getActivity(),com.example.android.fragmentlifecycle.SubActivity
                        .class);
                startActivity(intent);
            }
        }

}
