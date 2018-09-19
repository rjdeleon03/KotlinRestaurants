package com.rjdeleon.mvvmposts.network

import android.database.Observable
import com.rjdeleon.mvvmposts.model.Post
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface PostApi {

    /**
     * Get the list of the posts from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}