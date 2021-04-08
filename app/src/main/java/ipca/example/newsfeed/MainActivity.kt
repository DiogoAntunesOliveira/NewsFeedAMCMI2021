package ipca.example.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // Model
    var posts : MutableList<Post> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        posts.add(Post("Boa noticia", "esta é mesmo uma boa noticia", null, null))
        posts.add(Post("Má noticia", "esta é mesmo uma má noticia", null, null))


    }


}