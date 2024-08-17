package com.example.listapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
            ListItem("apple", "Subtitle"),
            ListItem("apricot", "Subtitle"),
            ListItem("avocado", "Subtitle"),
            ListItem("banana", "Subtitle"),
            ListItem("bell pepper", "Subtitle"),
            ListItem("bilberry", "Subtitle"),
            ListItem("blackberry", "Subtitle"),
            ListItem("blackcurrant", "Subtitle"),
            ListItem("blood orange", "Subtitle"),
            ListItem("blueberry", "Subtitle"),
            ListItem("boysenberry", "Subtitle"),
            ListItem("breadfruit", "Subtitle"),
            ListItem("canary melon", "Subtitle"),
            ListItem("cantaloupe", "Subtitle"),
            ListItem("cherimoya", "Subtitle")
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