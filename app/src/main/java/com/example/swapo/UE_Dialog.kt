package com.example.swapo

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.ue_dialog_layout.*

class UE_Dialog : AppCompatDialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder : AlertDialog.Builder = AlertDialog.Builder(activity)

        val inflater : LayoutInflater? = activity?.layoutInflater
        val view : View? = inflater?.inflate(R.layout.ue_dialog_layout, null)



        builder.setView(view)
            .setTitle("Select Existing")
            .setNegativeButton("Cancel", DialogInterface.OnClickListener{
                dialog, which -> dialog.cancel()
            })
            .setPositiveButton("Done", DialogInterface.OnClickListener(){
                dialog, which -> finish()
            })

        val folderButton : ImageButton? = view?.findViewById(R.id.btn_select_file);
        folderButton?.setOnClickListener {
            openFolder()
        }

        return builder.create()
    }

    private fun finish() {
        Toast.makeText(context, "DONE", Toast.LENGTH_SHORT).show()
    }

    private fun openFolder() {
        val fileDialog = File_Dialog()
        val s : String? = "Open File"
        fileDialog.show(childFragmentManager, s)

    }
}