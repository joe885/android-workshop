package com.warpwood.workshopapp

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeedApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                module {
                    single {
                        Retrofit.Builder()
                            .baseUrl("https://joe885.github.io/android-workshop-dummy-api/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                    }

                    single {
                        get<Retrofit>().create(FeedApiService::class.java)
                    }
                }
            )
        }
    }
}