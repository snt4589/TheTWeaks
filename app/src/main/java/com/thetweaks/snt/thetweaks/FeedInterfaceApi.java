package com.thetweaks.snt.thetweaks;

import com.thetweaks.snt.thetweaks.explorerData.DummyFeed;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

    public interface FeedInterfaceApi {

        @GET("posts")
        Call<List<DummyFeed>> getPosts();
    }
