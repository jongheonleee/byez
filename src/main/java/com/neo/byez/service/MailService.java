package com.neo.byez.service;

import com.neo.byez.dao.UserDaoImpl;
import com.neo.byez.domain.MailHandler;
import com.neo.byez.domain.TempKey;
import com.neo.byez.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class MailService {
    private final String subject = "[EZBY 인증메일 입니다.]";
    private final String title = "<h1>EZBY 메일인증</h1>";
    private final String content = "<br>EZBY를 찾아주셔서 감사합니다!" + "<br>인증번호: ";
    private final String senderName = "EZBY";
    private final String senderEmail = "parksuuuun@gmail.com";

    @Autowired
    UserDaoImpl userDao;
    @Autowired(required=false) JavaMailSender mailSender;

    // 인증번호 생성 메서드 makeRandomMailKey()
    public String makeRandomMailKey() {
        return new TempKey().getKey(6, false);
    }

    // 메일 전송 메서드 send()
    public void send(String recipient, String mail_key) throws Exception {
        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject(subject);
        sendMail.setText(
                title + content + mail_key
        );
        sendMail.setFrom(senderEmail, senderName);
        sendMail.setTo(recipient);
        sendMail.send();
    }

    // 아이디, 비밀번호 찾기 시 사용할 메일 인증 메서드
    public void sendMailToUser(UserDto userDto) throws Exception {
        String recipient = userDto.getEmail();

        // 1. 6자리 랜덤키 생성
//        String mail_key = new TempKey().getKey(6, false);
        String mail_key = makeRandomMailKey();
        // 2. 매개변수로 받은 userDto 객체에 인증번호 저장
        System.out.println("메일 인증번호 저장 전 userDto: " + userDto);
        userDto.setMail_key(mail_key);
        System.out.println("메일 인증번호 저장 후 userDto: " + userDto);

        // 3. 인증번호까지 저장한 매개변수로 받은 객체를 DB에 저장
        userDao.updateMailKey(userDto);

        // 4. 고객에게 인증번호 포함된 메일 전송
        send(recipient, mail_key);
    }

    // 회원가입 시 사용할 메일 인증 메서드
    public String sendMailToNonMember(String recipient) {
        // 1. 6자리 랜덤키 생성
        String mail_key = makeRandomMailKey();

        // 2. 메일 전송
        // 3. 메일을 전송하는 메서드 send() 실행 중 예외 발생 시 Null 반환
        // 4. 메일 전송 성공 시 인증번호 반환 (인증번호 일치 여부 확인 위함)
        try {
            send(recipient, mail_key);
            return mail_key;
        } catch (Exception e) {
            return null;
        }
    }
}
