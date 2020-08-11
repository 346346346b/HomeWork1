package serice;

public class SendMessageToConsole implements SendMessage{
    @Override
    public void sendMessage(String textMessage) {
        System.out.println(textMessage);
    }
}
