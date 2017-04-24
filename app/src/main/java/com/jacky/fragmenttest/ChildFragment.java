package com.jacky.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by hungming on 2016/10/7.
 */

public class ChildFragment extends Fragment {
    View rootView;
    Button btn;
    Callback callback;


    public void setCallBack(Callback callback)
    {
        this.callback =callback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.childfragment,container,false);
        rootView.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onResult("backzxxx");
                getFragmentManager().popBackStack();
            }
        });
        return rootView;
    }
    public interface  Callback
    {
        public void onResult(String data);
     }
}
