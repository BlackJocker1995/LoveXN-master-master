package me.itangqi.buildingblocks.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import me.itangqi.buildingblocks.R;
import me.itangqi.buildingblocks.network.clas.Luntaninfo;
import me.itangqi.buildingblocks.ui.activity.FragmentActivity.TiebaActivity;

/**
 * Created by rain on 2016/11/2.
 */
public class OwnMessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    ArrayList<Luntaninfo> info = new ArrayList<>();
    public OwnMessAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    public void network(String url) {
        Type type = new TypeToken<ArrayList<Luntaninfo>>() {}.getType();
        ArrayList<Luntaninfo> jsonObjects = new Gson().fromJson(url, type);

        for (Luntaninfo infoitem : jsonObjects)
        {
            info.add(0,infoitem);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ContentViewHolder) holder).title.setText(info.get(position).getTopic_title());//title[position]
        ((ContentViewHolder)holder).news.setText(info.get(position).getTopic_content());
        ((ContentViewHolder)holder).id = info.get(position).getTopic_id();
        ((ContentViewHolder) holder).pic_exist=info.get(position).getTopic_picture_url();
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        // @Bind(R.id.coordinatorLayout) CoordinatorLayout mContainer;
        private TextView title;
        private TextView news;
        private int id;
        public String pic_exist;

        public ContentViewHolder(final View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.tv_item_title);
            news = (TextView) itemView.findViewById(R.id.tv_item_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent userActivity = new Intent(itemView.getContext(), TiebaActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    userActivity.putExtra("content", news.getText());
                    userActivity.putExtra("title",title.getText());
                    userActivity.putExtra("id",id);
                    userActivity.putExtra("pic_exist",pic_exist);
                    itemView.getContext().startActivity(userActivity);
                }
            });
        }
    }

}
