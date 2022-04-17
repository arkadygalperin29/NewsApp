package space.arkady.myapplication.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import space.arkady.myapplication.R
import space.arkady.myapplication.presentation.recycler.BasicAdapter
import space.arkady.myapplication.presentation.recycler.clickListener.OnItemClickListener
import space.arkady.myapplication.utils.createIntentLinkNews
import space.arkady.myapplication.utils.hideKeyboard
import space.arkady.myapplication.utils.searchOnQueryListener

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()
    private val adapter by lazy { BasicAdapter(linkNews) }

    private val linkNews by lazy {
        object : OnItemClickListener {
            override fun onLinkButtonClickListener(urlNews: String) {
                createIntentLinkNews(
                    urlNews = urlNews,
                    getTitleLinkMenu = "Title",
                    getSubject = "Subject"
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        searchNews()
        initView()
        initObserver()
    }

    private fun searchNews() {
        searchBar.searchOnQueryListener { queryString ->
            viewModel.setWord(queryString.toString())
            hideKeyboard(searchBar)
            return@searchOnQueryListener true
        }
    }

    private fun initView() {
        recyclerDate.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    private fun initObserver() {
        viewModel.news.observe(this) { newslist ->
            textDisplayResult.text = "List of news: ${newslist.amountOfNews}"
            adapter.submitList(newslist.listOfNews)
        }
    }
}