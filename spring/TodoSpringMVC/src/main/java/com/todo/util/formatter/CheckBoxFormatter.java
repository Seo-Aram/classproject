package com.todo.util.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckBoxFormatter implements Formatter<Boolean> {
    /**
     * 문자열로 데이터를 받아오지만 반환 형 타입이 Boolean일 때 포맷 처리를 해줌
     * @param text the text string
     * @param locale the current user locale
     * @return
     * @throws ParseException
     */
    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        if(text == null) {
            return false;
        }
        return text.equals("on");
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
