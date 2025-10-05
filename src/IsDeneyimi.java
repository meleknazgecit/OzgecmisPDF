public class IsDeneyimi {
    private String kurum;
    private String pozisyon;
    private String donem;
    private String aciklama;

    public IsDeneyimi(String kurum, String pozisyon, String donem, String aciklama) {
        this.kurum = kurum;
        this.pozisyon = pozisyon;
        this.donem = donem;
        this.aciklama = aciklama;
    }

    public String getKurum() { return kurum; }
    public String getPozisyon() { return pozisyon; }
    public String getDonem() { return donem; }
    public String getAciklama() { return aciklama; }
}
