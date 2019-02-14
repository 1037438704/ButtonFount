package zdl.tianxunda.com.buttonfount;

import android.app.Application;

import com.kongzue.baseokhttp.HttpRequest;

/**
 * Created by dell-pc on 2019/2/14.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //开启请求日志
        HttpRequest.DEBUGMODE = true;
    }
}
