package ipca.example.newsfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import ipca.example.newsfeed.R.id.textViewTitle
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    // Model
    var posts : MutableList<Post> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        posts.add(Post("Boa noticia", "esta é mesmo uma boa noticia", null, null))
        posts.add(Post("Má noticia", "esta é mesmo uma má noticia", null, null))
        posts.add(Post("Má noticia", "esta é mesmo uma má noticia", null, null))

        val listViewPosts = findViewById<ListView>(R.id.listViewPosts)
        val postsAdapter = PostsAdapter()
        listViewPosts.adapter = postsAdapter

        val urlc : HttpURLConnection =
                URL("https://newsapi.org/v2/top-headlines?country=pt&category=business&apiKey=")
                        .openConnection() as HttpURLConnection
        urlc.connect()
        val stream = urlc.inputStream
        val isReader = InputStreamReader(stream)
        val brin  = BufferedReader(isReader)
        var str : String = ""

        var keepReading = true
        while(keepReading) {
            val line = brin.readLine()
            if (line == null){
                keepReading = false
            }else {
                str += line
            }
        }

        println(str)


    }

    inner class PostsAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return posts.size
        }

        override fun getItem(position: Int): Any {
            return posts[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = layoutInflater.inflate(R.layout.row_post, parent, false)

            val textViewTitle       = rowView.findViewById<TextView >(textViewTitle)
            val textViewDescription = rowView.findViewById<TextView >(R.id.textViewDescription)
            val imageViewPost       = rowView.findViewById<ImageView>(R.id.imageViewPost)

            textViewTitle.text = posts[position].title
            textViewDescription.text = posts[position].description

            rowView.setOnClickListener {
                Toast.makeText(this@MainActivity, posts[position].title, Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity, PostDetailActivity::class.java)
                intent.putExtra("title", posts[position].title)
                startActivity(intent)
            }


            return rowView
        }

    }


}