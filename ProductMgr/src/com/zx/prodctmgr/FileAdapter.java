package com.zx.prodctmgr;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FileAdapter extends BaseAdapter {
    private LayoutInflater mInfalter;
    private Context mContext;
    private ArrayList<MyFile> mMyFileList = null;
    
    public FileAdapter(Context c) {
        mContext = c;
        mInfalter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public FileAdapter(Context c, ArrayList<MyFile> MyFileList) {
        mContext = c;
        mMyFileList = MyFileList;
        mInfalter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        if (mMyFileList != null) {
            return mMyFileList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mMyFileList != null && position < mMyFileList.size()) {
            return mMyFileList.get(position);
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
        
        TextView fileLabel = (TextView) convertView.findViewById(R.id.textview);
        fileLabel.setText(mMyFileList.get(position).name);
        return convertView;
    }

}
