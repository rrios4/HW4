package com.CIS3368.HW4.api;
import com.CIS3368.HW4.model.Joke;

import com.CIS3368.HW4.model.JokeRepo;
import com.CIS3368.HW4.service.JokeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.UUID;

@Controller
public class jokeRestController {
    @Autowired
    private JokeService jokeService;

    @Autowired
    private JokeRepo jokeRepo;

    @RequestMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        String jokeString = "";
        String completeFact ="";
        String apikey = "5996236b48mshe1bed2116d9f65dp1447f4jsn41f09f77963f";
        try
        {
            URL url = new URL("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", "5996236b48mshe1bed2116d9f65dp1447f4jsn41f09f77963f");
            connection.connect();
            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                json.append(line);
            }
            JSONObject obj = new JSONObject(json.toString());
            jokeString = obj.getString("value");
            completeFact = jokeString;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        mv.addObject("list", jokeRepo.findAll());
        mv.addObject("fact", completeFact);
        return mv;
    }
    // On the UI side I was able to display the current joke that was loaded off the API.
    //This post request gets the input information which is fact that is coded in the UI side and once clicked it saves the information in the database.
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id,@RequestParam("jokes") String jokeStatement){
        ModelAndView mv = new ModelAndView("redirect:/");
        Joke jokeToSave;
        if(!id.isEmpty())
        {
            Optional<Joke> statements = jokeRepo.findById(id);
            jokeToSave = statements.get();

        }
        else
        {
            jokeToSave = new Joke();
            jokeToSave.setId(UUID.randomUUID().toString());
        }
        jokeToSave.setJoke(jokeStatement);
        jokeRepo.save(jokeToSave);
        mv.addObject("list", jokeRepo.findAll());
        return mv;
    }
    //I created this so it can load a list of all the jokes in a table once the request was made but it never filled the table
    //I ended up just adding the mv object in the list to display the raw information to let the user know that the database is holding the information.
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("jokesmodel", jokeService.listAllJokes() );
        return "redirect:/";
    }



    }








