package com.neo.byez.domain.user;

import java.util.Random;

// 인증번호를 보낼 때 사용할 클래스
// 같은 인증번호가 중복 생성되지 않도록 테이블 내 해당 컬럼값 조회해서 다시 재생성하는 기능 추가 필요 (-)
public class TempKey {
    private boolean lowerCheck;
    private int size;

    public String getKey(int size, boolean lowerCheck) {
        this.size = size;
        this.lowerCheck = lowerCheck;
        return init();
    }

    private String init() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num  = 0;
        do {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char) num);
            } else {
                continue;
            }
        } while (sb.length() < size);
        if (lowerCheck) {
            return sb.toString().toLowerCase();
        }
        return sb.toString();
    }
}