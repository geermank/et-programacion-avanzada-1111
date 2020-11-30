package com.geermank.programacinavanzada111120.staticfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.fragment_red.*

class RedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_show_message.setOnClickListener {
            (activity as? StaticFragmentsActivity)?.toast("Hola desde fragment rojo")
        }
    }
}
