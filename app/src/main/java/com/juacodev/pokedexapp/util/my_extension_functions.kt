package com.juacodev.pokedexapp.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*


fun View.safeClickListener(onSafeClick: (View) -> Unit) {
    val lasTimeClicked =0L
    setOnClickListener {
        if(System.currentTimeMillis()-lasTimeClicked>1000){
            onSafeClick(it)
        }
    }
}
fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
fun String.UpperCapitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}