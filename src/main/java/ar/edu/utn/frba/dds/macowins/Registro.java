package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Registro {
  public ArrayList<Venta> listadoVentas = new ArrayList<>();

  public void registrarVenta(Venta venta) {
    listadoVentas.add(venta);
  }

  public double obtenerGananciasFecha(LocalDate fecha) {
    double ganancias = obtenerVentasFecha(fecha).map(Venta::getTotalVenta).reduce(Double::sum).orElse((double) -1);
    return ganancias;
  }

  public Stream<Venta> obtenerVentasFecha(LocalDate fecha) {
    return listadoVentas.stream().filter(venta -> venta.fecha == fecha);
  }
}
