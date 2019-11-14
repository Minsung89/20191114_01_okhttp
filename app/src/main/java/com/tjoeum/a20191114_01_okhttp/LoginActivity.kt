package com.tjoeum.a20191114_01_okhttp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeum.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

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

            ServerUtil.postRequestLogin(mContext,id,pw, object :ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    runOnUiThread {
                        Log.d("액티비티에서보는응답",json.toString())

                        val code = json.getInt("code")

                        if(code == 400){
                            val message = json.getString("message")
                            Toast.makeText(mContext,message,Toast.LENGTH_LONG).show()
                        }
                        else if(code == 200){

                            val name = json.getJSONObject("data")
                                .getJSONObject("user")
                                .getString("name")

                            Toast.makeText(mContext,"${name}님 환영합니다.", Toast.LENGTH_LONG).show()
                        }

                    }

                }
            })

        }
    }

    override fun setValues() {
    }
}
