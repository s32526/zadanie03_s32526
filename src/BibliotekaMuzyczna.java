import java.util.ArrayList;

public class BibliotekaMuzyczna {

    private String nazwa;
    private String wlasciciel;
    private ArrayList<String> utwory;
    private ArrayList<Playlista> playlisty;

    public BibliotekaMuzyczna(String nazwa, String wlasciciel) {
        this.nazwa = nazwa;
        this.wlasciciel = wlasciciel;
        this.utwory = new ArrayList<>();
        this.playlisty = new ArrayList<>();
    }

    public void dodajUtwor(String utwor) {
        if (!utwory.contains(utwor)) {
            utwory.add(utwor);
        }
    }

    public void usunUtwor(String utwor) {
        utwory.remove(utwor); // usuwa z głównej listy

        for (Playlista playlista : playlisty) {
            playlista.usunUtwor(utwor); // usuwa z każdej playlisty
        }
    }

    public void wyswietlUtwory() {
        System.out.println("Utwory w bibliotece:");
        for (int i = 0; i < utwory.size(); i++) {
            System.out.println((i + 1) + ". " + utwory.get(i));
        }
    }

    public void wyszukajUtwory(String fraza) {
        System.out.println("Wyniki wyszukiwania dla: \"" + fraza + "\"");
        boolean znaleziono = false;

        for (String utwor : utwory) {
            if (utwor.toLowerCase().contains(fraza.toLowerCase())) {
                System.out.println("- " + utwor);
                znaleziono = true;
            }
        }

        if (!znaleziono) {
            System.out.println("Brak wyników.");
        }
    }

    public void utworzPlayliste(String nazwaPlaylisty) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equalsIgnoreCase(nazwaPlaylisty)) {
                System.out.println("Playlista o nazwie \"" + nazwaPlaylisty + "\" już istnieje.");
                return;
            }
        }
        playlisty.add(new Playlista(nazwaPlaylisty));
        System.out.println("Utworzono playlistę: " + nazwaPlaylisty);
    }

    private Playlista znajdzPlayliste(String nazwaPlaylisty) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equalsIgnoreCase(nazwaPlaylisty)) {
                return p;
            }
        }
        return null;
    }

    public void dodajUtworDoPlaylisty(String utwor, String nazwaPlaylisty) {
        Playlista playlista = znajdzPlayliste(nazwaPlaylisty);
        if (playlista == null) {
            System.out.println("Playlista \"" + nazwaPlaylisty + "\" nie istnieje.");
            return;
        }

        if (!utwory.contains(utwor)) {
            System.out.println("Utwór \"" + utwor + "\" nie istnieje w bibliotece.");
            return;
        }

        playlista.dodajUtwor(utwor);
        System.out.println("Dodano utwór \"" + utwor + "\" do playlisty \"" + nazwaPlaylisty + "\".");
    }

    public void wyswietlPlayliste(String nazwaPlaylisty) {
        Playlista playlista = znajdzPlayliste(nazwaPlaylisty);
        if (playlista == null) {
            System.out.println("Playlista \"" + nazwaPlaylisty + "\" nie istnieje.");
            return;
        }

        playlista.wyswietl();
    }

    public void wyswietlWszystkiePlaylisty() {
        if (playlisty.isEmpty()) {
            System.out.println("Brak dostępnych playlist.");
            return;
        }

        for (Playlista playlista : playlisty) {
            playlista.wyswietl();
            System.out.println(); // dla czytelności między playlistami
        }
    }

    public int getLiczbaUtworow() {
        return utwory.size();
    }

    public int getLiczbaPlaylist() {
        return playlisty.size();
    }


}
