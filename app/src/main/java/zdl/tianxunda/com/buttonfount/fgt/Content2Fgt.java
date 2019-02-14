package zdl.tianxunda.com.buttonfount.fgt;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongzue.baseframework.interfaces.Layout;

import java.util.ArrayList;
import java.util.Map;

import zdl.tianxunda.com.buttonfount.R;
import zdl.tianxunda.com.buttonfount.adp.ContentAdp;
import zdl.tianxunda.com.buttonfount.aty.ViewPger2Aty;
import zdl.tianxunda.com.buttonfount.base.BaseFgt;
import zdl.tianxunda.com.buttonfount.utils.JSONUtils;
import zdl.tianxunda.com.buttonfount.utils.PanDuanUtils;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(R.layout.fgt_content2)
public class Content2Fgt extends BaseFgt {
    private TextView aty_do_work_tv_title;
    private TextView aty_do_work_tv_content;
    private RecyclerView recyclerView;
    private int index;
    private ContentAdp contentAdp;
    private ArrayList<Map<String, String>> option;

    @Override
    public void initViews() {
        super.initViews();
        index = getArguments().getInt("index");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        aty_do_work_tv_content = findViewById(R.id.aty_do_work_tv_content);
        aty_do_work_tv_title = findViewById(R.id.aty_do_work_tv_title);
        contentAdp = new ContentAdp(R.layout.item_do_work_small_layout);
        recyclerView.setAdapter(contentAdp);
    }

    @Override
    public void initDatas() {
        Map<String, String> map = ViewPger2Aty.list.get(index);
        //id和标题
        aty_do_work_tv_title.setText("id" + map.get("questions_id") + "\n" + map.get("title"));
        aty_do_work_tv_content.setText(map.get("sub_title"));
        option = JSONUtils.parseKeyAndValueToMapList(map.get("option"));
        for (int i = 0; i < option.size(); i++) {
            option.get(i).put("xunze", index + "");
        }
        contentAdp.setNewData(option);
        contentAdp.notifyDataSetChanged();
    }


    @Override
    public void setEvents() {
        contentAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Map<String, String> map = contentAdp.getData().get(position);
                PanDuanUtils.list.get(index).user = map.get("answer");
                toast(map.get("question"));
                contentAdp.notifyDataSetChanged();
            }
        });
    }

}
