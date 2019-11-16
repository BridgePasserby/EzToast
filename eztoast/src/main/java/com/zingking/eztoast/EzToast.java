package com.zingking.eztoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;

/**
 * Copyright (c) 2019, Z.kai All rights reserved.
 *
 * @author Z.kai
 * @date 2019/10/18
 * @description
 */
public class EzToast {
    private static Toast lastToast;

    public static Toast info(Context context, CharSequence message, int duration) {
        return createToast(context, R.drawable.icon_info, message, duration, false, Color.parseColor("#757575"));
    }

    public static Toast success(Context context, CharSequence message, int duration) {
        return createToast(context, R.drawable.icon_success, message, duration, false, Color.parseColor("#2e7d32"));
    }

    public static Toast warn(Context context, CharSequence message, int duration) {
        return createToast(context, R.drawable.icon_warn, message, duration, false, Color.parseColor("#FFFF9800"));
    }

    public static Toast error(Context context, CharSequence message, int duration) {
        return createToast(context, R.drawable.icon_error, message, duration, false, Color.parseColor("#c30000"));
    }

    public static Toast createToast(Context context,
                                    @DrawableRes int icon,
                                    CharSequence message,
                                    int duration,
                                    boolean isQueue,
                                    int bgColor) {
        Toast toast = Toast.makeText(context, "", duration);
        View root = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        Drawable drawableFrame = ToastUtils.getDrawable(context, R.drawable.shape_toast_background);
        ToastUtils.tintDrawable(drawableFrame, bgColor);
        ToastUtils.setBackground(root, drawableFrame);

        ImageView imgIcon = root.findViewById(R.id.img_icon);
        TextView tvMessage = root.findViewById(R.id.tv_message);

        imgIcon.setImageDrawable(ToastUtils.getDrawable(context, icon));
        tvMessage.setText(message);

        toast.setView(root);
        if (!isQueue && lastToast != null) {
            lastToast.cancel();
        }
        lastToast = toast;
        return toast;
    }
}
