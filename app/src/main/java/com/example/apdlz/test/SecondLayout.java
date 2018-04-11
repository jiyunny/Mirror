package com.example.apdlz.test;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by apdlz on 2018-04-05.
 */

public class SecondLayout extends Fragment {
    View v;
    EditText edit;
    String ipset;
    Button btn;



    public interface OML{
        void oRD(String ipsend);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if( context instanceof OML){
            ML = (OML)context;
        }else {
            throw new RuntimeException(context.toString()+" must implement OML");
        }
    }
    @Override
    public void onDetach(){
        super.onDetach();
        ML=null;
    }
    private OML ML;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       v =inflater.inflate (R.layout.second_layout, container, false);
       final Activity root = getActivity();
       Bundle bd = new Bundle();
       bd=getArguments();
       if(bd.getString("ip")!=null)
       ipset = bd.getString("ip");
        btn = (Button)v.findViewById(R.id.button);
        edit =(EditText)v.findViewById(R.id.editText);
        edit.setText(ipset);
        btn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0){
                ipset = edit.getText().toString();
                ML.oRD(ipset);
              //  Toast.makeText(root,ipset, Toast.LENGTH_LONG).show();
            }
        });

       return v;
    }
}
