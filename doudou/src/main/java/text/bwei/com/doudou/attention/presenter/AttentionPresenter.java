package text.bwei.com.doudou.attention.presenter;


import text.bwei.com.doudou.attention.model.AttentionModel;
import text.bwei.com.doudou.attention.view.IView;

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
