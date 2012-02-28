package com.zx.prodctmgr;

import java.io.File;

public class MyFile {
	public String absolutePath; // 全路径名
    public String name; // 文件名
    public File   file; // 文件句柄
 
    public MyFile(String _name) {
        name = _name;
    }
    
    public MyFile(String _name, File _file) {
        name = _name;
        file = _file;
    }
    
    public MyFile(String _name, String _absolutePath, File _file) {
        name = _name;
    	absolutePath = _absolutePath;
    }
}
