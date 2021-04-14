package ar.edu.utn.frba.dds.macowins;

public class PrendaEnPromocion extends Prenda {
  public int descuento;

  public PrendaEnPromocion(double precioDeLista, String tipo, int descuento) {
    super(precioDeLista, tipo);
    this.descuento = descuento;
  }
  public double precio() {
    return this.precioDeLista - this.descuento;
  }
}
