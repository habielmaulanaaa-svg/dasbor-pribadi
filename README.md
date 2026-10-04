<p align="center">
  <img src="icon-512.png" width="128" height="128" alt="Logo Dasbor Pribadi" style="border-radius: 28px; box-shadow: 0 8px 24px rgba(0,0,0,0.18);" />
</p>

# 📱 Dasbor Pribadi Mobile — Progressive Web App (PWA) v1.1.5 (Stable)

[![Web PWA](https://img.shields.io/badge/Web%20PWA-100%25%20Offline--First-emerald?style=for-the-badge&logo=googlechrome&logoColor=white)](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)
[![Cloud Database](https://img.shields.io/badge/Cloud%20Sync-Firebase%20Firestore-orange?style=for-the-badge&logo=firebase&logoColor=white)](https://firebase.google.com/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

Aplikasi manajemen keuangan, tabungan, impian, dan produktivitas pribadi all-in-one yang berjalan sebagai **Progressive Web App (PWA) 100% Offline-First**. Aplikasi ini menggabungkan keindahan **CSS Grid Fluid Physics (0fr ➔ 1fr)**, respons mikro-taktil 120 FPS tanpa jeda, multi-dompet keuangan, kalender aktivitas 365°, manajemen tugas hierarkis dengan sub-tugas, limit anggaran bulanan, tagihan berulang, dan sinkronisasi cloud opsional Google Firebase.

---

## 🏷️ Skema Semantic Versioning Resmi (`MAJOR.MINOR.PATCH`)

Aplikasi ini menggunakan skema penomoran versi 3 tingkatan dengan penanda resmi `(Stable)`:

| Tingkat | Format | Deskripsi & Aturan | Contoh |
|:---:|:---:|---|---|
| **PATCH** | `1.0.X (Stable)` | Digunakan untuk **perbaikan bug / hotfix / perbaikan visual ringan** tanpa menambah fitur baru. | `1.1.4` ➔ `1.1.5 (Stable)` |
| **MINOR** | `1.X.0 (Stable)` | Digunakan saat ada **penambahan fitur baru** yang tetap kompatibel dengan data sebelumnya. | `1.0.0` ➔ `1.1.0 (Stable)` |
| **MAJOR** | `X.0.0 (Stable)` | Digunakan untuk **perombakan antarmuka (UI) besar-besaran** atau restrukturisasi sistem mendasar. | `1.1.0` ➔ `2.0.0 (Stable)` |

---

## 🌐 Akses & Pemasangan PWA (Progressive Web App)

Aplikasi dapat dibuka dan diinstal langsung dari peramban ponsel tanpa perlu mengunduh file APK manual:

* **URL Resmi**: [**habielmaulanaaa-svg.github.io/dasbor-pribadi**](https://habielmaulanaaa-svg.github.io/dasbor-pribadi/)

### Cara Memasang ke Layar Utama (*Install App*):
1. **Google Chrome (Android / Desktop)**:
   - Buka URL resmi di Chrome.
   - Tekan menu titik tiga (**⋮**) di pojok kanan atas.
   - Pilih **"Tambahkan ke Layar Utama"** atau **"Install App"**.
2. **Safari (iOS / iPhone)**:
   - Buka URL resmi di Safari.
   - Tekan tombol **Share** (kotak dengan panah ke atas).
   - Pilih **"Add to Home Screen" (Tambahkan ke Layar Utama)**.

---

## 🚀 Fitur Unggulan

1. **100% Offline-First & Zero-Knowledge**:
   - Seluruh data transaksi, tugas, dan jurnal tersimpan di `localStorage` perangkat.
   - Seluruh pustaka styling Tailwind CSS dan ikon FontAwesome tersimpan lokal di cache perangkat melalui Service Worker (`dasbor-pwa-v1-1-5-stable`).
   - Aplikasi dapat dibuka dan digunakan dengan lancar saat tidak ada koneksi internet (Mode Pesawat).
2. **Multi-Dompet Keuangan (Multi-Wallet)**:
   - Kelola berbagai kantong dana (Tunai, Bank, E-Wallet, Tabungan) dengan sensor privasi saldo.
3. **Produktivitas & Tugas Hierarkis**:
   - Daftar tugas dengan tingkat prioritas, tenggat waktu, sub-tugas (checklist) dinamis, dan efek gamifikasi konfeti.
4. **Jurnal & Refleksi Harian**:
   - Setor rekap kepuasan harian (bintang 1–5), mood tracker, dan kalender heatmap konsistensi.
5. **Limit Anggaran & Tagihan Berulang**:
   - Pantau plafon pengeluaran bulanan per kategori dan daftar langganan rutin (Subscriptions).
6. **Kilas Balik Tahunan (Yearly Wrapped)**:
   - Kartu rangkuman visual produktivitas dan finansial akhir tahun bergaya Spotify Wrapped.
7. **Cadangan Data & Reset Selektif**:
   - Ekspor/impor JSON lengkap untuk keamanan data offline dan modal reset selektif per modul.
8. **Sinkronisasi Cloud Opsional**:
   - Sinkronisasi instan antar-perangkat via Google Firebase Firestore bagi pengguna yang menghendakinya.

---

## 📂 Struktur Repositori

```text
dasbor-mobile/
├── index.html                 # Core App: SPA super-app, multi-wallet, budget, subs, cloud
├── privacy.html               # Halaman Kebijakan Privasi (Privacy Policy) mandiri dwibahasa
├── tailwind.js                # Bundel lokal Tailwind CSS (100% Offline & bebas redirect)
├── manifest.json              # Web App Manifest PWA
├── sw.js                      # Service Worker (Cache management v1.1.5 Stable)
├── icon-192.png               # Ikon Web PWA 192x192
├── icon-512.png               # Ikon Web PWA 512x512
└── README.md                  # Dokumentasi resmi proyek
```

---

<div align="center">
  <sub>Dikembangkan dengan ❤️ untuk kemudahan pencatatan finansial & produktivitas harian.</sub><br>
  <sub><b>Dasbor Pribadi Mobile v1.1.5 (Stable) • Progressive Web App (PWA) Offline-First</b></sub>
</div>
