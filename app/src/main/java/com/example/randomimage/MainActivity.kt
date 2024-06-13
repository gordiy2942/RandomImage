package com.example.randomimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.randomimage.databinding.ActivityMainBinding
import com.example.randomimage.newtwork.NewtworkClient
import com.squareup.picasso.Picasso
import okhttp3.internal.notify

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.root_container, MyNewFragment())
        }


    }
}