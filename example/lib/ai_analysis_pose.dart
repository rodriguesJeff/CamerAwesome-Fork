import 'package:camera_app/painters/pose_painter.dart';
import 'package:camera_app/utils/mlkit_utils.dart';
import 'package:camerawesome/camerawesome_plugin.dart';
import 'package:flutter/material.dart';
import 'package:google_mlkit_pose_detection/google_mlkit_pose_detection.dart';
import 'package:rxdart/rxdart.dart';

void main() {
  runApp(const CameraAwesomeApp());
}

class CameraAwesomeApp extends StatelessWidget {
  const CameraAwesomeApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'camerAwesome App Pose Detection',
      home: CameraPage(),
    );
  }
}

class CameraPage extends StatefulWidget {
  const CameraPage({super.key});

  @override
  State<CameraPage> createState() => _CameraPageState();
}

class _CameraPageState extends State<CameraPage> {
  final _poseDetectionController = BehaviorSubject<PoseDetectionModel>();

  final PoseDetector poseDetector =
      PoseDetector(options: PoseDetectorOptions());
  bool _canProcess = true;
  bool _isBusy = false;
  CustomPaint? _customPaint;
  bool isLoading = true;

  @override
  void deactivate() {
    poseDetector.close();
    super.deactivate();
  }

  @override
  void dispose() {
    _poseDetectionController.close();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CameraAwesomeBuilder.previewOnly(
        previewFit: CameraPreviewFit.contain,
        sensorConfig: SensorConfig.single(
          sensor: Sensor.position(SensorPosition.front),
          aspectRatio: CameraAspectRatios.ratio_4_3,
        ),
        onImageForAnalysis: (img) => _processImage(img),
        imageAnalysisConfig: AnalysisConfig(
          androidOptions: const AndroidAnalysisOptions.nv21(width: 250),
          maxFramesPerSecond: 30,
        ),
        // saveConfig: SaveConfig.photo(),
        builder: (state, previewSize, previewRect) {
          if (isLoading) {
            return const Center(
              child: CircularProgressIndicator(),
            );
          }
          return customPaint!;
        },
      ),
    );
  }

  CustomPaint? customPaint;

  Future<void> _processImage(AnalysisImage img) async {
    final inputImage = img.toInputImage();
    if (!_canProcess) return;
    if (_isBusy) return;
    _isBusy = true;
    final poses = await poseDetector.processImage(inputImage);
    if (inputImage.metadata?.size != null &&
        inputImage.metadata?.rotation != null) {
      final painter = PosePainter(
        poses,
        inputImage.metadata!.size,
        inputImage.metadata!.rotation,
        SensorPosition.back,
      );
      _customPaint = CustomPaint(painter: painter);
      setState(() {
        customPaint = _customPaint;
        isLoading = false;
      });
    } else {
      // _text = 'Poses found: ${poses.length}\n\n';
      // TODO: set _customPaint to draw landmarks on top of image
      _customPaint = null;
    }
    _isBusy = false;
    if (mounted) {
      setState(() {});
    }
  }
}
