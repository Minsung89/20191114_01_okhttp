package com.tjoeum.a20191114_01_okhttp

import android.os.Bundle
import com.tjoeum.a20191114_01_okhttp.utils.ServerUtil

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setValues()
        setupEvents()

        ServerUtil.postRequestLogin(mContext,"cho881020","qlalfqjsgh!", null)

    }

    override fun setupEvents() {
    }

    override fun setValues() {
    }
}
