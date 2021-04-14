package ar.edu.utn.frba.dds.macowins;

public class PrendaNueva extends Prenda {

  public PrendaNueva(double precioDeLista, String tipo) {
    super(precioDeLista, tipo);
  }
  public double precio() {
    return this.precioDeLista;
  }
}

