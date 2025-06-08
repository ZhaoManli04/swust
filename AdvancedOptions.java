package lab4_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedOptions {
    private List<Source> importantSources = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();
    private List<Carrier> carriers = new ArrayList<>();
    private Date publishDateStart;
    private Date publishDateEnd;
    private boolean intelligentExpansion;

    // Getters and Setters
    public List<Source> getImportantSources() { return importantSources; }
    public void setImportantSources(List<Source> importantSources) { this.importantSources = importantSources; }

    public List<Language> getLanguages() { return languages; }
    public void setLanguages(List<Language> languages) { this.languages = languages; }

    public List<Carrier> getCarriers() { return carriers; }
    public void setCarriers(List<Carrier> carriers) { this.carriers = carriers; }

    public boolean isIntelligentExpansion() { return intelligentExpansion; }
    public void setIntelligentExpansion(boolean intelligentExpansion) {
        this.intelligentExpansion = intelligentExpansion;
    }

    public void addSource(Source source) {
        importantSources.add(source);
    }

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public void addCarrier(Carrier carrier) {
        carriers.add(carrier);
    }
    public void addDate(Date publishDateStart,  Date publishDateEnd){
        this.publishDateStart=publishDateStart;
        this.publishDateEnd=publishDateEnd;
    }
}
