package com.example.HomeTask1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyActivity extends Activity implements ActivityEvent {
    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentTransaction fTrans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAddFragm1:
                fTrans.add(R.id.frgmCont1, fragment1);
                break;
            case R.id.btnDelFragm1:
                fTrans.remove(fragment1);
                break;
            case R.id.btnAddFragm2:
                fTrans.add(R.id.frgmCont2, fragment2);
                break;
            case R.id.btnDelFragm2:
                fTrans.remove(fragment2);
                break;
            default:
                break;
        }
        fTrans.commit();
    }

    @Override
    public void sendMessage(String text) {
        ((TextView)fragment2.getView().findViewById(R.id.resultMessage2)).setText(text);
    }

}
