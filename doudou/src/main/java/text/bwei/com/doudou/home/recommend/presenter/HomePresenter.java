package text.bwei.com.doudou.home.recommend.presenter;


import text.bwei.com.doudou.home.recommend.bean.BannerBeanlist;
import text.bwei.com.doudou.home.recommend.bean.RecommendBean;
import text.bwei.com.doudou.home.recommend.model.HomeModel;
import text.bwei.com.doudou.home.recommend.view.IHomeView;

public class HomePresenter implements IHomePre {
    private IHomeView iHomeView;
    private HomeModel homeModel;

    public HomePresenter(IHomeView iHomeView) {
        this.iHomeView = iHomeView;
        homeModel = new HomeModel();
    }

    //获取视频推荐
    public void getHomeRecommend(int cursor, int count) {
        homeModel.getHomeRecommend(cursor, count, this);
    }

    //轮播图
    public void getBanner() {
        homeModel.getHomeBanner(this);
    }

    @Override
    public void onHomeSuccess(RecommendBean recommendBean) {
        iHomeView.onHomeSuccess(recommendBean);
    }

    @Override
    public void onHomeFailed(String 数据错误) {
        iHomeView.onHomeFailed(数据错误);
    }

    @Override
    public void onBannerSuccess(BannerBeanlist bannerBean) {
        iHomeView.onBannerSuccess(bannerBean);
    }

    @Override
    public void onBannerFailed(String 数据错误) {
        iHomeView.onBannerFailed(数据错误);
    }
}
