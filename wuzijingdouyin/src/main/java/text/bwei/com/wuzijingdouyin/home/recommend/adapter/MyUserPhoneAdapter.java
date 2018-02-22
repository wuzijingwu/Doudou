package text.bwei.com.wuzijingdouyin.home.recommend.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

import text.bwei.com.wuzijingdouyin.R;
import text.bwei.com.wuzijingdouyin.home.recommend.bean.RecommendBean;
import text.bwei.com.wuzijingdouyin.home.recommend.view.Main_startvideo;

//import text.bwei.com.toutiao.R;
//import text.bwei.com.toutiao.home.recommend.bean.RecommendBean;
//import text.bwei.com.toutiao.home.recommend.view.Main_startvideo;

//import com.example.asus.douyinapp.R;
//import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;
//import com.example.asus.douyinapp.home.recommend.view.Main_startvideo;


public class MyUserPhoneAdapter extends RecyclerView.Adapter<MyUserPhoneAdapter.ViewHolder> {
    private Context context;
    private List<RecommendBean.CategoryListBean.AwemeListBean> list;

    public MyUserPhoneAdapter(Context context, List<RecommendBean.CategoryListBean.AwemeListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_user_news_phones, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String s = list.get(position).getVideo().getCover().getUrl_list().get(0);
        Uri parse = Uri.parse(s);
        // holder.sim.setImageURI(parse);
        //也可以控制图片请求的一些特性
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(parse)
                //设置支持jpeg渐进式展示（从模糊到清晰）
                .setProgressiveRenderingEnabled(true)
                .build();
        AbstractDraweeController builder = Fresco.newDraweeControllerBuilder()
                //图片的地址
                .setImageRequest(imageRequest)
                .setUri(parse)
                //设置图片自动播放属性
                .setAutoPlayAnimations(true)
                .build();
        holder.sim.setController(builder);

        holder.sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Main_startvideo.class);
                intent.putExtra("url",list.get(position).getVideo().getDownload_addr().getUrl_list().get(0));
                intent.putExtra("pic",list.get(position).getVideo().getCover().getUrl_list().get(0));
                intent.putExtra("desc",list.get(position).getDesc());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sim;

        public ViewHolder(View itemView) {
            super(itemView);
            sim = itemView.findViewById(R.id.sim);
        }
    }
}
