package com.JustinThyme.justinthymer.controllers.TwilioReminder;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
//import com.JustinThyme.justinthymer.controllers.TwilioReminder.TwillSend.*;

public class TwillTask {
    Timer timer;

    public void TwillSendExample(int seconds) {
        timer = new Timer();
        String message = null;
        String number = null;

        timer.schedule(new TwillReminder(message, number), seconds + 1000); //note wait time in milliseconds
        //timer.schedule(new TwillTask.TwillReminder(message, number), date);
    }


    static class TwillReminder extends TimerTask {
        String message;
        String number;

        public TwillReminder(String message, String number) {
            this.message = message;
            this.number = number;
        }
        @Override
        public void run() {
            TwillSend.twill_away(message, number);
            //timer.cancel(); //cancel in controller
        }

    }

}
