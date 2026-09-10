import java.util.ArrayList;

public class Scenario {
    private String id;
    private String name;
    private String location;
    private int maxCapacityOfAssistants;
    private boolean disponibility;
    private ArrayList<Artist> artists;
    private int artistsCounter;

    public Scenario(
        String id,
        String name,
        String location,
        int maxCapacityOfAssistants,
        boolean disponibility
    ) {
        this.id = id;
        this.name = name;
        this.location = location;

        if (maxCapacityOfAssistants <= 0) {
            throw new IllegalArgumentException(
                "La capacidad máxima debe ser mayor que 0."
            );
        }

        this.maxCapacityOfAssistants = maxCapacityOfAssistants;
        this.disponibility = disponibility;
        this.artists = new ArrayList<>();
        this.artistsCounter = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public int getMaxCapacityOfAssistants() {
        return this.maxCapacityOfAssistants;
    }

    public boolean getDisponibility() {
        return this.disponibility;
    }

    public ArrayList<Artist> getArtists() {
        return this.artists;
    }

    public int getArtistsCounter() {
        return this.artists.size();
    }

    public Artist getArtistById(String artistId) {
        for (Artist artist : this.artists) {
            if (artist.getId().equals(artistId)) {
                return artist;
            }
        }

        return null;
    }

    public void setNewMaxCapacityOfAssistants(
        int newMaxCapacityOfAssistants
    ) {
        if (newMaxCapacityOfAssistants <= 0) {
            throw new IllegalArgumentException(
                "La capacidad máxima debe ser mayor que 0."
            );
        }

        this.maxCapacityOfAssistants = newMaxCapacityOfAssistants;
    }

    public void changeDisponibility() {
        this.disponibility = !this.disponibility;
    }

    public void setNewArtist(
        String artistArtisticName,
        String artistMusicalGender,
        double artistPressentationTime,
        int artistNumberOfAssistants
    ) {
        if (
            artistArtisticName == null ||
            artistArtisticName.isBlank()
        ) {
            throw new IllegalArgumentException(
                "El nombre artístico está vacío."
            );
        }

        if (
            artistMusicalGender == null ||
            artistMusicalGender.isBlank()
        ) {
            throw new IllegalArgumentException(
                "El género musical está vacío."
            );
        }

        if (artistPressentationTime <= 0) {
            throw new IllegalArgumentException(
                "El tiempo de presentación debe ser mayor que 0."
            );
        }

        if (artistNumberOfAssistants < 0) {
            throw new IllegalArgumentException(
                "El número de asistentes no puede ser negativo."
            );
        }

        this.artistsCounter++;

        String artistId = String.format(
            "ART-%s-%03d",
            this.id,
            this.artistsCounter
        );

        Artist artist = new Artist(
            artistId,
            artistArtisticName,
            artistMusicalGender,
            artistPressentationTime,
            artistNumberOfAssistants
        );

        this.artists.add(artist);
    }

    public void cancelArtist(String artistId) {
        Artist artist = getArtistById(artistId);

        if (artist == null) {
            throw new IllegalArgumentException(
                "No existe el artista."
            );
        }

        this.artists.remove(artist);
    }
}