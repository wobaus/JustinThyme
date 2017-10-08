package com.JustinThyme.justinthymer.controllers.TwillioReminder;

import com.JustinThyme.justinthymer.models.forms.Seed;
import com.JustinThyme.justinthymer.models.forms.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Timer;


@Controller
@RequestMapping(value="") //note we'll have to figure out where to map this function to or just use internally
public class TwillController {


    @RequestMapping(value="set-reminders", method = RequestMethod.POST)
    //note do we want to use Forms attributes or just the data from the objects??
    public String message(Model model, @ModelAttribute User user, Seed seed) {
        Timer timer = new Timer(true); //note makes thread a daemon thread only executes as long as the program is running


        String number = user.getPhoneNumber(); ;//note will only work with my number for now
        // vs.  String number = userForm.getNumber()
        String message = seed.getMessage();
        Date date = seed.plantDate;

        //note for this example, message waits 2000 miliseconds, then repeats every 10000 milseconds
        //timer.schedule(new TwillTask.TwillReminder(message, number), 2000, 10000);
        //note can schedule task for specific date at a specific time schedule(Task, Date target)
        //Date(year - 1900, month(0-11), day-of-month, hour(24), minute)
        //note below for testing will use seeds plantDate field for production
        //Date date = new Date(117, 9, 7, 19, 41);//note this Date format is deprecated but it works so well!
        timer.schedule(new TwillTask.TwillReminder(message, number), date); //does this send at midnight?
        //timer.cancel(); //may be needed to stop the reminders running all day if time-of-day not stated
        //note can schedule task for date and repeate every year (Task, Date target, long repeat) where repeat = 1year in milliseconds?
        //timer.schedule(new TwillTask.TwillReminder(message, number),10/8,31557600000);//too long !!
        //maybe add a counter function to add date++ to year ?
        return "/sent";
    }
}
