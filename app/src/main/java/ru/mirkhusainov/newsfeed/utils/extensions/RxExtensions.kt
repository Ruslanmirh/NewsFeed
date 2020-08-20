package ru.mirkhusainov.newsfeed.utils.extensions

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.exceptions.CompositeException
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.async(): Observable<T> = subscribeOn(Schedulers.io()).observeOn(
    AndroidSchedulers.mainThread()
).dropBreadcrumb()

fun <T> Single<T>.async(): Single<T> = subscribeOn(Schedulers.io()).observeOn(
    AndroidSchedulers.mainThread()
).dropBreadcrumb()

fun <T> Maybe<T>.async(): Maybe<T> = subscribeOn(Schedulers.io()).observeOn(
    AndroidSchedulers.mainThread()
).dropBreadcrumb()

fun Completable.async(): Completable = subscribeOn(Schedulers.io()).observeOn(
    AndroidSchedulers.mainThread()
).dropBreadcrumb()


private fun <T> Observable<T>.dropBreadcrumb(): Observable<T> {
    val breadcrumb = BreadcrumbException()
    return this.onErrorResumeNext { error: Throwable ->
        throw CompositeException(error, breadcrumb)
    }
}

private fun <T> Single<T>.dropBreadcrumb(): Single<T> {
    val breadcrumb = BreadcrumbException()
    return this.onErrorResumeNext { error: Throwable ->
        throw CompositeException(error, breadcrumb)
    }
}

private fun <T> Maybe<T>.dropBreadcrumb(): Maybe<T> {
    val breadcrumb = BreadcrumbException()
    return this.onErrorResumeNext { error: Throwable ->
        throw CompositeException(error, breadcrumb)
    }
}

private fun Completable.dropBreadcrumb(): Completable {
    val breadcrumb = BreadcrumbException()
    return this.onErrorResumeNext { error: Throwable ->
        throw CompositeException(error, breadcrumb)
    }
}

class BreadcrumbException : Exception()