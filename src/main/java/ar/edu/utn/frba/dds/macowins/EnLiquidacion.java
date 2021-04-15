package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.Estado;

public class EnLiquidacion extends Estado {
  public double precio(double precioDeLista) {
    return precioDeLista / 2;
  }
}

