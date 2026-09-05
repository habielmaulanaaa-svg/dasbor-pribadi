# 📱 Dasbor Pribadi Mobile (PWA & APK Ready)

Aplikasi manajemen tugas, keuangan, dan jurnal harian pribadi berbasis Progressive Web App (PWA) yang berjalan 100% secara native dan offline di smartphone (Android / Google Pixel 6 / iOS).

---

## 📂 Struktur File
```
dasbor-mobile/
│
├── index.html            # Aplikasi utama Dasbor v29.70 (PWA Ready)
├── manifest.json         # Konfigurasi identitas aplikasi, warna tema, & mode fullscreen
├── sw.js                 # Service Worker (Offline Cache-First Engine)
├── icon-192.png          # Ikon aplikasi resolusi 192x192
├── icon-512.png          # Ikon aplikasi resolusi 512x512
├── run_server.bat        # Launcher 1-klik untuk menjalankan server di Windows
├── run_server.ps1        # Script server lokal PowerShell dengan deteksi IP otomatis
└── README.md             # Panduan instalasi & pembuatan APK
```

---

## 🚀 Cara Install Langsung di HP (Google Pixel 6):

### Langkah 1: Jalankan Server Lokal di Komputer
1. Pastikan HP dan Laptop/PC Anda terhubung ke **jaringan Wi-Fi yang sama**.
2. Klik ganda file `run_server.bat` di folder ini.
3. Jendela konsol akan menampilkan alamat IP lokal, contoh:
   ```
   http://192.168.1.15:8080
   ```

### Langkah 2: Buka & Install di HP
1. Buka browser **Google Chrome** di Google Pixel 6 Anda.
2. Ketik alamat IP yang muncul di layar laptop (contoh: `http://192.168.1.15:8080`).
3. Anda akan melihat tombol **"Install"** di bagian atas, atau Anda bisa mengetuk menu titik tiga (⋮) di pojok kanan atas Chrome, lalu pilih **"Install Aplikasi"** / **"Tambahkan ke Layar Utama"**.
4. **Selesai!** Aplikasi akan langsung terpasang di Home Screen & Laci Aplikasi (App Drawer) Anda dan dapat digunakan selamanya tanpa internet (100% Offline).

---

## 📦 Cara Mengubah Menjadi File Mentah `.APK` (Standar Google Play):
Jika Anda ingin memiliki file `.apk` mandiri yang bisa dibagikan langsung:
1. Upload folder `dasbor-mobile` ke GitHub atau hosting gratis (seperti Vercel / Netlify / GitHub Pages).
2. Buka [https://www.pwabuilder.com/](https://www.pwabuilder.com/).
3. Masukkan link web Anda, lalu klik **"Package for Stores"** > **Android**.
4. Klik **"Generate APK / AAB"** dan Anda langsung mendapatkan file installer `.apk` asli siap pakai!
