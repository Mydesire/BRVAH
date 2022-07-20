package com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider;

import android.graphics.Color;
import android.view.View;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.node.section.ItemNode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondNodeProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_section_content;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @Nullable BaseNode data) {
        if (data == null) return;

        ItemNode entity = (ItemNode) data;
        helper.setText(R.id.tv, entity.getName());

        final RecyclerView rv = helper.getView(R.id.rv);
        final GridLayoutManager glMgr = new GridLayoutManager(rv.getContext(), 2);
        rv.setLayoutManager(glMgr);
        rv.setAdapter(new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1, entity.getList()){
            @Override protected void convert(@NonNull BaseViewHolder holder, String item){
                holder.setText(android.R.id.text1, item).setTextColor(android.R.id.text1, Color.BLACK);
            }
        });
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, BaseNode data, int position) {
    }
}
