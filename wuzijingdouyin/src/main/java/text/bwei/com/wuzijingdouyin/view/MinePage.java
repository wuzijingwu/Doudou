package text.bwei.com.wuzijingdouyin.view;

/**
 * author:Created by ZhangPengFei.
 * Email: 1271396448@qq.com
 * data: 2018/1/25
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import text.bwei.com.wuzijingdouyin.R;

//import text.bwei.com.toutiao.R;

//import com.example.asus.douyinapp.R;


/**
 * 个人主页Fragment
 */
public class MinePage extends Fragment {


    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
