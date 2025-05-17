package br.com.cpsoftware.avancaif.domain.enums;

public enum Enabled {
    Y(true),
    N(false);

    private final boolean value;

    Enabled(boolean value) {
        this.value = value;
    }

    public boolean isEnabled() {
        return value;
    }
}
