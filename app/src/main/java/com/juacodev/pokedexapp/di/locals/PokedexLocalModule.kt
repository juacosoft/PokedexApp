package com.juacodev.pokedexapp.di.locals

import android.content.Context
import androidx.room.Room
import com.juacodev.pokedexapp.data.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokedexLocalModule {
    @Singleton
    @Provides
    fun providePokedexLocal(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "pokedex_local"
        ).build()
    @Singleton
    @Provides
    fun providePokedexDao(appDataBase: AppDataBase) = appDataBase.pokedexDao()
}