package party.loveit.commontopbar.demo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import party.loveit.commontopbar.CommonTopBar;
import party.loveit.commontopbar.CommonTopBarClick;
import qiu.niorgai.StatusBarCompat;

public class MainActivity extends AppCompatActivity implements CommonTopBarClick {

    private CommonTopBar mCommonTopBar;
    private boolean isLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarCompat.setStatusBarColor(this,this.getResources().getColor(R.color.top_bar_bg_color));
        mCommonTopBar = (CommonTopBar) findViewById(R.id.common);
        mCommonTopBar.setCommonTopBarClick(this);
        mCommonTopBar.setMidTextMaxLenth("TopBar".length());
        mCommonTopBar.setMidText("TopBar");
        mCommonTopBar.isShowLeftImgView(true);
        mCommonTopBar.isShowRightView(true);
        //mCommonTopBar.setLeftTextSize(10);
       mCommonTopBar.setLeftImage(R.mipmap.mobile_game_icon_activity_rank);
        mCommonTopBar.setRightText("Log out");
        //mCommonTopBar.setRightImage(R.mipmap.btn_addwallet_top_black);
        mCommonTopBar.addLeftImgMargin(10);
        mCommonTopBar.addRightMargin(10);

    }

    @Override
    public void onClickLeft() {
     startActivity(new Intent(this,MeActivity.class));
    }

    @Override
    public void onClickRight() {
        isLogin = !isLogin;
        if (isLogin) {
            mCommonTopBar.isShowLeftView(true);
            mCommonTopBar.setRightText("Log out");
        } else {
            mCommonTopBar.isShowLeftView(false);
            mCommonTopBar.setRightText("Log in");
        }
    }
}
