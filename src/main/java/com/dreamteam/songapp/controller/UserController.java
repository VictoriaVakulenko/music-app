package com.dreamteam.songapp.controller;

import com.dreamteam.songapp.dto.UserRegistrationDto;
import com.dreamteam.songapp.enteties.Playlist;
import com.dreamteam.songapp.enteties.Song;
import com.dreamteam.songapp.enteties.User;
import com.dreamteam.songapp.repository.SongRepository;
import com.dreamteam.songapp.service.PlaylistService;
import com.dreamteam.songapp.service.SongService;
import com.dreamteam.songapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private SongService songService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @ModelAttribute("playlist")
    public Playlist playlist(){return new Playlist();}

    @ModelAttribute("song")
    public  Song song(){return new Song();}

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        return "registration.html";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration.html";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }


    @GetMapping("/login")
    public String login(Model model) {
        return "login.html";
    }

    // Admin

    @GetMapping("/admin")
    public String admin(Model model){
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return  "admin.html";
    }

    @GetMapping(value = "/delete_user/{id}")
    public String handleUserDelete(@PathVariable(required = true, name = "id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/accessDenied")
    public String handleErrors(Model model){return "error_pages/accessDenied.html";}

    @GetMapping("/admin/content")
    public String manageContent(Model model){
        List<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "admin/manageContent.html";
    }

    @GetMapping("/edit_song")
    public String editForm(@RequestParam(name = "songId") String id, Model model){
        Song song = songRepository.findByName(id);
        model.addAttribute("song", song);
        return "admin/editContent.html";
    }

    @PostMapping("/edit_song")
    public String updateSong(@ModelAttribute("song") Song song){
        songService.updateSong(song);
        return "redirect:/admin/content";
    }

    @GetMapping("/delete_song/{id}")
    public String deleteSong(@PathVariable(required = true, name = "id") Long id){
        songRepository.deleteById(id);
        return "redirect:/admin/content";
    }

    @GetMapping("/admin/db")
    public String dbLogging(Model model){return "admin/dbLogs.html";}

    // User

    @GetMapping("/user")
    public String userPage(Principal principal, Model model){
        String currentUser = principal.getName();
        User user = userService.findByEmail(currentUser);
        model.addAttribute("username", user.getLogin());

        List<Playlist> playlists = playlistService.getAllUserPlaylists(user.getId());
        model.addAttribute("playlists", playlists);

        return "user/userPage.html";
    }

    @PostMapping("/user")
    public String addPlaylist(@ModelAttribute("playlist") Playlist playlist, Principal principal, Model model){
        String playlistName = playlist.getName();
        String currentUser = principal.getName();
        User user = userService.findByEmail(currentUser);
        playlistService.addPlaylist(playlistName, user.getId());
        return "redirect:/user";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}
