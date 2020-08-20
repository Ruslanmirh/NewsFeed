package ru.mirkhusainov.newsfeed.core.base

import android.annotation.SuppressLint
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpAppCompatActivity
import ru.mirkhusainov.newsfeed.core.di.Scopes
import ru.mirkhusainov.newsfeed.utils.extensions.injectInScope
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject

@SuppressLint("Registered")
abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected abstract var navigator: Navigator
    private val lifeCycleDisposable by lazy { CompositeDisposable() }
    
    protected lateinit var scope: Scope
        private set

    final override fun onCreate(savedInstanceState: Bundle?) {
        scope = Toothpick.openScope(Scopes.SCOPE_APP).injectInScope(this)
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