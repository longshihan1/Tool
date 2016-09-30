package com.longshihan.tool.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.longshihan.tool.utils.AppManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 * @time 2016/9/30 14:08
 * @des 基础的BaseActivity，实现注解框架
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private Context context;
    private String TAG = this.getLocalClassName();
    protected static UIHandler handler = new UIHandler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBase();
        setContentView(getContentViewId());
        context = this;
        unbinder = ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        AppManager.getAppManager().addActivity(this);
        initAllMembersView(savedInstanceState);
        setHandler();
        initView();
        initData();
    }

    protected abstract void setBase();

    protected abstract void initData();

    protected abstract void initView();

    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    private void setHandler() {
        handler.setHandler(new UIHandler.IHandler() {
            public void handleMessage(Message msg) {
                handler(msg);//有消息就提交给子类实现的方法
            }
        });
    }

    //让子类处理消息
    protected abstract void handler(Message msg);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
