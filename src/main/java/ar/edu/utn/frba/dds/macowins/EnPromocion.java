package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.Estado;

public class EnPromocion extends Estado {
  public double descuento;

  public EnPromocion(double descuento) {
    this.descuento = descuento;
  }
  public double precio(double precioDeLista) {
    return precioDeLista - this.descuento;
  }
}


