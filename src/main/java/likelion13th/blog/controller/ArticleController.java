package likelion13th.blog.controller;

import likelion13th.blog.Service.ArticleService;
import likelion13th.blog.dto.request.AddArticleRequest;
import likelion13th.blog.dto.request.DeleteRequest;
import likelion13th.blog.dto.request.UpdateArticleRequest;
import likelion13th.blog.dto.response.ApiResponse;
import likelion13th.blog.dto.response.ArticleDetailResponse;
import likelion13th.blog.dto.response.ArticleResponse;
import likelion13th.blog.dto.response.SimpleArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/articles")
public class ArticleController {
    private final ArticleService articleService;

    /*게시글 추가*/
    @PostMapping
    public ResponseEntity<ApiResponse> createArticle(@RequestBody AddArticleRequest request){
        ArticleResponse response=articleService.addArticle(request);
        return ResponseEntity.ok(new ApiResponse(true,201,"게시글 등록 성공",response));

    }

    @GetMapping
    public ResponseEntity<ApiResponse> readAllArticles(){
        List<SimpleArticleResponse> articles=articleService.getAllArticles();
        return ResponseEntity.ok(new ApiResponse(true,200,"게시글 조회 성공",articles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> readArticle(@PathVariable long id){
        ArticleDetailResponse response=articleService.getArticle(id);
        return ResponseEntity.ok(new ApiResponse(true,200,"게시글 조회 성공",response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        ArticleResponse response=articleService.updateArticle(id,request);
        return ResponseEntity.ok(new ApiResponse(true,204,"게시글 수정",response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteArticle(@PathVariable long id, @RequestBody DeleteRequest request){
        articleService.deleteArticle(id,request);
        return ResponseEntity.ok(new ApiResponse(true,204,"게시글 삭제 성공"));
    }


}

