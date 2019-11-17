package com.zingking.eztoast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;

/**
 * Copyright (c) 2019, Z.kai All rights reserved.
 *
 * @author Z.kai
 * @date 2019/10/18
 * @description
 */
public class EzToast {
    public static final int TOAST_LONG = Toast.LENGTH_LONG;
    public static final int TOAST_SHORT = Toast.LENGTH_SHORT;
    private static Toast lastToast;
    private static boolean isTintIcon = true; // icon的颜色是否跟随文本颜色，默认白色
    private static boolean isQueue = true; // 是否是队列等待显示
    @DrawableRes
    private static int background = R.drawable.shape_toast_background_transparent; // toast的背景
    @LayoutRes
    private static int layout = R.layout.layout_toast; // 自定义布局的layout文件，文件中必须含有img_icon和tv_message两个id

    public static Toast normal(Context context, CharSequence message) {
        return normal(context, TOAST_SHORT, message);
    }

    public static Toast normal(Context context, int duration, CharSequence message) {
        return normal(context, duration, ToastUtils.getColor(context, R.color.colorInfo), message);
    }

    public static Toast normal(Context context, int duration, @ColorInt int bgColor, CharSequence message) {
        return createToast(context, R.drawable.icon_info, message, duration,
                bgColor, false,
                ToastUtils.getColor(context, R.color.colorDefaultText));
    }

    public static Toast normal(Context context, CharSequence message, @DrawableRes int icon) {
        return normal(context, message, icon, TOAST_SHORT);
    }

    public static Toast normal(Context context, CharSequence message, @DrawableRes int icon, int duration) {
        return normal(context, message, icon, duration, ToastUtils.getColor(context, R.color.colorInfo));
    }

    public static Toast normal(Context context, CharSequence message, @DrawableRes int icon, int duration, @ColorInt int bgColor) {
        return createToast(context, icon, message, duration,
                bgColor, true,
                ToastUtils.getColor(context, R.color.colorDefaultText));
    }

    public static Toast info(Context context, CharSequence message) {
        return info(context, message, TOAST_SHORT, true);
    }

    public static Toast info(Context context, CharSequence message, int duration) {
        return info(context, message, duration, true);
    }

    public static Toast info(Context context, CharSequence message, int duration, boolean withIcon) {
        return createToast(context, R.drawable.icon_info, message, duration,
                ToastUtils.getColor(context, R.color.colorInfo), withIcon,
                ToastUtils.getColor(context, R.color.colorDefaultText));
    }

    public static Toast success(Context context, CharSequence message) {
        return success(context, message, TOAST_SHORT, true);
    }

    public static Toast success(Context context, CharSequence message, int duration) {
        return success(context, message, duration, true);
    }

    public static Toast success(Context context, CharSequence message, int duration, boolean withIcon) {
        return createToast(context, R.drawable.icon_success, message, duration,
                ToastUtils.getColor(context, R.color.colorSuccess), withIcon,
                ToastUtils.getColor(context, R.color.colorDefaultText));
    }

    public static Toast warn(Context context, CharSequence message) {
        return warn(context, message, TOAST_SHORT, true);
    }

    public static Toast warn(Context context, CharSequence message, int duration) {
        return warn(context, message, duration, true);
    }

    public static Toast warn(Context context, CharSequence message, int duration, boolean withIcon) {
        return createToast(context, R.drawable.icon_warn, message, duration,
                ToastUtils.getColor(context, R.color.colorWarn), withIcon,
                ToastUtils.getColor(context, R.color.colorDefaultText));
    }

    public static Toast error(Context context, CharSequence message) {
        return error(context, message, TOAST_SHORT, true);
    }

    public static Toast error(Context context, CharSequence message, int duration) {
        return error(context, message, duration, true);
    }

    public static Toast error(Context context, CharSequence message, int duration, boolean withIcon) {
        return createToast(context, R.drawable.icon_error, message, duration,
                ToastUtils.getColor(context, R.color.colorError), withIcon,
                ToastUtils.getColor(context, R.color.colorDefaultText));
    }

    /**
     * 自定义toast
     *
     * @param context   上下文
     * @param icon      icon的资源文件
     * @param message   显示的消息
     * @param duration  显示的时长 @see{@link #TOAST_LONG} {@link #TOAST_SHORT}
     * @param bgColor   toast的背景色
     * @param withIcon  是否显示icon
     * @param textColor 文本颜色
     * @return
     */
    public static Toast createToast(Context context,
                                    @DrawableRes int icon,
                                    CharSequence message,
                                    int duration,
                                    @ColorInt int bgColor,
                                    boolean withIcon,
                                    @ColorInt int textColor) {
        return createToast(context, icon, message, duration, bgColor, withIcon, textColor, layout, background, isTintIcon, isQueue);
    }

    /**
     * @param context    上下文
     * @param icon       icon的资源文件
     * @param message    显示的消息
     * @param duration   显示的时长 @see{@link #TOAST_LONG} {@link #TOAST_SHORT}
     * @param bgColor    toast的背景色
     * @param withIcon   是否显示icon
     * @param textColor  文本颜色
     * @param layout     自定义布局的layout文件，文件中必须含有img_icon和tv_message两个id
     * @param background toast的背景
     * @param isTintIcon icon的颜色是否跟随文本颜色，默认白色
     * @param isQueue    是否是队列等待显示
     * @return
     */
    public static Toast createToast(Context context,
                                    @DrawableRes int icon,
                                    CharSequence message,
                                    int duration,
                                    @ColorInt int bgColor,
                                    boolean withIcon,
                                    @ColorInt int textColor,
                                    @LayoutRes int layout,
                                    @DrawableRes int background,
                                    boolean isTintIcon,
                                    boolean isQueue) {
        Toast toast = Toast.makeText(context, "", duration);
        View root = LayoutInflater.from(context).inflate(layout, null);
        Drawable drawableBackground = ToastUtils.getDrawable(context, background);
        ToastUtils.tintDrawable(drawableBackground, bgColor);
        ToastUtils.setBackground(root, drawableBackground);

        ImageView imgIcon = root.findViewById(R.id.img_icon);
        if (withIcon) {
            Drawable iconDrawable = ToastUtils.getDrawable(context, icon);
            if (isTintIcon) {
                ToastUtils.tintDrawable(iconDrawable, textColor);
            }
            imgIcon.setImageDrawable(iconDrawable);
            imgIcon.setVisibility(View.VISIBLE);
        } else {
            imgIcon.setVisibility(View.GONE);
        }

        TextView tvMessage = root.findViewById(R.id.tv_message);
        tvMessage.setText(message);

        toast.setView(root);
        if (!isQueue && lastToast != null) {
            lastToast.cancel();
        }
        lastToast = toast;
        return toast;
    }
}
