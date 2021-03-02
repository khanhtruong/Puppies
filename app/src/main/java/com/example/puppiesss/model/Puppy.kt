package com.example.puppiesss.model

import android.os.Parcel
import android.os.Parcelable

data class Puppy(
    var id: Int,
    var name: String,
    var about: String,
    var picture: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(about)
        parcel.writeInt(picture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Puppy> {
        override fun createFromParcel(parcel: Parcel): Puppy {
            return Puppy(parcel)
        }

        override fun newArray(size: Int): Array<Puppy?> {
            return arrayOfNulls(size)
        }
    }
}
