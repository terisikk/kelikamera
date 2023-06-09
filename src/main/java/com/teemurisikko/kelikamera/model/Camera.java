package com.teemurisikko.kelikamera.model;

import java.util.List;

public record Camera(
        String cameraId,
        String name,
        List<Preset> presets) {
}