package project.model.product.enums;

public enum Gauge {

    OO_GAUGE("OO Gauge", "1/76th scale"),
    TT_GAUGE("TT Gauge", "1/120th scale"),
    N_GAUGE("N Gauge", "1/148th scale");

    private final String name;
    private final String scale;

    Gauge(String name, String scale) {
        this.name = name;
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public String getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return name + " (" + scale + ")";
    }

    public static Gauge fromString(String gauge) {
        switch (gauge.toUpperCase()) {
            case "OO GAUGE":
            return Gauge.OO_GAUGE;
            case "TT GAUGE":
            return Gauge.TT_GAUGE;
            case "N GAUGE":
            return Gauge.N_GAUGE;
            default:
            return Gauge.OO_GAUGE;
        }
    }
}
