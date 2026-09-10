# 📱 Dasbor Pribadi Mobile — Era Super-App Finansial & Produktivitas v33.15.OTA

[![Android APK Release](https://img.shields.io/badge/APK%20Release-v33.15.OTA-emerald?style=for-the-badge&logo=android&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk)
[![Cloud Database](https://img.shields.io/badge/Cloud%20Sync-Firebase%20Firestore-orange?style=for-the-badge&logo=firebase&logoColor=white)](https://firebase.google.com/)
[![Web PWA](https://img.shields.io/badge/Web%20PWA-Online%2024%2F7-blue?style=for-the-badge&logo=googlechrome&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)
[![GitHub Actions CI/CD](https://img.shields.io/badge/CI%2FCD-Automated%20Build-purple?style=for-the-badge&logo=githubactions&logoColor=white)](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/actions)

Aplikasi manajemen keuangan, tabungan, impian, dan produktivitas pribadi all-in-one yang telah berevolusi menjadi **Super-App Finansial & Produktivitas (v33.15.OTA)** dengan dukungan **Era Fisika Fluida & Pantulan (Fluid Spring Physics)**, **Hybrid Auth Bridge (Login Google Resmi Lancar)**, **100% APK Mandiri Bebas Web (Offline-First)**, **Background OTA Update Engine (Over-The-Air)**, **JavaScript Native Bridge Terpadu**, **Dok Navigasi & FAB Terpadu (*Smooth Surface*)**, **Kalender Terpadu 360°**, **3 Home Screen Widgets Android**, **Multi-Dompet**, **Sistem Anggaran Bulanan**, dan sinkronisasi **Google Cloud 24/7**.

---

## 📥 Unduh & Akses Resmi

| Saluran | Link Akses | Keterangan |
|---|---|---|
| 📲 **Download Langsung APK** | [**dasbor-pribadi.apk**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk) | Installer 100% mandiri offline-first dengan Hybrid Auth Bridge & OTA otomatis |
| 📦 **GitHub Releases** | [**Halaman Rilis `apk-latest`**](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases/tag/apk-latest) | Arsip rilis resmi & changelog APK v33.15.OTA |
| 🌐 **Akses Web PWA** | [**habielmaulanaaa-svg.github.io/dasbor-pribadi**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/) | Versi web browser / iOS Safari / Desktop (Cloud Realtime) |

---

## 🚀 Pembaruan Versi Sekarang (v33.15.OTA)

### 1. 🧲 Rubber-band Swipe Snap pada Geser Kartu Tugas
- **Fisika Redaman Karet Non-Linear (iOS Viscous Damping)**: Usapan kartu tugas terasa responsif 1:1 di awal, kemudian semakin berat saat ditarik melebihi 60px.
- **Pantulan Pegas Alami (*Spring Overshoot Snap-back*)**: Jika jari dilepas tanpa melewati ambang batas aksi, kartu membal kenyal melewati titik nol (`cubic-bezier(0.34, 1.56, 0.64, 1)`) sebelum diam di tempat semula.

### 2. 💧 Liquid Filter Pill pada Tab Riwayat Transaksi
- **Kapsul Air Raksa Presisi**: Kapsul meluncur elastis di belakang tab rentang waktu (`Semua`, `Hari Ini`, `Minggu Ini`, `Bulan Ini`) dengan koordinat absolut presisi 1:1, tanpa risiko melorot atau terpotong.
- **Umpan Balik Taktil**: Animasi tekan mikro (`scale(0.92)`) saat memilih kategori atau filter.

### 3. 📜 Spring Accordion Unfurl pada Form Input
- **Membentang Organik Melar Kenyal**: Membuka form input Tugas Baru, Jurnal, dan Tabungan membentang dengan kurva pegas hardware-accelerated (`transform: scaleY() & translateY()`).
- **Bebas Interferensi**: Khusus menargetkan container form input, sehingga menu pengaturan tetap ramping tanpa animasi pantulan yang tidak disengaja.

### 4. 🌊 Jelly Pulse & Mode Solid Bersih pada Kartu Saldo
- **Respon Fluida Mikro**: Kartu saldo bergetar fluida lembut (0.38s - 0.44s) saat transaksi masuk/keluar atau disentuh.
- **Proteksi Mode Solid Minimalis**: Saat gradasi warna dimatikan, getaran kartu saldo menggunakan bayangan netral gelap murni tanpa kebocoran pendaran warna (*zero gradient leakage*).

### 5. 🛡️ Stabilisasi & Pembersihan Bug Inti (Batch 1 & Batch 2)
- Sanitasi XSS menyeluruh (`escapeHtml`), ID integer unik monotonik (`generateUniqueId`), proteksi anti-spam submit (400ms), rekonsiliasi cerdas offline ➔ cloud, optimalisasi GPU *on-demand compositing* pada daftar tugas, perbaikan pergeseran tanggal UTC, dan penyesuaian cache PWA `dasbor-pwa-v33-15-ota`.

---

## 📜 Arsip Pembaruan Versi Sebelumnya (v33.14.OTA)

### 1. 🔑 Hybrid Auth Bridge (Solusi Tuntas Login Akun Google)
- **Otentikasi Aman Terpercaya**: Mengatasi kendala penolakan OAuth (*The requested action is invalid* / *network AuthError*) pada protokol `file://` di dalam WebView mandiri.
- **Chrome Custom Tabs Auth Handshake**: Khusus saat tombol *"Masuk dengan Google"* ditekan, aplikasi memanggil jendela Custom Tab aman ke domain terverifikasi (`auth-bridge.html`), lalu mentransfer token otentikasi secara otomatis kembali ke APK mandiri via skema deep-link `dasbor://auth-callback`.
- **Sesi Firebase Instan**: Profil pengguna dan sinkronisasi Cloud Firestore langsung aktif 100% tanpa perlu konfigurasi rumit.

### 2. 📦 100% APK Mandiri Bebas Web (*Offline-First Asset Bundle*)
- **Kemasan Aset Lokal**: APK kini mengemas bundel lengkap (`index.html`, ikon HD, dan metadata PWA) di dalam aset internal Android (`file:///android_asset/`).
- **Tanpa Ketergantungan Hosting**: Aplikasi dapat dibuka seketika saat perangkat dalam mode pesawat atau tanpa jaringan seluler.

### 3. 🔄 Background OTA Update Engine (*Over-The-Air Dynamic Bundle*)
- **Pembaruan Senyap di Latar Belakang**: Saat terhubung ke internet, aplikasi secara otomatis memeriksa pembaruan antarmuka dan fitur terbaru langsung dari repositori resmi.
- **Validasi Integritas Atomic + MD5**: File pembaruan diunduh ke ruang privat aplikasi, divalidasi keutuhannya secara ketat, dan diterapkan mulus tanpa memaksa instalasi ulang APK.

### 4. ⚡ JavaScript Native Bridge Terpadu (`DasborBridge`)
- **Sinkronisasi Langsung Bebas Kedip**: Pembaruan saldo dan sisa tugas dikirimkan langsung dari Web Engine ke 3 Widget Native Android secara real-time.
- **Intent Action Dispatcher**: Menekan tombol di widget Android (seperti *Tambah Pengeluaran*, *Tambah Pemasukan*, *Catat*, atau *Kalkulator*) langsung mengarahkan pengguna ke tab dan formulir yang sesuai secara instan.

### 1. 🌊 Gelombang Fluida Saldo 100% Seamless (*Infinite Laminar Flow*)
- **Formulasi Kurva $C^1$-Continuous**: Gelombang air pada kartu saldo kini menggunakan kurva Bezier kuadratik periodik simetris (`Q ... T ...`) dengan kondisi batas periodik identik pada koordinat Y dan vektor tangen.
- **Dual-Cycle Single Vector Track**: Dalam satu SVG dengan 2 siklus gelombang utuh sekaligus, menghilangkan celah subpiksel dan loncatan visual.
- **Bebas Stuttering**: Animasi translasi linear berkelanjutan berputar tenang tanpa jeda saat loop berulang, berjalan sangat mulus di 60/120 FPS.

### 2. 🚤 Dok Navigasi & FAB Terpadu (*Smooth Surface Buoyancy*)
- **Penyatuan Perilaku Gulir (*Unified Dock*)**: Bilah navigasi bawah (Beranda, Tugas, Uang) dan tombol aksi cepat FAB kini menjadi satu kesatuan pelampung.
- **Scroll ke Bawah (Menyelam / Submerge)**: Seluruh dok serempak menyelam ke bawah layar dengan kurva gravitasi fluida halus, menjaga layar tetap bersih dan lapang saat membaca riwayat transaksi.
- **Scroll ke Atas (Luncuran Halus / Smooth Surface)**: Seluruh dok meluncur naik ke atas secara elegan tanpa efek osilasi/pantulan pegas yang kaku.

### 3. ✨ Restorasi Sejati Frosted Glass & 100% Persistent Blur
- **100% Persistent Frosted Blur Tanpa Jeda Kaca**: Mekanisme luncuran dok menggunakan transisi koordinat `bottom` murni pada fixed layout, mengeliminasi isolasi RenderPass GPU (*isolated compositing layer*). Efek kaca buram (`backdrop-filter: blur(20px) saturate(180%)`) kini aktif 100% secara persisten dan terus membiaskan piksel latar belakang secara konsisten tanpa jeda efek kaca bening sedikit pun saat dok bergerak naik atau turun.
- **Bersih Bebas Outline**: Seluruh border putih kontras dan inset highlight di sekeliling tombol FAB dan bilah dok telah dihapus total, mengembalikan estetika minimalis yang berpadu lembut dengan bayangan alami.

### 4. 💧 Saklar Liquid Glass Waktu Pembuatan Tugas
- **Saklar Fluida Peregangan Cairan**: Form tambah tugas baru kini dilengkapi opsi *"Sertakan Waktu & Tanggal Dibuat"* dengan animasi fisika fluida (*stretching, detaching, spring rebound*).
- **Animasi Buka-Tutup Halus**: Sub-bar kustomisasi tanggal dan jam muncul dan menutup dengan transisi ekspansi/kolaps vertikal CSS yang lembut tanpa loncatan seketika.

### 5. 🌊 Efek Liquid Murni (*Natural Fluid Dynamics*)
- **🧪 Tabung Fluida Progres Tabungan & Anggaran (*Liquid Level Fill*)**: Bilah progres dengan ujung lengkung kapiler (*meniscus*) dan transisi fluida elastis yang mengayun lembut (*slosh & settle*).
- **🫧 Centang Tugas Riak Cairan (*Liquid Ripple Splash*)**: Ceklis tugas memancarkan gelombang riak fluida melingkar ganda dengan ikon centang yang mengapung ke atas layaknya gelembung cairan (*floating bubble rise*).
- **🪙 Tetesan Transaksi Tangki Saldo (*Droplet Fusion*)**: Pencatatan uang masuk dan keluar memicu tetesan partikel fluida yang tercebur ke tangki saldo dan memantik riak dinamis pada gelombang saldo.
- **⚡ Akselerasi 120 FPS & State Reaktif 100%**: Menghilangkan gesture Pull-to-Refresh konvensional demi melepaskan beban listener sentuhan (*zero touch overhead*). Semua pembaruan data kini berlangsung instan dan scrolling layar berjalan sehalus 120 FPS native tanpa lag.

### 6. 🧹 Optimalisasi Performa Bersih
- **Pembersihan Modul Kunci Internal**: Seluruh modul kunci PIN dan pola internal ditiadakan sepenuhnya sesuai preferensi pengguna, meningkatkan kecepatan pemuatan awal dan mengandalkan sistem penguncian bawaan perangkat HP yang lebih aman dan terintegrasi.

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
  <sub><b>Dasbor Pribadi Mobile v33.15.OTA • Era Super-App Finansial & Produktivitas</b></sub>
</div>
