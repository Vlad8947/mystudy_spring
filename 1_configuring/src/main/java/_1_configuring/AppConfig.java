package _1_configuring;

import _1_configuring.with_config_file.Camera;
import _1_configuring.with_config_file.CameraRoll;
import _1_configuring.with_config_file.ColorCameraRoll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("_1_configuring.with_annotation")
public class AppConfig {

    @Bean
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

    @Bean
    public Camera camera(/*отдает бин с тем же именем*/ CameraRoll cameraRoll) {
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }

}
