package com.bukable.lottery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RandomWebClient {

    private final WebClient client;

    @Value("${host}")
    private String host;

    @Value("${server.port}")
    private String port;

    public RandomWebClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://" + host + ":" + port).build();
    }

    public int getRandomNumber(int min, int max) {
        String url = "https://www.random.org/integers/?num=1&min=" +
                min +
                "&max=" +
                max +
                "&col=1&base=10&format=plain&rnd=new";

        String randomStr = this.client.get().uri(url).accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return Integer.parseInt(randomStr != null ? randomStr.replace("\n", "") : "0");
    }

}