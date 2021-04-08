package ipca.example.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PostDetailActivity : AppCompatActivity() {

    // Model
    var post : Post? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val postTitle = intent.getStringExtra("title")

        title = postTitle
    }
}