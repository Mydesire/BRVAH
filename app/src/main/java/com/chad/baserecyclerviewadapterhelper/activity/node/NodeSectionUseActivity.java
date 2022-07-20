package com.chad.baserecyclerviewadapterhelper.activity.node;

import android.os.Bundle;
import android.view.View;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.adapter.node.section.NodeSectionAdapter;
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.entity.node.section.ItemNode;
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class NodeSectionUseActivity extends BaseActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_section);

        setBackBtn();
        setTitle("Node Use (Section)");

        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        mRecyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));

        final NodeSectionAdapter nodeAdapter = new NodeSectionAdapter();

        // 顶部header
        View view = getLayoutInflater().inflate(R.layout.head_view, mRecyclerView, false);
        view.findViewById(R.id.iv).setVisibility(View.GONE);
        nodeAdapter.addHeaderView(view);

        mRecyclerView.setAdapter(nodeAdapter);

        nodeAdapter.setList(getEntity());
        mRecyclerView.scheduleLayoutAnimation();
    }

    private List<BaseNode> getEntity() {
        List<BaseNode> list = new ArrayList<>();

        final Random r = new Random(1);
        for (int i = 0; i < 8; i++) {
            final float rInt = r.nextFloat();
            List<String> rateList = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                rateList.add(rInt + "." + j);
            }

            //Item Node
            List<BaseNode> nodeContentList = new ArrayList<>();
            ItemNode itemEntity1 = new ItemNode("Root " + i + " - SecondNode 0", rateList);
//            ItemNode itemEntity2 = new ItemNode("Root " + i + " - SecondNode 1", rateList);
//            ItemNode itemEntity3 = new ItemNode("Root " + i + " - SecondNode 2", rateList);
//            ItemNode itemEntity4 = new ItemNode("Root " + i + " - SecondNode 3", rateList);
//            ItemNode itemEntity5 = new ItemNode("Root " + i + " - SecondNode 4", rateList);
            nodeContentList.add(itemEntity1);
//            nodeContentList.add(itemEntity2);
//            nodeContentList.add(itemEntity3);
//            nodeContentList.add(itemEntity4);
//            nodeContentList.add(itemEntity5);

            // Root Node
            RootNode entity = new RootNode("Root Node " + i, nodeContentList);

            // 第1号数据默认不展开
            if (i != 0) entity.setExpanded(false);

            list.add(entity);
        }
        return list;
    }
}
