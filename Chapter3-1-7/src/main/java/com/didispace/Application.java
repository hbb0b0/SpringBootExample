package com.didispace;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    class HelloController {


        //{"userName":"hbb0b0","birthday":"2019-02-12","createDate":"2019-02-02T12:00:00.000"}
        @PostMapping("/user")
        public UserDto user(@RequestBody UserDto userDto) throws Exception {
            //userDto.createDate = new Date();
            return userDto;
        }

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class UserDto {

        private String userName;
        private LocalDate birthday;
        private Date createDate;

    }

    @Bean
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //去掉objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        /**/
        //{
        //    "userName": "hbb0b0",
        //    "birthday": [
        //        2019,
        //        2,
        //        12
        //    ],
        //    "createDate": 1549108800000
        //}
        //正常的输出
        /*
        {
            "userName": "hbb0b0",
                "birthday": "2019-02-12",
                "createDate": "2019-02-02T12:00:00.000+0000"
        }
        */
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

}
