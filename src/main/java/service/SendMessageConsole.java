package service;

public class SendMessageConsole implements SendMessage{
    @Override
    public void sendMessage(String textMessage) {
        System.out.println(textMessage);
    }
}
