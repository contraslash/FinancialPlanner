package com.contraslash.android.financial_planner.applications.core.models

import androidx.compose.Model
//import androidx.room.*

//@Entity(tableName = "sms")
//@Model
//data class SMS(
//    @ColumnInfo(name = "body") val body: String,
//    @ColumnInfo(name = "originatingAddress")val originatingAddress: String,
//    @PrimaryKey @ColumnInfo(name = "timestamp") val timestamp: Long
//)

@Model
data class SMS(
    val body: String,
    val originatingAddress: String,
    val timestamp: Long
)

//@Dao
//interface WordDao {
//
//    @Query("SELECT * from sms ORDER BY timestamp DESC")
//    fun getAllSMS(): List<SMS>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(sms: SMS)
//
//    @Query("DELETE FROM sms")
//    suspend fun deleteAll()
//}