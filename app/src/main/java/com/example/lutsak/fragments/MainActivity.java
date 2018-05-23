package com.example.lutsak.fragments;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private Button mBlueButton;
    private Button mRedButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, ">> MainActivity onCreate");

        mBlueButton = findViewById(R.id.blue_button);
        mRedButton = findViewById(R.id.red_button);

        mBlueButton.setOnClickListener(this);
        mRedButton.setOnClickListener(this);

        Log.d(LOG_TAG, "<< MainActivity onCreate");
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "MainActivity onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "MainActivity onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "MainActivity onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "MainActivity onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity onDestroy");
    }

    @Override
    public void onClick(View v) {

        Fragment fragment1 = getFragmentManager().findFragmentByTag("fragment1");
        Fragment fragment2 = getFragmentManager().findFragmentByTag("fragment2");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.blue_button:
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                }
                fragmentTransaction.replace(R.id.frame_layout, fragment2, "fragment2");
                break;
            case R.id.red_button:
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                }
                fragmentTransaction.replace(R.id.frame_layout, fragment1, "fragment1");
                break;
        }
        fragmentTransaction.commit();
    }
}