package com.louisgeek.louistimelinedemo.Bean;

import java.util.List;

/**
 * Created by louisgeek on 2016/5/9.
 */
public class GroupBean {
    private String groupName;
    /** 二级Item数据列表 **/
    private List<ChildBean> childList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildBean> getChildList() {
        return childList;
    }

    public void setChildList(List<ChildBean> childList) {
        this.childList = childList;
    }
}
