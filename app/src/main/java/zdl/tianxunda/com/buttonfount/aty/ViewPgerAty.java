package zdl.tianxunda.com.buttonfount.aty;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.interfaces.SwipeBack;
import com.kongzue.baseframework.util.JumpParameter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zdl.tianxunda.com.buttonfount.R;
import zdl.tianxunda.com.buttonfount.adp.ViewPagerAdp;
import zdl.tianxunda.com.buttonfount.base.BaseAty;
import zdl.tianxunda.com.buttonfount.fgt.ContentFgt;

@Layout(R.layout.aty_view_pger)
@DarkStatusBarTheme(true)  //开启顶部状态栏图标、false 白色 true 黑色
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
public class ViewPgerAty extends BaseAty {

    private ViewPager viewPage;
    private LinearLayout llIndicator;
    private ViewPagerAdp adapter;
    private List<Fragment> fragment = new ArrayList<>();

    @Override
    public void initViews() {
        viewPage = findViewById(R.id.viewPage);
        llIndicator = findViewById(R.id.ll_indicator);
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        for (int i = 0; i < 3; i++) {
            ContentFgt contentFgt = new ContentFgt();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            contentFgt.setArguments(bundle);
            fragment.add(contentFgt);
        }
        adapter = new ViewPagerAdp(getSupportFragmentManager(), fragment);
        viewPage.setAdapter(adapter);
    }

    @Override
    public void setEvents() {

    }
}
