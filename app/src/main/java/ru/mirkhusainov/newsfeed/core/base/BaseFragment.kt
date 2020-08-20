package ru.mirkhusainov.newsfeed.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import toothpick.Scope


private const val STATE_SCOPE_NAME = "state_scope_name"

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {
    protected val scopeName: String = this.javaClass.name

    protected open fun installModules(scope: Scope) {}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit(savedInstanceState)
    }

    fun showToast(msg: String?){
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}