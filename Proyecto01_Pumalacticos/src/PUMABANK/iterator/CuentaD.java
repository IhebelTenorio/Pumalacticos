package PUMABANK.iterator;

public abstract class Cuenta {
    private String tipoCuenta;
    private double fondos;
    private final String numeroCuenta;

    public Cuenta(String numeroCuenta, String tipoCuenta, double fondoInicial){
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.fondos = fondoInicial;
    }

    public abstract void hacerDeposito(double monto);
    public abstract void hacerCompra(double monto);

    public double getFondo(){
        return fondos;
    }

    protected void setFondo(double fondos){
        this.fondos = fondos;
    }
    
    public String getTipoCuenta(){
        return tipoCuenta;
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }
}
