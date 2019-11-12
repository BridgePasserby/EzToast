package com.zingking.eztoast;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

/**
 * Copyright (c) 2019, Z.kai All rights reserved.
 *
 * @author Z.kai
 * @date 2019/11/12
 * @description
 */
public class ToastUtils {
    private ToastUtils() {
    }

    static Drawable tintDrawable(@NonNull Drawable drawable, @ColorInt int tintColor) {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    static Drawable tint9PatchDrawableFrame(@NonNull Context context, @ColorInt int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        return tintDrawable(toastDrawable, tintColor);
    }

    static void setBackground(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        return AppCompatResources.getDrawable(context, id);
    }

    static int getColor(@NonNull Context context, @ColorRes int color){
        return ContextCompat.getColor(context, color);
    }
}
