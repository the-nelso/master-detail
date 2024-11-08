package com.example.masterdetail

import android.os.Parcel
import android.os.Parcelable

data class Time (val nome: String, val estado: String, val divisao: String, val imagem: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(estado)
        parcel.writeString(divisao)
        parcel.writeInt(imagem)
    }

    companion object CREATOR : Parcelable.Creator<Time> {
        override fun createFromParcel(parcel: Parcel): Time {
            return Time(parcel)
        }

        override fun newArray(size: Int):Array<Time?> {
            return arrayOfNulls(size)
        }
    }
}