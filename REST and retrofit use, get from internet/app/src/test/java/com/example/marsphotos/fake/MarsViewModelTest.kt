package com.example.marsphotos.fake

import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherClass()
    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest{
        val marsViewModel = MarsViewModel(
            marsPhotosRepository = FakeNetworkMarsPhotosRepository())
            assertEquals(MarsUiState.Success(FakeDataSource.photosList), marsViewModel.marsUiState)
    }
}