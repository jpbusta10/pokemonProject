package model.exceptions;

public class FullSquadException extends Exception{
    @Override
    public String getMessage() {
        return "El equipo pokemon esta completo.";
    }
}
