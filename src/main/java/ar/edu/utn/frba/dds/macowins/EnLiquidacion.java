package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.Estado;

public class EnLiquidacion implements Estado {
  public double precio(double precioDeLista) {
    return precioDeLista / 2;
  }
}

