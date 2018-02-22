package text.bwei.com.wuzijingdouyin;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import text.bwei.com.wuzijingdouyin.home.recommend.adapter.MySearchAdapter;
import text.bwei.com.wuzijingdouyin.home.recommend.bean.BannerBeanlist;
import text.bwei.com.wuzijingdouyin.home.recommend.bean.RecommendBean;
import text.bwei.com.wuzijingdouyin.home.recommend.presenter.HomePresenter;
import text.bwei.com.wuzijingdouyin.home.recommend.view.IHomeView;

public class MainActivity extends AppCompatActivity implements IHomeView, SwipeRefreshLayout.OnRefreshListener {
    private HomePresenter homePresenter;
    private int count = 5;
    private int cursor = 1;
    private List<RecommendBean.CategoryListBean> reco_list = new ArrayList<>();
    private List<BannerBeanlist.BannerBean> banner_list = new ArrayList<>();
    private XRecyclerView xlv;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MySearchAdapter mySearchAdapter;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xlv = (XRecyclerView) findViewById(R.id.search_xlv);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.search_sr1);

        image = (ImageView) findViewById(R.id.image);

        swipeRefreshLayout.setOnRefreshListener(this);
        //实现p层关联
        homePresenter = new HomePresenter(this);
        homePresenter.getBanner();
        homePresenter.getHomeRecommend(cursor, count);
        //设置可上拉
        xlv.setPullRefreshEnabled(false);
        xlv.setLoadingMoreEnabled(true);


    }

    @Override
    public void onHomeSuccess(RecommendBean recommendBean) {
        List<RecommendBean.CategoryListBean> category_list = recommendBean.getCategory_list();
        reco_list.addAll(category_list);
        xlv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        mySearchAdapter = new MySearchAdapter(MainActivity.this, reco_list, banner_list);
        xlv.setAdapter(mySearchAdapter);
    }

    @Override
    public void onHomeFailed(String 数据错误) {

    }

    @Override
    public void onBannerSuccess(BannerBeanlist bannerBean) {
        List<BannerBeanlist.BannerBean> banner = bannerBean.getBanner();
        banner_list.addAll(banner);
    }

    @Override
    public void onBannerFailed(String 数据错误) {

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                reco_list.clear();
                cursor = cursor + 1;
                count = count + 5;
                homePresenter.getHomeRecommend(cursor, count);
                mySearchAdapter.notifyDataSetChanged();
            }
        }, 1000);
    }
}
