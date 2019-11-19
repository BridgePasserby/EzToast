package com.zingking.eztoastsample

import android.content.Context
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zingking.eztoast.EzToast
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EzToast.Config.getInstance()
            .setTintIcon(false)
            .setQueue(false)
            .setBackground(R.drawable.shape_toast_background)
            .confirm()
        var windowManager: WindowManager = /*App.getContext().*/getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val textView = TextView(this)
        textView.setText("1111111")
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.flags = (WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        windowManager.addView(textView, layoutParams)

        btn_info.setOnClickListener {
            EzToast.info(this, "测试", 5000).show()
        }
        btn_warn.setOnClickListener {
            EzToast.warn(this, "测试", 5000).show()
        }
        btn_success.setOnClickListener {
            EzToast.success(this, "测试", 5000).show()
        }
        btn_error.setOnClickListener {
            EzToast.error(this, "测试", 5000).show()
        }
    }
}
