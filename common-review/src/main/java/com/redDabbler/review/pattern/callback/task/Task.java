package com.redDabbler.review.pattern.callback.task;

import com.redDabbler.review.pattern.callback.ICallback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task {


    public void execute(ICallback callback){

        log.info("execute  ........========");
        if (callback!=null){
            callback.success("invoke callback");
        }
    }


    public static void main(String[]args){
        Task task = new Task();
        task.execute(new ICallback() {
            @Override
            public void success(String response) {
                log.info("hello:{} I am done" ,response);
            }

            @Override
            public void fail(String response) {

            }
        });
    }
}
