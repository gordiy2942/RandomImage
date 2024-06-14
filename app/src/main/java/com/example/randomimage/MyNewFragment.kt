package com.example.randomimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomimage.databinding.ActivityMainBinding
import com.example.randomimage.databinding.FragmentMyNewBinding
import com.example.randomimage.newtwork.NewtworkClient

class MyNewFragment(
    private val listener: Navigation
) : Fragment(){

    private lateinit var binding: FragmentMyNewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyNewBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.myList.layoutManager = LinearLayoutManager(this@MyNewFragment.requireContext())
        val myAdapter = MyListAdapter()
        binding.myList.adapter = myAdapter



        val networkClient = NewtworkClient()
        networkClient.initClient()


        networkClient.getDogImage() { imageAddress ->
            val data: List<DogData> = listOf(
                DogData(myText = "хаски", imageAddress),
                DogData(myText = "бульдог", imageAddress),
                DogData(myText = "овчарка", imageAddress),
                DogData(myText = "лабрадор", imageAddress),
                DogData(myText = "долматинец", imageAddress),
                DogData(myText = "чихуахуа", imageAddress),
            )
            myAdapter.setList(data)
            myAdapter.notifyDataSetChanged()

            binding.nextButton.setOnClickListener {
                listener.navigateToSecondFragment(imageUrl = imageAddress)
            }
        }
    }
}