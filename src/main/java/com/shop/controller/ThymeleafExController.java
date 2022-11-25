package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "thymeleaf")
public class ThymeleafExController {
    @GetMapping("/ex02")
    public String thymeleafExample(Model model){
        // thymeleaf로 가져온 데이터를 model이 가지고 있음
//        model.addAttribute("data", "타임리프 예제입니다.");
//        return "thymeleafEx/thymeleafEx01";
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("기본 커피 입니다.");
        itemDto.setItemName("아메리카노");
        itemDto.setPrice(2500);
        itemDto.setRegTime(LocalDateTime.now());
        itemDto.setUpdateTime(LocalDateTime.now());
        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";

    }
    @GetMapping("/ex04")
    public String thymeleafExample04(Model model) { // Model 객체는 타임리프를 가리킴
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명 " + i);
            itemDto.setItemName("테스트 상품 " + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());
            itemDto.setUpdateTime(LocalDateTime.now());
            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }
    @GetMapping("/ex05")
    // 값을 넘겨줄 매개변수가 없음
    public String thymeleafExample05(){
        return "thymeleafEx/thymeleafEx05";
    }
    @GetMapping("/ex06")
    public String thymeleafExample06(String param1, String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleafEx/thymeleafEx06";
    }
    @GetMapping("/ex07")
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }

}
