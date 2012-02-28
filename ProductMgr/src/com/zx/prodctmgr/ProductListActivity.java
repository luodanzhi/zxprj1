package com.zx.prodctmgr;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;


/**
 * 产品信息的列表
 * @author grind
 *
 */
public class ProductListActivity extends ListActivity {

    FolderAdapter mAdapter = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList<MyFolder> myFolderList = getFolderList(Config.BASE_DIR);
        //mAdapter = new FolderAdapter(this, myFolderList);

        setListAdapter(mAdapter);
    }
}
