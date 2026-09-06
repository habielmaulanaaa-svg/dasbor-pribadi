# 📱 Dasbor Pribadi Mobile — Era APK Android & Native Widgets

[![Android APK Release](https://img.shields.io/badge/APK%20Release-v32.40%20Pro-emerald?style=for-the-badge&logo=android&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk)
[![Cloud Database](https://img.shields.io/badge/Cloud%20Sync-Firebase%20Firestore-orange?style=for-the-badge&logo=firebase&logoColor=white)](https://firebase.google.com/)
[![Web PWA](https://img.shields.io/badge/Web%20PWA-Online%2024%2F7-blue?style=for-the-badge&logo=googlechrome&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)
[![GitHub Actions CI/CD](https://img.shields.io/badge/CI%2FCD-Automated%20Build-purple?style=for-the-badge&logo=githubactions&logoColor=white)](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/actions)

Aplikasi manajemen keuangan, tabungan, impian, dan catatan produktivitas pribadi yang telah resmi berevolusi memasuki **Era Aplikasi Android Mandiri (.APK)** dengan dukungan **Home Screen Widgets bawaan**, sinkronisasi saldo realtime, serta hosting **Cloud 24/7**.

---

## 📥 Unduh & Akses Resmi

| Saluran | Link Akses | Keterangan |
|---|---|---|
| 📲 **Download Langsung APK** | [**dasbor-pribadi.apk (5.69 MB)**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk) | Installer mandiri 1-klik cepat tanpa login |
| 📦 **GitHub Releases** | [**Halaman Rilis `apk-latest`**](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases/tag/apk-latest) | Arsip rilis resmi & changelog APK |
| 🌐 **Akses Web PWA** | [**habielmaulanaaa-svg.github.io/dasbor-pribadi**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/) | Versi web browser / iOS Safari / Desktop |

---

## ✨ Fitur Unggulan di Era APK

### 1. 📲 Aplikasi Android Mandiri Native (.APK)
- **Installer Mandiri**: Berjalan sebagai aplikasi native mandiri di sistem operasi Android (Android 8.0 Oreo hingga Android 14+).
- **Adaptive Icon Full-Bleed**: Didesain dengan standar *Android Adaptive Icon* (`res/mipmap-anydpi-v26`) berlatar `#0E1621` penuh, bebas dari efek bingkai kotak di launcher ponsel (Samsung One UI, Xiaomi HyperOS, ColorOS, dsb.).
- **Performa Ringan**: Ukuran binary kompak (~5.69 MB) dengan konsumsi RAM dan baterai yang sangat hemat.

### 2. 💳 Dua Home Screen Widget Modern
Tersedia 2 pilihan widget resmi yang dapat dipasang langsung di layar utama HP Anda:
- **Kartu Saldo Lengkap (4x2 / 3x2)**:
  - Menampilkan **Total Saldo Tersedia** secara riil dan terformat rapi dalam Rupiah.
  - Status Cloud realtime.
  - Tombol aksi cepat lebar untuk `+ Pemasukan` dan `- Pengeluaran`.
  - Desain bersih dan elegan tanpa logo atau teks berlebih.
- **Bar Aksi Cepat (4x1)**:
  - Bar ramping 1 baris hemat ruang di bawah search bar / jam HP.
  - 4 tombol aksi kilat simetris: `+ Masuk`, `- Keluar`, `Catatan`, dan `Impian`.
- **Pratinjau Visual (Widget Preview)**:
  - Gambar pratinjau asli (`android:previewImage`) muncul di menu pemilih widget ponsel sebelum Anda meletakkannya di Home Screen.

### 3. 🔄 Sinkronisasi Saldo Realtime
- Terhubung langsung via protokol internal native (`dasbor://sync?saldo=...`).
- Tombol **`[ 🔄 Sinkronkan Saldo ke Widget ]`** di menu Pengaturan dasbor mengirimkan total saldo kas asli secara instan ke widget Android tanpa kesalahan perhitungan.

### 4. ☁️ Google Cloud & Firebase Firestore 24/7
- Login akun Google dengan sekali klik.
- Seluruh data transaksi, target tabungan, catatan kilat, dan impian tersimpan aman di cloud dan dapat diakses dari perangkat manapun.

### 5. ⚡ Pembaruan Otomatis (OTA Pipeline)
- Perubahan antarmuka dan logika web didistribusikan secara instan melalui sistem *Over-The-Air (OTA)* via Service Worker.
- Notifikasi kapsul elegan bergaya **Dynamic Island** memberitahukan versi baru secara otomatis saat pembaruan siap.

### 6. 📴 100% Offline Ready
- Tetap dapat mencatat pemasukan, pengeluaran, dan jurnal harian saat tidak ada kuota internet.
- Data otomatis tersinkronisasi kembali ke Cloud saat perangkat terhubung ke internet.

---

## 📲 Panduan Pemasangan & Penggunaan

### A. Cara Install APK di HP Android:
1. Unduh file [**dasbor-pribadi.apk**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk).
2. Buka notifikasi unduhan atau File Manager, lalu tap file `.apk`.
3. Jika muncul konfirmasi keamanan, pilih **Izinkan instalasi dari sumber ini**.
4. Tekan **Install** / **Perbarui**.

### B. Cara Memasang Widget di Layar Utama HP:
1. Tekan dan tahan area kosong pada Home Screen HP Anda selama 2 detik.
2. Pilih menu **Widget**.
3. Cari dan pilih **Dasbor Pribadi**. Anda akan melihat **pratinjau gambar** kedua widget.
4. Pilih antara **Bar Aksi Cepat (4x1)** atau **Kartu Dasbor (4x2)** lalu seret ke layar depan.

### C. Cara Sinkronisasi Saldo ke Widget:
1. Buka aplikasi **Dasbor Pribadi**.
2. Masuk ke **Menu Pengaturan** (ikon gear / roda gigi).
3. Tap tombol **[ 🔄 Sinkronkan Saldo ke Widget ]**.
4. Saldo kas Anda akan langsung muncul di widget layar depan ponsel!

---

## 📂 Struktur Repositori

```text
dasbor-mobile/
├── .github/workflows/
│   └── build-apk.yml          # Otomatisasi GitHub Actions (Compile Gradle, Release, Deploy Pages)
├── android/                   # Proyek Native Android (Java & Android Gradle Plugin)
│   ├── app/
│   │   ├── build.gradle       # Konfigurasi aplikasi Android (versionCode 3238, versionName 32.38)
│   │   └── src/main/
│   │       ├── AndroidManifest.xml # Izin, intent filter dasbor://sync, & deklarasi Widget
│   │       ├── java/com/dasbor/pribadi/
│   │       │   ├── MainActivity.java             # WebView wrapper & receiver deep-link sync
│   │       │   ├── DasborWidgetProvider.java     # Logic widget Kartu Saldo 4x2
│   │       │   └── DasborBarWidgetProvider.java  # Logic widget Bar Aksi Cepat 4x1
│   │       └── res/                              # Adaptive icons, layout XML, & preview widget
├── dasbor-pribadi.apk         # Binary APK rilis terbaru (otomatis terupdate via CI/CD)
├── index.html                 # Core App: UI modern, manajemen keuangan, kalkulator impian, & Cloud sync
├── manifest.json              # Web App Manifest PWA
├── sw.js                      # Service Worker (Cache management & OTA pipeline)
├── icon-192.png               # Ikon Web PWA 192x192
├── icon-512.png               # Ikon Web PWA 512x512
└── README.md                  # Dokumentasi resmi proyek
```

---

## 🛠️ CI/CD & Build Pipeline Otomatis

Repositori ini dilengkapi dengan pipeline otomatis **GitHub Actions**:
1. Setiap commit yang di-*push* ke branch `main` akan memicu runner Ubuntu.
2. Runner mengonfigurasi **JDK 17**, mengunduh dependensi **Android SDK & Gradle**, dan mengompilasi APK secara mandiri.
3. Binary APK baru otomatis diterbitkan ke [GitHub Releases `apk-latest`](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases/tag/apk-latest) dan diperbarui di [GitHub Pages](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk).
4. Tidak diperlukan proses build manual di komputer lokal.

---

<div align="center">
  <sub>Dikembangkan dengan ❤️ untuk kemudahan pencatatan finansial & produktivitas harian.</sub><br>
  <sub><b>Dasbor Pribadi Mobile v32.39 Pro • Era APK Android</b></sub>
</div>
