package com.longshihan.tool.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * @author Administrator
 * @time 2016/9/30 15:31
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class UIHandler extends Handler {

    private IHandler mHandler;//设置消息的回调

    public UIHandler(Callback callback, IHandler handler) {
        super(callback);
        mHandler = handler;
    }

    public UIHandler(Looper looper, IHandler handler) {
        super(looper);
        mHandler = handler;
    }

    public UIHandler(Looper looper, Callback callback, IHandler handler) {
        super(looper, callback);
        mHandler = handler;
    }

    public UIHandler(IHandler handler) {
        mHandler = handler;
    }

    public UIHandler(Looper mainLooper) {
        super(mainLooper);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (mHandler != null) {
            mHandler.handleMessage(msg);
        }
    }

    public void setHandler(IHandler handler) {
        this.mHandler = handler;
    }

    public interface IHandler {
        public void handleMessage(Message msg);
    }

}
