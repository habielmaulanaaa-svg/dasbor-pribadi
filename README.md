<p align="center">
  <img src="icon-512.png" width="128" height="128" alt="Logo Dasbor Pribadi" style="border-radius: 28px; box-shadow: 0 8px 24px rgba(0,0,0,0.18);" />
</p>

# 📱 Dasbor Pribadi Mobile — Era Super-App Finansial & Produktivitas v33.17.OTA

[![Android APK Release](https://img.shields.io/badge/APK%20Release-v33.17.OTA-emerald?style=for-the-badge&logo=android&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk)
[![Cloud Database](https://img.shields.io/badge/Cloud%20Sync-Firebase%20Firestore-orange?style=for-the-badge&logo=firebase&logoColor=white)](https://firebase.google.com/)
[![Web PWA](https://img.shields.io/badge/Web%20PWA-Online%2024%2F7-blue?style=for-the-badge&logo=googlechrome&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)
[![GitHub Actions CI/CD](https://img.shields.io/badge/CI%2FCD-Automated%20Build-purple?style=for-the-badge&logo=githubactions&logoColor=white)](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/actions)

Aplikasi manajemen keuangan, tabungan, impian, dan produktivitas pribadi all-in-one yang telah berevolusi menjadi **Super-App Finansial & Produktivitas (v33.17.OTA)** dengan dukungan **Akselerasi 120 FPS & Zero Lag**, **Eliminasi Total Beban Scrolling (Bebas GPU Layer Explosion)**, **Akselerasi Hardware Sidebar Instan (Bebas Tertahan)**, **Dok Navigasi Berbasis GPU Transform**, **Scroll Throttling Bebas Reflow Thrashing**, **Checklist Hapus Data Terpilih (Selective Reset Data)**, **Pemulihan Animasi Saklar Fluida & Transisi Mode Renggang 60 FPS**, **Penyematan Logo Resmi di GitHub**, **Hybrid Auth Bridge (Login Google Resmi Lancar)**, **100% APK Mandiri Bebas Web (Offline-First)**, **Background OTA Update Engine (Over-The-Air)**, **JavaScript Native Bridge Terpadu**, **Dok Navigasi & FAB Terpadu (*Smooth Surface*)**, **Kalender Terpadu 360°**, **3 Home Screen Widgets Android**, **Multi-Dompet**, **Sistem Anggaran Bulanan**, dan sinkronisasi **Google Cloud 24/7**.

---

## 📥 Unduh & Akses Resmi

| Saluran | Link Akses | Keterangan |
|---|---|---|
| 📲 **Download Langsung APK** | [**dasbor-pribadi.apk**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk) | Installer 100% mandiri offline-first dengan Hybrid Auth Bridge & OTA otomatis |
| 📦 **GitHub Releases** | [**Halaman Rilis `apk-latest`**](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases/tag/apk-latest) | Arsip rilis resmi & changelog APK v33.17.OTA |
| 🌐 **Akses Web PWA** | [**habielmaulanaaa-svg.github.io/dasbor-pribadi**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/) | Versi web browser / iOS Safari / Desktop (Cloud Realtime) |

---

## 🚀 Pembaruan Versi Sekarang (v33.17.OTA)

### 1. ⚡ Scrolling Sehalus Sutra (60/120 FPS Native & Zero Layer Explosion)
- **Pembebasan Memori GPU VRAM**: Menghapus deklarasi `will-change: transform` dan `will-change: max-height, opacity` statis permanen dari seluruh kartu daftar transaksi dan tugas yang sebelumnya menciptakan ratusan GPU compositing layer berlebih.
- **Akselerasi On-Demand Cerdas**: Layer GPU dan hardware-accelerated transforms kini hanya diaktifkan secara dinamis saat kartu sedang disentuh atau digeser (`is-swiping` / gesture sentuh aktif). Scrolling kini berjalan sangat ringan tanpa hambatan beban rendering.

### 2. 🚀 Akselerasi Perangkat Keras Menu Sidebar Instan (Bebas Tertahan)
- **Eliminasi Layar Penuh Gaussian Blur**: Menggantikan efek `backdrop-blur-sm` layar penuh berlebih pada overlay dengan lapisan semi-transparan berkinerja tinggi (`bg-black/50`) yang melenyapkan 100% beban fill-rate GPU saat sidebar dibuka.
- **Layer Komposit Mandiri**: Menyematkan akselerasi perangkat keras independen (`will-change: transform`, `backface-visibility: hidden`, `contain: layout paint`) pada `#sidebar` sehingga menu langsung meluncur responsif seketika tanpa jeda awal (*zero latency*).

### 3. 🚤 Dok Navigasi Mengambang Berbasis GPU Transform (Bebas Reflow Layout)
- **Transisi Murni GPU Thread**: Menggantikan pergerakan dok navigasi dari transisi posisi layout fisik (`bottom`) menjadi GPU composited (`transform: translate3d(0, 110px, 0)`).
- **Nol Hentakan Layout**: Gerakan dok menyelam saat scroll ke bawah dan naik ke permukaan saat scroll ke atas berjalan 100% di GPU thread tanpa memicu *layout reflow* dan *repaint* CPU.

### 4. ⏱️ Scroll Throttling Presisi & Eliminasi Reflow Thrashing
- **Sinkronisasi `requestAnimationFrame`**: Event scroll pada kontainer utama kini disinkronkan langsung dengan *refresh rate* layar perangkat (60Hz / 120Hz).
- **Bebas Layout Thrashing**: Menghilangkan pembacaan dimensi DOM sinkron berulang (`scrollHeight` & `clientHeight`) di setiap frame pergerakan scroll.

---

## 📜 Arsip Pembaruan Versi Sebelumnya

Seluruh catatan riwayat pembaruan versi terdahulu telah didokumentasikan secara lengkap dan rapi di:
👉 [**Halaman Resmi GitHub Releases**](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases)

---

## 💎 Fitur Unggulan Utama

### 1. 💼 Multi-Dompet / Kantong Keuangan (*Pocket Management*)
- Pisahkan saldo kas Anda ke dalam **3 Dompet Utama**: 💵 **Uang Tunai**, 🏦 **Rekening Bank**, dan 📱 **E-Wallet**.
- Filter riwayat transaksi secara instan per dompet dengan 1 klik dan kalkulasi saldo gabungan otomatis secara akurat.

### 2. 🎯 Sistem Anggaran Bulanan (*Budgeting per Kategori*)
- Tetapkan plafon belanja bulanan per kategori (*Makanan, Transport, Hiburan, Tagihan, dsb.*).
- Progress bar dinamis 3-warna (Hijau, Kuning, Merah) dengan notifikasi Dynamic Island saat batas belanja terlampaui.

### 3. 📅 Pelacak Transaksi Rutin & Langganan (*Subscription Tracker*)
- Pantau tagihan berulang bulanan (*WiFi, Listrik, Kos, Netflix, dsb.*).
- Badge hitung mundur jatuh tempo interaktif & tombol **1-Klik "Bayar & Catat"**.

### 4. 🩺 Indikator Skor Kesehatan Finansial (*Financial Health Score*)
- Penilaian cerdas skor kesehatan finansial 0–100 berdasarkan rasio tabungan, kontrol belanja, dan aset cair beserta rekomendasi taktis harian.

### 5. 🗓️ Kalender Terpadu & Rekap Harian 360°
- Penyatuan kalender rekap harian dan kalender aktivitas dengan 4 indikator titik visual:
  - 🟢 **Pemasukan**: Transaksi uang masuk tercatat pada tanggal tersebut.
  - 🔴 **Pengeluaran**: Transaksi uang keluar tercatat.
  - 🔵 **Deadline Tugas**: Target tugas jatuh tempo pada tanggal tersebut.
  - 🟡 **Jurnal Rekap**: Catatan rekap harian tersimpan.
- Tombol pintar satu pintu di header (*+ Tugas Baru* / *Minimize*) untuk alur kerja yang cepat dan intuitif.

### 6. 🧪 UI Interaktif & Fisika Fluida (*Surface Tension & Pure Fluid Dynamics*)
- **⚡ Arsitektur Reaktif 100% & Akselerasi 120 FPS**: Dasbor bereaksi secara instan terhadap setiap perubahan data tanpa gesture tarik-layar (Pull-to-Refresh), memaksimalkan kecepatan sentuhan layar HP.
- **🧪 Tabung Fluida Progres Tabungan & Anggaran (*Liquid Level Fill*)**: Bilah progres dengan ujung lengkung kapiler (*meniscus*) dan transisi fluida elastis yang mengayun lembut (*slosh & settle*).
- **🫧 Centang Tugas Riak Cairan (*Liquid Ripple Splash*)**: Ceklis tugas memancarkan gelombang riak fluida melingkar ganda dengan ikon centang yang mengapung ke atas layaknya gelembung cairan (*floating bubble rise*).
- **🪙 Tetesan Transaksi Tangki Saldo (*Droplet Fusion*)**: Pencatatan uang masuk dan keluar memicu tetesan partikel fluida yang tercebur ke tangki saldo dan memantik riak dinamis pada gelombang saldo.
- **Saklar Peregangan Cairan**: Kenop toggle elastis meregang layaknya zat cair saat ditarik dan membal menyatu halus saat dilepas (*surface tension detach*).
- **Speed-Dial Gelembung FAB**: Tombol aksi cepat meluncur keluar layaknya gelembung fluida bertunas (*budding bubbles*).
- **Kapsul Merkuri Cair**: Indikator aktif pada bilah navigasi bawah berpindah dengan efek deformasi fluida seperti tetesan merkuri yang mengalir lincah.

### 7. 🌓 Transisi Tema Otomatis Jam WIB
- Pergantian tema otomatis mengikuti siklus waktu nyata:
  - 🌙 **Mode Gelap**: Aktif otomatis pukul 17:00 – 05:00 WIB.
  - ☀️ **Mode Terang**: Aktif otomatis pukul 05:00 – 17:00 WIB.
- Jadwal reset dan ringkasan harian tepat pukul 00:00:00 WIB tengah malam.

### 8. 📲 3 Pilihan Home Screen Widget Android Bawaan
- **Kartu Saldo Lengkap (4x2 / 3x2)**: Menampilkan total saldo dan tombol cepat `+ Masuk` & `- Keluar`.
- **Bar Aksi Cepat (4x1)**: Bar ramping 4 shortcut (`+ Masuk`, `- Keluar`, `Catatan`, `Impian`).
- **Widget Tugas & Aktivitas (4x2 / 3x2)**: Menampilkan jumlah tugas aktif & preview tugas prioritas.

### 9. ☁️ Sinkronisasi Google Cloud Firestore & Dukungan Offline PWA
- Terkoneksi secara aman ke Google Cloud Firebase Firestore untuk pencadangan otomatis realtime.
- Didukung Service Worker PWA modern untuk akses cepat secara mandiri dan offline di mana saja.

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
3. Cari dan pilih **Dasbor Pribadi**:
   - **Kartu Dasbor (4x2)**
   - **Bar Aksi Cepat (4x1)**
   - **Tugas & Aktivitas (4x2)**
4. Seret widget favorit Anda ke layar depan.

### C. Cara Sinkronisasi Saldo & Tugas ke Widget:
- Data widget otomatis tersinkronisasi setiap kali menyimpan transaksi atau tugas baru.
- Dapat juga memicu manual via tombol **[ 🔄 Sinkronkan Data ke Widget ]** di menu Pengaturan.

---

## 📂 Struktur Repositori

```text
dasbor-mobile/
├── .github/workflows/
│   └── build-apk.yml          # Otomatisasi GitHub Actions (Compile Gradle, Release, Deploy Pages)
├── android/                   # Proyek Native Android (Java & Android Gradle Plugin)
│   ├── app/
│   │   ├── build.gradle       # Konfigurasi aplikasi Android (v33.11.P5)
│   │   └── src/main/
│   │       ├── AndroidManifest.xml # Izin, intent filter dasbor://sync, & deklarasi 3 Widget
│   │       ├── java/com/dasbor/pribadi/
│   │       │   ├── MainActivity.java             # WebView wrapper & receiver deep-link sync
│   │       │   ├── DasborWidgetProvider.java     # Logic widget Kartu Saldo 4x2
│   │       │   ├── DasborBarWidgetProvider.java  # Logic widget Bar Aksi Cepat 4x1
│   │       │   └── TaskWidgetProvider.java       # Logic widget Tugas & Aktivitas 4x2
│   │       └── res/                              # Layout XML, adaptive icons, & preview widget
├── dasbor-pribadi.apk         # Binary APK rilis terbaru (otomatis terupdate via CI/CD)
├── index.html                 # Core App: UI super-app, multi-wallet, budget, subs, cloud
├── manifest.json              # Web App Manifest PWA
├── sw.js                      # Service Worker (Cache management & OTA pipeline v33.11.P5)
├── icon-192.png               # Ikon Web PWA 192x192
├── icon-512.png               # Ikon Web PWA 512x512
└── README.md                  # Dokumentasi resmi proyek
```

---

## 🛠️ CI/CD & Build Pipeline Otomatis

Repositori ini dilengkapi dengan pipeline otomatis **GitHub Actions**:
1. Setiap commit yang di-*push* ke branch `main` dengan perubahan pada `android/**` atau `.github/workflows/build-apk.yml` akan memicu runner Ubuntu.
2. Runner mengonfigurasi **JDK 17**, mengunduh dependensi **Android SDK & Gradle**, dan mengompilasi APK secara mandiri.
3. Binary APK baru otomatis diterbitkan ke [GitHub Releases `apk-latest`](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases/tag/apk-latest) dan diperbarui di [GitHub Pages](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk).
4. Tidak diperlukan proses build manual di komputer lokal.

---

<div align="center">
  <sub>Dikembangkan dengan ❤️ untuk kemudahan pencatatan finansial & produktivitas harian.</sub><br>
  <sub><b>Dasbor Pribadi Mobile v33.17.OTA • Era Super-App Finansial & Produktivitas</b></sub>
</div>
