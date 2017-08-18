package org.androidsummit.notepad.util

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Flowable<T>.android(): Flowable<T> {
    return observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}