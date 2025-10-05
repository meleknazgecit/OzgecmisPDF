public class Kisi {
    private String adSoyad;
    private String eposta;
    private String telefon;
    private String adres;
    private String fotoDosyaAdi;
    private String github;

    public Kisi(String adSoyad, String eposta, String telefon, String adres, String fotoDosyaAdi, String github) {
        this.adSoyad = adSoyad;
        this.eposta = eposta;
        this.telefon = telefon;
        this.adres = adres;
        this.fotoDosyaAdi = fotoDosyaAdi;
        this.github = github;
    }

    public String getAdSoyad() { return adSoyad; }
    public String getEposta() { return eposta; }
    public String getTelefon() { return telefon; }
    public String getAdres() { return adres; }
    public String getFotoDosyaAdi() { return fotoDosyaAdi; }
    public String getGithub() { return github; }
}
