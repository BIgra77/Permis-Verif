package com.mastercamp.permisverif.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mastercamp.permisverif.R
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // loadFieldsFromSharedPref()
        btnLogOut.setOnClickListener {
            //val success = applyChangesToSharedPref()
            //if(success) {
                Snackbar.make(view, "Fonctionnalité bientôt disponible", Snackbar.LENGTH_LONG).show()
          //  } else {
                Snackbar.make(view, "Fonctionnalité bientôt disponible", Snackbar.LENGTH_LONG).show()
            }
        }
    }
