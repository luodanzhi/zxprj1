package com.zx.prodctmgr;

import java.io.File;
import java.util.ArrayList;

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

        setTitle(R.string.main_title);

        ArrayList<MyFolder> myFolderList = getFolderList(Config.BASE_DIR);
        mAdapter = new FolderAdapter(this, myFolderList);

        setListAdapter(mAdapter);
    }
    
    
    // 如果这个时间长的话，要单独放到一个线程中
    private ArrayList<MyFolder> getFolderList(String baseDir) {
        ArrayList<MyFolder> myFolderList = new ArrayList<MyFolder>();
        
        File baseFile = new File(baseDir);
        
        File[] files = baseFile.listFiles();
        if (files != null) {
            for (File file : files) {
                MyFolder myFolder = new MyFolder(file.getName(), file);
                myFolderList.add(myFolder);
            }
        }
        
        return myFolderList;
    }
}