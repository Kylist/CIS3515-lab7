package edu.temple.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.WindowManager;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.SendURLInterface, PageControlFragment.goBackInterface, PageControlFragment.goNextInterface, PageViewerFragment.SetURLInterface {

    static PageControlFragment PageControlFragment = new PageControlFragment();
    static PageViewerFragment PageViewerFragment = new PageViewerFragment();

    PageControlFragment Fragment1;
    PageViewerFragment Fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Browser Activity");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        Fragment1 = new PageControlFragment();
        Fragment2 = new PageViewerFragment();

        FragmentManager FM = getSupportFragmentManager();

        FragmentTransaction FT = FM.beginTransaction();
        FT.add(R.id.page_control, Fragment1);
        FT.add(R.id.page_viewer, Fragment2);
        FT.commit();
    }

    public void SendURL(String URL){
        String reqStr = "https://";




        if(!URL.substring(0,reqStr.length()).equals(reqStr)){
            URL = reqStr.concat(URL);
        }

        Fragment2.setURL(URL);

        Fragment1.setText(Fragment2.getURL());


    }

    @Override
    public void SetURL() {

        Fragment1.setText(Fragment2.getURL());
    }

    @Override
    public void goBack() {
        Fragment2.goBack();
    }

    public void goNext() {
        Fragment2.goNext();
    }
}