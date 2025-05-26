package likelion13th.blog.dto;

import lombok.Getter;

public class UpdateArticleRequesst {
    @Getter
    public class UpdateArticleRequest {
        private String title;
        private String content;
        private String password;
    }
}
