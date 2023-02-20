package com.supertax.mailing;

import org.apache.commons.io.IOUtils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.InputStream;
import java.util.Properties;

public class SendMail {

    public static void main(String[] args) {

            final String username = "shivshankar18022023@gmail.com";
            final String password = "pjzerthdautiuicu";

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "465");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("shivshankar18022023@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse("nehamalviya152@gmail.com")
                );
                message.setSubject("Testing Gmail SSL");

                MimeMultipart multipart = new MimeMultipart("related");
                BodyPart messageBodyPart = new MimeBodyPart();
                String htmlText = "<H4>Hi,\n" +
                        "\n" +
                        "<br><br>We (SuperTax) are a software product company providing innovative and smart technological solutions powered by ML+AI+RPA in wide ranging domains including GST, ERP, Treasury management, E Invoicing etc. <br> \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<br>This email is about our Application for Lease Management and Accounting which does end to end calculation under IND AS 116 and IFRS 16. </H6>"
                        + "<img src=\"cid:super-tax\">"
                +"<H6>Please find enclosed our flyer for IND AS 116 product which shall give you details of many more benefits that you can derive from this product. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<br>PS: Some of our customers are:\n" +
                        "\n" +
                        "Adani, Welspun, Alembic Pharma, SBI Mutual Fund, HDFC Ergo, HDFC Life, HDFC Mutual Fund, Edelweiss, JM Financial, Reliance General Insurance, Reliance Mutual Fund, Reliance Life Insurance, Shoppers Stop, Hitachi, Savex Technologies, Deoleo, Red Hat, Shapoorji Pallonji, Etihad Airways, Emirates Airlines, Singapore Air, Metro Shoes, Overseas Polymer, Axis Mutual Fund, Thermofisher, SBI General Insurance, New India Assurance Company, Universal Sompo, Oriental Insurance, IndiaFirst, PNB Metlife, Aegon Life Insurance, Star Union Dai-ichi, Inorbit Malls, Phoenix Market City, CDSL, Car Dekho, Danone, Cotecna, Qatar Airways, SKF Bearing, Mediassist, ICICI Housing Finance, ICICI Mutual Fund, ICICI Lombard, Nippon Mutual Fund, Gulf Air, Intelenet, Multi Commodities Exchange (MCX) etc. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<br>Look forward to hearing from you when we can meet up for discussion. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<br><br>Best,</H4>";
                messageBodyPart.setContent(htmlText, "text/html");
                multipart.addBodyPart(messageBodyPart);
                try {
                    messageBodyPart = new MimeBodyPart();
                    InputStream imageStream = SendMail.class.getResourceAsStream("/superTax.png");
                    DataSource fds = new ByteArrayDataSource(IOUtils.toByteArray(imageStream), "image/png");
                    messageBodyPart.setDataHandler(new DataHandler(fds));
                    messageBodyPart.setHeader("Content-ID","<super-tax>");
                    multipart.addBodyPart(messageBodyPart);
                    message.setContent(multipart);
                    Transport.send(message);
                    System.out.println("Done");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

}
