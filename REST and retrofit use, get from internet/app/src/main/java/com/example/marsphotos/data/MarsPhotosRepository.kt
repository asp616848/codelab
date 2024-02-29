package com.example.marsphotos.data

import MarsPhoto
import com.example.marsphotos.network.MarsApiService

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}
class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository{
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}