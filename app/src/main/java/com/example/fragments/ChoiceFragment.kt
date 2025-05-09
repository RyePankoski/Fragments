package com.example.colorfragments  // Make sure this matches your package name

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.colorfragments.R

class ChoiceFragment : Fragment() {

    private lateinit var choiceListener: ChoiceListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        } else {
            throw RuntimeException("$context must implement ChoiceListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blueT = view.findViewById<TextView>(R.id.blueText)
        val redT = view.findViewById<TextView>(R.id.redText)

        blueT.setOnClickListener {
            val choice = 1 // 1 for blue
            choiceListener.onSelected(choice)
        }

        //hello

        redT.setOnClickListener {
            val choice = 2 // 2 for red
            choiceListener.onSelected(choice)
        }
    }
}