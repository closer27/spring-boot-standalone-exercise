package io.icednut.spring.exercise.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsungTv")
public class SamsungTv implements Tv {

    @Autowired
    @Qualifier("appleSpeaker")
    private Speaker speaker;
    private int price;

    public SamsungTv() {
        System.out.println("===> Samsung Tv 객체 생성(1)");
    }

    public SamsungTv(Speaker speaker) {
        System.out.println("===> Samsung Tv 객체 생성(2)");
        this.speaker = speaker;
    }

    public SamsungTv(Speaker speaker, int price) {
        System.out.println("===> Samsung Tv 객체 생성(3)");
        this.speaker = speaker;
        this.price = price;
    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("===> setSpeaker() 호출");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        System.out.println("===> setPrice() 호출");
        this.price = price;
    }

    @Override
    public void powerOn() {
        System.out.println("Samsung Tv -- 전원켜기");
    }

    @Override
    public void powerOff() { System.out.println("Samsung Tv -- 전원끄기"); }

    @Override
    public void volumeUp() { this.speaker.volumeUp(); }

    @Override
    public void volumeDown() { this.speaker.volumeDown(); }
}
