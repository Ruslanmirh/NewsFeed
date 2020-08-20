package ru.mirkhusainov.newsfeed.utils.extensions

import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module

fun module(func: (Module.() -> (Unit))) = object : Module() {
    init {
        func()
    }
}

fun Scope.modules(func: Module.() -> Unit): Scope {
    installModules(module { func(this) })
    return this
}

fun Scope.injectInScope(any: Any): Scope {
    Toothpick.inject(any, this)
    return this
}
