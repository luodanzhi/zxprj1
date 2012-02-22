package com.zx.prodctmgr;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
    
    FolderAdapter mAdapter = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mAdapter = new FolderAdapter();
        
        setTitle(R.string.main_title);
    }
}