package zdl.tianxunda.com.buttonfount.aty;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.interfaces.SwipeBack;
import com.kongzue.baseframework.util.JumpParameter;

import zdl.tianxunda.com.buttonfount.MainActivity;
import zdl.tianxunda.com.buttonfount.R;
import zdl.tianxunda.com.buttonfount.base.BaseAty;

@Layout(R.layout.aty_start)
@DarkStatusBarTheme(true)  //开启顶部状态栏图标、false 白色 true 黑色
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色
@SwipeBack(true) //开启侧滑返回上一页
public class StartAty extends BaseAty {

    private static final long DELAY_TIME = 3000L;

    @Override
    public void initViews() {
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jump(MainActivity.class);
                finish();
            }
        }, DELAY_TIME);
    }

    @Override
    public void setEvents() {

    }
}
