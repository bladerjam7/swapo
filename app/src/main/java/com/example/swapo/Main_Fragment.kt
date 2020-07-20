package com.example.swapo

import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main_.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Main_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Main_Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_create_new.setOnClickListener {
            val nextAction = Main_FragmentDirections.actionMainFragmentToCreateNewFragment()

            Navigation.findNavController(it).navigate(nextAction)
        }

        btn_use_existing.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val ue = UE_Dialog()
        val s : String? = "Open Existing File"
        ue.show(childFragmentManager, s)

    }
}
