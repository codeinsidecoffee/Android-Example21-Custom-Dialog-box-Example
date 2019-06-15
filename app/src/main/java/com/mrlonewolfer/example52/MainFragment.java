package com.mrlonewolfer.example52;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

Button btnDailog,btnYes,btnNo;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        btnDailog=view.findViewById(R.id.btnDailog);
        btnDailog.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnDailog){
            LayoutInflater layoutInflater=getLayoutInflater();
            View layoutinflateViewer=layoutInflater.inflate(R.layout.custom_alert_dailog, (ViewGroup) v.findViewById(R.id.linealayout));
            btnYes=layoutinflateViewer.findViewById(R.id.btnYes);
            btnNo=layoutinflateViewer.findViewById(R.id.btnNo);
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setTitle("This is my Custom Alert Dailog Box");
            builder.setMessage("Do You Really Like This Alert Dailog Box?");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setView(layoutinflateViewer);

            final AlertDialog dialog=builder.create();

            dialog.show();

            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Thank You For Your Like", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Ok!! We will Try to Improve Design", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
        }
    }
}
