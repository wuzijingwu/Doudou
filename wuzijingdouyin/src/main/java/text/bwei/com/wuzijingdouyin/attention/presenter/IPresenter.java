package text.bwei.com.wuzijingdouyin.attention.presenter;


public abstract class IPresenter <IView> {
    protected IView view;

    public IPresenter(IView view){
        this.view = view;
        init();
    }

    protected abstract void init();

}
