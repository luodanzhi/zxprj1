package com.zx.prodctmgr;

import java.io.File;
import java.util.ArrayList;

import com.zx.common.Const;
import com.zx.common.LogUtil;
import com.zx.common.MimeTypeTable;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DetailActivity extends Activity {

    private FileAdapter mAdapter = null;
    private String mProductDir = null;
    
	private ListView mListView = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        mProductDir = intent.getExtras().getString(Const.INTENT_PRODUCT_DIR);

        if (mProductDir != null) {
	        ArrayList<MyFile> myFileList = getFileList(mProductDir);
	        mAdapter = new FileAdapter(this, myFileList);

	        mListView = (ListView) findViewById(R.id.listview_attachment);
			mListView.setOnItemClickListener(onItemClickListener);
	        mListView.setAdapter(mAdapter);
        }
        else {
        	LogUtil.logE("cannot get product dir!");
        	finish();
        }
        
        
    }


    private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			MyFile myFile = (MyFile) parent.getItemAtPosition(position);
	    	if (myFile != null) {
	    		openFile(DetailActivity.this, myFile.file);
	    	}
		}
    	
    };
    
    public static void openFile(Activity activity, File file) {
        if (activity == null || file == null) {
            logD("openFile() param is null");
            return;
        }
        
        // 打开文件
        try {
            String mime = MimeTypeTable.getContentType(file.getName());  
            logD("fileName:" + file.getName() + " mine:" + mime);
            
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), mime);
            activity.startActivity(intent);
        } catch (Exception e) {
        	Toast.makeText(activity, "不能打开当前的文件。", Toast.LENGTH_SHORT);
        }
    }
 
    // 如果这个时间长的话，要单独放到一个线程中
    private ArrayList<MyFile> getFileList(String baseDir) {
        ArrayList<MyFile> myFileList = new ArrayList<MyFile>();
        
        File baseFile = new File(baseDir);
        
        File[] files = baseFile.listFiles();
        if (files != null) {
            for (File file : files) {
            	if (file.isFile()) {
	                MyFile myFile = new MyFile(file.getName(), file);
	                myFileList.add(myFile);
            	}
            }
        }
        
        return myFileList;
    }
    
    
    private static void logD(String msg) {
    	LogUtil.logD(msg);
    }
}
