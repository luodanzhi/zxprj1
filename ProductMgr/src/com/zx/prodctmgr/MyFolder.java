package com.zx.prodctmgr;

import java.io.File;

public class MyFolder {
    public String name; // 文件名
    public File   file; // 文件句柄
 
    public MyFolder(String _name) {
        this.name = _name;
    }
    
    public MyFolder(String _name, File _file) {
        this.name = _name;
    }
}
