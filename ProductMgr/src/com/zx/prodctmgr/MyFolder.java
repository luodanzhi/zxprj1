package com.zx.prodctmgr;

import java.io.File;

public class MyFolder {
    public String name; // 文件名
    public File   file; // 文件句柄
 
    public MyFolder(String name) {
        this.name = name;
    }
    
    public MyFolder(String name, File file) {
        this.name = name;
    }
}
