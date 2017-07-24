package io.icednut.spring.exercise.model;

public class SonySpeaker {
    public SonySpeaker() {
        System.out.println("===> SonySpeaker 객체 생성");
    }
    public void volumeUp() {
        System.out.println("SonySpeaker 볼륨 올림");
    }
    public void volumeDown() {
        System.out.println("SonySpeaker 볼륨 내림");
    }
}
