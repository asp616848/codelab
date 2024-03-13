package com.example.bluromatic.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.bluromatic.DELAY_TIME_MILLIS
import com.example.bluromatic.KEY_BLUR_LEVEL
import com.example.bluromatic.KEY_IMAGE_URI
import com.example.bluromatic.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private const val TAG = "BlurWorker"
class BlurWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        makeStatusNotification(applicationContext.resources.getString(R.string.blurring_image),
            applicationContext)
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        val blurLevel = inputData.getInt(KEY_BLUR_LEVEL, 1)
        return withContext(Dispatchers.IO){
            delay(DELAY_TIME_MILLIS)

            return@withContext try { // to return the final status of the work being performed
                require(!resourceUri.isNullOrBlank()) {
                    val errorMessage =
                        applicationContext.resources.getString(R.string.invalid_input_uri)
                    Log.e(TAG, errorMessage)
                    errorMessage
                }
                val resolver = applicationContext.contentResolver
//                val picture = BitmapFactory.decodeResource(
//                    applicationContext.resources,
//                    R.drawable.android_cupcake
//                )
                val picture = BitmapFactory.decodeStream(
                    resolver.openInputStream(Uri.parse(resourceUri))
                )
                val output = blurBitmap(picture, blurLevel)

                val outputUri = writeBitmapToFile(applicationContext, output)

//                makeStatusNotification("Output is $outputUri", applicationContext)

                val outputData = workDataOf(KEY_IMAGE_URI to output.toString())
                Result.success(outputData)


            } catch (throwable: Throwable) {
                Log.e(
                    TAG,
                    applicationContext.resources.getString(R.string.error_applying_blur),
                    throwable
                )
                Result.failure()
            }
        }
    }
}