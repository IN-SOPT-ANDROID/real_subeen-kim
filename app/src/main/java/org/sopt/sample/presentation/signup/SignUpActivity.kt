package org.sopt.sample.presentation.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.sample.R
import org.sopt.sample.data.User
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.presentation.signin.SignInActivity
import org.sopt.sample.util.showSnackBar

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickComplete()
    }

    private fun isComplete() {
        if (isCheck()) {
            setUser()
            showSnackBar(binding.root, getString(R.string.signup_complete))
        } else
            showSnackBar(binding.root, getString(R.string.signup_failure))
    }

    private fun isCheck(): Boolean {
        return binding.etId.text.length in 6..10 && binding.etPw.text.length in 8..12 && binding.etMbti.text.length == 4
    }

    private fun onClickComplete() {
        binding.btnComplete.setOnClickListener {
            isComplete()
        }
    }

    private fun setUser() {
        val user = User(
            binding.etId.text.toString(),
            binding.etPw.text.toString(),
            binding.etMbti.text.toString()
        )
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        intent.putExtra("user", user)
        setResult(RESULT_OK, intent)
        finish()
    }
}