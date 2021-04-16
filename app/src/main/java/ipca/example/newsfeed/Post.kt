package ipca.example.newsfeed

import org.json.JSONObject

class Post {

    var title : String? = null
    var description : String? = null
    var imageUrl : String? = null
    var url : String? = null

    constructor(title: String?, description: String?, imageUrl: String?, url: String?) {
        this.title = title
        this.description = description
        this.imageUrl = imageUrl
        this.url = url
    }

    constructor() {

    }

    companion object {

        fun fromJson(jsonObject: JSONObject) : Post {
            val post = Post()
            post.title = jsonObject.getString("title")
            post.description = jsonObject.getString("description")
            post.imageUrl = jsonObject.getString("urlToImage")
            post.url = jsonObject.getString("url")

            return post
        }
    }

}