package _2_bean_lifecycle.bean.camera;

import _2_bean_lifecycle.bean.camera_roll.CameraRoll;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CameraImpl implements Camera {

    private CameraRoll cameraRoll;

    public CameraImpl() {
    }

    @Override
    @PostConstruct
    public void ready() {
        System.out.println("Camera is ready");
    }

    @Override
    @PreDestroy
    public void extractRoll() {
        cameraRoll = null;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }
}
