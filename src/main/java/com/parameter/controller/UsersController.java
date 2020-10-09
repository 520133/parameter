package com.parameter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 杨森霖
 * @author 2020/10/9 0009 上午 11:32
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    //这一步是获取application.properties中设置的发件人邮箱地址
    @Value("${spring.mail.username}")
    private String username;

    /**
     * 发送HTML邮件
     * @param addressee
     * @throws MessagingException
     */
    //发送HTML邮件(接收前台传过来的参数:addressee 收件人地址)
    @RequestMapping("/sendMail")
    public void sendMail(String addressee) throws MessagingException {
        {
            // 生成6位随机数字
            Integer code = (int)((Math.random()*9+1)*100000);
            System.out.println(code);
            //发邮件
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            // 第二个参数true表示使用HTML语言来编写邮件
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            //发件人邮件地址(上面获取到的，也可以直接填写,string类型)
            helper.setFrom(username);
            //收件人邮件地址
            helper.setTo(addressee);
            //邮件主题
            helper.setSubject("注册验证码一");
            //邮件正文
            helper.setText("<p>您好！您此次注册xxx账号信息的验证码为：<b style='color:orange;'>" + code + "</b>，5分钟内有效，验证码提供给他人可能导致账号被盗，请勿泄露，谨防被骗。</p>, true, true");
            javaMailSender.send(mimeMessage);
        }
    }

    /**
     * 普通文本邮件
     * @param addressee  接收前台传过来的参数:addressee 收件人地址
     * @throws MessagingException
     */
    @RequestMapping("/sendMail2")
    public void sendMail2(String addressee) {
        {
            //发邮件
            SimpleMailMessage message = new SimpleMailMessage();
            //发件人邮件地址(上面获取到的，也可以直接填写,string类型)
            message.setFrom(username);
            //收件人邮件地址
            message.setTo(addressee);
            //邮件主题
            message.setSubject("注册验证码二");
            //邮件正文
            message.setText("我是普通文本邮件内容");
            javaMailSender.send(message);
        }
    }

    @RequestMapping("/sendEmail3")
    public boolean sendEmail3(String email, Integer code) throws MessagingException {
        //发邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 第二个参数true表示使用HTML语言来编写邮件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //发件人邮件地址(上面获取到的，也可以直接填写,string类型)
        helper.setFrom(username);
        //收件人邮件地址
        helper.setTo(email);
        //邮件主题
        helper.setSubject("注册验证码");

        //使用模板thymeleaf
        Context context = new Context();
        //设置传入模板的页面的参数 参数名为:code 参数随便写就行
        context.setVariable("code", code);
        //emailTemplate是你要发送的模板我这里用的是Thymeleaf
        String emailContent = templateEngine.process("index", context);
        //邮件正文
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
        return false;
    }


}
