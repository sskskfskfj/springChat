package spring.test.test;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType{
        ENTER, TALK, JOIN
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
