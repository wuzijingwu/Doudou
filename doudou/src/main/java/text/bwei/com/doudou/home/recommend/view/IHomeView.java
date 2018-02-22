package text.bwei.com.doudou.home.recommend.view;


import text.bwei.com.doudou.home.recommend.bean.BannerBeanlist;
import text.bwei.com.doudou.home.recommend.bean.RecommendBean;

public interface IHomeView {
    void onHomeSuccess(RecommendBean recommendBean);
    void onHomeFailed(String 数据错误);
    //轮播图请求
    void onBannerSuccess(BannerBeanlist bannerBean);
    void onBannerFailed(String 数据错误);
}
