package com.mzd.drugstore.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.*;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class EmailUtils {
    //发件人
    private final static String fromuser = "707307313@qq.com";
    //授权码
    private final static String authoritycode = "opdsvvjrnkefbcjg";
    //QQ邮箱服务器
    private final static String host = "smtp.qq.com";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static boolean sendEmail(String touser, String str, String username) throws Exception {
        boolean isF = false;
        Session session = getsession();
        if (session != null) {
            System.out.println("aaa");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromuser));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(touser));
            message.setSubject("找回密码!");
            message.setContent("验证码为（修改密码的时候带上验证码哦！）：" + str + "</br><a href='XXX.jsp?username=" + username + "'>点击找回</a>", "text/html; charset=utf-8");
            Transport.send(message);
            isF = true;
        }
        return isF;
    }


    private static Session getsession() throws Exception {
        Session session = null;
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromuser, authoritycode);
            }
        });
        return session;
    }
}
