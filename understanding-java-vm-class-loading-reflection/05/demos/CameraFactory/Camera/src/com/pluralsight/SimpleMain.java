package com.pluralsight;

public class SimpleMain {

    public static void main(String[] args) {
        ICameraFactory cameraFactory = new NikonCameraFactory();
        ICamera camera = cameraFactory.createCamera();

        camera.takePhoto();
    }
}