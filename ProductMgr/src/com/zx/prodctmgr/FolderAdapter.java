package com.zx.prodctmgr;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FolderAdapter extends BaseAdapter {
    private LayoutInflater mInfalter;
    private Context mContext;
    private ArrayList<MyFolder> mMyFolderList = null;
    
    public FolderAdapter(Context c) {
        mContext = c;
        mInfalter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public FolderAdapter(Context c, ArrayList<MyFolder> myFolderList) {
        mContext = c;
        mMyFolderList = myFolderList;
        mInfalter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        if (mMyFolderList != null) {
            return mMyFolderList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mMyFolderList != null && position < mMyFolderList.size()) {
            return mMyFolderList.get(position);
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
        folderLabel.setText(mMyFolderList.get(position).name);
        return convertView;
    }

}
