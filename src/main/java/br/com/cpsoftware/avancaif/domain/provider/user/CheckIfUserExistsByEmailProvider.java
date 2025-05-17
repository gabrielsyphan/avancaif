package br.com.cpsoftware.avancaif.domain.provider.user;

public interface CheckIfUserExistsByEmailProvider {

    boolean apply(String email);
}
