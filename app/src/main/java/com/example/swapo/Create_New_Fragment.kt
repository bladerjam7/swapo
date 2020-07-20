package com.example.swapo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_create__new_.*
import kotlinx.android.synthetic.main.fragment_create__new_.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [Create_New_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Create_New_Fragment : Fragment(), AddNew_Dialog.DialogListener{


    val displayArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initDisplayList()

        val view = inflater.inflate(R.layout.fragment_create__new_, container, false)
        view.fb_add_new.setOnClickListener {
            openAddNewDialog()
        }

        return view
    }

    private fun openAddNewDialog() {
        val addDialog = AddNew_Dialog()
        val bundle = Bundle();
        bundle.putStringArrayList("DisplayList", displayArray)
        addDialog.arguments = bundle
        val s : String? = "Add New"
        addDialog.show(childFragmentManager, s)
    }

    private fun initDisplayList() {
        displayArray.add(("A"))
        displayArray.add(("B"))
        displayArray.add(("C"))
        displayArray.add(("D"))
        displayArray.add(("E"))
        displayArray.add(("F"))
        displayArray.add(("G"))
        displayArray.add(("H"))
        displayArray.add(("I"))
        displayArray.add(("J"))
        displayArray.add(("K"))
        displayArray.add(("L"))
        displayArray.add(("M"))
        displayArray.add(("N"))
        displayArray.add(("O"))
        displayArray.add(("P"))
        displayArray.add(("Q"))
        displayArray.add(("R"))
        displayArray.add(("S"))
        displayArray.add(("T"))
        displayArray.add(("U"))
        displayArray.add(("V"))
        displayArray.add(("W"))
        displayArray.add(("X"))
        displayArray.add(("Y"))
        displayArray.add(("Z"))
    }

    override fun applySwap(firstLetter: String, secondLetter: String) {
        Toast.makeText(context, firstLetter + " " + secondLetter, Toast.LENGTH_SHORT ).show()
    }
}
