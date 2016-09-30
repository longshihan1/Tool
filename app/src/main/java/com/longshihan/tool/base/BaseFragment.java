package com.longshihan.tool.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 * @time 2016/9/30 15:15
 * @des 基础的BaseFragment，实现注解框架
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public abstract class BaseFragment extends Fragment {
    protected View mRootView;
    private Unbinder mUnbinder;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        EventBus.getDefault().register(this);
        initAllMembersView(savedInstanceState);
        initView();
        initData();
        return mRootView;
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    public abstract int getContentViewId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
