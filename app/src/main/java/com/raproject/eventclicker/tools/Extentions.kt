package com.raproject.eventclicker.tools

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun Fragment.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit,
) = viewLifecycleOwner.launch(context, start, block)

fun LifecycleOwner.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit,
) = lifecycleScope.launch(context, start, block)

fun Context.getImageCompat(id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun Context.getColorCompat(id: Int): Int {
    return ContextCompat.getColor(this, id)
}
