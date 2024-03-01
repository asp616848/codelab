package com.example.marsphotos.fake

import MarsPhoto
import com.example.marsphotos.network.MarsApiService

object FakeDataSource {

    const val idOne = "img1"
    const val idTwo = "img2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    val photosList = listOf(
        MarsPhoto(
            id = idOne,
            imgSrc = imgOne
        ),
        MarsPhoto(
            id = idTwo,
            imgSrc = imgTwo
        )
    )
}
class fakeApiService : MarsApiService{
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}