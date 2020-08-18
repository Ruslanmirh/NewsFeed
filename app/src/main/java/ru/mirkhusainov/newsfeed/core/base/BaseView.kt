package ru.mirkhusainov.newsfeed.core.base

import android.os.Bundle
interface BaseView {

    val layoutRes: Int
    fun onInit(savedInstanceState: Bundle?)
}