# Little Lemon Capstone

**Little Lemon Capstone** adalah aplikasi Android yang dikembangkan sebagai proyek capstone dari **Meta Android Developer Professional Certificate** (Coursera). Aplikasi ini menampilkan kemampuan membangun UI modern dengan **Jetpack Compose**, navigasi antar layar, manajemen state, dan penyimpanan data pengguna.  

> **Catatan:** Desain mengikuti arahan dari Coursera (Figma), dengan beberapa adaptasi untuk implementasi terbaik di Android modern.

## Fitur

- **Onboarding Screen**  
  Pengguna memasukkan data profil seperti nama dan email. Data disimpan untuk digunakan di layar profil.  

- **Home / Menu Makanan**  
  Menampilkan daftar menu makanan. Data menu bisa diadaptasi dari JSON atau static data.  

- **Navigasi antar layar**  
  Menggunakan **Navigation Compose** untuk berpindah antar screen dengan manajemen back stack yang konsisten.  

- **Profil Pengguna**  
  Menampilkan data pengguna yang diinput saat onboarding.  

---

## Teknologi & Arsitektur

- **Kotlin** — bahasa pemrograman utama  
- **Jetpack Compose** — UI deklaratif modern  
- **Navigation Compose** — navigasi antar layar  
- **State Management** — menggunakan State / MutableState / ViewModel  
- **Penyimpanan Data** — SharedPreferences / DataStore (sesuai implementasi)  
- **Git** — version control  

---

## Desain & Alur Pengguna

1. Pengguna membuka aplikasi dan melihat layar onboarding.  
2. Setelah memasukkan data, pengguna diarahkan ke **Home**.  
3. Home menampilkan daftar menu dan informasi restoran.  
4. Pengguna bisa melihat layar **Profil** untuk data yang sudah diinput.  

> **Catatan:** Implementasi tidak 100% mirip Figma dari Coursera, beberapa bagian diadaptasi sesuai best practice Android.

---

## Cara Menjalankan

1. Clone repo:  
   ```bash
   git clone https://github.com/DhanyDelio/Little-Lemon-Capstone.git
