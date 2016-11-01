package me.itangqi.buildingblocks.ui.activity.OtherActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.itangqi.buildingblocks.R;

public class Playlist_Activity extends  ListActivity {

    int kk=0;
    int pos;
    ViewHolder holder;
    int[] zhuangtai={0,1,2,3};
    ListView lvplay;
    String[] pname = {"王志豪", "张三", "孙仲谋", "吴承恩", "唐三藏"};
    String[] pftime = {"9月22日 13:25", "9月22日 23:25", "9月23日 09:23", "9月23日 13:40", "9月24日 11:05"};
    String[] playname = {"习近平主席西农报告会", "社团换届大会", "新生才艺大赛", "名家讲座中心之我心中的九一八", "葡萄酒晚会加交谊舞"};
    String[] playtime = {"9月25日晚7点-9点", "9月26日晚7点-9点", "9月27日晚7点-9点", "9月27日晚7点-9点", "9月28日晚7点-9点"};
    String[] pla = {"北秀大厅", "北秀206", "北秀大厅", "北秀南报告厅", "北秀大厅"};
    List<Map<String, Object>> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        lvplay=(ListView)findViewById(android.R.id.list);
        listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < pname.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("pname", pname[i]);
            listItem.put("pftime", pftime[i]);
            listItem.put("playname", playname[i]);
            listItem.put("playtime", playtime[i]);
            listItem.put("pla", pla[i]);
            listItems.add(listItem);
        }
        MyAdapter adapter = new MyAdapter(this);
        lvplay.setAdapter(adapter);
        lvplay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos=position;
            }
        });
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.play,
//                new String[]{"pname", "pftime", "playname", "playtime", "pla"},
//                new int[]{R.id.pname, R.id.pftime, R.id.playname, R.id.playtime, R.id.pla});
//        lvplay.setAdapter(simpleAdapter);
    }
    public final class ViewHolder{
        public TextView pname;
        public TextView pftime;
        public TextView playname;
        public TextView playtime;
        public TextView pla;
        public ImageButton zan;
        public ImageButton dzan;
        public ImageButton wen;
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        public int getCount() {
            // TODO Auto-generated method stub
            return listItems.size();
        }
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        //获取ListView每一行
        public View getView(int position, View convertView, ViewGroup parent) {
             holder = null;
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.play, null);
                holder.pname = (TextView)convertView.findViewById(R.id.pname);
                holder.pftime = (TextView)convertView.findViewById(R.id.pftime);
                holder.playname = (TextView)convertView.findViewById(R.id.playname);
                holder.playtime = (TextView) convertView.findViewById(R.id.playtime);
                holder.pla = (TextView) convertView.findViewById(R.id.pla);
                holder.zan=(ImageButton)convertView.findViewById(R.id.zan);
                holder.dzan=(ImageButton)convertView.findViewById(R.id.dzan);
                holder.wen=(ImageButton)convertView.findViewById(R.id.wen);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.pname.setText((String) listItems.get(position).get("pname"));
            holder.pftime.setText((String)listItems.get(position).get("pftime"));
            holder.playname.setText((String)listItems.get(position).get("playname"));
            holder.playtime.setText((String)listItems.get(position).get("playtime"));
            holder.pla.setText((String) listItems.get(position).get("pla"));
            //holder.rating.setRating((Float)mData.get(position).get("rating"));
            holder.zan.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if(kk!=1)
                    {
                        kk=1;
                    }
                    else
                    {
                        kk=0;
                    }
                    tubiao(kk);
                }});
            holder.dzan.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if(kk!=2)
                    {
                        kk=2;
                    }
                    else
                    {
                        kk=0;
                    }
                    tubiao(kk);
                }});
            holder.wen.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if(kk!=3)
                    {
                        kk=3;
                    }
                    else
                    {
                        kk=0;
                    }
                    tubiao(kk);
                }});




            return convertView;
        }
        public void tubiao(int kk)
        {
            if (kk == 0) {
                holder.zan.setBackgroundResource(R.drawable.zan);
                holder.dzan.setBackgroundResource(R.drawable.dzan);
                holder.wen.setBackgroundResource(R.drawable.wen);
            } else if (kk == 1) {
                holder.zan.setBackgroundResource(R.drawable.zan1);
                holder.dzan.setBackgroundResource(R.drawable.dzan);
                holder.wen.setBackgroundResource(R.drawable.wen);
            } else if (kk == 2) {
                holder.zan.setBackgroundResource(R.drawable.zan);
                holder.dzan.setBackgroundResource(R.drawable.dzan1);
                holder.wen.setBackgroundResource(R.drawable.wen);
            } else if (kk == 3) {
                holder.zan.setBackgroundResource(R.drawable.zan);
                holder.dzan.setBackgroundResource(R.drawable.dzan);
                holder.wen.setBackgroundResource(R.drawable.wen1);
            }
        }
    }
}
