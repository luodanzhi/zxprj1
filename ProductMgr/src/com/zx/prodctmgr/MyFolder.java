package com.zx.prodctmgr;

import java.io.File;

public class MyFolder {
	public String absolutePath; // 全路径名
    public String name; // 文件名
    public File   file; // 文件句柄
 
    public MyFolder(String _name) {
        name = _name;
    }
    
    public MyFolder(String _name, File _file) {
        name = _name;
        file = _file;
    }
    
    public MyFolder(String _name, String _absolutePath, File _file) {
        name = _name;
    	absolutePath = _absolutePath;
    }
}
