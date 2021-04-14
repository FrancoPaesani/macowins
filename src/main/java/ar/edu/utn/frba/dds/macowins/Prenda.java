package ar.edu.utn.frba.dds.macowins;

public abstract class Prenda {
  public double precioDeLista;
  public String tipo;

  public Prenda(double precioDeLista, String tipo) {
    this.precioDeLista = precioDeLista;
    this.tipo = tipo;
  }
  public double precio(){
    return 0;
  }
  public String getTipo(){
    return tipo;
  }
}