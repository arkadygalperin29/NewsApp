package space.arkady.myapplication.domain.models

data class NewsInfo(
    val amountOfNews: String,
    val listOfNews: List<BaseItem>
)
