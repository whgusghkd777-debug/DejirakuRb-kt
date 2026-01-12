package org.example.dejiraku_notification

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationController {

    @GetMapping("/notify")
    fun sendNotification(@RequestParam roomName: String): String {
        return """
            <html>
            <head>
                <style>
                    body { font-family: 'Hiragino Sans', 'Meiryo', sans-serif; display: flex; justify-content: center; align-items: center; min-height: 200px; margin: 0; background-color: transparent; }
                    .notification-box { 
                        text-align: left; 
                        background: #ffffff; 
                        border: 1px dashed #3498db; 
                        padding: 20px; 
                        border-radius: 12px; 
                        width: 100%;
                        max-width: 400px;
                    }
                    .title { color: #2980b9; font-weight: bold; font-size: 1.1em; display: flex; align-items: center; gap: 8px; margin-bottom: 10px; }
                    .content { color: #2c3e50; line-height: 1.8; font-size: 0.95em; }
                    .note { color: #7f8c8d; font-size: 0.85em; margin-top: 12px; display: block; }
                </style>
            </head>
            <body>
                <div class='notification-box'>
                    <div class='title'>🔔 チェックインのご案内</div>
                    <div class='content'>
                        <span style='color: #e74c3c; font-weight: bold;'>${roomName}</span>の準備が整い次第、<br>
                        ご登録いただいたメールアドレスへ詳細をお送りいたします。
                    </div>
                    <span class='note'>※当日はフロントにて予約番号をご提示ください。</span>
                </div>
            </body>
            </html>
        """.trimIndent()
    }
}