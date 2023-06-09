package com.teemurisikko.kelikamera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.teemurisikko.kelikamera.model.Camera;
import com.teemurisikko.kelikamera.services.CameraService;

@SpringBootApplication
@RestController
public class KelikameraApplication {
	@Autowired
	CameraService cameraService;

	public static void main(String[] args) {
		SpringApplication.run(KelikameraApplication.class, args);
	}

	@GetMapping("/hello")
	public ResponseEntity<Camera> camera(@RequestParam(name = "id", defaultValue = "C12614") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(cameraService.getCamera(id));
	}
}
