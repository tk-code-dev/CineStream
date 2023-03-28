package mv.tk.cinestream.business.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mv.tk.cinestream.business.data.repository.MoviesRepositoryImpl
import mv.tk.cinestream.business.domain.repository.MoviesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindMoviesRepository(repository: MoviesRepositoryImpl): MoviesRepository
}