import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Ozgecmis {
    public static void main(String[] args) {
        try {
            String fontPath = System.getProperty("user.dir") + "/fonts/DejaVuSans.ttf";
            File fnt = new File(fontPath);
            if (!fnt.exists()) {
                System.err.println("HATA: Font dosyası bulunamadı: " + fontPath);
                System.err.println("Lütfen fonts/DejaVuSans.ttf dosyasını proje köküne koy.");
                return;
            }

            // BaseFont: Türkçe karakter desteği için IDENTITY_H ve EMBEDDED
            BaseFont base = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font baslikFont = new Font(base, 18, Font.BOLD);
            Font baslik2Font = new Font(base, 14, Font.BOLD);
            Font normal = new Font(base, 11, Font.NORMAL);
            Font italic = new Font(base, 10, Font.ITALIC);

            // 2) Veri
            Kisi kisi = new Kisi(
                    "Melek Naz Geçit",
                    "meleknazgecit1@gmail.com",
                    "0555 444 33 22",
                    "İstanbul, Türkiye",
                    "foto.png",
                    "https://github.com/meleknazgecit" // GitHub link
            );

            ArrayList<Egitim> egitimler = new ArrayList<>();
            egitimler.add(new Egitim("Kırklareli Üniversitesi", "Yazılım Mühendisliği", "2024 - 2028"));
            egitimler.add(new Egitim("İstanbul Anadolu Lisesi", "Sayısal", "2020 - 2024"));

            ArrayList<IsDeneyimi> deneyimler = new ArrayList<>();
            deneyimler.add(new IsDeneyimi("Yazılım Topluluğu", "Proje Üyesi", "2024 - 2025", "Kulüp projelerinde modül geliştirme ve sürüm kontrolü."));
            deneyimler.add(new IsDeneyimi("Üniversite Araştırma Asistanlığı", "Gönüllü", "2025 - 2026", "Öğretim üyesine literatür ve kod desteği."));
            deneyimler.add(new IsDeneyimi("Kırklareli Belediyesi Bilgi İşlem", "Stajyer", "2026 - 2027", "Yerel projelerde test ve hata raporlama."));

            ArrayList<String> yetenekler = new ArrayList<>();
            yetenekler.add("Java");
            yetenekler.add("Nesne Yönelimli Programlama");
            yetenekler.add("Git");
            yetenekler.add("Temel SQL");
            yetenekler.add("Linux komutları");

            String hedef = "Yapay zekâ ve yazılım geliştirme alanında kendimi geliştirip, yenilikçi projelerde yer almak istiyorum.";

            // 3) PDF oluştur
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            String outName = "Ozgecmis_ozel.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(outName));
            document.open();

            // --- Başlık + foto (iki sütunlu düzen: sol metin, sağ foto) ---
            PdfPTable header = new PdfPTable(2);
            header.setWidthPercentage(100);
            header.setWidths(new float[]{3, 1});

            // Sol hücre: isim + iletişim
            PdfPCell sol = new PdfPCell();
            sol.setBorder(Rectangle.NO_BORDER);
            Paragraph isimPar = new Paragraph(kisi.getAdSoyad(), baslikFont);
            sol.addElement(isimPar);
            sol.addElement(new Paragraph("E-posta: " + kisi.getEposta(), normal));
            sol.addElement(new Paragraph("Telefon: " + kisi.getTelefon(), normal));
            sol.addElement(new Paragraph("Adres: " + kisi.getAdres(), normal));

            // GitHub (tıklanabilir)
            Anchor githubAnchor = new Anchor(kisi.getGithub(), normal);
            githubAnchor.setReference(kisi.getGithub());
            Paragraph ghPara = new Paragraph();
            ghPara.add(new Phrase("GitHub: ", normal));
            ghPara.add(githubAnchor);
            sol.addElement(ghPara);

            header.addCell(sol);

            // Sağ hücre: fotoğraf (varsa)
            PdfPCell sag = new PdfPCell();
            sag.setBorder(Rectangle.NO_BORDER);
            File fotoFile = new File(kisi.getFotoDosyaAdi());
            if (fotoFile.exists()) {
                Image foto = Image.getInstance(kisi.getFotoDosyaAdi());
                foto.scaleToFit(140, 160);
                foto.setAlignment(Image.ALIGN_RIGHT);
                sag.addElement(foto);
            } else {
                sag.addElement(new Paragraph("Fotoğraf bulunamadı (foto.png)", italic));
            }
            header.addCell(sag);

            document.add(header);
            document.add(Chunk.NEWLINE);

            // --- Eğitim ---
            document.add(new Paragraph("Eğitim", baslik2Font));
            for (Egitim e : egitimler) {
                Paragraph p = new Paragraph(e.getOkul() + " — " + e.getBolum() + " (" + e.getDonem() + ")", normal);
                document.add(p);
            }
            document.add(Chunk.NEWLINE);

            // --- Deneyimler ---
            document.add(new Paragraph("İş Deneyimleri", baslik2Font));
            for (IsDeneyimi d : deneyimler) {
                Paragraph p = new Paragraph(d.getKurum() + " | " + d.getPozisyon() + " (" + d.getDonem() + ")", normal);
                document.add(p);
                document.add(new Paragraph("  - " + d.getAciklama(), new Font(base, 10)));
            }
            document.add(Chunk.NEWLINE);

            // --- Yetenekler ---
            document.add(new Paragraph("Yetenekler", baslik2Font));
            com.itextpdf.text.List list = new com.itextpdf.text.List(false, 10f);
            for (String y : yetenekler) list.add(new ListItem(y, normal));
            document.add(list);
            document.add(Chunk.NEWLINE);

            // --- Hedefler ---
            document.add(new Paragraph("Hedefler", baslik2Font));
            document.add(new Paragraph(hedef, normal));
            document.add(Chunk.NEWLINE);

            // Oluşturma tarihi
            document.add(new Paragraph("Oluşturuldu: " + java.time.LocalDate.now(), italic));

            document.close();
            System.out.println("PDF başarıyla oluşturuldu: " + outName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
