package com.trpg.voicechat.model;

public class VoiceMessage {

    private String from;
    private String audioData;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAudioData() {
        return audioData;
    }

    public void setAudioData(String audioData) {
        this.audioData = audioData;
    }
}
