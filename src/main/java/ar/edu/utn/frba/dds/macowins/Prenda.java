package ar.edu.utn.frba.dds.macowins;

import java.util.Optional;

public class Prenda {
  public double precioDeLista;
  public String tipo;
  public Estado estado;

  public Prenda(double precioDeLista, String tipo, Estado estado) {
    this.precioDeLista = precioDeLista;
    this.tipo = tipo;
    this.estado = estado;
  }
  public void cambiarEstadoDePrenda(Estado nuevoEstado) {
    this.estado = nuevoEstado;
  }
  public double precio(){
    return estado.precio(this.precioDeLista);
  }
  public String getTipo(){
    return tipo;
  }
}