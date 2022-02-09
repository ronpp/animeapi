package com.example.animeapi.services;


import com.example.animeapi.domains.dto.RequestFavorite;
import com.example.animeapi.domains.dto.RequestNewUser;
import com.example.animeapi.domains.dto.ResponseUser;
import com.example.animeapi.domains.models.Favorite;
import com.example.animeapi.domains.models.User;
import com.example.animeapi.domains.models.projections.ProjectionFavorite;
import com.example.animeapi.domains.models.projections.ProjectionUser;
import com.example.animeapi.domains.models.projections.ProjectionUserDetail;
import com.example.animeapi.repositories.AnimeRepository;
import com.example.animeapi.repositories.FavoriteRepository;
import com.example.animeapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    public boolean ifExist(String username){
        return userRepository.findByUsername(username) != null;
    }

    public UUID getUserId(String username){
        return userRepository.findByUsername(username).userid;
    }

    public List<ProjectionUser> getAllUsers(){
        return userRepository.findBy();
    }

    public ProjectionUserDetail getUserById(UUID userId){
        return userRepository.findByUserid(userId, ProjectionUserDetail.class);
    }

    public ResponseUser addNewUser(RequestNewUser newUser){
        User user = new User();
        user.username = newUser.username;
        user.password = passwordEncoder.encode(newUser.password);
        user.enabled = true;
        userRepository.save(user);
        return ResponseUser.user(user);
    }

    public void deleteUser(UUID userId){
        userRepository.deleteById(userId);
    }




    // FAVORITES
    public List<ProjectionFavorite> getUserFavorites(String username){
       return favoriteRepository.findByUserid(getUserId(username)).stream()
               .map(favorite ->
                   animeRepository.findByAnimeid(favorite.animeid, ProjectionFavorite.class))
               .collect(Collectors.toList());

    }

    public Favorite addFavoriteToUser(RequestFavorite newFavorite, String username){
        Favorite favorite = new Favorite();
        favorite.userid = getUserId(username);
        favorite.animeid = newFavorite.animeid;
        favoriteRepository.save(favorite);
        return favorite;
    }

}
