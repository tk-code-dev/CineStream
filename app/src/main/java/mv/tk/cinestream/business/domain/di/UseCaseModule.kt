package mv.tk.cinestream.business.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mv.tk.cinestream.business.domain.usecase.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindMoviesUseCase(useCaseImpl: MoviesUseCaseImpl): MoviesUseCase

    @Binds
    @Singleton
    internal abstract fun bindTvsUseCase(useCaseImpl: TvsUseCaseImpl): TvsUseCase

    @Binds
    @Singleton
    internal abstract fun bindActorsUseCase(useCaseImpl: ActorsUseCaseImpl): ActorsUseCase
}