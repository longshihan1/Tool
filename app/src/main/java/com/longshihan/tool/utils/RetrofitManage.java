package com.longshihan.tool.utils;

/**
 * @author Administrator
 * @time 2016/9/30 16:54
 * @des Retrofit的请求管理类RetrofitManage
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class RetrofitManage {
    public static RetrofitManage getInstance() {
        return RetrofitManager.retrofitManage;
    }

    private static class RetrofitManager {
        private static final RetrofitManage retrofitManage = new RetrofitManage();
    }
}
