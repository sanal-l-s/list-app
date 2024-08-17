package com.example.listapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.listapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ItemListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
        )

        val imageViewPagerAdapter = ImageViewPagerAdapter(images)
        binding.viewPager.adapter = imageViewPagerAdapter


        var items = listOf(
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle"),
            ListItem("Title","Subtitle")
        )
        listAdapter = ItemListAdapter(items)
        binding.rvItems.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }

        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                listAdapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
}