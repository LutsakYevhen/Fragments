package com.example.lutsak.fragments;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    final String LOG_TAG = MainActivity.class.getSimpleName();

    private Fragment1 mFragment1;
    private Fragment2 mFragment2;
    Button blueButton;
    Button redButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, ">> MainActivity onCreate");

        mFragment1 = new Fragment1();
        mFragment2 = new Fragment2();

        blueButton = findViewById(R.id.blue_button);
        redButton = findViewById(R.id.red_button);

        blueButton.setOnClickListener(this);
        redButton.setOnClickListener(this);

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
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.blue_button:
                fragmentTransaction.replace(R.id.frame_layout, mFragment2);
                break;
            case R.id.red_button:
                fragmentTransaction.replace(R.id.frame_layout, mFragment1);
                break;
        }
        fragmentTransaction.commit();
    }
}