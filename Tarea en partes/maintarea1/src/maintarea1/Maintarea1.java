
package maintarea1;

import java.util.Date;


public class Maintarea1 {

    
    public static void main(String[] args) {
        Articulo a1 = new Articulo(5, "Juguete", "Juguete para niños", 19990);
        Articulo a2 = new Articulo(1, "Polera", "Polera Nike", 9990);
        Articulo a3 = new Articulo(1, "Chocolate", "Cholate de 350g", 1990);
        Articulo a4 = new Articulo(6, "Sabanas", "Sabanas para cama de dos plazas", 24990);
        Articulo a5 = new Articulo(2, "Autito", "Autito de juguete coleccionable", 4990);
        Cliente c1 = new Cliente("Alexis Sanchez", "16.927.586-6");
        Cliente c2 = new Cliente("Arturo Vidal", "16.713.130-1");
        Boleta b = new Boleta("0002","16.927.586-6", new Date());
        Factura f = new Factura("0003","16.713.130-1", new Date());
        Direccion d1 = new Direccion("Marseilla");
        Direccion d2 = new Direccion("Sao Paulo");
        DetalleOrden do1 = new DetalleOrden();
        do1.addArticulo(a1);
        do1.addArticulo(a2);
        do1.addArticulo(a3);
        do1.addArticulo(a4);
        do1.addArticulo(a5);
        do1.calcPrecio();
        do1.calcPrecioSinIVA();
        do1.calcIVA();
        do1.calcPeso();
        DetalleOrden do2 = new DetalleOrden();
        do2.addArticulo(a1);
        do2.addArticulo(a1);
        do2.addArticulo(a3);
        do2.addArticulo(a3);
        do2.addArticulo(a5);
        do2.calcPrecio();
        do2.calcPrecioSinIVA();
        do2.calcIVA();
        do2.calcPeso();
        DetalleOrden do3 = new DetalleOrden();
        do3.addArticulo(a2);
        do3.addArticulo(a2);
        do3.addArticulo(a4);
        do3.addArticulo(a4);
        do3.addArticulo(a1);
        do3.calcPrecio();
        do3.calcPrecioSinIVA();
        do3.calcIVA();
        do3.calcPeso();
        OrdenCompra o1 = new OrdenCompra(new Date(), c1, b, d1);
        o1.addDetalleOrden(do1);
        o1.addDetalleOrden(do2);
        o1.calcPrecio();
        o1.calcPrecioSinIVA();
        o1.calcIVA();
        o1.calcPeso();
        OrdenCompra o2 = new OrdenCompra(new Date(), c2, f, d2);
        o2.addDetalleOrden(do3);
        o2.calcPrecio();
        o2.calcPrecioSinIVA();
        o2.calcIVA();
        o2.calcPeso();
        Tarjeta t1 = new Tarjeta(100000, new Date(),"Debito", "2353253253523");
        Tarjeta t2 = new Tarjeta(100000, new Date(),"Debito", "2353253253524");
        Tarjeta t3 = new Tarjeta(100000, new Date(),"Debito", "2353253253525");
        Tarjeta t4 = new Tarjeta(100000, new Date(),"Debito", "2353253253526");
        Tarjeta t5 = new Tarjeta(100000, new Date(),"Debito", "2353253253527");
        Tarjeta t6 = new Tarjeta(100000, new Date(),"Debito", "2353253253528");
        o1.addPago(t1);
        o1.addPago(t2);
        o1.addPago(t3);
        o1.addPago(t4);
        o1.addPago(t5);
        o1.addPago(t6);
        Efectivo e = new Efectivo(500000, new Date());
        o2.addPago(e);
        o2.addPago(e);
        o2.addPago(e);
        o2.addPago(e);
        System.out.println(o1.toStringOrdenCompra()+"\n"+o2.toStringOrdenCompra());
    }
    
}
