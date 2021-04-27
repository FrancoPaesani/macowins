package ar.edu.utn.frba.dds.macowins;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }

  @Test
  public void agregoDosElementosALaLista() {
    VentaEfectivo venta = new VentaEfectivo(null);
    venta.agregarPrendaAVenta(pantalonEnPromocion(1500, 100),2);
    venta.agregarPrendaAVenta(camisaNueva(4000),1);
    assertEquals(venta.prendasVendidas.size(), 2, 0);
  }

  @Test
  public void laFechaCamisaNuevaEsFecha13042021() {
    VentaEfectivo venta = new VentaEfectivo(fecha13Abril());
    venta.agregarPrendaAVenta(camisaNueva(4000),1);
    LocalDate fecha = LocalDate.of(2021, Month.APRIL, 13);
    assertEquals(venta.fecha.toString(),"2021-04-13");
  }

  @Test
  public void vendoDosSacosEnPromocionIgualesValorEsElValorDeUnSaco() {
    VentaEfectivo venta = new VentaEfectivo(null);
    venta.agregarPrendaAVenta(sacoEnLiquidacion(2000),1);
    venta.agregarPrendaAVenta(sacoEnLiquidacion(2000),1);
    venta.calcularTotal();
    assertEquals(venta.prendasVendidas.size(),2);
    assertEquals(venta.getTotalVenta(),1000 + 1000, 0);
  }

  @Test
  public void RegistroDosVentasDeTresMilGananciaFechaSeisMil() {
    LocalDate fecha = fecha13Abril();
    Registro registro = new Registro();
    VentaEfectivo venta1 = new VentaEfectivo(fecha);
    VentaEfectivo venta2 = new VentaEfectivo(fecha);
    venta1.agregarPrendaAVenta(camisaNueva(3000),1);
    registro.registrarVenta(venta1);
    venta2.agregarPrendaAVenta(camisaNueva(3000),1);
    registro.registrarVenta(venta2);
    venta1.calcularTotal();
    venta2.calcularTotal();
    assertEquals(registro.obtenerGananciasFecha(fecha), 6000, 0);
  }

  @Test
  public void VentaSinPrendasGenerarExcepcion() {
    VentaEfectivo venta = new VentaEfectivo(fecha13Abril());
    try{
      venta.calcularTotal();
    }
    catch (VentaSinPrendasException programException){
      assertTrue(programException.getMessage().contains(
          "La venta no posee prendas asociadas. Agregue al menos una prenda para generar la venta"));
    }
  }

  @Test
  public void compro2SacosEnLiquidacionEn3Cuotas() {
    LocalDate fecha = fecha13Abril();
    Registro registro = new Registro();
    VentaConTarjeta venta = new VentaConTarjeta(fecha, 3, 5);
    venta.agregarPrendaAVenta(sacoEnLiquidacion(2000),2);
    venta.calcularTotal();
    assertEquals(venta.getTotalVenta(), 1000 + 1000 + 10 + 10 + 3*5,0);
    registro.registrarVenta(venta);
  }

  private Nueva nueva() {
    return new Nueva();
  }
  private EnLiquidacion liquidacion() {
    return new EnLiquidacion();
  }
  private EnPromocion promocion(int descuento) {
    return new EnPromocion((double) descuento);
  }
  private LocalDate fecha13Abril() {
    LocalDate fecha = LocalDate.of(2021, Month.APRIL, 13);
    return fecha;
  }

  private Prenda pantalonEnPromocion(int precioBase, int descuento) {
    Prenda prenda = new Prenda((double) precioBase,pantalon(),promocion(descuento));
    return prenda;
  }

  private Prenda camisaNueva(double precioBase) {
    Prenda prenda = new Prenda(precioBase, camisa(), nueva());
    return prenda;
  }

  private Prenda sacoEnLiquidacion(double precioBase) {
    Prenda prenda = new Prenda(precioBase, saco(), liquidacion());
    return prenda;
  }

  private TipoPrenda saco() {
    return TipoPrenda.SACO;
  }
  private TipoPrenda camisa() {
    return TipoPrenda.CAMISA;
  }
  private TipoPrenda pantalon() {
    return TipoPrenda.PANTALON;
  }
}
