package ar.edu.utn.frba.dds.macowins;

public class PrendaEnLiquidacion extends Prenda {

  public PrendaEnLiquidacion(double precioDeLista, String tipo) {
    super(precioDeLista, tipo);
  }
  public double precio() {
    return this.precioDeLista / 2;
  }
}
