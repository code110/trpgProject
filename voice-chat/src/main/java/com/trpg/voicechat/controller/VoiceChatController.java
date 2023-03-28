package com.trpg.voicechat.controller;

import com.trpg.voicechat.model.VoiceMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class VoiceChatController {

    @MessageMapping("voice-room/{roomUuid}")
    @SendTo("/voice-topic/voice-room/{roomUuid}")
    public VoiceMessage forwardVoiceMessage(@DestinationVariable String roomUuid, VoiceMessage voiceMessage){
        return voiceMessage;
    }
}
