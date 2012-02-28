package com.zx.prodctmgr;

import java.io.File;
import java.util.ArrayList;

import com.zx.common.Const;
import com.zx.common.LogUtil;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


/**
 * 产品信息的列表
 * @author grind
 *
 */
public class ProductListActivity extends ListActivity {

    private ProductAdapter mAdapter = null;
    private String mProductDir = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = getIntent();
        mProductDir = intent.getExtras().getString(Const.INTENT_PRODUCT_DIR);

        if (mProductDir != null) {
	        ArrayList<MyProduct> myProductList = getProductList(mProductDir);
	        mAdapter = new ProductAdapter(this, myProductList);

	        setListAdapter(mAdapter);
        }
        else {
        	LogUtil.logE("cannot get product dir!");
        	finish();
        }
    }
    

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	MyProduct myProduct = (MyProduct) l.getItemAtPosition(position);
    	if (myProduct != null) {
    		Intent intent = new Intent();
    		intent.setClass(ProductListActivity.this, DetailActivity.class);
    		logD("open folder " + myProduct.name);
    		intent.putExtra(Const.INTENT_PRODUCT_DIR, myProduct.file.getAbsolutePath());
    		startActivity(intent);
    	}
    }

    // 如果这个时间长的话，要单独放到一个线程中
    private ArrayList<MyProduct> getProductList(String baseDir) {
        ArrayList<MyProduct> myProductList = new ArrayList<MyProduct>();
        
        File baseFile = new File(baseDir);
        
        File[] files = baseFile.listFiles();
        if (files != null) {
            for (File file : files) {
                MyProduct myProduct = new MyProduct(file.getName(), file);
                myProductList.add(myProduct);
            }
        }
        
        return myProductList;
    }
    
    
    private void logD(String msg) {
    	LogUtil.logD(msg);
    }
}
