# 📱 Dasbor Pribadi Mobile (PWA & APK Ready)

Aplikasi manajemen tugas, keuangan, dan jurnal harian pribadi berbasis **Progressive Web App (PWA)** modern. Berjalan 100% secara native, aman, dan offline di smartphone (**Perangkat Android / iOS**) dengan dukungan hosting **Cloud 24/7** dan **Pembaruan Otomatis (OTA)**.

🌐 **Link Resmi Aplikasi**: [https://habielmaulanaaa-svg.github.io/dasbor-pribadi/](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)

---

## ✨ Fitur Unggulan

- ☁️ **Online 24/7 Nonstop**: Dihosting resmi di GitHub Pages dengan enkripsi HTTPS SSL. Laptop/PC tidak perlu menyala.
- 📲 **Native WebAPK Installation**: Dapat di-install langsung ke layar utama & app drawer Perangkat Android tanpa address bar browser.
- ⚡ **Pembaruan Otomatis (OTA Pipeline)**: Setiap pembaruan kode langsung tersinkronisasi otomatis ke aplikasi di ponsel melalui *Network-First Service Worker*.
- 🏝️ **Notifikasi iOS Dynamic Island**: Notifikasi pembaruan elegan bergaya kapsul iOS yang muncul otomatis saat versi baru terpasang.
- 📴 **100% Offline Ready**: Data dan aset tersimpan di memori perangkat melalui Service Worker & LocalStorage sehingga tetap bisa digunakan tanpa kuota internet.
- 🔒 **Data Pribadi Aman**: Seluruh transaksi, catatan jurnal, dan saldo tersimpan lokal di perangkat pengguna.

---

## 📂 Struktur File

```text
dasbor-mobile/
│
├── index.html            # Aplikasi Dasbor PWA (UI & Controller Utama)
├── manifest.json         # Konfigurasi PWA WebAPK (Nama, Ikon, Standalone Display)
├── sw.js                 # Service Worker (Network-First Navigation & Offline Cache)
├── icon-192.png          # Ikon aplikasi resolusi 192x192
├── icon-512.png          # Ikon aplikasi resolusi 512x512
└── README.md             # Dokumentasi proyek & panduan penggunaan
```

---

## 🚀 Cara Pasang di Perangkat Android

1. Buka browser **Google Chrome** di Perangkat Android Anda.
2. Kunjungi alamat resmi: **[https://habielmaulanaaa-svg.github.io/dasbor-pribadi/](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)**
3. Tap tombol **"Install"** pada banner yang muncul, atau buka menu titik tiga (⋮) di Chrome lalu pilih **"Install Aplikasi"** / **"Tambahkan ke Layar Utama"**.
4. **Selesai!** Ikon Dasbor Pribadi akan langsung terpasang di layar utama & laci aplikasi HP Anda.

---

## 🔄 Alur Pembaruan Otomatis (OTA)

1. Perubahan atau fitur baru di-*push* ke repositori GitHub melalui Git.
2. GitHub Pages membangun versi terbaru dalam ~45 detik.
3. Saat aplikasi di HP dibuka, Service Worker mendeteksi file baru dan memperbarui sistem secara otomatis.
4. Notifikasi kapsul bergaya **iOS Dynamic Island** akan muncul satu kali untuk memberitahukan versi baru beserta ringkasan catatan pembaruan (*changelog*).

---

## 📦 Mengubah Menjadi File Mentah `.APK` (Opsional)

Jika ingin membagikan installer mandiri bertipe file `.apk`:
1. Buka [https://www.pwabuilder.com/](https://www.pwabuilder.com/).
2. Masukkan URL: `https://habielmaulanaaa-svg.github.io/dasbor-pribadi/`.
3. Klik **"Package for Stores"** > **Android**.
4. Unduh file `.apk` mentah siap pasang.
