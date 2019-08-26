package com.example.oyea;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public final class AutoInfo implements Parcelable {
    private final String mAutoId;
    private final String mTitle;
    private final List<ModuleInfo> mModules;

    public AutoInfo(String autoId, String title, List<ModuleInfo> modules) {
        mAutoId = autoId;
        mTitle = title;
        mModules = modules;
    }

    private AutoInfo(Parcel source) {
        mAutoId = source.readString();
        mTitle = source.readString();
        mModules = new ArrayList<>();
        source.readTypedList(mModules, ModuleInfo.CREATOR);
    }

    public String getAutoId() {
        return mAutoId;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<ModuleInfo> getModules() {
        return mModules;
    }

    public boolean[] getModulesCompletionStatus() {
        boolean[] status = new boolean[mModules.size()];

        for(int i=0; i < mModules.size(); i++)
            status[i] = mModules.get(i).isComplete();

        return status;
    }

    public void setModulesCompletionStatus(boolean[] status) {
        for(int i=0; i < mModules.size(); i++)
            mModules.get(i).setComplete(status[i]);
    }

    public ModuleInfo getModule(String moduleId) {
        for(ModuleInfo moduleInfo: mModules) {
            if(moduleId.equals(moduleInfo.getModuleId()))
                return moduleInfo;
        }
        return null;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoInfo that = (AutoInfo) o;

        return mAutoId.equals(that.mAutoId);

    }

    @Override
    public int hashCode() {
        return mAutoId.hashCode();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAutoId);
        dest.writeString(mTitle);
        dest.writeTypedList(mModules);
    }

    public static final Parcelable.Creator<AutoInfo> CREATOR =
            new Parcelable.Creator<AutoInfo>() {

                @Override
                public AutoInfo createFromParcel(Parcel source) {
                    return new AutoInfo(source);
                }

                @Override
                public AutoInfo[] newArray(int size) {
                    return new AutoInfo[size];
                }
            };

}
