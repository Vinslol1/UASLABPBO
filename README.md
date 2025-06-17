Projek BukanPeduliLindungi
- Patrick Nathan Wangsa (231401071)
- M. Kevin Gibran Lubis (231401065)
- Steven W. Girsang (231401059)
- Fadjar Maulana Ikhsan (231401092)
- Luthfiah Amanda Putri (231401125)

Link Youtube : 

Aplikasi ini akan dikembangkan sebagai platform yang memfasilitasi komunikasi antara pasien dan dokter serta mempermudah proses administrasi rumah sakit oleh admin.
Aplikasi ini terdiri atas:
1. Admin : 
- Role yang bisa mengatur status dan profile dari pasien dan dokter
- Edit Appointment
- Membuat Payment 
2. Dokter :
- Role yang mengatur dalam pembuatan pasien (status dari pasien ditentukan admin)
- Membuat dan mengedit Appointment dan hasil dari appointment tersebut (dalam treatment dan diagnosis)
3. Pasien :
- Melihat list list dokter yang ada
- Booking Appointment
4. Register/Login : Register & Login Account
   
Fitur fitur aplikasi =
- Appointment Scheduling = Pasien & Dokter bisa menentukan appointment dan hasilnya
- Pending Account Approval = Dokter & Pasien ketika account nya harus menunggu presetujuan admin baru bisa dilogin
- Dashboard = Di halaman utama admin, pasien, dan dokter terdapat dashboard yang memberitahu informasi yang sesuai
- Payment = Pembayaran yang disesuaikan dari appointment

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
