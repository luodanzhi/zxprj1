package com.zx.prodctmgr;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter {
    private LayoutInflater mInfalter;
    private Context        mContext;
    private ArrayList<MyProduct> mMyProductList = null;

    public ProductAdapter(Context c) {
        mContext = c;
        mInfalter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public ProductAdapter(Context c, ArrayList<MyProduct> myProductList) {
        mContext = c;
        mMyProductList = myProductList;
        mInfalter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	@Override
	public int getCount() {
        if (mMyProductList != null) {
            return mMyProductList.size();
        }
		return 0;
	}

	@Override
	public Object getItem(int position) {
        if (mMyProductList != null && position < mMyProductList.size()) {
            return mMyProductList.get(position);
        }
		return null;
	}

	@Override
	public long getItemId(int position) {
        return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInfalter.inflate(R.layout.list_view_item, parent, false);
        } else {
        }
        
        TextView folderLabel = (TextView) convertView.findViewById(R.id.textview);
        folderLabel.setText(mMyProductList.get(position).name);
        return convertView;
	}

}
