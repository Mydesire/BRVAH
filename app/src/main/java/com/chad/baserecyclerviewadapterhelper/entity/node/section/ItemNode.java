package com.chad.baserecyclerviewadapterhelper.entity.node.section;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import androidx.annotation.DrawableRes;

public class ItemNode extends BaseNode {

    private String teamA;
    private String teamB;
    private int img;
    private List<String> list;

    public ItemNode(String teamA, String teamB, List<String> list) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.list = list;
    }

    @DrawableRes
    public int getImg() {
        return img;
    }

    public void setImg(@DrawableRes int img) {
        this.img = img;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
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
