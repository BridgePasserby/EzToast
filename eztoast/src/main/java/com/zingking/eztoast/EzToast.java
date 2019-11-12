package com.zingking.eztoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
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

        boolean shouldTint = true;
        if (shouldTint){
            drawableFrame = ToastUtils.tint9PatchDrawableFrame(context, Color.parseColor("#7f00ffff"));
        }
        else{
            drawableFrame = ToastUtils.getDrawable(context, R.drawable.toast_frame);
        }
        ToastUtils.setBackground(root, drawableFrame);
        TextView tvMessage = root.findViewById(R.id.tv_message);
        tvMessage.setText(message);


        toast.setView(root);
        return toast;
    }
}
