package ru.mirkhusainov.newsfeed.features.main

import android.os.Bundle
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.mirkhusainov.newsfeed.R
import ru.mirkhusainov.newsfeed.core.base.BaseActivity
import ru.mirkhusainov.newsfeed.core.navigation.MainNavigator
import ru.terrakok.cicerone.Navigator

class MainActivity : BaseActivity(), MainView {
    override var navigator: Navigator = MainNavigator(this, R.id.fragmentContainer)
    override val layoutRes: Int = R.layout.activity_main

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = scope.getInstance(MainPresenter::class.java)

    override fun onInit(savedInstanceState: Bundle?) {
        presenter.openHomeScreen()
    }

}