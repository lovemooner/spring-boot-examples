package love.moon.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import love.moon.dto.NewsDTO;
import love.moon.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther lovemooner
 * @date 2020/2/29 23:47
 * @describe
 */
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ApiOperation(value = "查询图片素材")
    @PostMapping()
    public String send(@RequestBody NewsDTO newsDTO) {
        newsService.send(newsDTO);
        return "OK";
    }
}
