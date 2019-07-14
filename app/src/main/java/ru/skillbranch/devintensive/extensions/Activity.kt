package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val typing = this.currentFocus
    typing?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(typing.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen():Boolean {
    val rootView = findViewById<View>(android.R.id.content)
    val visibleBounds = Rect()
    rootView.getWindowVisibleDisplayFrame(visibleBounds)
    val keyboardHeight = rootView.height - visibleBounds.bottom
    return keyboardHeight > 0
}

fun Activity.isKeyboardClosed(): Boolean {
    val visibleBounds = Rect()
    val rootView = this.window.decorView
    rootView.getWindowVisibleDisplayFrame(visibleBounds)
    val keybardHeight = rootView.height - visibleBounds.bottom
    return keybardHeight == 0
}