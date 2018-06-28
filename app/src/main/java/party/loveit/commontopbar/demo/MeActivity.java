package party.loveit.commontopbar.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import party.loveit.commontopbar.CommonTopBar;
import party.loveit.commontopbar.CommonTopBarClick;
import qiu.niorgai.StatusBarCompat;

public class MeActivity extends AppCompatActivity implements CommonTopBarClick {

    private CommonTopBar mCommonTopBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        StatusBarCompat.setStatusBarColor(this,this.getResources().getColor(R.color.top_bar_bg_color));
        mCommonTopBar = (CommonTopBar) findViewById(R.id.me);
        mCommonTopBar.setCommonTopBarClick(this);
        mCommonTopBar.setMidTextMaxLenth("MeCenter".length());
        mCommonTopBar.setMidText("MeCenter");
        mCommonTopBar.isShowLeftView(true);
        //mCommonTopBar.setLeftImage(R.mipmap.friend_btn_back_click);
        mCommonTopBar.setLeftText("back");
        mCommonTopBar.setLeftTextViewDrawLeft(R.mipmap.friend_btn_back_click);
        mCommonTopBar.setLefTextViewDrawPadding(15);
        mCommonTopBar.setLeftTextSize(24);

    }

    @Override
    public void onClickLeft() {
         finish();
    }

    @Override
    public void onClickRight() {

    }
}
