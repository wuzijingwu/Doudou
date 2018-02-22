package text.bwei.com.wuzijingdouyin.attention.presenter;


//import com.example.asus.douyinapp.attention.model.AttentionModel;
//import com.example.asus.douyinapp.attention.view.IView;

//import text.bwei.com.toutiao.attention.model.AttentionModel;
//import text.bwei.com.toutiao.attention.view.IView;

import text.bwei.com.wuzijingdouyin.attention.model.AttentionModel;
import text.bwei.com.wuzijingdouyin.attention.view.IView;

public class AttentionPresenter extends IPresenter<IView>{
    private AttentionModel model;
    public AttentionPresenter(IView iView) {
        super(iView);
    }

    @Override
    protected void init() {
        model = new AttentionModel();
    }
}
