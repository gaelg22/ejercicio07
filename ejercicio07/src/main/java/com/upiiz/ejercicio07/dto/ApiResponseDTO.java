package com.upiiz.ejercicio07.dto;

public class ApiResponseDTO {

    private String estado;
    private String mensaje;
    private Object data;

    public ApiResponseDTO(String estado, String mensaje, Object data) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
