package smu.FittingPair.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import smu.FittingPair.util.response.BaseResponse;
import smu.FittingPair.dto.UserStylingRequestDto;
import smu.FittingPair.service.UserClothesService;
import smu.FittingPair.service.UserResultService;

@RestController
@RequiredArgsConstructor
public class ResultController {

    private final UserResultService userResultService;
    private final UserClothesService userClothesService;

    //체형 측정 후 바로 조회
    @GetMapping("/result/{imgId}")
    public BaseResponse<?> getNewResult(@PathVariable("imgId") Long imgId){
        return BaseResponse.ok(userResultService.getResultByImgId(imgId));
    }
    // 옷 스타일링
    @PostMapping("/result/styling/{resultId}")
    public BaseResponse<?> makeUserStyling(@PathVariable("resultId") Long resultId, @RequestBody UserStylingRequestDto userStylingRequestDto){
        return BaseResponse.ok(userClothesService.makeUserStyling(resultId,userStylingRequestDto));
    }
    @GetMapping("/mypage/result/{resultId}")
    public BaseResponse<?> getOneResult(@PathVariable("resultId") Long resultId){
        return BaseResponse.ok(userResultService.getOneResult(resultId));
    }
    //todo: 마이페이지 삭제 로직 마이페이지에 사용자 결과 하나 삭제하기
    @DeleteMapping("/result/{resultId}")
    public BaseResponse<?> deleteMyPage(@PathVariable("resultId") Long resultId) {
        userResultService.deleteResult(resultId);
        return BaseResponse.ok();
    }

}
