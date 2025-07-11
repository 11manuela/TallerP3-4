package Registro;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class Consulta {

    private String codigo;
    //private String fecha;
    private Veterinario veterinario;
    private LocalDate fecha;

    public Consulta(String codigo, String fecha, Veterinario veterinario) {
        /*this.codigo = codigo;
        this.fecha = fecha;
        this.veterinario = veterinario;*/
        //Validación y conversión de fecha
        setCodigo(codigo);
        setFecha(fecha);
        setVeterinario(veterinario);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }
        this.codigo = codigo;
    }

    // public String getFecha() { return fecha; }
    public LocalDate getFecha() { return fecha; }

    public void setFecha(String fechaTexto) {
        try {
            this.fecha = LocalDate.parse(fechaTexto); // Formato YYYY-MM-DD
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido.");
        }
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            throw new IllegalArgumentException("Veterinario requerido.");
        }
        this.veterinario = veterinario;
    }

    public void mostrarDetallesConsulta() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Fecha: " + fecha);
        if(veterinario != null){
            veterinario.mostrarPerfil();
        }else{
            System.out.println("Sin veterinario asignado.");
        }
        System.out.println("Veterinario: " + veterinario.getEspecialidad());

    }
}