package org.sopt.sample.presentation.signin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import org.sopt.sample.R
import org.sopt.sample.data.User
import org.sopt.sample.databinding.ActivitySignInBinding
import org.sopt.sample.presentation.main.MyPageActivity
import org.sopt.sample.presentation.signup.SignUpActivity
import org.sopt.sample.util.showSnackBar
import org.sopt.sample.util.showToast



class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private var user: User? = null
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onSignUpClick()
        onSignInClick()
        setSignUp()
    }

    private fun onSignUpClick() {
        binding.btnSignUp.setOnClickListener {
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(signUpIntent)
        }
    }

    private fun onSignInClick() {
        binding.btnSignIn.setOnClickListener {
            if (isSuccessLogin()) {
                goToMyPage()
            } else {
                showToast("로그인 실패했습니다.")
            }
        }
    }

    private fun setSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    if (result.data?.hasExtra("user") == true) {
                        showSnackBar(binding.root, getString(R.string.signup_complete))
                        user = result.data?.getParcelableExtra(User)
                    }
                    binding.apply {
                        etId.setText(user?.id)
                        etPw.setText(user?.password)
                    }
                }
            }

    }

    private fun goToMyPage() {
        val intent = Intent(this, MyPageActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun isSuccessLogin(): Boolean {
        return binding.etId.text.toString() == user?.id && binding.etPw.text.toString() == user?.password
    }

    companion object {
        const val User = "user"
    }
}