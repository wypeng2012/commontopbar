package party.loveit.commontopbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by wangyunpeng on 2016/11/1.
 * common top bar
 */
public class CommonTopBar extends FrameLayout {

    private Context mContext;
    private TextView mLeftTextView;//left view
    private CommonTopBarClick mCommonTopBarClick;
    private TextView mMidTextView;//middle view
    private TextView mRightTextView;//right view


    public CommonTopBar(Context context) {
        this(context, null);

    }

    public CommonTopBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initView();
    }

    public CommonTopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    /**
     * init view
     */
    @SuppressLint("InflateParams")
    private void initView() {
        View view = ((Activity)mContext).getLayoutInflater().inflate(R.layout.common_bar_layout, null);

        mLeftTextView = (TextView) view.findViewById(R.id.common_top_bar_text_left);
        mLeftTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mCommonTopBarClick != null)
                    mCommonTopBarClick.onClickLeft();
            }
        });
        mMidTextView = (TextView) view.findViewById(R.id.common_top_bar_text_mid);
        mRightTextView = (TextView) view.findViewById(R.id.common_top_bar_text_right);

        mRightTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mCommonTopBarClick != null)
                    mCommonTopBarClick.onClickRight();
            }
        });
        addView(view);
        FrameLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        view.setLayoutParams(layoutParams);
    }

    /**
     * if show right view,default gone
     * @param isShow
     */
    public void isShowRightView(boolean isShow){
        if(mRightTextView != null)
            mRightTextView.setVisibility(isShow? View.VISIBLE: View.GONE);
    }

    /**
     * 设if show left view,default gone
     * @param isShow
     */
    public void isShowLeftView(boolean isShow){
        if(mLeftTextView != null)
            mLeftTextView.setVisibility(isShow? View.VISIBLE: View.GONE);
    }


    /*public CommonTopBarClick getCommonTopBarClick() {
        return mCommonTopBarClick;
    }*/

    /**
     *  set click event listener
     * @param mCommonTopBarClick
     */
    public void setCommonTopBarClick(CommonTopBarClick mCommonTopBarClick) {
        this.mCommonTopBarClick = mCommonTopBarClick;
    }

    /**
     * set right view margin right,the param is dp
     * @param marginRight
     */
    public void addRightMargin(float marginRight){
        if(mRightTextView != null){
            RelativeLayout.LayoutParams mLayoutParams =	(android.widget.RelativeLayout.LayoutParams) mRightTextView.getLayoutParams();
            mLayoutParams.rightMargin = DensityUtils.dp2px(mContext, marginRight);
            mRightTextView.setLayoutParams(mLayoutParams);
            mRightTextView.requestLayout();
        }
    }

    /**
     * set left view margin left,the param is dp
     * @param marginLeft
     */
    public void addLeftMargin(float marginLeft){
        if(mLeftTextView != null){
            RelativeLayout.LayoutParams mLayoutParams =	(android.widget.RelativeLayout.LayoutParams) mLeftTextView.getLayoutParams();
            mLayoutParams.leftMargin = DensityUtils.dp2px(mContext, marginLeft);
            mLeftTextView.setLayoutParams(mLayoutParams);
            mLeftTextView.requestLayout();
        }
    }

    /**
     * set
     * @param lenth
     */
    public void setMidTextMaxLenth(int lenth){
        if(mMidTextView != null)
            mMidTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(lenth)});
    }

    /**
     * set mid view text
     * @param charSequence
     */
    public void setMidText(CharSequence charSequence){
        if(mMidTextView != null)
             mMidTextView.setText(charSequence);
    }
    /**
     * set mid view text
     * @param textRes
     */
    public void setMidText(@StringRes int textRes){
        if(mMidTextView != null)
            mMidTextView.setText(textRes);
    }

    /**
     * set mid text size
     * @param size
     */
    public void setMidTextSize(float size){
        if(mMidTextView != null)
            mMidTextView.setTextSize(size);
    }

    /**
     * set mid text color
     * @param colorStateList
     */
    public void setMidTextColor(@NonNull ColorStateList colorStateList){
        if(mMidTextView != null)
            mMidTextView.setTextColor(colorStateList);
    }
    /**
     * set mid text color
     * @param color
     */
    public void setMidTextColor(@ColorInt int color){
        if(mMidTextView != null)
            mMidTextView.setTextColor(color);
    }

    /**
     * set left image
     * @param drawable
     */
    public void setLeftImage(@NonNull Drawable drawable){
        if (mLeftTextView != null) {
            if(Build.VERSION.SDK_INT < 16) {
                mLeftTextView.setBackgroundDrawable(drawable);
            } else {
                mLeftTextView.setBackground(drawable);
            }
        }
    }
    /**
     * set left image
     * @param drawableRes
     */
    public void setLeftImage(@DrawableRes int drawableRes){
        if (mLeftTextView != null)
            mLeftTextView.setBackgroundResource(drawableRes);
    }

    /**
     * set left view text
     * @param charSequence
     */
    public void setLeftText(CharSequence charSequence){
        if(mLeftTextView != null)
            mLeftTextView.setText(charSequence);
    }
    /**
     * set left view text
     * @param textRes
     */
    public void setLeftText(@StringRes int textRes){
        if(mLeftTextView != null)
            mLeftTextView.setText(textRes);
    }

    /**
     * set left text size
     * @param size
     */
    public void setLeftTextSize(float size){
        if(mLeftTextView != null)
            mLeftTextView.setTextSize(size);
    }

    /**
     * set left text color
     * @param colorStateList
     */
    public void setLeftTextColor(@NonNull ColorStateList colorStateList){
        if(mLeftTextView != null)
            mLeftTextView.setTextColor(colorStateList);
    }
    /**
     * set left text color
     * @param color
     */
    public void setLeftTextColor(@ColorInt int color){
        if(mLeftTextView != null)
            mLeftTextView.setTextColor(color);
    }


    /**
     * set right image
     * @param drawable
     */
    public void setRightImage(@NonNull Drawable drawable){
        if (mRightTextView != null) {
            if(Build.VERSION.SDK_INT < 16) {
                mRightTextView.setBackgroundDrawable(drawable);
            } else {
                mRightTextView.setBackground(drawable);
            }
        }
    }
    /**
     * set right image
     * @param drawableRes
     */
    public void setRightImage(@DrawableRes int drawableRes){
        if (mRightTextView != null)
            mRightTextView.setBackgroundResource(drawableRes);
    }

    /**
     * set right view text
     * @param charSequence
     */
    public void setRightText(CharSequence charSequence){
        if(mRightTextView != null)
            mRightTextView.setText(charSequence);
    }
    /**
     * set right view text
     * @param textRes
     */
    public void setRightText(@StringRes int textRes){
        if(mRightTextView != null)
            mRightTextView.setText(textRes);
    }

    /**
     * set right text size
     * @param size
     */
    public void setRightTextSize(float size){
        if(mRightTextView != null)
            mRightTextView.setTextSize(size);
    }

    /**
     * set right text color
     * @param colorStateList
     */
    public void setRightTextColor(@NonNull ColorStateList colorStateList){
        if(mRightTextView != null)
            mRightTextView.setTextColor(colorStateList);
    }
    /**
     * set right text color
     * @param color
     */
    public void setRightTextColor(@ColorInt int color){
        if(mRightTextView != null)
            mRightTextView.setTextColor(color);
    }
}

