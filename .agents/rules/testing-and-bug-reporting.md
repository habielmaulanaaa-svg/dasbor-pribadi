# Aturan Proyek: Pengujian Pra-Rilis & Pelaporan Bug Otomatis

Aturan ini wajib ditaati pada setiap siklus pengembangan proyek **Dasbor Pribadi Mobile**:

## 1. Pengujian Mandatori Sebelum Rilis (Pre-Release Testing)
- Setiap kali ada penambahan fitur baru (**MINOR**) ataupun perbaikan masalah (**PATCH**), agen **WAJIB melakukan pengujian menyeluruh terlebih dahulu** sebelum merilis, membuat git tag, atau mengompilasi rilis baru.
- Aspek yang wajib diuji:
  - Sintaks JavaScript, CSS, dan HTML (bebas dari sintaks error atau referensi undefined).
  - Sinkronisasi identik 100% antara `index.html` dan `android/app/src/main/assets/index.html`.
  - Logika interaksi (DOM manipulation, event listeners, timer debouncing, state transitions).
  - Kompatibilitas offline dan responsivitas layout mobile.

## 2. Pemeriksaan Bug & Izin Perbaikan Otomatis
- Saat pengujian dilakukan, teliti secara proaktif apakah ada bug baru, bug tersembunyi, atau regresi sampingan.
- Agen **diberikan izin untuk memperbaiki bug yang ditemukan secara otomatis** agar kualitas aplikasi tetap prima.

## 3. Kewajiban Pelaporan Transparan kepada Pengguna
- Agen **wajib memberitahukan kepada pengguna** terkait:
  1. **Bug / masalah apa yang ditemukan** saat pengujian.
  2. **Akar penyebab masalah tersebut**.
  3. **Bagaimana cara / solusi yang diterapkan untuk memperbaikinya**.
- Laporan ini disampaikan secara jelas dan transparan dalam pesan tanggapan sebelum atau bersamaan dengan konfirmasi hasil akhir rilis.
