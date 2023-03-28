//package mv.tk.cinestream.di
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import mv.tk.cinestream.BuildConfig
//import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.Response
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Singleton
//    @Provides
//    fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        return interceptor
//    }
//
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(
//        loggingInterceptor: HttpLoggingInterceptor
//    ): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .addInterceptor(RequestInterceptor())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(MovieDatabaseAPI.BASE_API_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideApiService(retrofit: Retrofit): MovieDatabaseAPI {
//        return retrofit.create(MovieDatabaseAPI::class.java)
//    }
//
//    internal class RequestInterceptor : Interceptor {
//        override fun intercept(chain: Interceptor.Chain): Response {
//            val oldRequest = chain.request()
//            val url = oldRequest.url.newBuilder()
//                .addQueryParameter("language", "en-US")
//                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
//                .build()
//            val newRequest = oldRequest.newBuilder().url(url).build()
//            return chain.proceed(newRequest)
//        }
//
//    }
//
//
//}
