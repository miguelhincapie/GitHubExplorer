package com.mac.githubexplorer.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mac.githubexplorer.R
import com.mac.githubexplorer.presentation.App

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        (application as App).getActivity2Component().inject(this)
    }
}
