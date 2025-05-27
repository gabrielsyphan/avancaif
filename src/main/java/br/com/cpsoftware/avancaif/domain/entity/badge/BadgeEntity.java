package br.com.cpsoftware.avancaif.domain.entity.badge;

import java.util.List;

public class BadgeEntity {
    private Long id;
    private String title;
    private String description;
    private List<String> technologies;
    private String imageUrl;

    public BadgeEntity() {}

    public BadgeEntity(String title, String description, List<String> technologies, String imageUrl) {
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
