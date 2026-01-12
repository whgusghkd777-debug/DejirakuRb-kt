package org.example.dejiraku_payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {

    @GetMapping("/pay")
    public String processPayment(@RequestParam String roomName) {
        String notificationUrl = "http://localhost:8081/notify?roomName=" + roomName;
        RestTemplate restTemplate = new RestTemplate();
        String notificationMessage = restTemplate.getForObject(notificationUrl, String.class);

        // 럭셔리한 호텔 예약 카드 디자인 (디자인 최적화)
        return "<html>" +
                "<head><style>" +
                "  body { font-family: 'Hiragino Sans', 'Meiryo', sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f0f2f5; }" +
                "  .card { background: white; padding: 40px; border-radius: 20px; box-shadow: 0 15px 35px rgba(0,0,0,0.1); text-align: center; width: 450px; border-top: 8px solid #2c3e50; }" +
                "  .brand { color: #2c3e50; font-size: 24px; font-weight: bold; margin-bottom: 5px; letter-spacing: 2px; }" +
                "  .status-badge { background: #27ae60; color: white; padding: 6px 20px; border-radius: 50px; display: inline-block; font-size: 14px; margin: 15px 0; font-weight: bold; }" +
                "  .room-info { background: #f8f9fa; padding: 20px; border-radius: 12px; margin: 20px 0; border: 1px solid #eee; }" +
                "  .room-name { color: #e74c3c; font-size: 1.3em; font-weight: bold; display: block; margin-bottom: 5px; }" +
                "  .notification-area { text-align: left; background: #ffffff; border: 1px dashed #3498db; padding: 15px; border-radius: 10px; margin-top: 20px; }" +
                "  .footer { color: #bdc3c7; font-size: 12px; margin-top: 30px; border-top: 1px solid #eee; padding-top: 20px; }" +
                "</style></head>" +
                "<body>" +
                "  <div class='card'>" +
                "    <div class='brand'>DEJIRAKU HOTEL</div>" +
                "    <div class='status-badge'>決済完了</div>" +
                "    <div class='room-info'>" +
                "      <span class='room-name'>" + roomName + "</span>" +
                "      <span style='color: #7f8c8d;'>のご予約を承りました。</span>" +
                "    </div>" +
                "    <div class='notification-area'>" +
                "      " + notificationMessage + "" + // 코틀린에서 보낸 파란색 알림이 여기 쏙 들어갑니다!
                "    </div>" +
                "    <div class='footer'>© 2026 Dejiraku Hotel Group. All rights reserved.</div>" +
                "  </div>" +
                "</body>" +
                "</html>";
    }
}