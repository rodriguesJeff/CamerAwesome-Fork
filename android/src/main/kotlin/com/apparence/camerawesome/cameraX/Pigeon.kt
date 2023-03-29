// Autogenerated from Pigeon (v9.1.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.apparence.camerawesome.cameraX

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  if (exception is FlutterError) {
    return listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    return listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

enum class SensorPosition(val raw: Int) {
  BACK(0),
  FRONT(1);

  companion object {
    fun ofRaw(raw: Int): SensorPosition? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

enum class PigeonSensorType(val raw: Int) {
  /**
   * A built-in wide-angle camera.
   *
   * The wide angle sensor is the default sensor for iOS
   */
  WIDEANGLE(0),
  /** A built-in camera with a shorter focal length than that of the wide-angle camera. */
  ULTRAWIDEANGLE(1),
  /** A built-in camera device with a longer focal length than the wide-angle camera. */
  TELEPHOTO(2),
  /**
   * A device that consists of two cameras, one Infrared and one YUV.
   *
   * iOS only
   */
  TRUEDEPTH(3),
  UNKNOWN(4);

  companion object {
    fun ofRaw(raw: Int): PigeonSensorType? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

enum class CamerAwesomePermission(val raw: Int) {
  STORAGE(0),
  CAMERA(1),
  LOCATION(2),
  RECORD_AUDIO(3);

  companion object {
    fun ofRaw(raw: Int): CamerAwesomePermission? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class PreviewSize (
  val width: Double,
  val height: Double

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): PreviewSize {
      val width = list[0] as Double
      val height = list[1] as Double
      return PreviewSize(width, height)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      width,
      height,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class ExifPreferences (
  val saveGPSLocation: Boolean

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): ExifPreferences {
      val saveGPSLocation = list[0] as Boolean
      return ExifPreferences(saveGPSLocation)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      saveGPSLocation,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class Sensor (
  val position: SensorPosition? = null,
  val type: PigeonSensorType? = null,
  val deviceId: String? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): Sensor {
      val position: SensorPosition? = (list[0] as Int?)?.let {
        SensorPosition.ofRaw(it)
      }
      val type: PigeonSensorType? = (list[1] as Int?)?.let {
        PigeonSensorType.ofRaw(it)
      }
      val deviceId = list[2] as String?
      return Sensor(position, type, deviceId)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      position?.raw,
      type?.raw,
      deviceId,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class VideoOptions (
  val fileType: String,
  val codec: String

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): VideoOptions {
      val fileType = list[0] as String
      val codec = list[1] as String
      return VideoOptions(fileType, codec)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      fileType,
      codec,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class PigeonSensorTypeDevice (
  val sensorType: PigeonSensorType,
  /** A localized device name for display in the user interface. */
  val name: String,
  /** The current exposure ISO value. */
  val iso: Double,
  /** A Boolean value that indicates whether the flash is currently available for use. */
  val flashAvailable: Boolean,
  /** An identifier that uniquely identifies the device. */
  val uid: String

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): PigeonSensorTypeDevice {
      val sensorType = PigeonSensorType.ofRaw(list[0] as Int)!!
      val name = list[1] as String
      val iso = list[2] as Double
      val flashAvailable = list[3] as Boolean
      val uid = list[4] as String
      return PigeonSensorTypeDevice(sensorType, name, iso, flashAvailable, uid)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      sensorType.raw,
      name,
      iso,
      flashAvailable,
      uid,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class AndroidFocusSettings (
  /**
   * The auto focus will be canceled after the given [autoCancelDurationInMillis].
   * If [autoCancelDurationInMillis] is equals to 0 (or less), the auto focus
   * will **not** be canceled. A manual `focusOnPoint` call will be needed to
   * focus on an other point.
   * Minimal duration of [autoCancelDurationInMillis] is 1000 ms. If set
   * between 0 (exclusive) and 1000 (exclusive), it will be raised to 1000.
   */
  val autoCancelDurationInMillis: Long

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): AndroidFocusSettings {
      val autoCancelDurationInMillis = list[0].let { if (it is Int) it.toLong() else it as Long }
      return AndroidFocusSettings(autoCancelDurationInMillis)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      autoCancelDurationInMillis,
    )
  }
}

@Suppress("UNCHECKED_CAST")
private object CameraInterfaceCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          AndroidFocusSettings.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          ExifPreferences.fromList(it)
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          PigeonSensorTypeDevice.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          PreviewSize.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          PreviewSize.fromList(it)
        }
      }
      133.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Sensor.fromList(it)
        }
      }
      134.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          VideoOptions.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is AndroidFocusSettings -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is ExifPreferences -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      is PigeonSensorTypeDevice -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is PreviewSize -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is PreviewSize -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      is Sensor -> {
        stream.write(133)
        writeValue(stream, value.toList())
      }
      is VideoOptions -> {
        stream.write(134)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface CameraInterface {
  fun setupCamera(sensors: List<Sensor>, aspectRatio: String, zoom: Double, mirrorFrontCamera: Boolean, enablePhysicalButton: Boolean, flashMode: String, captureMode: String, enableImageStream: Boolean, exifPreferences: ExifPreferences, callback: (Result<Boolean>) -> Unit)
  fun checkPermissions(): List<String>
  /**
   * Returns given [CamerAwesomePermission] list (as String). Location permission might be
   * refused but the app should still be able to run.
   */
  fun requestPermissions(saveGpsLocation: Boolean, callback: (Result<List<String>>) -> Unit)
  fun getPreviewTextureId(cameraPosition: Long): Long
  fun takePhoto(path: String, callback: (Result<Boolean>) -> Unit)
  fun recordVideo(path: String, options: VideoOptions?, callback: (Result<Unit>) -> Unit)
  fun pauseVideoRecording()
  fun resumeVideoRecording()
  fun receivedImageFromStream()
  fun stopRecordingVideo(callback: (Result<Boolean>) -> Unit)
  fun getFrontSensors(): List<PigeonSensorTypeDevice>
  fun getBackSensors(): List<PigeonSensorTypeDevice>
  fun start(): Boolean
  fun stop(): Boolean
  fun setFlashMode(mode: String)
  fun handleAutoFocus()
  /**
   * Starts auto focus on a point at ([x], [y]).
   *
   * On Android, you can control after how much time you want to switch back
   * to passive focus mode with [androidFocusSettings].
   */
  fun focusOnPoint(previewSize: PreviewSize, x: Double, y: Double, androidFocusSettings: AndroidFocusSettings?)
  fun setZoom(zoom: Double)
  fun setMirrorFrontCamera(mirror: Boolean)
  fun setSensor(sensors: List<Sensor>)
  fun setCorrection(brightness: Double)
  fun getMaxZoom(): Double
  fun setCaptureMode(mode: String)
  fun isMultiCamSupported(): Boolean
  fun setRecordingAudioMode(enableAudio: Boolean, callback: (Result<Boolean>) -> Unit)
  fun availableSizes(): List<PreviewSize>
  fun refresh()
  fun getEffectivPreviewSize(): PreviewSize?
  fun setPhotoSize(size: PreviewSize)
  fun setPreviewSize(size: PreviewSize)
  fun setAspectRatio(aspectRatio: String)
  fun setupImageAnalysisStream(format: String, width: Long, maxFramesPerSecond: Double?, autoStart: Boolean)
  fun setExifPreferences(exifPreferences: ExifPreferences, callback: (Result<Boolean>) -> Unit)
  fun startAnalysis()
  fun stopAnalysis()
  fun setFilter(matrix: List<Double>)

  companion object {
    /** The codec used by CameraInterface. */
    val codec: MessageCodec<Any?> by lazy {
      CameraInterfaceCodec
    }
    /** Sets up an instance of `CameraInterface` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: CameraInterface?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setupCamera", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val sensorsArg = args[0] as List<Sensor>
            val aspectRatioArg = args[1] as String
            val zoomArg = args[2] as Double
            val mirrorFrontCameraArg = args[3] as Boolean
            val enablePhysicalButtonArg = args[4] as Boolean
            val flashModeArg = args[5] as String
            val captureModeArg = args[6] as String
            val enableImageStreamArg = args[7] as Boolean
            val exifPreferencesArg = args[8] as ExifPreferences
            api.setupCamera(sensorsArg, aspectRatioArg, zoomArg, mirrorFrontCameraArg, enablePhysicalButtonArg, flashModeArg, captureModeArg, enableImageStreamArg, exifPreferencesArg) { result: Result<Boolean> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.checkPermissions", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.checkPermissions())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.requestPermissions", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val saveGpsLocationArg = args[0] as Boolean
            api.requestPermissions(saveGpsLocationArg) { result: Result<List<String>> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getPreviewTextureId", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val cameraPositionArg = args[0].let { if (it is Int) it.toLong() else it as Long }
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getPreviewTextureId(cameraPositionArg))
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.takePhoto", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val pathArg = args[0] as String
            api.takePhoto(pathArg) { result: Result<Boolean> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.recordVideo", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val pathArg = args[0] as String
            val optionsArg = args[1] as VideoOptions?
            api.recordVideo(pathArg, optionsArg) { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.pauseVideoRecording", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.pauseVideoRecording()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.resumeVideoRecording", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.resumeVideoRecording()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.receivedImageFromStream", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.receivedImageFromStream()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.stopRecordingVideo", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            api.stopRecordingVideo() { result: Result<Boolean> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getFrontSensors", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getFrontSensors())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getBackSensors", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getBackSensors())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.start", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.start())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.stop", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.stop())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setFlashMode", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val modeArg = args[0] as String
            var wrapped: List<Any?>
            try {
              api.setFlashMode(modeArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.handleAutoFocus", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.handleAutoFocus()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.focusOnPoint", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val previewSizeArg = args[0] as PreviewSize
            val xArg = args[1] as Double
            val yArg = args[2] as Double
            val androidFocusSettingsArg = args[3] as AndroidFocusSettings?
            var wrapped: List<Any?>
            try {
              api.focusOnPoint(previewSizeArg, xArg, yArg, androidFocusSettingsArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setZoom", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val zoomArg = args[0] as Double
            var wrapped: List<Any?>
            try {
              api.setZoom(zoomArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setMirrorFrontCamera", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val mirrorArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setMirrorFrontCamera(mirrorArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setSensor", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val sensorsArg = args[0] as List<Sensor>
            var wrapped: List<Any?>
            try {
              api.setSensor(sensorsArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setCorrection", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val brightnessArg = args[0] as Double
            var wrapped: List<Any?>
            try {
              api.setCorrection(brightnessArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getMaxZoom", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getMaxZoom())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setCaptureMode", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val modeArg = args[0] as String
            var wrapped: List<Any?>
            try {
              api.setCaptureMode(modeArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.isMultiCamSupported", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.isMultiCamSupported())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setRecordingAudioMode", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enableAudioArg = args[0] as Boolean
            api.setRecordingAudioMode(enableAudioArg) { result: Result<Boolean> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.availableSizes", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.availableSizes())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.refresh", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.refresh()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getEffectivPreviewSize", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getEffectivPreviewSize())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setPhotoSize", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val sizeArg = args[0] as PreviewSize
            var wrapped: List<Any?>
            try {
              api.setPhotoSize(sizeArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setPreviewSize", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val sizeArg = args[0] as PreviewSize
            var wrapped: List<Any?>
            try {
              api.setPreviewSize(sizeArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setAspectRatio", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val aspectRatioArg = args[0] as String
            var wrapped: List<Any?>
            try {
              api.setAspectRatio(aspectRatioArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setupImageAnalysisStream", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val formatArg = args[0] as String
            val widthArg = args[1].let { if (it is Int) it.toLong() else it as Long }
            val maxFramesPerSecondArg = args[2] as Double?
            val autoStartArg = args[3] as Boolean
            var wrapped: List<Any?>
            try {
              api.setupImageAnalysisStream(formatArg, widthArg, maxFramesPerSecondArg, autoStartArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setExifPreferences", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val exifPreferencesArg = args[0] as ExifPreferences
            api.setExifPreferences(exifPreferencesArg) { result: Result<Boolean> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.startAnalysis", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.startAnalysis()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.stopAnalysis", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.stopAnalysis()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setFilter", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val matrixArg = args[0] as List<Double>
            var wrapped: List<Any?>
            try {
              api.setFilter(matrixArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
