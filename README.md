Projek BukanPeduliLindungi
Tim ubulubul
- Patrick Nathan Wangsa (231401071)
- M. Kevin Gibran Lubis (231401065)
- Steven W. Girsang (231401059)
- Fadjar Maulana Ikhsan (231401092)
- Luthfiah Amanda Putri (231401125)

Deskripsi Proyek
BukanPeduliLindungi adalah aplikasi yang dikembangkan sebagai platform untuk memfasilitasi komunikasi antara pasien dan dokter serta mempermudah proses administrasi rumah sakit oleh admin. Platform ini bertujuan untuk meningkatkan efisiensi layanan kesehatan dengan menyediakan sistem terintegrasi bagi seluruh pihak terkait.

Link YouTube

Fitur Utama
1. Manajemen Pengguna Berdasarkan Role
- Admin
    Mengelola status dan profil pasien serta dokter.
    Mengedit dan mengatur jadwal appointment.
    Membuat dan mengelola pembayaran.
- Dokter
    Mengelola data pasien (status pasien ditentukan oleh admin).
    Membuat dan mengedit appointment, termasuk hasil diagnosis dan treatment.
- Pasien
    Melihat daftar dokter yang tersedia.
    Melakukan booking appointment dengan dokter pilihan.

2. Register dan Login Akun
- Setiap pengguna dapat melakukan registrasi dan login ke dalam sistem.
- Akun dokter dan pasien memerlukan persetujuan admin sebelum dapat digunakan.

3. Appointment Scheduling
    Pasien dan dokter dapat menentukan jadwal appointment serta mengatur hasil konsultasi.

4. Pending Account Approval
    Akun dokter dan pasien harus melalui proses persetujuan admin sebelum dapat mengakses aplikasi.

5. Dashboard
    Tersedia dashboard khusus untuk admin, dokter, dan pasien yang menampilkan informasi sesuai peran masing-masing.

6. Payment
    Sistem pembayaran yang memudahkan proses administrasi keuangan.

Role      | Fitur Utama
Admin     | Manajemen status/profil, edit appointment, kelola pembayaran
Dokter	  | Kelola pasien, buat/edit appointment, input hasil diagnosis dan treatment
Pasien	  | Lihat daftar dokter, booking appointment

Cara Menjalankan Aplikasi = 
1. Clone Github di IntellIJ IDEA
2. Buat project structure baru ke folder library yang  ("\src\main\resources\com\pos\bukanpedulilindungi\lib")
3. Buat database baru dari PhpMyAdmin(dari XAMPP aktifkan, kemudian dari phpmyadmin buat database bernama "hospital" dan ikuti sql ini =
   CREATE TABLE admin (
    admin_id INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    username VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    password VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    full_name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    image VARCHAR(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    gender VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (admin_id)
);

CREATE TABLE appointment (
    id INT(11) NOT NULL AUTO_INCREMENT,
    appointment_id INT(50) NOT NULL,
    patient_id BIGINT(50) DEFAULT NULL,
    name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    gender VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    description VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    diagnosis VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    treatment VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    mobile_number BIGINT(50) NOT NULL,
    address VARCHAR(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    date DATE NOT NULL,
    date_modify DATE DEFAULT NULL,
    date_delete DATE DEFAULT NULL,
    status VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    doctor VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    specialized VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    schedule DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE doctor (
    id INT(11) NOT NULL AUTO_INCREMENT,
    doctor_id VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    password VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    full_name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    email VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    gender VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    mobile_number BIGINT DEFAULT NULL,
    specialized VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    address VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    image VARCHAR(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    date DATE NOT NULL,
    modify_date DATE DEFAULT NULL,
    delete_date DATE DEFAULT NULL,
    status VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE patient (
    id INT(11) NOT NULL AUTO_INCREMENT,
    patient_id BIGINT NOT NULL,
    password VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    full_name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    gender VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    mobile_number BIGINT DEFAULT NULL,
    address VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    image VARCHAR(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    description VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    diagnosis VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    treatment VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    
    doctor VARCHAR(100), -- Tidak pakai foreign key
    specialized VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,

    date DATE NOT NULL,
    date_modify DATE DEFAULT NULL,
    date_delete DATE DEFAULT NULL,
    status VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    status_pay VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE payment (
    id INT(11) NOT NULL AUTO_INCREMENT,
    patient_id INT(11),
    doctor VARCHAR(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    total_days INT(11) DEFAULT NULL,
    total_price DOUBLE DEFAULT NULL,
    date DATE DEFAULT NULL,
    date_checkout DATE DEFAULT NULL,
    date_pay DATE DEFAULT NULL,

    PRIMARY KEY (id)
);

4. Ubah beberapa code pengalokasian yang terdiri atas
   a. D:\USU - LAB\Semester4\UASLABPBO\BukanPeduliLindungi\src\main\resources\com\pos\bukanpedulilindungi\Directory1\
   b. D:\USU - LAB\Semester4\UASLABPBO\BukanPeduliLindungi\src\main\resources\com\pos\bukanpedulilindungi\Directory\
   c. D:\USU - LAB\Semester4\UASLABPBO\BukanPeduliLindungi\src\main\resources\com\pos\bukanpedulilindungi\Directory2\

   menjadi nama dari lokasi file abosult dari device masing masing


Di-inspirasi dari :
    Github : https://github.com/marcoman2/HospitalManagementSystem
