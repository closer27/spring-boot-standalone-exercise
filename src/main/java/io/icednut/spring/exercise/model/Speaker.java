package io.icednut.spring.exercise.model;

import org.springframework.stereotype.Component;

@Component
public interface Speaker {
    void volumeUp();

    void volumeDown();
}
