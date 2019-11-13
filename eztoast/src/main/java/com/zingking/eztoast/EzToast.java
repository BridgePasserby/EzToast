package com.zingking.eztoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Copyright (c) 2019, Z.kai All rights reserved.
 *
 * @author Z.kai
 * @date 2019/10/18
 * @description
 */
public class EzToast {
    private Toast lastToast;

    public static Toast createToast(Context context, CharSequence message, int duration) {
        Toast toast = Toast.makeText(context, "", duration);
        View root = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        Drawable drawableFrame;

        boolean shouldTint = false;
        if (shouldTint) {
            drawableFrame = ToastUtils.tint9PatchDrawableFrame(context, Color.parseColor("#7f00ffff"));
        } else {
            drawableFrame = ToastUtils.getDrawable(context, R.drawable.shape_toast_background);
        }
        ToastUtils.tintDrawable(drawableFrame, Color.parseColor("#ff0000"));
        ToastUtils.setBackground(root, drawableFrame);
        ImageView imgIcon = root.findViewById(R.id.img_icon);
        TextView tvMessage = root.findViewById(R.id.tv_message);
        imgIcon.setImageDrawable(ToastUtils.getDrawable(context, R.drawable.icon_warn));
        tvMessage.setText(message);


        toast.setView(root);
        return toast;
    }
}
