package ipca.example.newsfeed

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
}