package com.hyeran.android.hw8;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmVO extends RealmObject {
    @PrimaryKey
    public String title;
    public String filename;
}
