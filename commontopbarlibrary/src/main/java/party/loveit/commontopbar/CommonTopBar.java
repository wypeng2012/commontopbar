package party.loveit.commontopbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

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

    private ImageView mRightImg;
    private ImageView mLeftImg;


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
        View view = ((Activity) mContext).getLayoutInflater().inflate(R.layout.common_bar_layout, null);

        mLeftTextView = view.findViewById(R.id.common_top_bar_text_left);
        mLeftTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mCommonTopBarClick != null)
                    mCommonTopBarClick.onClickLeft();
            }
        });
        mMidTextView = view.findViewById(R.id.common_top_bar_text_mid);
        mRightTextView = view.findViewById(R.id.common_top_bar_text_right);
        mRightImg = view.findViewById(R.id.common_top_bar_img_right);

        mLeftImg = view.findViewById(R.id.common_top_bar_img_left);

        mLeftImg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mCommonTopBarClick != null)
                    mCommonTopBarClick.onClickLeft();
            }
        });
        mRightImg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mCommonTopBarClick != null)
                    mCommonTopBarClick.onClickRight();
            }
        });
        mRightTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mCommonTopBarClick != null)
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
     *
     * @param isShow
     */
    public void isShowRightView(boolean isShow) {
        if (mRightTextView != null)
            mRightTextView.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void isShowRightImgView(boolean isShow) {
        if (mRightImg != null)
            mRightImg.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    /**
     * 设if show left view,default gone
     *
     * @param isShow
     */
    public void isShowLeftView(boolean isShow) {
        if (mLeftTextView != null)
            mLeftTextView.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void setLeftTextBold(boolean isBold) {
        if (mLeftTextView != null)
            mLeftTextView.getPaint().setFakeBoldText(isBold);

    }

    public void isShowLeftImgView(boolean isShow) {
        if (mLeftImg != null)
            mLeftImg.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }



    /*public CommonTopBarClick getCommonTopBarClick() {
        return mCommonTopBarClick;
    }*/

    /**
     * set click event listener
     *
     * @param mCommonTopBarClick
     */
    public void setCommonTopBarClick(CommonTopBarClick mCommonTopBarClick) {
        this.mCommonTopBarClick = mCommonTopBarClick;
    }

    /**
     * set right view margin right,the param is dp
     *
     * @param marginRight
     */
    public void addRightMargin(float marginRight) {
        if (mRightTextView != null) {
            RelativeLayout.LayoutParams mLayoutParams = (android.widget.RelativeLayout.LayoutParams) mRightTextView.getLayoutParams();
            mLayoutParams.rightMargin = DensityUtils.dp2px(mContext, marginRight);
            mRightTextView.setLayoutParams(mLayoutParams);
            mRightTextView.requestLayout();
        }
    }

    public void addRightImgMargin(float marginRight) {
        if (mRightImg != null) {
            RelativeLayout.LayoutParams mLayoutParams = (android.widget.RelativeLayout.LayoutParams) mRightImg.getLayoutParams();
            mLayoutParams.rightMargin = DensityUtils.dp2px(mContext, marginRight);
            mRightImg.setLayoutParams(mLayoutParams);
            mRightImg.requestLayout();
        }
    }

    /**
     * set left view margin left,the param is dp
     *
     * @param marginLeft
     */
    public void addLeftMargin(float marginLeft) {
        if (mLeftTextView != null) {
            RelativeLayout.LayoutParams mLayoutParams = (android.widget.RelativeLayout.LayoutParams) mLeftTextView.getLayoutParams();
            mLayoutParams.leftMargin = DensityUtils.dp2px(mContext, marginLeft);
            mLeftTextView.setLayoutParams(mLayoutParams);
            mLeftTextView.requestLayout();
        }
    }

    public void addLeftImgMargin(float marginLeft) {
        if (mLeftImg != null) {
            RelativeLayout.LayoutParams mLayoutParams = (android.widget.RelativeLayout.LayoutParams) mLeftImg.getLayoutParams();
            mLayoutParams.leftMargin = DensityUtils.dp2px(mContext, marginLeft);
            mLeftImg.setLayoutParams(mLayoutParams);
            mLeftImg.requestLayout();
        }
    }


    /**
     * set
     *
     * @param lenth
     */
    public void setMidTextMaxLenth(int lenth) {
        if (mMidTextView != null)
            mMidTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(lenth)});
    }

    /**
     * set mid view text
     *
     * @param charSequence
     */
    public void setMidText(CharSequence charSequence) {
        if (mMidTextView != null)
            mMidTextView.setText(charSequence);
    }

    public void setMidTextBold(boolean isBold) {
        if (mMidTextView != null)
            mMidTextView.getPaint().setFakeBoldText(isBold);

    }
    /**
     * set mid view text
     *
     * @param textRes
     */
    public void setMidText(@StringRes int textRes) {
        if (mMidTextView != null)
            mMidTextView.setText(textRes);
    }

    /**
     * set mid text size
     *
     * @param size
     */
    public void setMidTextSize(float size) {
        if (mMidTextView != null)
            mMidTextView.setTextSize(size);
    }

    /**
     * set mid text color
     *
     * @param colorStateList
     */
    public void setMidTextColor(@NonNull ColorStateList colorStateList) {
        if (mMidTextView != null)
            mMidTextView.setTextColor(colorStateList);
    }

    /**
     * set mid text color
     *
     * @param color
     */
    public void setMidTextColor(@ColorInt int color) {
        if (mMidTextView != null)
            mMidTextView.setTextColor(color);
    }

    /**
     * set left image
     *
     * @param drawable
     */
    public void setLeftImage(@NonNull Drawable drawable) {
        if (mLeftImg != null) {
            if (Build.VERSION.SDK_INT < 16) {
                mLeftImg.setBackgroundDrawable(drawable);
            } else {
                mLeftImg.setBackground(drawable);
            }
        }
    }

    /**
     * set left image
     *
     * @param drawableRes
     */
    public void setLeftImage(@DrawableRes int drawableRes) {
        if (mLeftImg != null)
            mLeftImg.setBackgroundResource(drawableRes);
    }

    /**
     * set left view text
     *
     * @param charSequence
     */
    public void setLeftText(CharSequence charSequence) {
        if (mLeftTextView != null)
            mLeftTextView.setText(charSequence);
    }

    /**
     * set left view text
     *
     * @param textRes
     */
    public void setLeftText(@StringRes int textRes) {
        if (mLeftTextView != null)
            mLeftTextView.setText(textRes);
    }

    /**
     * set left text size
     *
     * @param size
     */
    public void setLeftTextSize(float size) {
        if (mLeftTextView != null)
            mLeftTextView.setTextSize(size);
    }

    /**
     * set left text color
     *
     * @param colorStateList
     */
    public void setLeftTextColor(@NonNull ColorStateList colorStateList) {
        if (mLeftTextView != null)
            mLeftTextView.setTextColor(colorStateList);
    }

    /**
     * set left text color
     *
     * @param color
     */
    public void setLeftTextColor(@ColorInt int color) {
        if (mLeftTextView != null)
            mLeftTextView.setTextColor(color);
    }


    /**
     * set right image
     *
     * @param drawable
     */
    public void setRightImage(@NonNull Drawable drawable) {
        if (mRightImg != null) {
            if (Build.VERSION.SDK_INT < 16) {
                mRightImg.setBackgroundDrawable(drawable);
            } else {
                mRightImg.setBackground(drawable);
            }
        }
    }

    /**
     * set right image
     *
     * @param drawableRes
     */
    public void setRightImage(@DrawableRes int drawableRes) {
        if (mRightImg != null)
            mRightImg.setBackgroundResource(drawableRes);
    }

    /**
     * set right view text
     *
     * @param charSequence
     */
    public void setRightText(CharSequence charSequence) {
        if (mRightTextView != null)
            mRightTextView.setText(charSequence);
    }

    public void setRightTextBold(boolean isBold) {
        if (mRightTextView != null)
            mRightTextView.getPaint().setFakeBoldText(isBold);

    }
    /**
     * set right view text
     *
     * @param textRes
     */
    public void setRightText(@StringRes int textRes) {
        if (mRightTextView != null)
            mRightTextView.setText(textRes);
    }

    /**
     * set right text size
     *
     * @param size
     */
    public void setRightTextSize(float size) {
        if (mRightTextView != null)
            mRightTextView.setTextSize(size);
    }

    /**
     * set right text color
     *
     * @param colorStateList
     */
    public void setRightTextColor(@NonNull ColorStateList colorStateList) {
        if (mRightTextView != null)
            mRightTextView.setTextColor(colorStateList);
    }

    /**
     * set right text color
     *
     * @param color
     */
    public void setRightTextColor(@ColorInt int color) {
        if (mRightTextView != null)
            mRightTextView.setTextColor(color);
    }

    /**
     * set DrawPadding
     *
     * @param size dp
     */
    public void setLefTextViewDrawPadding(int size) {
        if (mLeftTextView != null)
            mLeftTextView.setCompoundDrawablePadding(DensityUtils.dp2px(mContext, size));
    }

    /**
     * set left drawImg
     *
     * @param drawableRes
     */
    public void setLeftTextViewDrawLeft(@DrawableRes int drawableRes) {
        if (mLeftTextView != null)
            mLeftTextView.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);
    }

    /**
     * set left drawImg
     *
     * @param drawableRes
     */
    public void setLeftTextViewDrawLeft(@NonNull Drawable drawableRes) {
        if (mLeftTextView != null)
            mLeftTextView.setCompoundDrawablesWithIntrinsicBounds(drawableRes, null, null, null);
    }

}

