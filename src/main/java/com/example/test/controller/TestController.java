package com.example.test.controller;

// import java.util.Arrays;
// import java.util.List;

// 載入兩個Library
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import com.example.test.util.ResponseBody;

// 標記為Restful API Controller
@RestController
public class TestController {
    // 標記HTTP Get方法，並設定URL的路由
    @GetMapping("/hello")
    public String Hello() {
        return "Hellooo1";
    }

    // public ResponseBody Hello() {
    // List<String> dataArray = Arrays.asList();
    // return new ResponseBody(true, "OK", dataArray, 0);
    // }
}
