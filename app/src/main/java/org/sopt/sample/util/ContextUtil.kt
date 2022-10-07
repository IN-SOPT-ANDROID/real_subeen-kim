package org.sopt.sample.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

//ToastMessage
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

//SnackBarMessage
fun showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun showSnackBar(view: View, message: String, it: Snackbar.() -> Unit) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).apply { it() }.show()
}