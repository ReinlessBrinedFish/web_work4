package com.work4.Item;

import java.io.Serializable;
import java.util.Vector;

public class Table implements Serializable {
    private final Vector<Person> tableinfo;
    //对应初始化列表
    public Table() {
        tableinfo = new Vector<Person>();
        tableinfo.add(new Person("XXX", "134XXXXXXXX", "XXXXXXXXXX@qq.com", "北京市海淀区北太平庄街道西土城路10号", "XXXXXXXXXX"));
        tableinfo.add(new Person("XXX", "134XXXXXXXX", "XXXXXXXXXX@qq.com", "北京市海淀区北太平庄街道西土城路10号", "XXXXXXXXXX"));
        tableinfo.add(new Person("XXX", "134XXXXXXXX", "XXXXXXXXXX@qq.com", "北京市海淀区北太平庄街道西土城路10号", "XXXXXXXXXX"));
    }

    public Vector<Person> addPerson(Person person) {
        tableinfo.add(person);
        return tableinfo;
    }

    //返回当前的列表全内容
    public Vector<Person> getTable(){
        return tableinfo;
    }
    
    public int getSize() { return tableinfo.size(); }
}
