package com.pluralsight;

/**
 * Created by kevinj.
 */
public class NikonCameraFactory implements ICameraFactory {
    @Override
    public ICamera createCamera() {
        return new NikonCamera();
    }
}

