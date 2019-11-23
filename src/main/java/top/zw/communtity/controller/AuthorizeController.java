package top.zw.communtity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.zw.communtity.dto.AccessTokenDTO;
import top.zw.communtity.dto.GithubUser;
import top.zw.communtity.provider.GithubProvider;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider provider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret );
        String accessToken = provider.getAccessToken(accessTokenDTO);
        GithubUser user = provider.githubUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}