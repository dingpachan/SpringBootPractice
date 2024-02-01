package com.example.test.util;

import java.util.List;

public class ResponseBody {
    // 回傳狀態代碼(自定義)
    private Boolean Result;
    // 回傳狀態訊息(自定義)
    private String Message;
    // 回傳資料，型別為Object，讓回傳的資料型別可以更多樣化
    // private Object Data;
    private List<Object> Data;
    // 回傳資料數量
    private Integer TotalCount;

    public ResponseBody(Boolean Result, String Message, List<Object> Data, Integer TotalCount) {
        this.Result = Result;
        this.Message = Message;
        this.Data = Data;
        this.TotalCount = TotalCount;
    }

    public Boolean getResult() {
        return Result;
    }

    public void setResult(Boolean Result) {
        this.Result = Result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<Object> getData() {
        return Data;
    }

    public void setData(List<Object> Data) {
        this.Data = Data;
    }

    // public Object getData() {
    // return Data;
    // }

    // public void setData(String Data) {
    // this.Data = Data;
    // }

    public Object getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer TotalCount) {
        this.TotalCount = TotalCount;
    }
}
