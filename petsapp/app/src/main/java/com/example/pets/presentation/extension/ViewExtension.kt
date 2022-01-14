package com.example.pets.presentation.extension

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.visibleOrGone(isVisible: Boolean) {
    visibility = if (isVisible) VISIBLE else GONE
}