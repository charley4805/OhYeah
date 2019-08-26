package com.example.oyea;


import android.os.Parcel;
import android.os.Parcelable;



public final class NoteInfo implements Parcelable {
    private AutoInfo mAuto;
    private String mTitle;
    private String mText;

    public NoteInfo(AutoInfo auto, String title, String text) {
        mAuto = auto;
        mTitle = title;
        mText = text;
    }

    private NoteInfo(Parcel source) {
        mAuto = source.readParcelable(AutoInfo.class.getClassLoader());
        mTitle = source.readString();
        mText = source.readString();
    }

    public AutoInfo getAuto() {
        return mAuto;
    }

    public void setAuto(AutoInfo auto) {
        mAuto = auto;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    private String getCompareKey() {
        return mAuto.getAutoId() + "|" + mTitle + "|" + mText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteInfo that = (NoteInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mAuto, 0);
        dest.writeString(mTitle);
        dest.writeString(mText);
    }

    public final static Parcelable.Creator<NoteInfo> CREATOR =
            new Parcelable.Creator<NoteInfo>() {

                @Override
                public NoteInfo createFromParcel(Parcel source) {
                    return new NoteInfo(source);
                }

                @Override
                public NoteInfo[] newArray(int size) {
                    return new NoteInfo[size];
                }
            };
}
