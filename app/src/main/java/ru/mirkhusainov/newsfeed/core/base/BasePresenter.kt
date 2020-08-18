package ru.mirkhusainov.newsfeed.core.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<V : MvpView> : MvpPresenter<V>() {

    private val fullLifeCycleCompositeDisposable = CompositeDisposable()
    private val viewLifeCycleCompositeDisposable = CompositeDisposable()


    override fun onDestroy() {
        viewLifeCycleCompositeDisposable.dispose()
        fullLifeCycleCompositeDisposable.dispose()
    }

    protected fun Disposable.addFullLifeCycle(): Disposable {
        fullLifeCycleCompositeDisposable.add(this)
        return this
    }

    protected fun Disposable.addViewLifeCycle(): Disposable {
        viewLifeCycleCompositeDisposable.add(this)
        return this
    }

    override fun destroyView(view: V) {
        super.destroyView(view)
        viewLifeCycleCompositeDisposable.clear()
    }

}