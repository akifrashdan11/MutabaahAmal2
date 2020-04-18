package com.example.mutabaahamal.Utils;

import com.example.mutabaahamal.Model.AmalanLatest;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<AmalanLatest> amalanLatestList);
    void onFirebaseLoadFailed(String message);
}
