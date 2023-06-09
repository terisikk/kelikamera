package com.teemurisikko.kelikamera.repository;

import com.teemurisikko.kelikamera.model.Camera;
import org.springframework.data.repository.ListCrudRepository;

public interface CameraRepository extends ListCrudRepository<Camera, Integer> {

}
