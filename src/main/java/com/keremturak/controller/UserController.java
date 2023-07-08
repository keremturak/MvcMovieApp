package com.keremturak.controller;


import com.keremturak.dto.request.FavMovieRequestDto;
import com.keremturak.dto.request.UserLoginRequestDto;
import com.keremturak.dto.request.UserRegisterRequestDto;
import com.keremturak.dto.response.MovieAdminPageResponseDto;
import com.keremturak.dto.response.UserLoginResponseDto;
import com.keremturak.dto.response.UserRegisterResponseDto;
import com.keremturak.entity.User;
import com.keremturak.entity.UserType;
import com.keremturak.mapper.IMovieMapper;
import com.keremturak.service.GenreService;
import com.keremturak.service.MovieService;
import com.keremturak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //register işlemi
    //daha önceden o email ile kayıt olunmuş mu kontrol edelim
    //eğer veritabanında o email var ise hata fırlatalım
    //yoksa kaydetsin
    //dto, repository, service katmanını, mapper0

    //Login sayfasını getirelim

    //kullanıcı login olsun eğer kullanıcı bilgileri doğru ise Giriş Başarılı yazsın
    //hatalıylsa hatalı yazsın

    private final UserService userService;
    private final MovieService movieService;
    private final GenreService genreService;
    private final MovieController movieController;

    @GetMapping("/registerPage")
    public ModelAndView getRegisterPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterRequestDto dto) {
        String error = "";
        ModelAndView modelAndView = new ModelAndView();
        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        try {
            responseDto = userService.save(dto);
            System.out.println("dto--->  " + responseDto);
            modelAndView.addObject("email", responseDto.getEmail());
            modelAndView.setViewName("loginSayfasi");
        } catch (Exception ex) {
            error = ex.getMessage();
            modelAndView.setViewName("register");
            modelAndView.addObject("error", error);
        }
        return modelAndView;
    }

    @GetMapping("/loginPage")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginSayfasi");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView doLogin(UserLoginRequestDto dto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            UserLoginResponseDto responseDto = userService.login(dto);
            if (responseDto.getUserType().equals(UserType.ADMIN)){
                return admingPage();
            }
            return movieController.getMoviePage(responseDto,null);
        } catch (Exception e) {
            modelAndView.addObject("result", e.getMessage());
            modelAndView.setViewName("loginSayfasi");
        }
        return modelAndView;
    }

    @GetMapping("/admin")
    private ModelAndView admingPage() {
        ModelAndView modelAndView = new ModelAndView();
        //find alla bütün userleri çekelim çektiğimz userların usertype ADMIN olmayanları listeleyelim
        List<User> users = userService.findAllUser();
        modelAndView.addObject("users",users);
        //Mapperini yazarken Liste verelim bize derikt List<MovieAdminPageResponseDto> dönsün
        List<MovieAdminPageResponseDto> movies = IMovieMapper.INSTANCE.toMovieAdminPageResponseDto(movieService.findAll());
        modelAndView.addObject("movies",movies);

        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/addfavmovies")
    public ModelAndView addFavMovies(FavMovieRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        userService.addFavmovies(dto);
        modelAndView.addObject("id",dto.getMovieId());
        modelAndView.addObject("userId",dto.getUserId());
        modelAndView.setViewName("redirect:/movie/findbyid");
        return modelAndView;
    }
    @GetMapping("/removefavmovies")
    public ModelAndView removeFavMovies(FavMovieRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        userService.removeFavmovies(dto);
        modelAndView.addObject("id",dto.getMovieId());
        modelAndView.addObject("userId",dto.getUserId());
        modelAndView.setViewName("redirect:/movie/findbyid");
        return modelAndView;
    }
}