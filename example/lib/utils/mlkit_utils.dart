import 'package:camerawesome/camerawesome_plugin.dart';
import 'package:google_mlkit_face_detection/google_mlkit_face_detection.dart';

extension MLKitUtils on AnalysisImage {
  InputImage toInputImage() {
    // final planeData =
    //     when(nv21: (img) => img.planes, bgra8888: (img) => img.planes)?.map(
    //   (plane) {
    //     return InputImageMetadata(
    //       bytesPerRow: plane.bytesPerRow,
    //       height: height,
    //       width: width,
    //       size:
    //     );
    //   },
    // ).toList();

    return when(nv21: (image) {
      return InputImage.fromBytes(
        bytes: image.bytes,
        metadata: InputImageMetadata(
          rotation: inputImageRotation,
          format: InputImageFormat.nv21,
          size: image.size,
          bytesPerRow: image.planes.first.bytesPerRow,
        ),
      );
    }, bgra8888: (image) {
      final inputImageData = InputImageMetadata(
        size: size,
        // FIXME: seems to be ignored on iOS...
        format: InputImageFormat.bgra8888,
        rotation: inputImageRotation,
        bytesPerRow: image.planes.first.bytesPerRow,
      );

      return InputImage.fromBytes(
        bytes: image.bytes,
        metadata: inputImageData,
      );
    })!;
  }

  InputImageRotation get inputImageRotation =>
      InputImageRotation.values.byName(rotation.name);

  InputImageFormat get inputImageFormat {
    switch (format) {
      case InputAnalysisImageFormat.bgra8888:
        return InputImageFormat.bgra8888;
      case InputAnalysisImageFormat.nv21:
        return InputImageFormat.nv21;
      default:
        return InputImageFormat.yuv420;
    }
  }
}
