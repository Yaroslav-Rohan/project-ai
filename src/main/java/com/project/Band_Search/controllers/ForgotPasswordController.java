package com.project.Band_Search.controllers;

import com.project.Band_Search.Requests.EmailRequest;
import com.project.Band_Search.Requests.ResetPasswordRequest;
import com.project.Band_Search.models.User;
import com.project.Band_Search.models.Utility;
import com.project.Band_Search.service.UserServiceImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/forgot_password")
    public ResponseEntity<?> processForgotPassword(@RequestBody EmailRequest emailRequest, HttpServletRequest request, Model model) {
        String email = emailRequest.getEmail();
        String token = RandomString.make(30);
        /**
         * show resetPasswordToken in terminal*/
        // System.out.println(token + " TOOOOOOOKEN");
        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
        } catch (UnsupportedEncodingException | MessagingException e) {

            return new ResponseEntity<>("Failed to send an email", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("band_search@gmail.com", "BandSearch Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @GetMapping("/reset_password")
    public ResponseEntity<String> showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User customer = userService.getByResetPasswordToken(token);
        model.addAttribute("token", token);

        if (customer == null) {
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Everything is ok", HttpStatus.OK);
    }

    @PostMapping("/reset_password")
    public ResponseEntity<String> processResetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest, Model model) {
        String token = resetPasswordRequest.getToken();
        String newPassword = resetPasswordRequest.getNewPassword();
        String confirmPassword = resetPasswordRequest.getConfirmPassword();
        if (confirmPassword.equals(newPassword)) {
            User user = userService.getByResetPasswordToken(token);
            if (user != null) {
                userService.updatePassword(user, newPassword);
                System.out.println(user.getPassword());
            }
        } else {
            return new ResponseEntity<>("Confirm pass != new pass", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
    }
}