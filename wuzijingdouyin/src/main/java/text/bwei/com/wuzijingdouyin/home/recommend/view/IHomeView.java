package text.bwei.com.wuzijingdouyin.home.recommend.view;


//import com.example.asus.douyinapp.home.recommend.bean.BannerBeanlist;
//import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;

//import text.bwei.com.toutiao.home.recommend.bean.BannerBeanlist;
//import text.bwei.com.toutiao.home.recommend.bean.RecommendBean;

import text.bwei.com.wuzijingdouyin.home.recommend.bean.BannerBeanlist;
import text.bwei.com.wuzijingdouyin.home.recommend.bean.RecommendBean;

public interface IHomeView {
    void onHomeSuccess(RecommendBean recommendBean);
    void onHomeFailed(String 数据错误);
    //轮播图请求
    void onBannerSuccess(BannerBeanlist bannerBean);
    void onBannerFailed(String 数据错误);
}
