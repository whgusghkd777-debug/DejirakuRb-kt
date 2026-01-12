<img width="300" height="400" alt="image" src="https://github.com/user-attachments/assets/ba2d664d-b203-4dc0-adbf-f50b1972ae7f" />

## 📸 実行画面 (Screenshots)
| 客室選択 (Ruby) | 決済完了 (Java) | 通知案内 (Kotlin) |

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



---

## 🛠️ 実務での活用例
このプロジェクトのようにサービスを分割することで、以下のようなメリットがあります。
1. **障害の分離**: 通知サービス(Kotlin)が止まっても、予約(Ruby)や決済(Java)は止まらない。
2. **言語の適材適所**: 画面は作りやすいRuby、堅牢な処理はJava、最新の機能はKotlinといった使い分けが可能。
3. **拡張性**: 将来的に「清掃管理サービス」をPythonで追加するなど、言語に縛られない拡張ができる。

---

## 👨‍💻 学習の記録
このプロジェクトは [dejiraku (Original)](https://github.com/whgusghkd777-debug/dejiraku) をベースに、3つの異なる環境を一つのリポジトリ（Monorepo）で管理・統合する挑戦をしました。
