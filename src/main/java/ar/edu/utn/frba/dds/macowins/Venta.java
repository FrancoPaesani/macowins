package ar.edu.utn.frba.dds.macowins;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

public class Venta {
  public ArrayList<ItemVenta> prendasVendidas = new ArrayList<>();
  public LocalDate fecha;
  protected double totalVenta;

  public Venta(LocalDate fecha) {
    this.fecha = fecha;
  }

  public void agregarPrendaAVenta(Prenda prenda, Integer cantidad) {
    prendasVendidas.add(new ItemVenta(prenda,cantidad));
  }

  public void calcularTotal() {
    if(prendasVendidas.size() > 0)
      this.totalVenta = prendasVendidas.stream().mapToDouble(item -> item.cantidad * item.prenda.precio()).sum();
    else
      throw new VentaSinPrendasException(
          "La venta no posee prendas asociadas. Agregue al menos una prenda para generar la venta");
  }

  public double getTotalVenta() { return totalVenta; }
}

class ItemVenta{
  public Prenda prenda;
  public int cantidad;

  public ItemVenta(Prenda prenda, int cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }
}