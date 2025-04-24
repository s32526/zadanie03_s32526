public class Main {
    public static void main(String[] args) {

        BibliotekaMuzyczna mojaBiblioteka = new BibliotekaMuzyczna("Moja kolekcja", "Tomasz");

        mojaBiblioteka.dodajUtwor("Billie Eilish - Chihiro");
        mojaBiblioteka.dodajUtwor("Artemas - dirty little secret");
        mojaBiblioteka.dodajUtwor("Pet Shop Boys - I Want a Dog");
        mojaBiblioteka.dodajUtwor("Sokół - Z Tobą");
        mojaBiblioteka.dodajUtwor("Daniel Bloom - Katarakta (feat. Mela Koteluk)");

        mojaBiblioteka.wyswietlUtwory();

        mojaBiblioteka.utworzPlayliste("Chill");
        mojaBiblioteka.utworzPlayliste("Bieganie");

        mojaBiblioteka.dodajUtworDoPlaylisty("Billie Eilish - Chihiro", "Chill");
        mojaBiblioteka.dodajUtworDoPlaylisty("Pet Shop Boys - I Want a Dog", "Chill");
        mojaBiblioteka.dodajUtworDoPlaylisty("Daniel Bloom - Katarakta (feat. Mela Koteluk)", "Bieganie");
        mojaBiblioteka.dodajUtworDoPlaylisty("Artemas - dirty little secret", "Chill");

        mojaBiblioteka.wyswietlWszystkiePlaylisty();

        mojaBiblioteka.wyswietlPlayliste("Chill");

        mojaBiblioteka.wyszukajUtwory("Billie Eilish");

        mojaBiblioteka.usunUtwor("Sokół - Z Tobą");

        mojaBiblioteka.wyswietlPlayliste("Bieganie");

        System.out.println("Łączna liczba utworów w bibliotece: " + mojaBiblioteka.getLiczbaUtworow());
        System.out.println("Łączna liczba playlist: " + mojaBiblioteka.getLiczbaPlaylist());
    }
}
