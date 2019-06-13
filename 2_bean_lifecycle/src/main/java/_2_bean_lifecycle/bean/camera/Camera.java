package _2_bean_lifecycle.bean.camera;

public interface Camera {

    default void doPhotograph() {
        System.out.println("photo");
    }

    void ready();

    void extractRoll();
}
