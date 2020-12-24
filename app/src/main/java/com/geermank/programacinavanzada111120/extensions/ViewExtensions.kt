package com.geermank.programacinavanzada111120.extensions

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.remove() {
    visibility = View.GONE
}

fun View.block() {
    isEnabled = false
}

fun View.unblock() {
    isEnabled = true
}