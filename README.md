# 📱 Dasbor Pribadi Mobile — Era Super-App Finansial & Produktivitas v33.11.P2

[![Android APK Release](https://img.shields.io/badge/APK%20Release-v33.11.P2-emerald?style=for-the-badge&logo=android&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk)
[![Cloud Database](https://img.shields.io/badge/Cloud%20Sync-Firebase%20Firestore-orange?style=for-the-badge&logo=firebase&logoColor=white)](https://firebase.google.com/)
[![Web PWA](https://img.shields.io/badge/Web%20PWA-Online%2024%2F7-blue?style=for-the-badge&logo=googlechrome&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)
[![GitHub Actions CI/CD](https://img.shields.io/badge/CI%2FCD-Automated%20Build-purple?style=for-the-badge&logo=githubactions&logoColor=white)](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/actions)

Aplikasi manajemen keuangan, tabungan, impian, dan produktivitas pribadi all-in-one yang telah berevolusi menjadi **Super-App Finansial & Produktivitas (v33.11.P2)** dengan dukungan **Kalender Terpadu & Rekap Harian 360°**, **Wawasan Pintar Bergilir (*Smart Insights*)**, **Speed-Dial Floating Action Button (FAB)**, **Prediksi Tabungan Cerdas**, **3 Home Screen Widgets Android bawaan**, keamanan tangguh **PIN 4-Digit & Kunci Pola (Pattern Lock 3x3)**, **Multi-Dompet**, **Sistem Anggaran Bulanan**, dan sinkronisasi **Google Cloud 24/7**.

---

## 📥 Unduh & Akses Resmi

| Saluran | Link Akses | Keterangan |
|---|---|---|
| 📲 **Download Langsung APK** | [**dasbor-pribadi.apk**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/dasbor-pribadi.apk) | Installer mandiri 1-klik cepat tanpa login |
| 📦 **GitHub Releases** | [**Halaman Rilis `apk-latest`**](https://github.com/habielmaulanaaa-svg/dasbor-pribadi/releases/tag/apk-latest) | Arsip rilis resmi & changelog APK v33.11.P2 |
| 🌐 **Akses Web PWA** | [**habielmaulanaaa-svg.github.io/dasbor-pribadi**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/) | Versi web browser / iOS Safari / Desktop (OTA Realtime) |

---

## 🌟 Fitur Baru Generasi v33.11.P2

### 1. 📅 Penyatuan Kalender Terpadu & Rekap Harian 360° (*Unified 360° Calendar*)
- **Satu Kalender Holistik**: Menggabungkan Kalender Rekap Harian (jurnal catatan & rating bintang kepuasan ⭐) dengan Kalender Aktivitas & Keuangan (arus kas & tenggat tugas) ke dalam satu antarmuka modal interaktif yang terpadu.
- **4 Indikator Titik Visual Interaktif (*Dot Indicators*)**:
  - 🟢 **Titik Hijau**: Ada transaksi pemasukan uang pada tanggal tersebut.
  - 🔴 **Titik Merah**: Ada transaksi pengeluaran uang pada tanggal tersebut.
  - 🔵 **Titik Biru**: Ada tugas dengan tenggat waktu (*deadline*) pada tanggal tersebut.
  - 🟡 **Titik Amber**: Ada catatan refleksi & rekap jurnal harian pada tanggal tersebut.
- **Panel Rincian Tanggal Terpadu (*Unified Daily Detail Panel*)**:
  - **Seksi Jurnal Harian**: Menampilkan kartu refleksi harian berwarna amber dengan rating bintang dan tombol pintasan `+ Tulis Jurnal` jika hari ini belum diisi.
  - **Seksi Transaksi Keuangan**: Menampilkan rincian transaksi kas Masuk (`+`) & Keluar (`-`) lengkap dengan subtotal harian.
  - **Seksi Tugas Jatuh Tempo**: Menampilkan daftar tugas jatuh tempo pada tanggal tersebut lengkap dengan lencana prioritas dan status penyelesaian.
- **Arsitektur Ramping & Efisien**: Menghapus modal lama `#calendar-modal` dan fungsi-fungsi redundan, menghemat memori WebView dan meningkatkan responsivitas dasbor.

### 2. 📝 Tombol Tunggal "+ Tugas Baru" & Auto-Minimize Form Tugas
- **Header Tab Tugas**: Tombol kapsul tunggal **`[+ Tugas Baru]`** di samping judul *Manajemen Tugas* untuk membuka form input secara langsung tanpa lewat dock bawah.
- **Tombol Berubah Menjadi Minimize**: Saat form terbuka, tombol di kanan atas header ini otomatis berubah menjadi **`[ Minimize ▲ ]`** untuk melipat form kapan saja agar layar tetap leluasa.
- **Card Bersih & Rapi**: Card input tugas tetap bersih dan elegan tanpa tombol ganda di dalamnya.

### 3. 💡 Wawasan Pintar Bergilir di Kartu Saldo (*Rotating Smart Insights*)
- **Animasi Bergilir Halus**:
  - Muncul anggun di bawah nominal saldo: menampilkan wawasan **Finansial** (kategori pengeluaran terbesar / total pemasukan) selama 3.5 detik dengan *fade-out* lembut.
  - Beralih menampilkan wawasan **Produktivitas** (persentase tugas tuntas / pengingat tugas mendekati tenggat) selama 3.5 detik, lalu menyusut (*smooth collapse*) rapi.
- **Proteksi Non-Duplikat (*Single-Play Guard*)**: Hanya berjalan otomatis tepat 1x saat dasbor dibuka dan tersinkronisasi sempurna dengan data Cloud tanpa pengulangan.
- **Kondisi Tanpa Aktivitas**: Jika transaksi dan tugas kosong, wawasan tidak akan muncul sama sekali.
- **Putar Ulang Interaktif**: Cukup **ketuk angka nominal saldo `Rp`** atau kapsul wawasan untuk memutar ulang wawasan pintar kapan saja!

### 4. 🎯 Prediksi Cerdas Target Tabungan (*Smart Goal Estimator*)
- Perhitungan otomatis sisa nominal yang belum terkumpul pada setiap impian/tabungan.
- Menampilkan lencana estimasi pintar: *"Sisa Rp 600.000 lagi (~6x nabung Rp 100rb)"* atau *"Sisa Rp 150.000 lagi (~3x nabung Rp 50rb)"*.
- Tombol langsung menuju simulasi impian (*Simulasi ➔*).

### 5. ⚡ Tombol Melayang Aksi Cepat (*Speed-Dial Floating Action Button / FAB*)
- Tombol bulat `+` di kanan dok navigasi bawah.
- Saat diketuk, tombol berputar 45° menjadi `✕` dan memunculkan 4 pintasan aksi cepat:
  1. 📝 **Tugas Baru**: Fokus langsung ke input nama tugas.
  2. 💸 **Catat Pengeluaran**: Beralih ke tab keuangan dan fokus ke input nominal pengeluaran.
  3. 💰 **Catat Pemasukan**: Beralih ke tab keuangan dan fokus ke input nominal pemasukan.
  4. ⚡ **Catatan Kilat**: Membuka lembar catatan kilat dari mana saja.

### 6. 🔕 Penonaktifan Respon Getar (*Haptic Feedback Fully Removed*)
- Seluruh fungsi getaran fisik dinonaktifkan sepenuhnya demi operasional dasbor yang hening, mulus, dan nyaman di semua perangkat.

### 7. 🏷️ Standarisasi Penomoran Versi Berjenjang
- Format resmi: `[Major].[Standar].[Minor/Patch]` (contoh: **`v33.11.P2`**).
  - **Major (`33`)**: Pembaruan arsitektur besar.
  - **Standar (`11`)**: Pembaruan penambahan fitur fungsional.
  - **Minor/Patch (`P1`, `P2`, dst.)**: Pembaruan perbaikan bug dan penyesuaian UX.

---

## 💎 Fitur Unggulan Lainnya

### 1. 💼 Multi-Dompet / Kantong Keuangan (*Pocket Management*)
- Pisahkan saldo kas Anda ke dalam **3 Dompet Utama**: 💵 **Uang Tunai**, 🏦 **Rekening Bank**, dan 📱 **E-Wallet**.
- Filter riwayat transaksi secara instan per dompet dengan 1 klik.

### 2. 🎯 Sistem Anggaran Bulanan (*Budgeting per Kategori*)
- Tetapkan plafon belanja bulanan per kategori (*Makanan, Transport, Hiburan, Tagihan, dsb.*).
- Progress bar dinamis 3-warna (Hijau, Kuning, Merah) dengan notifikasi Dynamic Island saat batas terlampaui.

### 3. 📅 Pelacak Transaksi Rutin & Langganan (*Subscription Tracker*)
- Pantau tagihan berulang bulanan (*WiFi, Listrik, Kos, Netflix, dsb.*).
- Badge hitung mundur jatuh tempo & tombol **1-Klik "Bayar & Catat"**.

### 4. 🩺 Indikator Skor Kesehatan Keuangan (*Financial Health Score*)
- Penilaian cerdas skor kesehatan finansial 0–100 berdasarkan rasio tabungan, kontrol belanja, dan aset cair beserta rekomendasi taktis.

### 5. 🔒 Keamanan Ganda: PIN 4-Digit & Kunci Pola 3x3
- Pilihan kunci fleksibel: **PIN 4-Digit** atau **Kunci Pola 3x3** dengan kanvas neon responsif.
- **Pemulihan Lupa Password**: Verifikasi pertanyaan keamanan rahasia tanpa menghapus data transaksi sedikit pun.
- **Anti-Brute Force**: Pembatasan percobaan dengan cooldown timer 30s–60s yang tahan terhadap reload aplikasi.

### 6. 📲 3 Pilihan Home Screen Widget Android Bawaan
- **Kartu Saldo Lengkap (4x2 / 3x2)**: Menampilkan total saldo dan tombol cepat `+ Masuk` & `- Keluar`.
- **Bar Aksi Cepat (4x1)**: Bar ramping 4 shortcut (`+ Masuk`, `- Keluar`, `Catatan`, `Impian`).
- **Widget Tugas & Aktivitas (4x2 / 3x2)**: Menampilkan jumlah tugas aktif & preview tugas prioritas.

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
│   │   ├── build.gradle       # Konfigurasi aplikasi Android
│   │   └── src/main/
│   │       ├── AndroidManifest.xml # Izin, intent filter dasbor://sync, & deklarasi 3 Widget
│   │       ├── java/com/dasbor/pribadi/
│   │       │   ├── MainActivity.java             # WebView wrapper & receiver deep-link sync
│   │       │   ├── DasborWidgetProvider.java     # Logic widget Kartu Saldo 4x2
│   │       │   ├── DasborBarWidgetProvider.java  # Logic widget Bar Aksi Cepat 4x1
│   │       │   └── TaskWidgetProvider.java       # Logic widget Tugas & Aktivitas 4x2
│   │       └── res/                              # Layout XML, adaptive icons, & preview widget
├── dasbor-pribadi.apk         # Binary APK rilis terbaru (otomatis terupdate via CI/CD)
├── index.html                 # Core App: UI super-app, multi-wallet, budget, subs, lock, cloud
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
  <sub><b>Dasbor Pribadi Mobile v33.11.P2 • Era Super-App Finansial & Produktivitas</b></sub>
</div>
