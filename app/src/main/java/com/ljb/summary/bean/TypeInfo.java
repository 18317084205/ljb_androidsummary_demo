package com.ljb.summary.bean;

/**
 * 作者：ljb
 * 时间：2016/11/28 15:18
 * 邮箱：563773219@qq.com
 * 描述：
 */
public class TypeInfo {
    private String type;
    private String name;

    public TypeInfo(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
