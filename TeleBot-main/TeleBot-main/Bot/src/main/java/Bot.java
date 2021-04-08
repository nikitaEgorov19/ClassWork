import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {

            setButtons(sendMessage);
            sendMessage(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void onUpdateReceived(Update update) {
        Model model = new Model();
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "Вы должны ввести название города и все\n" +
                            "/subscribe  -  функция подписки на расслыку прогноза погоды\n" +
                            "/unsubscribe - функция отписки от рассылки прогноза погоды\n");
                    break;
                case "/subscribe":
                    sendMsg(message, "Вы оформили подписку");
                    break;
                case "/unsubscribe":
                    sendMsg(message, "Вы отминили подписку");
                    break;
                case "/start" : sendMsg(message, "Привет! Я погодный бот, просто введите название города, и я покажу вам погоду :)");
                    break;
                case "Привет" : sendMsg(message, "Привет! Я погодный бот, просто введите название города, и я покажу вам погоду :)");
                    break;
                case "привет" : sendMsg(message, "Привет! Я погодный бот, просто введите название города, и я покажу вам погоду :)");
                    break;
                case "/about" : sendMsg(message, "Бот, сделанный Никитой Егоровым. Бот берет погоду из OpenWeather.");
                    break;
                default:
                    try {
                        sendMsg(message, Weather.getWeather(message.getText(), model));
                    } catch (IOException e) {
                        sendMsg(message, "Город не найден");
                    }
            }
        }

    }


    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/about"));
        keyboardSecondRow.add(new KeyboardButton("/subscribe"));
        keyboardSecondRow.add(new KeyboardButton("/unsubscribe"));

        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }

    public String getBotUsername() {
        return "DiamondWeatherBot";
    }

    public String getBotToken() {
        return "1445735592:AAEAUQ3mBYa1z4smXsPD5yzqtQcYkM8Uu6g";
    }


}
