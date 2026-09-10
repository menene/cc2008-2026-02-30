public class Artist {
    private String id;
    private String artisticName;
    private String musicalGender;
    private double pressentationTime;
    private int numberOfAssistants;

    public Artist(
        String id,
        String artisticName,
        String musicalGender,
        double pressentationTime,
        int numberOfAssistants
    ) {
        this.id = id;
        this.artisticName = artisticName;
        this.musicalGender = musicalGender;

        if (pressentationTime <= 0) {
            throw new IllegalArgumentException(
                "La duración debe ser mayor que 0."
            );
        }

        if (numberOfAssistants < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa."
            );
        }

        this.pressentationTime = pressentationTime;
        this.numberOfAssistants = numberOfAssistants;
    }

    public String getId() {
        return this.id;
    }

    public String getArtisticName() {
        return this.artisticName;
    }

    public String getMusicalGender() {
        return this.musicalGender;
    }

    public double getPressentationTime() {
        return this.pressentationTime;
    }

    public int getNumberOfAssistants() {
        return this.numberOfAssistants;
    }

    public void setNewArtisticName(String newArtisticName) {
        this.artisticName = newArtisticName;
    }

    public void setNewMusicalGender(String newMusicalGender) {
        this.musicalGender = newMusicalGender;
    }

    public void setNewPressentationTime(double newPressentationTime) {
        this.pressentationTime = newPressentationTime;
    }

    public void setNewNumberOfAssistants(int newNumberOfAssistants) {
        this.numberOfAssistants = newNumberOfAssistants;
    }
}