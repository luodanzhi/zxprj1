package com.zx.prodctmgr;

import java.io.File;
import java.util.ArrayList;

import com.zx.common.Const;
import com.zx.common.LogUtil;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	MyFolder myFolder = (MyFolder) l.getItemAtPosition(position);
    	if (myFolder != null) {
    		Intent intent = new Intent();
    		intent.setClass(MainActivity.this, ProductListActivity.class);
    		logD("open folder " + myFolder.name);
    		intent.putExtra(Const.INTENT_PRODUCT_DIR, myFolder.file.getAbsolutePath());
    		startActivity(intent);
    	}
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
    
    private void logD(String msg) {
    	LogUtil.logD(msg);
    }
}