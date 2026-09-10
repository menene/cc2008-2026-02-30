public class Festival {
    private static final int MAX_SCENARIOS = 5;

    private String name;
    private String id;
    private String coordinatorName;
    private Scenario[] scenarios;

    public Festival(
        String name,
        String id,
        String coordinatorName
    ) {
        this.name = name;
        this.id = id;
        this.coordinatorName = coordinatorName;
        this.scenarios = new Scenario[MAX_SCENARIOS];
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getCoordinatorName() {
        return this.coordinatorName;
    }

    public Scenario[] getScenarios() {
        return this.scenarios.clone();
    }

    public void setNewCoordinatorName(String newCoordinatorName) {
        if (
            newCoordinatorName == null ||
            newCoordinatorName.isBlank()
        ) {
            throw new IllegalArgumentException(
                "El nombre del coordinador no puede estar vacío."
            );
        }

        this.coordinatorName = newCoordinatorName;
    }

    private void validateScenarioIndex(int scenarioIndex) {
        if (
            scenarioIndex < 0 ||
            scenarioIndex >= this.scenarios.length
        ) {
            throw new IndexOutOfBoundsException(
                "La posición debe estar entre 1 y 5."
            );
        }
    }

    private boolean scenarioIdExists(String scenarioId) {
        for (Scenario scenario : this.scenarios) {
            if (
                scenario != null &&
                scenario.getId().equalsIgnoreCase(scenarioId)
            ) {
                return true;
            }
        }

        return false;
    }

    public void setNewScenario(
        int scenarioIndex,
        Scenario scenario
    ) {
        validateScenarioIndex(scenarioIndex);

        if (scenario == null) {
            throw new IllegalArgumentException(
                "El escenario no puede ser null."
            );
        }

        if (this.scenarios[scenarioIndex] != null) {
            throw new IllegalStateException(
                "La posición seleccionada ya está ocupada."
            );
        }

        if (scenarioIdExists(scenario.getId())) {
            throw new IllegalArgumentException(
                "Ya existe un escenario con ese código."
            );
        }

        this.scenarios[scenarioIndex] = scenario;
    }

    public Scenario getScenarioByIndex(int scenarioIndex) {
        validateScenarioIndex(scenarioIndex);

        Scenario scenario = this.scenarios[scenarioIndex];

        if (scenario == null) {
            throw new IllegalStateException(
                "No existe un escenario en esa posición."
            );
        }

        return scenario;
    }

    public void modifyScenario(
        int scenarioIndex,
        int newMaxCapacityOfAssistants,
        boolean newDisponibility
    ) {
        Scenario scenario = getScenarioByIndex(scenarioIndex);

        scenario.setNewMaxCapacityOfAssistants(
            newMaxCapacityOfAssistants
        );

        if (
            scenario.getDisponibility() !=
            newDisponibility
        ) {
            scenario.changeDisponibility();
        }
    }

    public void deleteScenario(int scenarioIndex) {
        getScenarioByIndex(scenarioIndex);
        this.scenarios[scenarioIndex] = null;
    }

    public int getConfiguredScenarios() {
        int counter = 0;

        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                counter++;
            }
        }

        return counter;
    }

    public int getDisponibleSpaces() {
        return MAX_SCENARIOS - getConfiguredScenarios();
    }

    public Scenario getScenarioWithMostNumberOfAssistants() {
        Scenario largestScenario = null;

        for (Scenario scenario : this.scenarios) {
            if (
                scenario != null &&
                (
                    largestScenario == null ||
                    scenario.getMaxCapacityOfAssistants() >
                    largestScenario.getMaxCapacityOfAssistants()
                )
            ) {
                largestScenario = scenario;
            }
        }

        return largestScenario;
    }

    public void registerArtist(
        int scenarioIndex,
        String artisticName,
        String musicalGender,
        double pressentationTime,
        int numberOfAssistants
    ) {
        Scenario scenario = getScenarioByIndex(scenarioIndex);

        scenario.setNewArtist(
            artisticName,
            musicalGender,
            pressentationTime,
            numberOfAssistants
        );
    }

    public Artist findArtistById(String artistId) {
        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                for (Artist artist : scenario.getArtists()) {
                    if (
                        artist.getId().equalsIgnoreCase(artistId)
                    ) {
                        return artist;
                    }
                }
            }
        }

        return null;
    }

    public void modifyArtist(
        String artistId,
        String newArtisticName,
        String newMusicalGender,
        double newPressentationTime,
        int newNumberOfAssistants
    ) {
        Artist artist = findArtistById(artistId);

        if (artist == null) {
            throw new IllegalArgumentException(
                "No existe un artista con ese código."
            );
        }

        if (
            newArtisticName == null ||
            newArtisticName.isBlank()
        ) {
            throw new IllegalArgumentException(
                "El nombre artístico no puede estar vacío."
            );
        }

        if (
            newMusicalGender == null ||
            newMusicalGender.isBlank()
        ) {
            throw new IllegalArgumentException(
                "El género musical no puede estar vacío."
            );
        }

        if (newPressentationTime <= 0) {
            throw new IllegalArgumentException(
                "La duración debe ser mayor que 0."
            );
        }

        if (newNumberOfAssistants < 0) {
            throw new IllegalArgumentException(
                "Los asistentes no pueden ser negativos."
            );
        }

        artist.setNewArtisticName(newArtisticName);
        artist.setNewMusicalGender(newMusicalGender);
        artist.setNewPressentationTime(
            newPressentationTime
        );
        artist.setNewNumberOfAssistants(
            newNumberOfAssistants
        );
    }

    public void cancelArtist(String artistId) {
        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                for (Artist artist : scenario.getArtists()) {
                    if (
                        artist.getId().equalsIgnoreCase(artistId)
                    ) {
                        scenario.cancelArtist(artist.getId());
                        return;
                    }
                }
            }
        }

        throw new IllegalArgumentException(
            "No existe un artista con ese código."
        );
    }

    public int getRegisteredArtist() {
        int counter = 0;

        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                counter += scenario.getArtistsCounter();
            }
        }

        return counter;
    }

    public Artist getArtistWithTheMostPresentationTime() {
        Artist longestArtist = null;

        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                for (Artist artist : scenario.getArtists()) {
                    if (
                        longestArtist == null ||
                        artist.getPressentationTime() >
                        longestArtist.getPressentationTime()
                    ) {
                        longestArtist = artist;
                    }
                }
            }
        }

        return longestArtist;
    }

    public Artist getArtistWithTheMostNumberOfAssistants() {
        Artist largestArtist = null;

        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                for (Artist artist : scenario.getArtists()) {
                    if (
                        largestArtist == null ||
                        artist.getNumberOfAssistants() >
                        largestArtist.getNumberOfAssistants()
                    ) {
                        largestArtist = artist;
                    }
                }
            }
        }

        return largestArtist;
    }

    public double getAverageOfAllPresentation() {
        double totalTime = 0;
        int artistCounter = 0;

        for (Scenario scenario : this.scenarios) {
            if (scenario != null) {
                for (Artist artist : scenario.getArtists()) {
                    totalTime += artist.getPressentationTime();
                    artistCounter++;
                }
            }
        }

        if (artistCounter == 0) {
            return 0;
        }

        return totalTime / artistCounter;
    }

    public double getAverageOfPresentationByScenario(
        int scenarioIndex
    ) {
        Scenario scenario = getScenarioByIndex(scenarioIndex);

        if (scenario.getArtists().isEmpty()) {
            return 0;
        }

        double totalTime = 0;

        for (Artist artist : scenario.getArtists()) {
            totalTime += artist.getPressentationTime();
        }

        return totalTime / scenario.getArtistsCounter();
    }
}