package me.itangqi.buildingblocks.ui.activity.Setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;
import me.itangqi.buildingblocks.R;
import me.itangqi.buildingblocks.adapter.OwnMessAdapter;

/**
 * Created by rain on 2016/11/2.
 */
public class OwnMessActivity extends AppCompatActivity implements SwipeBackActivityBase {
    @Bind(R.id.ownmess_list)
    RecyclerView cardList;
    @Bind(R.id.own_tool)
    Toolbar toolbar;
    private OwnMessAdapter messAdapter;
    private SwipeBackActivityHelper mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownmess);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("我的消息");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        messAdapter = new OwnMessAdapter(this);
        cardList.setLayoutManager(new LinearLayoutManager(this));
        cardList.setHasFixedSize(true);
        cardList.setAdapter(messAdapter);

        mSwipeBackLayout = new SwipeBackActivityHelper(this);
        mSwipeBackLayout.onActivityCreate();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeBackLayout.onPostCreate();
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
