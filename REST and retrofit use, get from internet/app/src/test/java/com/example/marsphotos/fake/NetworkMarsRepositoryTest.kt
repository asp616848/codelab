package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkMarsRepositoryTest {
    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest{
        val repository = NetworkMarsPhotosRepository(marsApiService = fakeApiService())
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
}
