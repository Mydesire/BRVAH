package com.chad.baserecyclerviewadapterhelper.adapter;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DragAndSwipeAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements DraggableModule {

    public DragAndSwipeAdapter(List<String> data) {
        super(R.layout.item_draggable_view, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull String item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img0);
                break;
            case 1:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img1);
                break;
            case 2:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img2);
                break;
            default:
                break;
        }
        helper.setText(R.id.tv, item);
    }

    // kotlin 新特新, 目前再java 中并不支持, 修复方法
    // https://github.com/CymChad/BaseRecyclerViewAdapterHelper/issues/3557
    // https://github.com/CymChad/BaseRecyclerViewAdapterHelper/issues/3555
    @NotNull
    @Override
    public BaseDraggableModule addDraggableModule(@NotNull BaseQuickAdapter<?, ?> baseQuickAdapter) {
        return new BaseDraggableModule(baseQuickAdapter);
    }
}
