package com.geermank.programacinavanzada111120.threads

import android.os.AsyncTask
import java.lang.ref.WeakReference

class BackgroundTask(listener: LoadingCallback) : AsyncTask<Int, String, String>() {

    private val weakListener = WeakReference(listener)

    override fun onPreExecute() {
        super.onPreExecute()
        weakListener.get()?.startLoading()
    }

    override fun doInBackground(vararg params: Int?): String {
        Thread.sleep(3000)
        return "hola"
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        weakListener.get()?.finishLoading()
    }
}
