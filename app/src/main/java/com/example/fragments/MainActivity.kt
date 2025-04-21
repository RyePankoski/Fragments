package com.example.colorfragments
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

interface ChoiceListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), ChoiceListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()

            supportFragmentManager.beginTransaction()
                .add(cfv.id, choiceFragment)
                .commit()
        }
    }

    override fun onSelected(choiceID: Int) {
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        val colorFragment = ColorFragment.newInstance(choiceID)
        supportFragmentManager.beginTransaction()
            .replace(fcv.id, colorFragment)
            .addToBackStack(null)
            .commit()
    }
}