package com.example.colorfragments  // Make sure this matches your package name

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.colorfragments.R

class ColorFragment : Fragment() {

    companion object {
        var fragmentCount: Int = 0

        fun newInstance(choice: Int) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt("COLOR CHOICE", choice)
                }
            }
    }

    private var myIndex: Int = 0

    private val chosenColorTV: TextView?
        get() = view?.findViewById(R.id.mycolor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0
        when (choiceId) {
            1 -> { // Blue
                chosenColorTV?.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> { // Red
                chosenColorTV?.text = "GENERIC RED FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }
}