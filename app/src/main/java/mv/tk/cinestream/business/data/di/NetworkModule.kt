package mv.tk.cinestream.business.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mv.tk.cinestream.BuildConfig
import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val modifiedRequest = originalRequest.newBuilder()
                    .url(originalRequest.url.newBuilder()
                        .addQueryParameter("language", "en-US")
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build())
                    .build()
                chain.proceed(modifiedRequest)
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MovieDatabaseAPI.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): MovieDatabaseAPI.MovieService{
        return retrofit.create(MovieDatabaseAPI.MovieService::class.java)
    }

    @Singleton
    @Provides
    fun provideTvApiService(retrofit: Retrofit): MovieDatabaseAPI.TvService{
        return retrofit.create(MovieDatabaseAPI.TvService::class.java)
    }

    @Singleton
    @Provides
    fun provideActorApiService(retrofit: Retrofit): MovieDatabaseAPI.ActorService{
        return retrofit.create(MovieDatabaseAPI.ActorService::class.java)
    }
}