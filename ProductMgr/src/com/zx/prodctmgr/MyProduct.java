package com.zx.prodctmgr;

import java.io.File;

public class MyProduct {
	public String name;
	public String serialNo;
    public File   file; // 文件句柄
	
	public MyProduct(String _name) {
		name = _name;
	}
	
    public MyProduct(String _name, File _file) {
        name = _name;
        file = _file;
    }
}
