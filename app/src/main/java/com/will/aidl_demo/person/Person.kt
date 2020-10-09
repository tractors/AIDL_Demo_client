package com.will.aidl_demo.person

import android.os.Parcel
import android.os.Parcelable

class Person():Parcelable{
    private var name:String = ""
    private var grade:Int = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        grade = parcel.readInt()
    }

    constructor(name: String,grade:Int):this(){
        this.name = name
        this.grade = grade
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(grade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }


}