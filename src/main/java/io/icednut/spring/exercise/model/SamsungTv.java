package io.icednut.spring.exercise.model;

/**
 * @author wangeun.lee@sk.com
 * @created 2017. 7. 21.
 */
public class SamsungTv implements Tv {
    private SonySpeaker speaker;

    public SamsungTv() {
        System.out.println("===> Samsung Tv 객체 생성");
    }

    public SamsungTv(SonySpeaker speaker) {
        this.speaker = speaker;
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
