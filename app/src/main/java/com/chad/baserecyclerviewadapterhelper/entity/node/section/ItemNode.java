package com.chad.baserecyclerviewadapterhelper.entity.node.section;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import androidx.annotation.DrawableRes;

public class ItemNode extends BaseNode {

    private String name;
    private int img;
    private List<String> list;

    public ItemNode(String name, List<String> list) {
        this.name = name;
        this.list = list;
    }

    @DrawableRes
    public int getImg() {
        return img;
    }

    public void setImg(@DrawableRes int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList(){
        return list;
    }

    public void setList(List<String> list){
        this.list = list;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
