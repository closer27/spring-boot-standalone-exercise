package io.icednut.spring.exercise.model;

import org.springframework.stereotype.Component;

@Component
public interface Tv {
    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
}
