package _2_bean_lifecycle.bean.camera_roll;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
@OldCameraRoll(usingCameraRollClass=ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll {
}
