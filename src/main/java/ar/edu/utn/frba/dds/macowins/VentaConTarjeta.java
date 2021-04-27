package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDate;

public class VentaConTarjeta extends Venta {
  public int cantidadCuotas;
  public double coeficienteFijo;

  public VentaConTarjeta(LocalDate fecha, int cantidadCuotas, double coeficienteFijo) {
    super(fecha);
    this.cantidadCuotas = cantidadCuotas;
    this.coeficienteFijo = coeficienteFijo;
  }

  public VentaConTarjeta(LocalDate fecha) {
    super(fecha);
  }
  public void calcularTotal() {
    super.calcularTotal();
    this.totalVenta += this.prendasVendidas.stream().mapToDouble(
        itemVenta -> itemVenta.cantidad * itemVenta.prenda.precio() * 0.01
    ).sum() + cantidadCuotas * coeficienteFijo;
  }
}
