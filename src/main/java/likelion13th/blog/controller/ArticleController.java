package likelion13th.blog.controller;

import likelion13th.blog.Service.ArticleService;
import likelion13th.blog.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping()
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        Article newArticle=articleService.addArticle(article);

        return ResponseEntity.status(HttpStatus.CREATED).body(newArticle);
    }

    @GetMapping()
        public ResponseEntity<List<Article>> getArticle() {
        List<Article> articles=new ArrayList<>();
            return ResponseEntity.status(HttpStatus.OK).body(articles);
        }
}
