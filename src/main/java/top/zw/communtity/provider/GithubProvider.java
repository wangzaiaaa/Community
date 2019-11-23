package top.zw.communtity.provider;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import okhttp3.*;
import org.springframework.stereotype.Component;
import top.zw.communtity.dto.AccessTokenDTO;
import top.zw.communtity.dto.GithubUser;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType meidaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(meidaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string =  response.body().string();
            String [] split = string.split("&");
            String tokenstr = split[0];
            String token = tokenstr.split("=")[1];
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser githubUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        }catch (IOException e){

        }
        return null;
    }

}
