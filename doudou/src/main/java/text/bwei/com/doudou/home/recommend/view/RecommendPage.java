package text.bwei.com.doudou.home.recommend.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import text.bwei.com.doudou.R;
import text.bwei.com.doudou.home.recommend.adapter.MyHomeAdapter;
import text.bwei.com.doudou.home.recommend.bean.BannerBeanlist;
import text.bwei.com.doudou.home.recommend.bean.RecommendBean;
import text.bwei.com.doudou.home.recommend.presenter.HomePresenter;


public class RecommendPage extends Fragment implements IHomeView{

    private View view;
    private HomePresenter homePresenter;
    private int count=15;
    private int cursor=0;
    private List<RecommendBean.CategoryListBean.AwemeListBean> list = new ArrayList<>();
    private VerticalViewPager vvp;
    private MyHomeAdapter myHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_recommend, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vvp = getView().findViewById(R.id.vvp);
        homePresenter = new HomePresenter(this);
        homePresenter.getHomeRecommend(cursor,count);
    }

    @Override
    public void onHomeSuccess(RecommendBean recommendBean) {
        List<RecommendBean.CategoryListBean> category_list = recommendBean.getCategory_list();
        for (int i = 0; i < category_list.size(); i++) {
            List<RecommendBean.CategoryListBean.AwemeListBean> aweme_list = category_list.get(i).getAweme_list();
            list.addAll(aweme_list);
        }
        myHomeAdapter = new MyHomeAdapter(getContext(),list);
        vvp.setAdapter(myHomeAdapter);
        vvp.setOffscreenPageLimit(1);
    }

    @Override
    public void onHomeFailed(String 数据错误) {

    }

    @Override
    public void onBannerSuccess(BannerBeanlist bannerBean) {

    }

    @Override
    public void onBannerFailed(String 数据错误) {

    }
}
