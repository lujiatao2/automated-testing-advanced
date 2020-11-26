package com.lujiatao.c08;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SendEmailClient {

    private Session session;

    public static class SendEmailClientBuilder {

        private String serverHost = "smtp.qq.com";
        private int serverPort = 465;
        private String serverUsername = "yourqq@qq.com";
        private String serverPassword = "yourpassword";
        private boolean useSsl = true;
        private Session session;

        public SendEmailClientBuilder serverHost(String serverHost) {
            this.serverHost = serverHost;
            return this;
        }

        public SendEmailClientBuilder serverPort(int serverPort) {
            this.serverPort = serverPort;
            return this;
        }

        public SendEmailClientBuilder serverUsername(String serverUsername) {
            this.serverUsername = serverUsername;
            return this;
        }

        public SendEmailClientBuilder serverPassword(String serverPassword) {
            this.serverPassword = serverPassword;
            return this;
        }

        public SendEmailClientBuilder useSsl(boolean useSsl) {
            this.useSsl = useSsl;
            return this;
        }

        public SendEmailClient build() {
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", serverHost);
            properties.setProperty("mail.smtp.port", String.valueOf(serverPort));
            if (useSsl) {
                properties.put("mail.smtp.ssl.enable", "true");
            }
            properties.put("mail.smtp.auth", "true");
            session = Session.getDefaultInstance(properties, new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(serverUsername, serverPassword);
                }

            });
            return new SendEmailClient(this);
        }

    }

    private SendEmailClient(SendEmailClientBuilder sendEmailClientBuilder) {
        session = sendEmailClientBuilder.session;
    }

    public void sendHTMLEmail(String from, String to, String subject, String htmlPath) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setContent(readFile(new File(htmlPath)), "text/html;charset=utf-8");
        Transport.send(message);
    }

    private String readFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            char[] chars = new char[1024];
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.read(chars) != -1) {
                for (char tmp : chars) {
                    stringBuilder.append(tmp);
                }
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return "";
        }
    }

}
