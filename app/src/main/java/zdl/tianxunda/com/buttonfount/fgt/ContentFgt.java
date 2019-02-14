package zdl.tianxunda.com.buttonfount.fgt;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.kongzue.baseframework.interfaces.Layout;

import zdl.tianxunda.com.buttonfount.MainActivity;
import zdl.tianxunda.com.buttonfount.R;
import zdl.tianxunda.com.buttonfount.base.BaseFgt;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(R.layout.fgt_content)
public class ContentFgt extends BaseFgt {
    private int [] bgRes = {R.mipmap.icon_page_1,R.mipmap.icon_page_2,R.mipmap.icon_page_3};
    private Button btn;
    private RelativeLayout rl;

    @Override
    public void initViews() {
        super.initViews();
        btn = findViewById(R.id.btn);
        rl = findViewById(R.id.rl);
        int index = getArguments().getInt("index");
        rl.setBackgroundResource(bgRes[index]);
        if (index == 2){
            btn.setVisibility(View.VISIBLE);
        }else {
            btn.setVisibility(View.GONE);
        }
    }

    @Override
    public void initDatas() {
        //数据请求
        practice();
    }

    private void practice() {
    }

    @Override
    public void setEvents() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(MainActivity.class);
            }
        });
    }
}
