package com.example.converter;

import com.example.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by tom on 2016/5/15.
 */
public class TomMessageConverter extends AbstractHttpMessageConverter<Person> {
    Logger logger = LoggerFactory.getLogger(TomMessageConverter.class);

    //自定义媒体类型
    public TomMessageConverter() {//application/x-tom
        super(new MediaType("application", "x-tom", Charset.forName("UTF-8")));
    }

    //从request里获得构造Person实例的数据
    @Override
    protected Person readInternal(Class<? extends Person> clazz,
                                  HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(),

                Charset.forName("UTF-8"));
        logger.debug("readInternal{}", temp);
        String[] tempArr = temp.split("-");
        return new Person(tempArr[0], tempArr[1]);
    }

    //只支持Person类
    @Override
    protected boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    //将person实例转换成你想要的字符串格式
    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        String out = "entity:" + person.getFirstName() + "-" + person.getLastName();
        logger.debug("writeInternal{}", out);
        outputMessage.getBody().write(out.getBytes());
    }

}