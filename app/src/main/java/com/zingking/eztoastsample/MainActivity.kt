package com.zingking.eztoastsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zingking.eztoast.EzToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_hello.setOnClickListener {
            EzToast.createToast(this, "测试", 1000).show()
        }
    }
}
