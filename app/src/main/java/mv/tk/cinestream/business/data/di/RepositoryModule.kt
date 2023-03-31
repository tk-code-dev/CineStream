package mv.tk.cinestream.business.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mv.tk.cinestream.business.data.repository.ActorsRepositoryImpl
import mv.tk.cinestream.business.data.repository.MoviesRepositoryImpl
import mv.tk.cinestream.business.data.repository.TvsRepositoryImpl
import mv.tk.cinestream.business.domain.repository.ActorsRepository
import mv.tk.cinestream.business.domain.repository.MoviesRepository
import mv.tk.cinestream.business.domain.repository.TvsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindMoviesRepository(repository: MoviesRepositoryImpl): MoviesRepository

    @Binds
    @Singleton
    internal abstract fun bindTvsRepository(repository: TvsRepositoryImpl): TvsRepository

    @Binds
    @Singleton
    internal abstract fun bindActorsRepository(repository: ActorsRepositoryImpl): ActorsRepository
}