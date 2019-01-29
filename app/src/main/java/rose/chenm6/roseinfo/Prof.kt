package rose.chenm6.roseinfo

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable

data class Prof(
    val name: String,
    var profilePhotoID: String,
    var email:String,
    val office: String,
    val department: String,
    var workloadLevel: Float,
    var challengingLevel: Float,
    var interestingLevel: Float,
    var schedule:String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readString()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Prof> {
        override fun createFromParcel(parcel: Parcel): Prof {
            return Prof(parcel)
        }

        override fun newArray(size: Int): Array<Prof?> {
            return arrayOfNulls(size)
        }
    }


}