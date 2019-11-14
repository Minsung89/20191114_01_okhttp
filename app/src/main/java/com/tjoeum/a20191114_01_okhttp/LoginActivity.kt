package com.tjoeum.a20191114_01_okhttp

import android.os.Bundle
import com.tjoeum.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setValues()
        setupEvents()

//        ServerUtil.postRequestLogin(mContext,"cho881020","qlalfqjsgh!", null)

    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {

            var id = userIdEdt.text.toString()
            var pw = userPwEdt.text.toString()

            ServerUtil.postRequestLogin(mContext,id,pw, null)

        }
    }

    override fun setValues() {
    }
}
