package likelion13th.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import likelion13th.blog.dto.response.ApiResponse;
import likelion13th.blog.dto.request.DeleteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import likelion13th.blog.Service.CommentService;
import likelion13th.blog.dto.request.AddCommentRequest;
import likelion13th.blog.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{articleId}")
    public ResponseEntity<ApiResponse> createComment(@PathVariable long articleId,
                                                     @RequestBody AddCommentRequest request) {
        CommentResponse response = commentService.addComment(articleId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body((new ApiResponse(true, 201, "댓글 등록 성공", response)));

    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable long commentId, @RequestBody DeleteRequest request) {
        commentService.deleteComment(commentId, request);
        return ResponseEntity.ok(new ApiResponse(true, 200, "댓글 삭제 성공"));
    }
}

