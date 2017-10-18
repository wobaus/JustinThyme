package com.JustinThyme.justinthymer.controllers.GroundControl;


import com.JustinThyme.justinthymer.models.data.PacketDao;
import com.JustinThyme.justinthymer.models.data.SeedDao;
import com.JustinThyme.justinthymer.models.data.UserDao;
import com.JustinThyme.justinthymer.models.forms.Packet;
import com.JustinThyme.justinthymer.models.forms.Seed;
import com.JustinThyme.justinthymer.models.forms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.length;


@Controller
@RequestMapping("JustinThyme")
public class MainController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SeedDao seedDao;

    @Autowired
    private PacketDao packetDao;


    @RequestMapping(value="")
    public String splash(Model model) {

        model.addAttribute("title", "Welcome to JustinThyme");
        return "splash";

    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Log on in!");
        model.addAttribute(new User());
        return "/login";
    }
    // @ModelAttribute @Valid User user, Error errors
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(Model model, User user) {
        User knownUser = userDao.findOne(user.getId());
        // User knownUser = userDao.findOne(findByUsername());

        if (user.getPassword() == knownUser.getPassword()) {
            model.addAttribute("user", user);
            return "/welcome-user";
        } else {
            model.addAttribute("title", "NO user by that name or incorrect password!");
            return "/login";
        }
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "New User!");
        model.addAttribute(new User());
        model.addAttribute("areas", Seed.Area.values());
        return "/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User newUser, Errors errors, Model model,
                      String passwordVerify) {

        String username = newUser.username;
        //newUser.checkPassword();
        if (errors.hasErrors()) {
            model.addAttribute("title", "Try again");
            model.addAttribute(newUser);
            model.addAttribute("areas", Seed.Area.values());
            return "/signup";

        } else {
            userDao.save(newUser);
            model.addAttribute("user", newUser);
            Seed.Area area = newUser.getArea();
            System.out.println("&&&&&&&&&&" + area);
            //Packet seeds = new Packet(newUser.getId(), seedDao.findByArea(area));
            List<Seed> seeds = new ArrayList<>();
            seeds = seedDao.findByArea(area);
            for (Seed seed:seeds) {
                System.out.println(seed.getName());
            }
            System.out.println("=============" + seeds.size());

            model.addAttribute("seeds", seeds);
            //return "/welcome-user";
            return "/seed-edit";
        }
    }

    @RequestMapping(value = "/seed-edit", method = RequestMethod.GET)
    public String showSeeds(Model model, User newUser) {
        Seed.Area area = newUser.getArea();
        //System.out.println("**********************" + area);
        model.addAttribute(new Packet());
        model.addAttribute("seeds", seedDao.findByArea(area));
        return "/seed-edit";
    }



    @RequestMapping(value = "/seed-edit", method = RequestMethod.POST)
    public String seedListing(Model model, @ModelAttribute Packet aPacket, @RequestParam List<Seed> seeds,
                              User currentUser) {
        for (Seed seed : seeds)
            aPacket.addSeed(seed);
        aPacket.setUser_id(currentUser.getId());
        packetDao.save(aPacket);
        model.addAttribute("user", currentUser);
        return "/welcome-user";


    }







}
