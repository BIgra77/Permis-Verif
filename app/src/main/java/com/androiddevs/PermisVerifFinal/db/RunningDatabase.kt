package com.mastercamp.permisverif.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//laison entre RunDAO et la BDD

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDAO
}