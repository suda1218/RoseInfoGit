package rose.chenm6.roseinfo

import android.os.Parcel
import android.os.Parcelable

data class Student(
    var profilePhotoID: String,
    val name: String = "Name",
    var email:String = "nothing@mail.com",
    var major:String = "sleep"):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(profilePhotoID)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(major)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}