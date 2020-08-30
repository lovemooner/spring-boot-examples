package test.love.moon;
import love.moon.pojo.DemoObj;
import org.apache.http.HttpHeaders;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;



/**
 * reference: https://www.zifangsky.cn/1343.html
 *
 * @author dongnan
 * @date 2020/8/26 18:05
 */
public class TestWebClient {

    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .defaultHeader(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)")
            .defaultCookie("ACCESS_TOKEN", "test_token").build();

    /**
     * 测试GET请求
     */
    @Test
    public void testGetMethod(){
        Mono<DemoObj> response = webClient.get().uri("/person/testGetHeader")
                .retrieve()
                .onStatus(HttpStatus::isError, res -> Mono.error(new RuntimeException("----"+res.statusCode().value() + ":" + res.statusCode().getReasonPhrase())))
                .bodyToMono(DemoObj.class).timeout(Duration.of(10, ChronoUnit.SECONDS))
//                .doAfterSuccessOrError((obj, ex) -> {
//                    System.out.println(obj);
//
//                    if(ex != null){
//                        ex.printStackTrace();
//                    }
//                })
                .doOnError(e -> {
                    System.out.println(e.getMessage());
                });

        Optional<DemoObj> demoObjOptional = response.blockOptional();
        demoObjOptional.ifPresent(e->{
            System.out.println(e);
        });
    }

    /**
     * 测试POST表单请求
     */
    @Test
    public void testPostValue(){
        MultiValueMap<String,String> formData = new LinkedMultiValueMap<>(2);
        formData.add("id", "1");
        formData.add("name", "admin");

        Mono<DemoObj> response = webClient.post().uri("/rest/testPostValue")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(DemoObj.class).timeout(Duration.of(10, ChronoUnit.SECONDS));

        DemoObj demoObj = response.block();
        System.out.println(demoObj);
    }

    /**
     * 测试POST传JSON请求（使用json字符串）
     */
    @Test
    public void testPostJson(){
        Mono<DemoObj> response = webClient.post().uri("/rest/testPostJson")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject("{\"id\":1,\"name\":\"admin\"}"))
                .retrieve()
                .bodyToMono(DemoObj.class).timeout(Duration.of(10, ChronoUnit.SECONDS));

        DemoObj demoObj = response.block();
        System.out.println(demoObj);
    }

    /**
     * 测试POST传JSON请求（使用Java Bean）
     */
    @Test
    public void testPostJson2(){
        DemoObj requestData = new DemoObj();
        requestData.setId(1);
        requestData.setName("admin");

        Mono<DemoObj> response = webClient.post().uri("/rest/testPostJson")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .body(Mono.just(requestData), DemoObj.class)
                .syncBody(requestData)
                .retrieve()
                .bodyToMono(DemoObj.class).timeout(Duration.of(10, ChronoUnit.SECONDS));

        DemoObj demoObj = response.block();
        System.out.println(demoObj);
    }

}
