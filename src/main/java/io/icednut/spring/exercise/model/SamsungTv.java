package io.icednut.spring.exercise.model;

/**
 * @author wangeun.lee@sk.com
 * @created 2017. 7. 21.
 */
public class SamsungTv implements Tv {
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
    public void volumeUp() { speaker.volumeUp(); }

    @Override
    public void volumeDown() { speaker.volumeDown(); }
}
