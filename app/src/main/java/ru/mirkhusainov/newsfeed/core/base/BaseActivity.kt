package ru.mirkhusainov.newsfeed.core.base

import android.annotation.SuppressLint
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpAppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

@SuppressLint("Registered")
abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected abstract var navigator: Navigator
    private val lifeCycleDisposable by lazy { CompositeDisposable() }

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        onInit(savedInstanceState)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    protected fun Disposable.addLifeCycle(): Disposable {
        lifeCycleDisposable.add(this)
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeCycleDisposable.dispose()
    }
}