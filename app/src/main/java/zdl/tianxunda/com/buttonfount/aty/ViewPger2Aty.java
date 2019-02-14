package zdl.tianxunda.com.buttonfount.aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import zdl.tianxunda.com.buttonfount.R;
import zdl.tianxunda.com.buttonfount.adp.ViewPagerAdp;
import zdl.tianxunda.com.buttonfount.base.BaseAty;
import zdl.tianxunda.com.buttonfount.bean.PanDuanBean;
import zdl.tianxunda.com.buttonfount.fgt.Content2Fgt;
import zdl.tianxunda.com.buttonfount.utils.JSONUtils;
import zdl.tianxunda.com.buttonfount.utils.PanDuanUtils;

@Layout(R.layout.aty_view_pger2)
@DarkStatusBarTheme(true)  //开启顶部状态栏图标、false 白色 true 黑色
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
public class ViewPger2Aty extends BaseAty {

    private ViewPager viewPage;
    private LinearLayout llIndicator;
    private ViewPagerAdp adapter;
    private List<Fragment> fragment = new ArrayList<>();
    public static ArrayList<Map<String, String>> list = new ArrayList<>();

    @Override
    public void initViews() {
        viewPage = findViewById(R.id.viewPage);
        llIndicator = findViewById(R.id.ll_indicator);
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        practice();
    }

    @Override
    public void setEvents() {

    }

    private void practice() {
        HttpRequest.POST(me, "http://jgb.txunda.com/index.php/Api/Exercises/practice"
                , new Parameter()
                        .add("token", "a4a3505952d7889e11b1cefc62884bac")
                        .add("subject_id", "1")
                        .add("type", "1")
                , new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            Map<String, String> map = JSONUtils.parseKeyAndValueToMap(response);
                            Map<String, String> map1 = JSONUtils.parseKeyAndValueToMap(map.get("data"));
                            list = JSONUtils.parseKeyAndValueToMapList(map1.get("list"));
                            if (list == null) {
                                return;
                            }
                            PanDuanUtils.list.clear();
                            for (int i = 0; i < list.size(); i++) {
                                PanDuanUtils.list.add(new PanDuanBean(i+"",""));
                                Content2Fgt contentFgt = new Content2Fgt();
                                Bundle bundle = new Bundle();
                                bundle.putInt("index", i);
                                contentFgt.setArguments(bundle);
                                fragment.add(contentFgt);
                            }
                            adapter = new ViewPagerAdp(getSupportFragmentManager(), fragment);
                            viewPage.setAdapter(adapter);
                        } else {
                            toast("网络连接失败");
                        }
                    }
                });
    }
}
