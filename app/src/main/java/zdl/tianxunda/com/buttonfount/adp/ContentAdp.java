package zdl.tianxunda.com.buttonfount.adp;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Map;

import zdl.tianxunda.com.buttonfount.R;
import zdl.tianxunda.com.buttonfount.bean.PanDuanBean;
import zdl.tianxunda.com.buttonfount.utils.PanDuanUtils;

/**
 * @author dell-pc
 * @date 2019/2/14
 */

public class ContentAdp extends BaseQuickAdapter<Map<String, String>, BaseViewHolder> {

    public ContentAdp(int item_do_work_small_layout) {
        super(item_do_work_small_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, Map<String, String> item) {
        TextView item_dowork_small_number = helper.itemView.findViewById(R.id.item_dowork_small_number);
        TextView item_dowork_small_title = helper.itemView.findViewById(R.id.item_dowork_small_title);
        helper.setText(R.id.item_dowork_small_number, item.get("answer"))
                .setText(R.id.item_dowork_small_title, item.get("question"));
        Log.d("zdl", "===============" + item.get("xunze"));
        int xunze = Integer.valueOf(item.get("xunze"));
        PanDuanBean panDuanBean = PanDuanUtils.list.get(xunze);
        if (panDuanBean.user.equals(item.get("answer"))){
            item_dowork_small_title.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            item_dowork_small_number.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }else {
            item_dowork_small_title.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
            item_dowork_small_number.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
