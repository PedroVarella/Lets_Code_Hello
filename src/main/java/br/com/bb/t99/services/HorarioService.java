package br.com.bb.t99.services;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class HorarioService {

    public String horaAtual() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
