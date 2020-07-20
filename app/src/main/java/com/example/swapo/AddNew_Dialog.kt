package com.example.swapo

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.add_new_dialog.*
import java.lang.ClassCastException

class AddNew_Dialog : AppCompatDialogFragment(){

   // private var listener : AddNewListener
   lateinit var displayList : ArrayList<String>

   lateinit var firstletter : String
   lateinit var secondletter : String
    internal lateinit var listener : DialogListener



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder : AlertDialog.Builder = AlertDialog.Builder(activity)

        // TODO Create Adapter
        // TODO Display Result
        // TODO Set Click Listener to get Input

        return activity.let {

            val inflater : LayoutInflater? = activity?.layoutInflater
            val view : View? = inflater?.inflate(R.layout.add_new_dialog, null)

            val spinnerOne = view?.findViewById<Spinner>(R.id.spin_firstLetter)
            val spinnerTwo = view?.findViewById<Spinner>(R.id.spin_secondLetter)



            displayList = arguments?.getStringArrayList("DisplayList") as ArrayList<String>

            if (spinnerOne != null && spinnerTwo != null){
                val adapter = ArrayAdapter(view.context, R.layout.support_simple_spinner_dropdown_item, displayList)
                spinnerOne.adapter = adapter
                spinnerTwo.adapter = adapter
            }

            spinnerOne?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    firstletter = displayList[position]
                }
            }

            spinnerTwo?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    secondletter = displayList[position]
                }
            }


            builder.setView(view)
                .setTitle("Select Existing")
                .setNegativeButton("Cancel") { dialog, _ -> dialog.cancel()
                }
                .setPositiveButton("Done"){dialog, which ->

                    listener.applySwap(firstletter, secondletter)

                }
                .create()

        }

    }

    /*override fun onAttach(context: Context) {
        super.onAttach(context)

        try {

            listener = context
        } catch (e: ClassCastException) {
            System.out.println("DIDNT WORK")
        }
    }*/

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        try {

            listener = context as DialogListener
        } catch (e: ClassCastException) {
            System.out.println("DIDNT WORK")
        }
    }

    interface DialogListener{
        fun applySwap(firstLetter : String, secondLetter : String)
    }
}