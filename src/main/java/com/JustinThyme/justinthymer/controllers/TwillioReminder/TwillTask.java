package com.JustinThyme.justinthymer.controllers.TwillioReminder;

import java.util.Timer;
import java.util.TimerTask;

import static com.JustinThyme.justinthymer.controllers.TwillioReminder.TwillSend.twill_away;



public class TwillTask {
    Timer timer;

    public void TwillSendExample(int seconds) {
        timer = new Timer();
        String message = null;
        String number = null;
        timer.schedule(new TwillReminder(message, number), seconds + 1000); //note wait time in milliseconds
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
            twill_away(message, number);
            //timer.cancel(); //cancel in controller
        }

    }

}
