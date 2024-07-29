package smu.FittingPair.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import smu.FittingPair.model.BodyShape;
import smu.FittingPair.model.UserBodyType;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResultResponseDto {
    //todo: 의류 넣기
    private String objFile;
    private String bodyTypeName;
    private String bodyTypeFeature;
    private String bodyTypeCareful;
//    private List<TopClothes> top;
//    private List<ButtomClothes> buttom;

    public static UserResultResponseDto to(String objFile, String bodyTypeName,
                                 String bodyTypeFeature, String bodyTypeCareful) {
        return new UserResultResponseDto(objFile,bodyTypeName,bodyTypeFeature,bodyTypeCareful);
    }

}
