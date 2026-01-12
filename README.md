
## 📸 実行画面 (Screenshots)
<img src="[https://github.com/user-attachments/assets/ba2d664d-b203-4dc0-adbf-f50b1972ae7f](https://github.com/user-attachments/assets/ba2d664d-b203-4dc0-adbf-f50b1972ae7f)" width="200"/>
| 客室選択 (Ruby) | 決済完了 (Java) | 通知案内 (Kotlin) |
| :---: | :---: | :---: |


---
# 🏨 Dejiraku Hotel & Resort System
**Ruby, Java, Kotlinを統合したマイクロサービス学習プロジェクト**

このプロジェクトは、異なる言語（Ruby on Rails, Java, Kotlin）で構築された3つのサービスを一つに繋ぎ, 実際の業務で使われる**マイクロサービスアーキテクチャ(MSA)**の基礎を学習することを目的としています。

---

## 🎯 プロジェクトの目標
- **多言語統合の学習**: Ruby, Java, KotlinをAPIで連携させ、一つのサービスとして動作させる。
- **フルスタック体験**: フロントエンドから決済、通知サービスまで、バックエンドの主要な流れを構築する。
- **実務的な設計**: 各サービスを分離し、独立して動作させる設計（MSA）を理解する。

---

## 🏗️ システム構成 (System Architecture)

### 1️⃣ Frontend Service (Ruby on Rails)
- **役割**: ユーザーが最初に接する「ホテルの顔」です。
- **主な機能**: 客室情報の表示、予約の開始。
- **技術スタック**: Ruby 3.x, Rails 7.x

### 2️⃣ Payment Service (Java Spring Boot)
- **役割**: 決済ロジックを担当するコアサービスです。
- **主な機能**: 決済完了の処理、Kotlin通知サービスへのデータ転送。
- **技術スタック**: Java 17, Spring Boot 3.x

### 3️⃣ Notification Service (Kotlin Spring Boot)
- **役割**: 予約完了後の案内を担当する独立した通知サービスです。
- **主な機能**: 予約詳細情報の表示、チェックイン案内の生成。
- **技術スタック**: Kotlin 1.9, Spring Boot 3.x
---

## 💻 Core Code & Flow (核心ロジックと連携)

このプロジェクトの核心は、**Rubyで予約し、Javaで決済し、Kotlinで通知する**という一連の流れを異なる言語で実現したことです。

### 🔴 Ruby on Rails (Frontend & Reservation)
ユーザーが宿泊プランを選択し、決済サービスへデータを送る入り口です。
```ruby
# dejiraku_hotel/app/controllers/reservations_controller.rb
def create
  @reservation = Reservation.new(reservation_params)
  if @reservation.save
    # 決済サービス(Java)へリダイレクトし、データを引き継ぐ
    redirect_to "http://localhost:8080/payment?id=#{@reservation.id}&amount=#{@reservation.price}"
  end
end

```

### 🟡 Java Spring Boot (Payment Integration)

Rubyから受け取った予約情報を処理し、決済完了後にKotlinサービスへ通知を依頼します。

```java
// dejiraku_payment/src/main/java/com/payment/PaymentController.java
@GetMapping("/payment/complete")
public String completePayment(@RequestParam String reservationId) {
    // 決済論理を実行した後、Kotlin通知サービスへデータを転送
    String kotlinUrl = "http://localhost:8081/notification?id=" + reservationId;
    return "redirect:" + kotlinUrl;
}

```

### 🔵 Kotlin Spring Boot (Notification Service)

最終的に決済が完了した情報をユーザーに分かりやすく表示（通知）します。

```kotlin
// dejiraku_notification/src/main/java/com/notification/NotificationController.kt
@GetMapping("/notification")
fun showNotification(@RequestParam id: String, model: Model): String {
    val reservationDetail = service.getDetail(id)
    model.addAttribute("detail", reservationDetail)
    return "notification_view" // 日本語で構成された完了画面を表示
}

```

---

## 📂 ディレクトリ構造 (Directory Structure)

プロジェクト全体を理解するためのマップです。



DejirakuRb,kt/
├── dejiraku_hotel/         # Ruby on Rails (予約システム)
│   └── app/controllers/    # メ인로직
├── dejiraku_payment/       # Java Spring Boot (決済システム)
│   └── src/main/java/      # 결제처리로직
└── dejiraku_notification/  # Kotlin Spring Boot (通知システム)
    └── src/main/kotlin/    # 알림처리로직

## 👨‍💻 学習の記録
このプロジェクトは [dejiraku (Original)](https://github.com/whgusghkd777-debug/dejiraku) をベースに、3つの異なる環境を一つのリポジトリ（Monorepo）で管理・統合する挑戦をしました。
