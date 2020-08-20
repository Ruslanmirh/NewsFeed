package ru.mirkhusainov.newsfeed.core.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainNavigator(fragmentActivity: FragmentActivity, @IdRes containerId: Int) :
    SupportAppNavigator(fragmentActivity, containerId)