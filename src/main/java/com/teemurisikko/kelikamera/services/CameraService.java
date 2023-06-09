package com.teemurisikko.kelikamera.services;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.teemurisikko.kelikamera.model.Camera;

@Service
public class CameraService {
    public static HttpGraphQlClient client = HttpGraphQlClient
            .builder(WebClient.create("https://api.oulunliikenne.fi/proxy/graphql")).build();

    public Camera getCamera(String cameraId) {
        String document = String.format("""
                query {
                    weatherCamera(id: \"%s\") {
                      cameraId
                      name
                      presets {
                        imageUrl
                      }
                    }
                  }
                """, cameraId);

        Mono<Camera> cameraMono = client.document(document)
                .retrieve("weatherCamera")
                .toEntity(Camera.class);

        return cameraMono.block();
    }

}
