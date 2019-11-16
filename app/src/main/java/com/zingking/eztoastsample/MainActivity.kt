package com.zingking.eztoastsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zingking.eztoast.EzToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
