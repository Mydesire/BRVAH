package com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider;

import android.view.View;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootNode;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RootNodeProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.def_section_head;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @Nullable BaseNode data) {
        RootNode entity = (RootNode) data;
        helper.setText(R.id.header, entity.getTitle());
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, BaseNode data, int position) {
        // 全量更新, 点击 导致 convert 方法再次被调用,
//        getAdapter().expandOrCollapse(position);
        // 这里使用payload进行增量刷新（避免单个item刷新导致列表闪烁）
        getAdapter().expandOrCollapse(position, true, true, data);
    }
}
