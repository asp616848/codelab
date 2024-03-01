package com.example.marsphotos.fake

import MarsPhoto
import com.example.marsphotos.data.MarsPhotosRepository

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}