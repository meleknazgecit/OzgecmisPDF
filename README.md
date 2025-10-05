# Özgeçmiş PDF Oluşturucu - Java Projesi

Bu proje, Java ve iTextPDF kütüphanesi kullanarak dinamik olarak özgeçmiş (CV) PDF dosyaları oluşturan bir uygulamadır. Türkçe karakter desteği ile profesyonel özgeçmişler hazırlanabilir.

## Özellikler
- ✅ Türkçe karakter desteği
- ✅ Fotoğraf ekleme
- ✅ Tıklanabilir GitHub linki
- ✅ Temiz ve profesyonel tasarım
- ✅ Dinamik veri girişi
- ✅ Eğitim bilgileri bölümü
- ✅ İş deneyimleri bölümü
- ✅ Yetenekler listesi
- ✅ Kariyer hedefleri bölümü
- 
## Kurulum ve Çalıştırma

### 1. Gereksinimler
- Java JDK 8 veya üzeri
- iTextPDF kütüphanesi (itextpdf-5.5.13.jar)

### 2. Font Kurulumu
Proje kök dizininde `fonts/` klasörü oluşturun ve `DejaVuSans.ttf` font dosyasını buraya yerleştirin.

### 3. Derleme ve Çalıştırma

*Windows için:*
#### Java dosyalarını derle
javac -cp "itextpdf-5.5.13.jar" src/*.java

#### Programı çalıştır
java -cp ".;itextpdf-5.5.13.jar;src" Ozgecmis

## Özelleştirme
Ozgecmis.java dosyasındaki aşağıdaki bölümleri kendi bilgilerinizle güncelleyin:

**// Kişi bilgileri**

Kisi kisi = new Kisi(
    "Adınız Soyadınız",
    "email@example.com",
    "0555 444 33 22",
    "Şehir, Ülke",
    "foto.png",
    "https://github.com/kullaniciadiniz"
);

**// Eğitim bilgileri**

egitimler.add(new Egitim("Üniversite Adı", "Bölüm", "2024 - 2028"));

**// İş deneyimleri**

deneyimler.add(new IsDeneyimi("Şirket Adı", "Pozisyon", "2024 - 2025", "Açıklama"));

**// Yetenekler**

yetenekler.add("Java");

yetenekler.add("Spring Boot");

**//Fotoğraf Ekleme**

Proje kök dizinine foto.png adında bir fotoğraf ekleyin

Boyut: 140x160 piksel önerilir

Format: PNG veya JPG

## Çıktı Örneği
 Oluşturulan PDF şu bölümleri içerir:

- Kişisel Bilgiler (Fotoğraflı)

- Eğitim Geçmişi

- İş Deneyimleri

- Teknik Yetenekler

- Kariyer Hedefleri

- Oluşturulma Tarihi

//Not: Bu proje Java ve iTextPDF kütüphanesi kullanılarak geliştirilmiştir. PDF oluşturma işlemleri için iTextPDF 5.5.13 sürümü gereklidir.//
