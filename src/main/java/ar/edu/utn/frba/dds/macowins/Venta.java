package ar.edu.utn.frba.dds.macowins;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

public class Venta {
  public Map<Prenda,Integer> prendasVendidas = new HashMap<>();
  public LocalDate fecha;
  public TipoPago tipoPago;
  private double totalVenta;

  public Venta(TipoPago tipoPago, LocalDate fecha) {
    this.tipoPago = tipoPago;
    this.fecha = fecha;
  }

  public void agregarPrendaAVenta(Prenda prenda, Integer cantidad) {
    if(prendasVendidas.containsKey(prenda)) {
      Integer previo = prendasVendidas.get(prenda);
      prendasVendidas.put(prenda,previo + cantidad);
    }else{
      prendasVendidas.put(prenda, cantidad); }
  }

  public double calcularSubTotal() {
    double subtotal = 0;
    for(Map.Entry<Prenda, Integer> entry : prendasVendidas.entrySet()) {
      subtotal += entry.getValue() * entry.getKey().precio() + this.tipoPago.recargoPorPrenda(entry.getKey()) * entry.getValue() ;
    }
    return subtotal;
  }

  public void calcularTotal() {
    if(this.prendasVendidas.size() > 0)
    this.totalVenta = calcularSubTotal() + this.tipoPago.calcularRecargo();
    else
      throw new VentaSinPrendasException(
          "La venta no posee prendas asociadas. Agregue al menos una prenda para generar la venta");
  }

  public double getTotalVenta() { return totalVenta; }
}

class TipoPago {
  public double calcularRecargo() {
    return 0;
  }
  public double recargoPorPrenda(Prenda prenda){ return 0; }
}

class Efectivo extends TipoPago {
  public double calcularRecargo() { return 0; }
  public double recargoPorPrenda(Prenda prenda){ return 0; }
}

class Tarjeta extends TipoPago {
  private int cantidadCuotas;
  private double coeficienteFijo;

  public Tarjeta(int cantidadCuotas, double coeficienteFijo) {
    this.cantidadCuotas = cantidadCuotas;
    this.coeficienteFijo = coeficienteFijo;
  }

  public void Tarjeta(int cantidadCuotas) {
    this.cantidadCuotas = cantidadCuotas;
  }

  public double calcularRecargo() { return cantidadCuotas * coeficienteFijo; }

  public double recargoPorPrenda(Prenda prenda) {
    return prenda.precio() * 0.01;
  }
}