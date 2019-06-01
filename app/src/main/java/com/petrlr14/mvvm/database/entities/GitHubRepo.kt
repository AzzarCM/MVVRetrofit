package com.petrlr14.mvvm.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "repos")
data class GitHubRepo(
    @PrimaryKey
    @field:Json(name = "id")
    val id: Long,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "full_name")
    @ColumnInfo(name="full_name")
    val fullName:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(fullName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GitHubRepo> {
        override fun createFromParcel(parcel: Parcel): GitHubRepo {
            return GitHubRepo(parcel)
        }

        override fun newArray(size: Int): Array<GitHubRepo?> {
            return arrayOfNulls(size)
        }
    }
}