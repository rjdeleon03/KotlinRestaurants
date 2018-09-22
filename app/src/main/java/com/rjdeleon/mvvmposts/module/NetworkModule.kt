package com.rjdeleon.mvvmposts.module

import com.rjdeleon.mvvmposts.network.PostApi
import com.rjdeleon.mvvmposts.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required network dependencies
 */
@Module

// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {

    /**
     * Provides the Post service implementation.
     * @param retrofit The Retrofit object used to instantiate the service
     * @return The Post service implementation
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit : Retrofit) : PostApi {
        return retrofit.create(PostApi::class.java)
    }

    /**
     * Provides the Retrofit object
     * @return The Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}