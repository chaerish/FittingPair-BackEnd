package smu.FittingPair.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter @Setter @Entity
public class UserImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userImg_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;


    private String image_url;
    private String created_at ;


    @Builder
    public UserImg(Users users, String image_url) {
        this.users = users;
        this.image_url = "http://localhost:8080/Ai/sendImg/" + image_url;
        this.created_at = LocalDateTime.now().toString();
    }

    public static UserImg saveImg (Users users,String imgurl) {
        return UserImg.builder()
                .users(users)
                .image_url(imgurl)
                .build();
    }


}



