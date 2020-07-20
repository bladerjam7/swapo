package com.example.swapo

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment

class File_Dialog : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder : AlertDialog.Builder = AlertDialog.Builder(activity)

        val inflater : LayoutInflater? = activity?.layoutInflater
        val view : View? = inflater?.inflate(R.layout.ue_dialog_layout2, null)

        builder.setView(view)
            .setTitle("Select File")
            .setNegativeButton("Cancel", DialogInterface.OnClickListener{
                dialog, which -> dialog.cancel()
            })
            .setPositiveButton("Select", DialogInterface.OnClickListener{
                dialog, which -> finish()
            })

        //TODO Create inventory list

        return builder.create()

    }

    private fun finish() {

    }
}